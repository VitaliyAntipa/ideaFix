package com.ideafix.controller;

import com.ideafix.model.pojo.IdeaList;
import com.ideafix.model.pojo.User;
import com.ideafix.dao.IdeaListDAO;
import com.ideafix.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    IdeaListDAO ideaListDAO;

    @Autowired
    UserDAO userDAO;

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public User getUser(@RequestParam("id") long id){
        System.out.println("fasfa");
        return userDAO.findOne(id);
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public IdeaList getIdeaList(@RequestParam("id") long id){
        System.out.println("fasfa");
        return ideaListDAO.findOne(id);
    }

    @RequestMapping(path = "/save", method = RequestMethod.GET)
    public void getUser(){
        //userService.save(new User("Name",12,"afsa","fas","fas","fas","fas","fas",false));
    }
}
