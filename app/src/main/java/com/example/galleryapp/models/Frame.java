package com.example.galleryapp.models;

public class Frame {

    private int frameId;
    private String picture;
    private String title;

    public Frame(int frameId, String picture, String title) {
        this.frameId = frameId;
        this.picture = picture;
        this.title = title;
    }

    public int getFrameId() {
        return frameId;
    }

    public void setFrameId(int frameId) {
        this.frameId = frameId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
