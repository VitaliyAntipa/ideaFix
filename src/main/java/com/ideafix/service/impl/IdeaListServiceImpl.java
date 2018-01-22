package com.ideafix.service.impl;

import com.ideafix.dao.IdeaListDAO;
import com.ideafix.model.dto.IdeaListDTO;
import com.ideafix.model.pojo.Idea;
import com.ideafix.model.pojo.IdeaList;
import com.ideafix.service.IdeaListService;
import com.ideafix.service.IdeaService;
import com.ideafix.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class IdeaListServiceImpl implements IdeaListService {
    private IdeaListDAO ideaListDAO;
    private UserService userService;
    private IdeaService ideaService;

    public IdeaListServiceImpl(IdeaListDAO ideaListDAO, UserService userService,
                               IdeaService ideaService) {
        this.ideaListDAO = ideaListDAO;
        this.userService = userService;
        this.ideaService = ideaService;
    }

    @Override
    public IdeaList create(IdeaListDTO newIdeaListDTO, long userId) {
        IdeaList ideaList = new IdeaList();
        ideaList.setName(newIdeaListDTO.getName());
        ideaList.setAuthor(userService.getUserById(userId));

        return ideaListDAO.saveAndFlush(ideaList);
    }

    @Override
    public IdeaList create(IdeaListDTO newIdeaListDTO, String nickname) {
        IdeaList ideaList = new IdeaList();
        ideaList.setName(newIdeaListDTO.getName());
        ideaList.setAuthor(userService.getUserByNickname(nickname));

        return ideaListDAO.saveAndFlush(ideaList);
    }

    @Override
    public IdeaList create(IdeaListDTO newIdeaListDTO, long userId, long ideaId) {
        IdeaList ideaList = new IdeaList();
        ideaList.setName(newIdeaListDTO.getName());
        ideaList.setAuthor(userService.getUserById(userId));

        Set<Idea> setOfIdeas = new HashSet<>();
        setOfIdeas.add(ideaService.getIdeaById(ideaId));
        ideaList.setSetOfIdeas(setOfIdeas);

        return ideaListDAO.saveAndFlush(ideaList);
    }

    @Override
    public IdeaList create(IdeaListDTO newIdeaListDTO, String nickname, long ideaId) {
        IdeaList ideaList = new IdeaList();
        ideaList.setName(newIdeaListDTO.getName());
        ideaList.setAuthor(userService.getUserByNickname(nickname));

        Set<Idea> setOfIdeas = new HashSet<>();
        setOfIdeas.add(ideaService.getIdeaById(ideaId));
        ideaList.setSetOfIdeas(setOfIdeas);

        return ideaListDAO.saveAndFlush(ideaList);
    }

    @Override
    public IdeaList edit(IdeaListDTO ideaListDTO, long ideaListId) {
        IdeaList ideaList = ideaListDAO.findOne(ideaListId);
        ideaList.setName(ideaListDTO.getName());

        return ideaListDAO.saveAndFlush(ideaList);
    }

    @Override
    public IdeaList addIdea(long ideaListId, long ideaId) {
        IdeaList ideaList = ideaListDAO.findOne(ideaListId);
        Set<Idea> ideas = ideaList.getSetOfIdeas();

        ideas.add(ideaService.getIdeaById(ideaId));
        ideaList.setSetOfIdeas(ideas);

        return ideaListDAO.saveAndFlush(ideaList);
    }

    @Override
    public IdeaList deletIdea(long ideaListId, long ideaId) {
        IdeaList ideaList = ideaListDAO.findOne(ideaListId);
        Set<Idea> ideas = ideaList.getSetOfIdeas();

        for (Idea idea : ideas) {
            if (idea.getId() == ideaId)
                ideas.remove(idea);
            break;
        }

        ideaList.setSetOfIdeas(ideas);

        return ideaListDAO.saveAndFlush(ideaList);
    }


    @Override
    public void delete(long ideaListId) {
        ideaListDAO.delete(ideaListId);
    }
}
