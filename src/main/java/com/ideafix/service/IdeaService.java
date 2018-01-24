package com.ideafix.service;

import com.ideafix.model.dto.IdeaDTO;
import com.ideafix.model.dto.MediaDTO;
import com.ideafix.model.pojo.Comment;
import com.ideafix.model.pojo.Idea;

import java.util.List;

public interface IdeaService {

    Idea createIdea(IdeaDTO idea);

    Idea getIdeaById(long id);

    Idea edit(IdeaDTO editIdea);

    void delete(long id);

    List<Idea> getIdeasByUserId(long id);

    List<Idea> getAll();

    void setBan(long id, boolean ban);

    void setLike(long ideaId, long userId);
}
