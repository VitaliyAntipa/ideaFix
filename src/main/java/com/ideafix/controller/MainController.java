package com.ideafix.controller;

import com.ideafix.dao.*;
import com.ideafix.model.dto.IdeaDTO;
import com.ideafix.model.dto.MediaDTO;
import com.ideafix.model.dto.UserDTO;
import com.ideafix.model.pojo.*;
import com.ideafix.service.IdeaService;
import com.ideafix.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;


@RestController
public class MainController {
    private IdeaListDAO ideaListDAO;
    private UserDAO userDAO;
    private CommentDAO commentDAO;
    private ReportDAO reportDAO;
    private IdeaDAO ideaDAO;
    private TagDAO tagDAO;
    private RoleDAO roleDAO;
    private MediaDAO mediaDAO;
    private IdeaService ideaService;
    private UserService userService;

    public MainController(IdeaListDAO ideaListDAO, UserDAO userDAO,
                          CommentDAO commentDAO, ReportDAO reportDAO,
                          IdeaDAO ideaDAO, TagDAO tagDAO, RoleDAO roleDAO,
                          MediaDAO mediaDAO, IdeaService ideaService, UserService userService) {
        this.ideaListDAO = ideaListDAO;
        this.userDAO = userDAO;
        this.commentDAO = commentDAO;
        this.reportDAO = reportDAO;
        this.ideaDAO = ideaDAO;
        this.tagDAO = tagDAO;
        this.roleDAO = roleDAO;
        this.mediaDAO = mediaDAO;
        this.ideaService = ideaService;
        this.userService = userService;
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

    @PostConstruct
    private void createEntities() {

        UserDTO user1 = new UserDTO("Petr Poroshenk",
                "Poroh", "pass", 12,
                "poroh@rambler.ua", "about",
                "pic", "city", "Ukraine");

        UserDTO user2 = new UserDTO("Vladimir Sytnik",
                "sys", "pass",
                11, "sys@gmail.ua",
                "about", "pic", "Odessa", "Ukraine");

        UserDTO user3 = new UserDTO("Alex Makovetsky",
                "dr.newman", "pass",
                12, "dr.newman@gmail.ua",
                "about", "pic", "Odessa", "Ukraine");

        UserDTO user4 = new UserDTO("Ashot Unanyan",
                "headshot", "pass",
                14, "ahik@gmail.ua",
                "about", "pic", "city", "country");

        Tag tag1 = new Tag("Dog");
        Tag tag2 = new Tag("Science");
        Tag tag3 = new Tag("Fun");
        Tag tag4 = new Tag("Cool");
        Tag tag5 = new Tag("IT");

        Set<Tag> tagSet1 = new HashSet<>();
        tagSet1.add(tag1);
        tagSet1.add(tag3);

        Set<Tag> tagSet2 = new HashSet<>();
        tagSet2.add(tag2);
        tagSet2.add(tag1);
        tagSet2.add(tag4);

        Set<Tag> tagSet3 = new HashSet<>();
        tagSet3.add(tag3);
        tagSet3.add(tag5);


        IdeaDTO idea1 = new IdeaDTO("Java", "descr",
                0, tagSet2, Arrays.asList(new MediaDTO("url1"),
                new MediaDTO("url2")));
        IdeaDTO idea2 = new IdeaDTO("Ruby", "Shine bright like a dimond",
                0, tagSet1, Arrays.asList(new MediaDTO("url1"),
                new MediaDTO("url2")));
        IdeaDTO idea3 = new IdeaDTO("Learning", "You know nothing",
                0, tagSet3, Arrays.asList(new MediaDTO("url1"),
                new MediaDTO("url2")));
        IdeaDTO idea4 = new IdeaDTO("Java 9", "Lorem ipsum dolore bla-bla-lba",
                0, tagSet1, Arrays.asList(new MediaDTO("url1"),
                new MediaDTO("url2")));
        IdeaDTO idea5 = new IdeaDTO("PHP", "Do you know madness?",
                0, tagSet2, Arrays.asList(new MediaDTO("url1"),
                new MediaDTO("url2")));

        IdeaDTO idea6 = new IdeaDTO("Project management", "Hi from Teslenko. Nyan!",
                0, tagSet2, Arrays.asList(new MediaDTO("url1"),
                new MediaDTO("url2"), new MediaDTO("url23")));


        userService.create(user1);
        userService.create(user2);
        userService.create(user3);
        userService.create(user4);

        ideaService.createIdea(idea1, "sys");
        ideaService.createIdea(idea2, "Poroh");
        ideaService.createIdea(idea3, "dr.newman");
        ideaService.createIdea(idea4, "headshot");
        ideaService.createIdea(idea5, "dr.newman");
        ideaService.createIdea(idea6, "sys");
    }
}



