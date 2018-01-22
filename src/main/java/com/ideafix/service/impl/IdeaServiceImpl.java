package com.ideafix.service.impl;

import com.ideafix.dao.IdeaDAO;
import com.ideafix.model.dto.IdeaDTO;
import com.ideafix.model.pojo.Idea;
import com.ideafix.service.IdeaService;
import com.ideafix.service.MediaService;
import com.ideafix.service.TagService;
import com.ideafix.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IdeaServiceImpl implements IdeaService {
    private IdeaDAO ideaDAO;
    private UserService userService;
    private TagService tagService;
    private MediaService mediaService;

    public IdeaServiceImpl(IdeaDAO ideaDAO, UserService userService,
                           TagService tagService, MediaService mediaService) {
        this.ideaDAO = ideaDAO;
        this.userService = userService;
        this.tagService = tagService;
        this.mediaService = mediaService;
    }

    @Override
    public Idea createIdea(IdeaDTO newIdea, String nickname) {
        Idea idea = new Idea();

        idea.setSetOfTags(tagService.assignTags(newIdea.getSetOfTags()));
        idea.setAuthor(userService.getUserByNickname(nickname));
        idea.setTitle(newIdea.getTitle());
        idea.setBigDescription(newIdea.getBig_description());
        idea.setBanned(false);
        idea.setDate(new Date());

        idea = ideaDAO.saveAndFlush(idea);
        mediaService.attachMedia(newIdea.getListOfMedia(), idea);
        tagService.clearFreeTags();

        return idea;
    }

    @Override
    public Idea getIdeaById(long id) {
        return ideaDAO.findOne(id);
    }

    @Override
    public Idea edit(IdeaDTO editIdea, long ideaId) {
        Idea idea = ideaDAO.findOne(ideaId);

        mediaService.attachMedia(editIdea.getListOfMedia(), idea);
        idea.setSetOfTags(tagService.assignTags(idea.getSetOfTags()));
        idea.setTitle(editIdea.getTitle());
        idea.setBigDescription(editIdea.getBig_description());

        idea = ideaDAO.saveAndFlush(idea);
        tagService.clearFreeTags();

        return idea;
    }

    @Override
    public void delete(long id) {
        ideaDAO.delete(id);
        tagService.clearFreeTags();
    }

    @Override
    public List<Idea> getIdeasByUserId(long id) {
        return ideaDAO.findAllByAuthor_Id(id);
    }

    @Override
    public List<Idea> getAll() {
        return ideaDAO.findAll();
    }

    @Override
    public void setBan(long id) {
        ideaDAO.setBanToIdea(id);
    }

    @Override
    public void unban(long id) {
        ideaDAO.unbanIdea(id);
    }
}
