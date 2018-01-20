package com.ideafix.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "idea_media")
public class Media implements Serializable {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "idea_id")
    @JsonIgnore
    private long ideaId;

    @Column(name = "media_url")
    private String mediaUrl;

    public Media(long ideaId, String mediaUrl) {
        this.ideaId = ideaId;
        this.mediaUrl = mediaUrl;
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
