package com.ideafix.service.impl;

import com.ideafix.dao.CommentDAO;
import com.ideafix.model.dto.CommentDTO;
import com.ideafix.model.pojo.Comment;
import com.ideafix.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentDAO commentDAO;

    @Override
    public void createComment(CommentDTO commentDTO) {

    }

    @Override
    public List<Comment> getAllCommentsByIdeaId(long ideaId) {
        return null;
    }

    @Override
    public void delete(long commentId) {

    }
}
