package com.makeus.elder.call.interfaces;


import com.makeus.elder.call.models.CallResponse;

import java.util.ArrayList;


public interface CallActivityView {
    void validateGroupSuccess(CallResponse.Result result, boolean isSuccess, int code, String message);

    void validateGroupFail(String msg);

}
