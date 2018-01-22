package com.ideafix.service.impl;

import com.ideafix.dao.RoleDAO;
import com.ideafix.dao.UserDAO;
import com.ideafix.model.dto.UserDTO;
import com.ideafix.model.pojo.User;
import com.ideafix.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    private RoleDAO roleDAO;

    public UserServiceImpl(UserDAO userDAO, RoleDAO roleDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
    }

    @Override
    public User getUserByNickname(String username) {
        return userDAO.findUsersByNickname(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDAO.findUsersByEmail(email);
    }

    @Override
    public User getUserById(long id) {
        return userDAO.findOne(id);
    }

    @Override
    public void create(UserDTO newUser) {

        if (userDAO.findUsersByNickname(newUser.getNickname()) != null
                || userDAO.findUsersByEmail(newUser.getEmail()) != null) {
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
    public User edit(UserDTO editUser, long id) {
        User user = userDAO.findOne(id);

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
}
