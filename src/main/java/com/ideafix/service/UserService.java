package com.ideafix.service;

import com.ideafix.model.dto.UserDTO;
import com.ideafix.model.pojo.User;

import java.util.List;

public interface UserService {

    User getUserByNickname(String nickname);

    User getUserByEmail(String email);

    User getUserById(long id);

    void create(UserDTO newUser);

    User edit(UserDTO user, long id);

    void delete(long userId);

    List<User> getAll();

    void setBan(long id);

    void unban(long id);
}
