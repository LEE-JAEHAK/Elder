package com.makeus.elder.login.interfaces;

public interface LoginActivityView {
    void validateUserSuccess(int insertId, boolean isSuccess, int code, String message);
    void validateUserFail(String msg);
}
