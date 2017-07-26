package com.acv.components.domain.model;

public class Picture {
    private String medium;
    private String thumbnail;

    public Picture(String medium, String thumbnail) {
        this.medium = medium;
        this.thumbnail = thumbnail;
    }

    public String getMedium() {
        return medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}