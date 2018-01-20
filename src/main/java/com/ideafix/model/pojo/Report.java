package com.ideafix.model.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "report")
public class Report implements Serializable {

    @Id
    @Column(name = "id")
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private ShortUser author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idea_id")
    private Idea reportedOn;

    @Column(name = "report_text")
    private String description;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    public Report(ShortUser author, Idea reportedOn, String description, Date date) {
        this.author = author;
        this.reportedOn = reportedOn;
        this.description = description;
        this.date = date;
    }

    public Report() {
    }

    public ShortUser getAuthor() {
        return author;
    }

    public Idea getReportedOn() {
        return reportedOn;
    }

    public String getDescription() {
        return description;
    }

    public void setAuthor(ShortUser author) {
        this.author = author;
    }

    public void setReportedOn(Idea reportedOn) {
        this.reportedOn = reportedOn;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
