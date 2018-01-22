package com.ideafix.service;

import com.ideafix.model.dto.CommentDTO;
import com.ideafix.model.pojo.Comment;

import java.util.List;

public interface CommentService {
    void createComment(CommentDTO commentDTO);

    List<Comment> getAllCommentsByIdeaId(long ideaId);

    void delete(long commentId);
}
