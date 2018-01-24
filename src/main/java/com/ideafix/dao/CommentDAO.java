package com.ideafix.dao;

import com.ideafix.model.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDAO extends JpaRepository<Comment, Long> {
    List<Comment> findAllByIdea_Id(long ideaId);
}
