package com.ideafix.service;

import com.ideafix.model.dto.IdeaListDTO;
import com.ideafix.model.pojo.IdeaList;

public interface IdeaListService {

    IdeaList create(IdeaListDTO ideaListDTO, long userId);

    IdeaList create(IdeaListDTO ideaListDTO, String nickname);

    IdeaList create(IdeaListDTO ideaListDTO, long userId, long ideaId);

    IdeaList create(IdeaListDTO ideaListDTO, String nickname, long ideaId);

    IdeaList edit(IdeaListDTO ideaListDTO, long ideaListId);

    IdeaList addIdea(long ideaListId, long ideaId);

    IdeaList deletIdea(long ideaListId, long ideaId);

    void delete(long ideaListId);
}
