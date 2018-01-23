package com.ideafix.service.impl;

import com.ideafix.dao.RoleDAO;
import com.ideafix.dao.UserDAO;
import com.ideafix.model.dto.UserDTO;
import com.ideafix.model.pojo.User;
import com.ideafix.security.JwtAuthenticationProvider;
import com.ideafix.service.UserService;
import com.ideafix.service.util.JwtTokenUtil;
import com.ideafix.service.util.ValidationUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    private RoleDAO roleDAO;
    private JwtAuthenticationProvider authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private JwtUserDetailsServiceImpl userDetailsService;

    public UserServiceImpl(UserDAO userDAO, RoleDAO roleDAO,
                           JwtAuthenticationProvider authenticationManager,
                           JwtTokenUtil jwtTokenUtil,
                           JwtUserDetailsServiceImpl userDetailsService) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public User getUserByNickname(String username) {
        return userDAO.findUserByNickname(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDAO.findUserByEmail(email);
    }

    @Override
    public User getUserById(long id) {
        return userDAO.findOne(id);
    }

    @Override
    public void create(UserDTO newUser) {

        if (userDAO.findUserByNickname(newUser.getNickname()) != null
                || userDAO.findUserByEmail(newUser.getEmail()) != null) {
            throw new IllegalArgumentException("There is user with such nickname or email.");
        }

        User user = new User();
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setNickname(newUser.getNickname());
        user.setPassword(newUser.getPassword());
        user.setCountry(newUser.getCountry());
        user.setRole(roleDAO.findOne(1L));
        user.setBanned(false);

        if (newUser.getAge() != 0)
            user.setAge(newUser.getAge());

        if (newUser.getPicture() != "" || newUser.getPicture() != null)
            user.setPic(newUser.getPicture());

        if (newUser.getCity() != "" || newUser.getCity() != null)
            user.setCity(newUser.getCity());

        if (newUser.getAbout() != "" || newUser.getAbout() != null)
            user.setAbout(newUser.getAbout());

        userDAO.save(user);
    }

    @Override
    public User edit(UserDTO editUser) {
        User user = userDAO.findUserByNickname(
                editUser.getNickname());

        user.setPic(editUser.getPicture());
        user.setAge(editUser.getAge());
        user.setAbout(editUser.getAbout());
        user.setCity(editUser.getCity());
        user.setCountry(editUser.getCountry());
        user.setName(editUser.getName());

        return userDAO.saveAndFlush(user);
    }

    @Override
    public void delete(long userId) {
        userDAO.delete(userId);
    }

    @Override
    public List<User> getAll() {
        return userDAO.findAll();
    }

    @Override
    public void setBan(long id) {
        userDAO.setBanToUser(id);
    }

    @Override
    public void unban(long id) {
        userDAO.unbanUser(id);
    }

    @Override
    public void setRole(long userId, Long roleId) {
        User user = userDAO.findOne(userId);
        user.setRole(roleDAO.findOne(roleId));

        userDAO.save(user);
    }

    @Override
    public String authUser(String uniqueUserString, String password) {
        final Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                uniqueUserString,
                                password
                        )
                );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtTokenUtil.generateToken(
                userDetailsService.loadUserByUsername(uniqueUserString));
    }

    @Override
    public Boolean checkCredentialsForRegister(UserDTO userDTO) {
        return userDAO.existsUserByEmailOrNickname(
                userDTO.getEmail(), userDTO.getNickname());
    }

    @Override
    public User getUserByEmailOrNickname(String email, String nickname) {
        return userDAO.findUserByEmailOrNickname(email, nickname);
    }
}
