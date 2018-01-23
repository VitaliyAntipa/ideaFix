package com.ideafix.service;

import com.ideafix.model.dto.CommentDTO;
import com.ideafix.model.pojo.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(CommentDTO commentDTO, long authorId);

    List<Comment> getAllCommentsByIdeaId(long ideaId);

    void delete(long commentId);
}
