package com.ideafix.model.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity(name = "idea")
@Table(name = "idea")
public class Idea implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "idea_id_seq")
    @SequenceGenerator(name = "idea_id_seq", sequenceName = "idea_id_seq", allocationSize = 1)
    @Column(name = "id")
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "big_description", nullable = false)
    private String bigDescription;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinColumn(name = "author_id")
    private User author;

    @Column(name = "date", nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date date;

    @Column(name = "is_banned")
    private boolean isBanned;

    @OneToMany
    @JoinColumn(name = "idea_id")
    @JsonBackReference
    private List<Comment> listOfComments;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "idea_tag",
            joinColumns = @JoinColumn(name = "idea_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id")
    )
    private Set<Tag> setOfTags;

    @OneToMany(mappedBy = "idea", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Media> listOfMedia;

    @Formula("(Select count(*) from comment c where c.idea_id = id)")
    private long countOfComments;

    @Column(name = "views")
    private long amountOfViews;

    public Idea(String title, String bigDescription) {
        this.title = title;
        this.bigDescription = bigDescription;
        this.isBanned = false;
        this.setOfTags = new HashSet<>();
        this.listOfMedia = new ArrayList<>();
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
        return new ShortUser(author);
    }

    public void setAuthor(User author) {
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

    public List<Comment> getListOfComments() {
        return listOfComments;
    }

    public void setListOfComments(List<Comment> listOfComments) {
        this.listOfComments = listOfComments;
    }

    public long getAmountOfViews() {
        return amountOfViews;
    }

    public void setAmountOfViews(long amountOfViews) {
        this.amountOfViews = amountOfViews;
    }

    @Override
    public String toString() {
        return "Idea{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", bigDescription='" + bigDescription + '\'' +
                ", author=" + author +
                ", date=" + date +
                ", isBanned=" + isBanned +
                ", setOfTags=" + setOfTags +
                ", listOfMedia=" + listOfMedia +
                ", countOfComments=" + countOfComments +
                '}';
    }
}
