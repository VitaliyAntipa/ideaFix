package com.ideafix.model.dto;

import com.ideafix.model.pojo.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class IdeaDTO {
    private long ideaId;
    private String title;
    private String bigDescription;
    private long authorId;
    private Set<Tag> setOfTags;
    private List<MediaDTO> listOfMedia;

    public IdeaDTO(String title, String bigDescription,
                   long authorId, Set<Tag> setOfTags,
                   List<MediaDTO> listOfMedia) {
        this.title = title;
        this.bigDescription = bigDescription;
        this.authorId = authorId;
        this.setOfTags = setOfTags;
        this.listOfMedia = listOfMedia;
    }

    public IdeaDTO(long ideaId, String title,
                   String bigDescription,
                   long authorId,
                   Set<Tag> setOfTags,
                   List<MediaDTO> listOfMedia) {
        this.ideaId = ideaId;
        this.title = title;
        this.bigDescription = bigDescription;
        this.authorId = authorId;
        this.setOfTags = setOfTags;
        this.listOfMedia = listOfMedia;
    }

    public IdeaDTO() {
    }

    public IdeaDTO(String title, String bigDescription,
                   long authorId, Set<Tag> setOfTags) {
        this.title = title;
        this.bigDescription = bigDescription;
        this.authorId = authorId;
        this.setOfTags = setOfTags;
        this.listOfMedia = new ArrayList<>(0);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBigDescription(String bigDescription) {
        this.bigDescription = bigDescription;
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

    public String getBigDescription() {
        return bigDescription;
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

    public long getIdeaId() {
        return ideaId;
    }

    public void setIdeaId(long ideaId) {
        this.ideaId = ideaId;
    }
}
