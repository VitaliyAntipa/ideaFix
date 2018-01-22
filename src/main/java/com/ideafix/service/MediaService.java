package com.ideafix.service;

import com.ideafix.model.dto.MediaDTO;
import com.ideafix.model.pojo.Idea;
import com.ideafix.model.pojo.Media;

import java.util.List;

public interface MediaService {

    public List<Media> attachMedia(List<MediaDTO> listOfMedia, Idea idea);
}
