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
import java.util.List;
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
    public List<IdeaList> getAll() {
        return ideaListDAO.findAll();
    }

    @Override
    public List<IdeaList> getByUserId(long userId) {
        return ideaListDAO.findAllByAuthor_Id(userId);
    }

    @Override
    public IdeaList getById(long id) {
        return ideaListDAO.findOne(id);
    }

    @Override
    public IdeaList create(IdeaListDTO newIdeaListDTO) {
        IdeaList ideaList = new IdeaList();
        ideaList.setName(newIdeaListDTO.getName());
        ideaList.setAuthor(userService.getUserById(newIdeaListDTO.getAuthorId()));

        return ideaListDAO.saveAndFlush(ideaList);
    }

    @Override
    public IdeaList create(IdeaListDTO newIdeaListDTO, long ideaId) {
        IdeaList ideaList = new IdeaList();
        ideaList.setName(newIdeaListDTO.getName());
        ideaList.setAuthor(userService.getUserById(newIdeaListDTO.getAuthorId()));

        Set<Idea> setOfIdeas = new HashSet<>();
        setOfIdeas.add(ideaService.getIdeaById(ideaId));
        ideaList.setSetOfIdeas(setOfIdeas);

        return ideaListDAO.saveAndFlush(ideaList);
    }

    @Override
    public IdeaList edit(IdeaListDTO ideaListDTO) {
        IdeaList ideaList = ideaListDAO.findOne(ideaListDTO.getId());
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
    public IdeaList deleteIdea(long ideaListId, long ideaId) {
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
    public void setIdeaListPrivate(long ideaList, long userId, boolean isPrivate) {
        if(ideaListDAO.findOne(ideaList).getAuthor().getId() == userId){
            ideaListDAO.setListPrivate(ideaList,isPrivate);
        }

        throw  new IllegalArgumentException("You can make private only yours List");
    }


    @Override
    public void delete(long ideaListId) {
        ideaListDAO.delete(ideaListId);
    }
}
