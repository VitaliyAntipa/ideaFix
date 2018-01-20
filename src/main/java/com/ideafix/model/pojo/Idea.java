package com.ideafix.model.pojo;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "idea")
public class Idea implements Serializable {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "big_description")
    private String bigDescription;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private ShortUser author;

    @Column(name = "date")
    @Temporal(value = TemporalType.DATE)
    private Date date;

    @Column(name = "is_banned")
    private boolean isBanned;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "idea_tag",
            joinColumns = @JoinColumn(name = "idea_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> setOfTags;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idea_id")
    private List<Media> listOfMedia;

    @Formula("(Select count(*) from comment c where c.idea_id = id)")
    private long countOfComments;

    @Formula("(Select count(*) from likes l where l.idea_id = id)")
    private long countOfLikes;

    public Idea(String title, String bigDescription, ShortUser author,
                Date date, boolean isBanned, Set<Tag> setOfTags,
                List<Media> listOfMedia) {
        this.title = title;
        this.bigDescription = bigDescription;
        this.author = author;
        this.date = date;
        this.isBanned = isBanned;
        this.setOfTags = setOfTags;
        this.listOfMedia = listOfMedia;
    }

    public Idea() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBigDescription() {
        return bigDescription;
    }

    public void setBigDescription(String bigDescription) {
        this.bigDescription = bigDescription;
    }

    public ShortUser getAuthor() {
        return author;
    }

    public void setAuthor(ShortUser author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public Set<Tag> getSetOfTags() {
        return setOfTags;
    }

    public void setSetOfTags(Set<Tag> setOfTags) {
        this.setOfTags = setOfTags;
    }

    public List<Media> getListOfMedia() {
        return listOfMedia;
    }

    public void setListOfMedia(List<Media> listOfMedia) {
        this.listOfMedia = listOfMedia;
    }

    public long getCountOfComments() {
        return countOfComments;
    }

    public void setCountOfComments(long countOfComments) {
        this.countOfComments = countOfComments;
    }

    public long getCountOfLikes() {
        return countOfLikes;
    }

    public void setCountOfLikes(long countOfLikes) {
        this.countOfLikes = countOfLikes;
    }
}
