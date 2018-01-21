package com.ideafix.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "idea_media")
public class Media implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="idea_media_id_seq")
    @SequenceGenerator(name="idea_media_id_seq", sequenceName="idea_media_id_seq", allocationSize=1)
    @Column(name = "id")
    private long id;

    @Column(name = "idea_id")
    private long ideaId;

    @Column(name = "media_url")
    private String mediaUrl;

    public Media(long ideaId, String mediaUrl) {
        this.ideaId = ideaId;
        this.mediaUrl = mediaUrl;
    }

    public Media(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Media() {
    }

    public long getIdeaId() {
        return ideaId;
    }

    public void setIdeaId(long ideaId) {
        this.ideaId = ideaId;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }
}
