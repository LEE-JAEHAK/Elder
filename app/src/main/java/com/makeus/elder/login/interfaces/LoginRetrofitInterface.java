package com.makeus.elder.login.interfaces;

import com.makeus.elder.login.models.LoginResponse;
import com.makeus.elder.login.models.RequestUser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginRetrofitInterface {
    @POST("/user")
    Call<LoginResponse> postUser(@Body RequestUser params);
}
