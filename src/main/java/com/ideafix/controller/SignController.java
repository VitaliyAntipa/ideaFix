package com.ideafix.controller;

import com.ideafix.exception.ExceptionHandlerController;
import com.ideafix.exception.RestException;
import com.ideafix.model.dto.UserDTO;
import com.ideafix.model.pojo.User;
import com.ideafix.model.security.JwtAuthenticationRequest;
import com.ideafix.service.UserService;
import com.ideafix.service.util.ValidationUtil;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.ideafix.model.response.ControllerResponseEntity.emptyResponse;
import static com.ideafix.model.response.ControllerResponseEntity.errorResponse;
import static com.ideafix.model.response.ControllerResponseEntity.successAuthentication;

@RestController
public class SignController extends ExceptionHandlerController {

    @Autowired
    UserService userService;

    private static final Logger LOG =
            Logger.getLogger(SignController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login
            (@RequestBody(required = false) JwtAuthenticationRequest loginUser) throws RestException {
        String token;
        try {
            ValidationUtil.assertNotBlank(loginUser, "Log In credentials");
            ValidationUtil.assertNotBlank(loginUser.getPassword(), "Password Filed");

            User user = userService.getUserByEmailOrNickname(loginUser.getEmail(), loginUser.getNickname());
            ValidationUtil.assertPasswordsEqualls(loginUser.getPassword(), user.getPassword());
            if (loginUser.getNickname() == null) {
                token = userService.authUser(user.getNickname(), loginUser.getPassword());
            } else {
                token = userService.authUser(loginUser.getNickname(), loginUser.getPassword());
            }

            return successAuthentication(token, user);
        } catch (Exception e) {
            LOG.trace(e.getMessage(), e);
            throw new RestException(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/register",
            method = RequestMethod.POST)
    public Map<String, Object> registerUser(@RequestBody(required = false) UserDTO userDTO) throws RestException {
        try {
            ValidationUtil.assertNotBlank(userDTO.getNickname(), "Nickname Field");
            ValidationUtil.assertNotBlank(userDTO.getPassword(), "Password Filed");
            ValidationUtil.assertNotBlank(userDTO.getEmail(), "Email Field");
            ValidationUtil.assertNotBlank(userDTO.getCountry(), "Country Filed");

            if (!userService.checkCredentialsForRegister(userDTO)) {
                userService.create(userDTO);
                return emptyResponse();
            }

            return errorResponse("There is User with such nickname or password");
        } catch (Exception e) {
            LOG.trace(e.getMessage(), e);
            throw new RestException(e.getMessage(), e);
        }
    }

}
