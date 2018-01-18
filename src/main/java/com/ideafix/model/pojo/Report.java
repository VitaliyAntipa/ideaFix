package com.ideafix.model.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Report")
public class Report {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;

//    ?
    private User author;
//    ?
    private Idea reportedOn;

    @Column(name = "report_text")
    private String description;

    @Column(name = "date")
    private Date date;

    public Report(long id, User author, Idea reportedOn, String description, Date date) {
        this.id = id;
        this.author = author;
        this.reportedOn = reportedOn;
        this.description = description;
        this.date = date;
    }

    public Report() {
    }

    public User getAuthor() {
        return author;
    }

    public Idea getReportedOn() {
        return reportedOn;
    }

    public String getDescription() {
        return description;
    }

    public void setAuthor(User author) {
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
