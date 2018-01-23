package com.ideafix.model.dto;

public class IdeaListDTO {
    private long id;
    private String name;
    private long authorId;

    public IdeaListDTO(long id, String name, long authorId) {
        this.id = id;
        this.name = name;
        this.authorId = authorId;
    }

    public IdeaListDTO(String name) {
        this.name = name;
    }

    public IdeaListDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
