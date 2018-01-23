package com.ideafix.service.impl;

import com.ideafix.dao.MediaDAO;
import com.ideafix.model.dto.MediaDTO;
import com.ideafix.model.pojo.Idea;
import com.ideafix.model.pojo.Media;
import com.ideafix.service.MediaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MediaServiceImpl implements MediaService {
    private MediaDAO mediaDAO;

    public MediaServiceImpl(MediaDAO mediaDAO) {
        this.mediaDAO = mediaDAO;
    }

    @Override
    public void attachMedia(List<MediaDTO> listOfMedia, Idea idea) {
        if (listOfMedia.size() > 0) {
            List<Media> medias = new ArrayList<>(listOfMedia.size());
            deleteMediaByIdeaId(idea.getId());

            for (MediaDTO mediaDTO : listOfMedia) {
                Media tmpMedia = new Media(mediaDTO.getMediaUrl());
                tmpMedia.setIdea(idea);
                medias.add(mediaDAO.saveAndFlush(tmpMedia));
            }

            mediaDAO.save(medias);
            idea.setListOfMedia(medias);
        }
    }

    private void deleteMediaByIdeaId(long ideaId) {
        mediaDAO.deleteAllByIdeaId(ideaId);
    }
}
