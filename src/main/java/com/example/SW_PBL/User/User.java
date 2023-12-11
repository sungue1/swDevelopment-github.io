package com.example.SW_PBL.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int user_id;
    private String user_location;



    public User(int user_id, String user_location) {
        this.user_id = user_id;
        this.user_location = user_location;

    }

    public User() {
    }
}
