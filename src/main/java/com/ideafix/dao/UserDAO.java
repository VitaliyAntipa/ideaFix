package com.ideafix.dao;

import com.ideafix.model.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User,Long> {

    public User findUsersByNickname(String string);

}
