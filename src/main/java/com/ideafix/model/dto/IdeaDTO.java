package com.ideafix.model.dto;

import com.ideafix.model.pojo.Tag;

import java.util.List;
import java.util.Set;

public class IdeaDTO {
    private final String title;
    private final String big_description;
    private final long authorId;
    private final Set<Tag> setOfTags;
    private final List<MediaDTO> listOfMedia;

    public IdeaDTO(String title, String big_description,
                   long authorId, Set<Tag> setOfTags,
                   List<MediaDTO> listOfMedia) {
        this.title = title;
        this.big_description = big_description;
        this.authorId = authorId;
        this.setOfTags = setOfTags;
        this.listOfMedia = listOfMedia;
    }

    public String getTitle() {
        return title;
    }

    public String getBig_description() {
        return big_description;
    }

    public long getAuthorId() {
        return authorId;
    }

    public Set<Tag> getSetOfTags() {
        return setOfTags;
    }

    public List<MediaDTO> getListOfMedia() {
        return listOfMedia;
    }
}
