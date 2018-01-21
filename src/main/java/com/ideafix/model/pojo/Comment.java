package com.ideafix.model.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="comment_id_seq")
    @SequenceGenerator(name="comment_id_seq", sequenceName="comment_id_seq", allocationSize=1)
    @Column(name = "id")
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private ShortUser author;

    @Column(name = "idea_id")
    private long ideaId;

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    public Comment(ShortUser author, long ideaId, String text, Date date) {
        this.author = author;
        this.ideaId = ideaId;
        this.text = text;
        this.date = date;
    }

    public Comment() {
    }

    public ShortUser getAuthor() {
        return author;
    }

    public void setAuthor(ShortUser author) {
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
