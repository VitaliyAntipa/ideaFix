package com.ideafix.dao;

import com.ideafix.model.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    public User findUsersByNickname(String string);

    public User findUsersByEmail(String email);

    @Query("update users set is_banned = true where id = :id")
    @Transactional
    @Modifying
    public void setBanToUser(@Param("id") long id);

    @Query("update users set is_banned = false where id = :id")
    @Transactional
    @Modifying
    public void unbanUser(@Param("id") long id);

}
