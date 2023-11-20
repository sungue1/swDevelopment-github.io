package com.example.Swpbl_back.domain;

public class User {
    private Long user_id;
    private String user_location;
    private String user_start;
    private String user_end;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_location() {
        return user_location;
    }

    public void setUser_location(String user_location) {
        this.user_location = user_location;
    }

    public String getUser_start() {
        return user_start;
    }

    public void setUser_start(String user_start) {
        this.user_start = user_start;
    }

    public String getUser_end() {
        return user_end;
    }

    public void setUse_rend(String use_rend) {
        this.user_end = use_rend;
    }


}
