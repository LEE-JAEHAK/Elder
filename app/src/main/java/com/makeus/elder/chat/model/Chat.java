package com.makeus.elder.chat.model;

public class Chat {

    private String name;
    private String createdAt;
    private String status;
    private boolean isMine;

    public boolean isMine() {
        return isMine;
    }

    public String getName() {
        return name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getStatus() {
        return status;
    }
}
