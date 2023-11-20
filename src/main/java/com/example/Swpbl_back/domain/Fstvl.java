package com.example.Swpbl_back.domain;

public class Fstvl {

    private  Long Fstvl_id;
    private String title;
    private String date;
    private String location;
    private String photo;
    private String price;
    private String phone;
    private String text;
    private String fstvl_keyword;

    public String getFstvl_keyword() {
        return fstvl_keyword;
    }

    public void setFstvl_keyword(String fstvl_keyword) {
        this.fstvl_keyword = fstvl_keyword;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }




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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
