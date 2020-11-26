package com.makeus.elder.Splash.models;

import com.google.gson.annotations.SerializedName;

public class RequestLocation {
    @SerializedName("latitude")
    public String latitude;

    @SerializedName("longitude")
    public String longitude;

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongtitude(String longtitude) {
        this.longitude = longtitude;
    }
}
