package com.ideafix.controller;

import com.ideafix.dao.*;
import com.ideafix.model.pojo.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    private IdeaListDAO ideaListDAO;
    private UserDAO userDAO;
    private CommentDAO commentDAO;
    private ReportDAO reportDAO;
    private IdeaDAO ideaDAO;
    private TagDAO tagDAO;

    public MainController(IdeaListDAO ideaListDAO, UserDAO userDAO,
                          CommentDAO commentDAO, ReportDAO reportDAO,
                          IdeaDAO ideaDAO, TagDAO tagDAO) {
        this.ideaListDAO = ideaListDAO;
        this.userDAO = userDAO;
        this.commentDAO = commentDAO;
        this.reportDAO = reportDAO;
        this.ideaDAO = ideaDAO;
        this.tagDAO = tagDAO;
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<User> getUser() {
        return userDAO.findAll();
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public List<IdeaList> getIdeaList() {
        return ideaListDAO.findAll();
    }

    @RequestMapping(path = "/comment", method = RequestMethod.GET)
    public List<Comment> getComments() {
        return commentDAO.findAll();
    }

    @RequestMapping(path = "/report", method = RequestMethod.GET)
    public List<Report> getReports() {
        return reportDAO.findAll();
    }

    @RequestMapping(path = "/idea", method = RequestMethod.GET)
    public List<Idea> getIdeas() {
        return ideaDAO.findAll();
    }

    @RequestMapping(path = "/tag", method = RequestMethod.GET)
    public List<Tag> getTags() {
        return tagDAO.findAll();
    }
}
