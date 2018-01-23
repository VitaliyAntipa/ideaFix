package com.ideafix.model.dto;

public class CommentDTO {
    private String text;
    private long ideaId;

    public CommentDTO(String text, long authorId, long ideaId) {
        this.text = text;
        this.ideaId = ideaId;
    }

    public CommentDTO() {
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIdeaId(long ideaId) {
        this.ideaId = ideaId;
    }

    public String getText() {
        return text;
    }

    public long getIdeaId() {
        return ideaId;
    }
}
