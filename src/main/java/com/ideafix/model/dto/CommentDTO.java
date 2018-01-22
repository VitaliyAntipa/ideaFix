package com.ideafix.model.dto;

public class CommentDTO {
    final private String text;
    final private long authorId;
    final private long ideaId;

    public CommentDTO(String text, long authorId, long ideaId) {
        this.text = text;
        this.authorId = authorId;
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
