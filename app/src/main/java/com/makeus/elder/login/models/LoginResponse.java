package com.makeus.elder.login.models;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("insertId")
    int insertId;

    @SerializedName("isSuccess")
    boolean isSuccess;

    @SerializedName("code")
    int code;

    @SerializedName("message")
    String message;

    public int getInsertId() {
        return insertId;
    }


    public boolean getIsSuccess() {
        return isSuccess;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
