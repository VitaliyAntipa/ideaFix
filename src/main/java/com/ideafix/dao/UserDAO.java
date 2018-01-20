package com.ideafix.dao;

import com.ideafix.model.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserDAO extends JpaRepository<User,Long> {

}
