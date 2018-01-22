package com.ideafix.model.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "report")
public class Report implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "report_id_seq")
    @SequenceGenerator(name = "report_id_seq", sequenceName = "report_id_seq", allocationSize = 1)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "idea_id")
    private Idea reportedOn;

    @Column(name = "report_text", nullable = false)
    private String description;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    public Report(String description) {
        this.description = description;
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
