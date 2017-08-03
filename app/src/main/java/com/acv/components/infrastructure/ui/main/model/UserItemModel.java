package com.acv.components.infrastructure.ui.main.model;

/**
 * Created by alejandro on 14/06/17.
 */

public class UserItemModel {
    private String id;
    private String fullName;
    private String email;
    private String picture;
    private String phone;

    public UserItemModel(String id, String fullName, String email, String picture, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.picture = picture;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPicture() {
        return picture;
    }

    public String getPhone() {
        return phone;
    }
}
