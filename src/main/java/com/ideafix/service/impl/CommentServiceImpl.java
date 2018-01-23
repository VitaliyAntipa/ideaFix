package com.ideafix.service.impl;

import com.ideafix.dao.CommentDAO;
import com.ideafix.model.dto.CommentDTO;
import com.ideafix.model.pojo.Comment;
import com.ideafix.service.CommentService;
import com.ideafix.service.IdeaService;
import com.ideafix.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentDAO commentDAO;
    private UserService userService;
    private IdeaService ideaService;

    public CommentServiceImpl(CommentDAO commentDAO,
                              UserService userService,
                              IdeaService ideaService) {
        this.commentDAO = commentDAO;
        this.userService = userService;
        this.ideaService = ideaService;
    }

    @Override
    public Comment createComment(CommentDTO commentDTO, long authorId) {
        Comment comment = new Comment();
        comment.setDate(new Date());
        comment.setText(commentDTO.getText());
        comment.setAuthor(userService.getUserById(authorId));
        comment.setIdea(ideaService.getIdeaById(commentDTO.getIdeaId()));

        return commentDAO.saveAndFlush(comment);
    }

    @Override
    public List<Comment> getAllCommentsByIdeaId(long ideaId) {
        return commentDAO.findAllByIdea_Id(ideaId);
    }

    @Override
    public void delete(long commentId) {
        commentDAO.delete(commentId);
    }
}
