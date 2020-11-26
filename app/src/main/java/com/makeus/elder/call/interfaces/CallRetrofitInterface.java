package com.makeus.elder.call.interfaces;


import com.makeus.elder.call.models.CallResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CallRetrofitInterface {
    @GET("/elder/calendar")
    Call<CallResponse> getcall();
}
