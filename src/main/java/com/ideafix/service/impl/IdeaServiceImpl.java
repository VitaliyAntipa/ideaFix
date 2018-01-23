package com.ideafix.service.impl;

import com.ideafix.dao.IdeaDAO;
import com.ideafix.model.dto.IdeaDTO;
import com.ideafix.model.pojo.Idea;
import com.ideafix.service.IdeaService;
import com.ideafix.service.MediaService;
import com.ideafix.service.TagService;
import com.ideafix.service.UserService;
import com.ideafix.service.util.ValidationUtil;
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
    public Idea createIdea(IdeaDTO newIdea) {
        Idea idea = new Idea();

        idea.setSetOfTags(tagService.assignTags(newIdea.getSetOfTags()));
        idea.setAuthor(userService.getUserById(newIdea.getAuthorId()));
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
    public Idea edit(IdeaDTO editIdea) {
        Idea idea = ideaDAO.findOne(editIdea.getIdeaId());
        ValidationUtil.assertNotBlank(idea, "No Idea with such id");

        mediaService.attachMedia(editIdea.getListOfMedia(), idea);
        idea.setSetOfTags(tagService.assignTags(idea.getSetOfTags()));
        idea.setTitle(editIdea.getTitle());
        idea.setBigDescription(editIdea.getBig_description());
        idea.setSetOfTags(tagService.assignTags(editIdea.getSetOfTags()));

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
        return ideaDAO.findAllByAuthorId(id);
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

    @Override
    public void setLike(long ideaId, long userId) {

    }
}
