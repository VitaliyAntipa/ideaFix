package com.ideafix.model.dto;

import com.ideafix.model.pojo.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class IdeaDTO {
    private String title;
    private String big_description;
    private long authorId;
    private Set<Tag> setOfTags;
    private List<MediaDTO> listOfMedia;

    public IdeaDTO(String title, String big_description,
                   long authorId, Set<Tag> setOfTags,
                   List<MediaDTO> listOfMedia) {
        this.title = title;
        this.big_description = big_description;
        this.authorId = authorId;
        this.setOfTags = setOfTags;
        this.listOfMedia = listOfMedia;
    }

    public IdeaDTO() {
    }

    public IdeaDTO(String title, String big_description,
                   long authorId, Set<Tag> setOfTags) {
        this.title = title;
        this.big_description = big_description;
        this.authorId = authorId;
        this.setOfTags = setOfTags;
        this.listOfMedia = new ArrayList<>(0);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBig_description(String big_description) {
        this.big_description = big_description;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public void setSetOfTags(Set<Tag> setOfTags) {
        this.setOfTags = setOfTags;
    }

    public void setListOfMedia(List<MediaDTO> listOfMedia) {
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
