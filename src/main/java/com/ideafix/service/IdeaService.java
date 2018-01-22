package com.ideafix.service;

import com.ideafix.model.dto.IdeaDTO;
import com.ideafix.model.dto.MediaDTO;
import com.ideafix.model.pojo.Comment;
import com.ideafix.model.pojo.Idea;

import java.util.List;

public interface IdeaService {

    Idea createIdea(IdeaDTO idea, String authorNickname);

    Idea getIdeaById(long id);

    Idea edit(IdeaDTO editIdea, long ideaId);

    void delete(long id);

    List<Idea> getIdeasByUserId(long id);

    List<Idea> getAll();
}
