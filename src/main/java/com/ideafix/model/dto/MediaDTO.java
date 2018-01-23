package com.ideafix.model.dto;

public class MediaDTO {
    private String mediaUrl;

    public MediaDTO(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public MediaDTO() {
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }
}
