package com.acv.components.infrastructure.ui.main;


public class User {

    public String id;
    public String email;

    public User(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }
}

