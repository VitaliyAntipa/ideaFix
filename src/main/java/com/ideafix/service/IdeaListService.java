package com.ideafix.service;

import com.ideafix.model.dto.IdeaListDTO;
import com.ideafix.model.pojo.IdeaList;

import java.util.List;

public interface IdeaListService {

    List<IdeaList> getAll();

    List<IdeaList> getByUserId(long userId);

    IdeaList getById(long id);

    IdeaList create(IdeaListDTO ideaListDTO);

    IdeaList create(IdeaListDTO ideaListDTO, long ideaId);

    IdeaList edit(IdeaListDTO ideaListDTO);

    IdeaList addIdea(long ideaListId, long ideaId);

    IdeaList deleteIdea(long ideaListId, long ideaId);

    void delete(long ideaListId);
}
