package com.makeus.elder.login.models;

import com.google.gson.annotations.SerializedName;

public class RequestUser {
    @SerializedName("name")
    public String name;

    @SerializedName("phone")
    public String phone;

    @SerializedName("type")
    public String type;

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setType(String type) {
        this.type = type;
    }
}
