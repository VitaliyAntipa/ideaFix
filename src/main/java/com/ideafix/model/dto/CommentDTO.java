package com.ideafix.model.dto;

public class CommentDTO {
    private String text;
    private long authorId;
    private long ideaId;

    public CommentDTO(String text, long authorId, long ideaId) {
        this.text = text;
        this.authorId = authorId;
        this.ideaId = ideaId;
    }

    public CommentDTO() {
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public void setIdeaId(long ideaId) {
        this.ideaId = ideaId;
    }

    public String getText() {
        return text;
    }

    public long getAuthorId() {
        return authorId;
    }

    public long getIdeaId() {
        return ideaId;
    }
}
