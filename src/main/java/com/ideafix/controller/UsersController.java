package com.ideafix.controller;

import com.ideafix.exception.ExceptionHandlerController;
import com.ideafix.exception.RestException;
import com.ideafix.model.dto.UserDTO;
import com.ideafix.model.pojo.User;
import com.ideafix.model.security.JwtUser;
import com.ideafix.service.UserService;
import com.ideafix.service.util.ValidationUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static com.ideafix.model.response.ControllerResponseEntity.*;

@RestController
@RequestMapping("/users")
public class UsersController extends ExceptionHandlerController {
    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Map<String, Object> getAll() {
        List<User> userList = userService.getAll();
        userList.stream().forEach(user -> user.setSetOfFavoriteIdea(new HashSet<>()));
        return successResponse("data", userList);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Map<String, Object> getUserByCredentials(@RequestParam(value = "id", required = false, defaultValue = "0") Long id,
                                                    @RequestParam(value = "nickname", required = false, defaultValue = "") String nickname)
            throws RestException {
        try {
            User user = new User();
            if (id > 0) {
                user = userService.getUserById(id);
            } else if (nickname != null && !nickname.equals("")) {
                user = userService.getUserByNickname(nickname);
            }

            user.setSetOfFavoriteIdea(new HashSet<>());

            if (user == null)
                return errorResponse("No user with such id");

            return successResponse("data", user);
        } catch (Exception e) {
            throw new RestException(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/currentUser", method = RequestMethod.GET)
    public Map<String, Object> getCurrentUser()
            throws RestException {
        try {
            JwtUser user = (JwtUser) SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getPrincipal();

            User currentUser = userService.getUserById(user.getId());

            return successResponse("data", currentUser);
        } catch (Exception e) {
            throw new RestException(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Map<String, Object> editUser(@RequestBody UserDTO userDTO)
            throws RestException {
        try {
            JwtUser user = (JwtUser) SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getPrincipal();

            ValidationUtil.assertEquals(userDTO.getUserId(),
                    user.getId(),
                    "Current User's and User's for edit ids");
            User newUser = userService.edit(userDTO);

            return successResponse("data", newUser);
        } catch (Exception e) {
            throw new RestException(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@RequestParam(value = "id") long id) throws RestException {
        try {
            JwtUser user = (JwtUser) SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getPrincipal();

            if (user.getId() == id) {
                userService.delete(id);
                return emptyResponse();
            }


            return errorResponse("You cannot delete User account " +
                    "if it's not your or " +
                    "if you haven't role 'Admin'");
        } catch (Exception e) {
            throw new RestException(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/ban", method = RequestMethod.GET)
    public Map<String, Object> banUser(@RequestParam(value = "id") long userId,
                                       @RequestParam(value = "ban") boolean shouldBan)
            throws RestException {
        try {
            JwtUser user = (JwtUser) SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getPrincipal();

            ValidationUtil.assertEquals(user
                            .getAuthorities()
                            .iterator()
                            .next().toString(),
                    "ADMIN",
                    "Wrong Role!");

            userService.setBan(userId, shouldBan);

            return emptyResponse();
        } catch (Exception e) {
            throw new RestException(e.getMessage(), e);
        }
    }
}
