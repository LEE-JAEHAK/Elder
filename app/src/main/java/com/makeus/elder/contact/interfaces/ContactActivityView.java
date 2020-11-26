package com.makeus.elder.contact.interfaces;

public interface ContactActivityView {
    void validateUserSuccess(boolean isSuccess, int code, String message);
    void validateUserFail(String msg);
}
