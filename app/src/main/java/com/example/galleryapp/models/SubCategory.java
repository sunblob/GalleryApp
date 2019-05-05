package com.example.galleryapp.models;

public class SubCategory {

    private int subId;
    private String subTitle;

    public SubCategory(int subId, String title) {
        this.subId = subId;
        this.subTitle = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public int getSubId(){
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public void setSubTitle(String title) {
        this.subTitle = title;
    }
}
