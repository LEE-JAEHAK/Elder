package com.makeus.elder.login.interfaces;

public interface LoginActivityView {
    void validateUserSuccess(String jwt, boolean isSuccess, int code, String message);
    void validateUserFail(String msg);
}
