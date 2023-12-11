package com.example.SW_PBL.Festival;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fstvl {

    private int Fstvl_id;
    private String title;
    private String date;
    private String location;
    private String photo;
    private String price;
    private String phone;
    private String text;

    public Fstvl() {
    }

    public Fstvl(int fstvl_id, String title, String date, String location, String photo, String price, String phone, String text) {
        Fstvl_id = fstvl_id;
        this.title = title;
        this.date = date;
        this.location = location;
        this.photo = photo;
        this.price = price;
        this.phone = phone;
        this.text = text;
    }
}
