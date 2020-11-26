package com.makeus.elder.Splash.interfaces;

public interface LocationActivityView {
    void validateUserSuccess(boolean isSuccess, int code, String message);
    void validateUserFail(String msg);
}
