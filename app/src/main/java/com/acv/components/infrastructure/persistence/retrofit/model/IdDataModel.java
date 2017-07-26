package com.acv.components.infrastructure.persistence.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class IdDataModel {

    @SerializedName("name")
    private String name;

    @SerializedName("value")
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
