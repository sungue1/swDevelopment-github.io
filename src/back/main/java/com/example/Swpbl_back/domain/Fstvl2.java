package com.example.Swpbl_back.domain;

public class Fstvl2 {
    public Long getFstvl_id() {
        return Fstvl_id;
    }

    public void setFstvl_id(Long fstvl_id) {
        Fstvl_id = fstvl_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    private  Long Fstvl_id;
    private String title;
    private String date;
    private String location;
    private String photo;
}
