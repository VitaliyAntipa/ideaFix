package com.ideafix.model.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class Comment {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;

//    ?
    private User author;

//    ?
    private long ideaId;

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private Date date;

    public Comment(long id, User author, long ideaId,
                   String text, Date date) {
        this.id = id;
        this.author = author;
        this.ideaId = ideaId;
        this.text = text;
        this.date = date;
    }

    public Comment() {
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public long getIdeaId() {
        return ideaId;
    }

    public void setIdeaId(long ideaId) {
        this.ideaId = ideaId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
