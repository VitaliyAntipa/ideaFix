package com.ideafix.model.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

public class Idea {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "big_description")
    private String bigDescription;

//    ?
    private User author;

    @Column(name = "date")
    private Date date;

    @Column(name = "is_banned")
    private boolean isBanned;

//    ?
    private List<Tag> listOfTags;

//    ?
    private List<String> listOfMedia;

    public Idea(long id, String title, String bigDescription,
                User author, Date date,
                boolean isBanned, List<Tag> listOfTags,
                List<String> listOfMedia) {
        this.id = id;
        this.title = title;
        this.bigDescription = bigDescription;
        this.author = author;
        this.date = date;
        this.isBanned = isBanned;
        this.listOfTags = listOfTags;
        this.listOfMedia = listOfMedia;
    }

    public Idea() {
    }

    public String getTitle() {
        return title;
    }

    public String getBigDescription() {
        return bigDescription;
    }

    public User getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public List<Tag> getListOfTags() {
        return listOfTags;
    }

    public List<String> getListOfMedia() {
        return listOfMedia;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBigDescription(String bigDescription) {
        this.bigDescription = bigDescription;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public void setListOfTags(List<Tag> listOfTags) {
        this.listOfTags = listOfTags;
    }

    public void setListOfMedia(List<String> listOfMedia) {
        this.listOfMedia = listOfMedia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
