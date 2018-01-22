package com.ideafix.service;

import com.ideafix.model.dto.IdeaListDTO;
import com.ideafix.model.pojo.IdeaList;

public interface IdeaListService {

    IdeaList create(IdeaListDTO ideaListDTO, long userId);

    IdeaList create(IdeaListDTO ideaListDTO, long userId, long ideaId);

    IdeaList edit(IdeaListDTO ideaListDTO, long ideaListId);

    IdeaList addIdeaToIdeaList(long ideaListId, long ideaId);

    IdeaList deletIdeaFromIdeaList(long ideaListId, long ideaId);

    void delete(long ideaListId);
}
