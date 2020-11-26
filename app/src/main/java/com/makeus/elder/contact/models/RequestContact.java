package com.makeus.elder.contact.models;

import com.google.gson.annotations.SerializedName;

public class RequestContact {
    @SerializedName("state")
    public String state;

    public void setState(String state) {
        this.state = state;
    }
}
