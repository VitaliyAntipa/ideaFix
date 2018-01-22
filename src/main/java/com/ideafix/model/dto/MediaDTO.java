package com.ideafix.model.dto;

public class MediaDTO {
    private String media_url;

    public MediaDTO(String media_url) {
        this.media_url = media_url;
    }

    public MediaDTO() {
    }

    public void setMedia_url(String media_url) {
        this.media_url = media_url;
    }

    public String getMedia_url() {
        return media_url;
    }
}
