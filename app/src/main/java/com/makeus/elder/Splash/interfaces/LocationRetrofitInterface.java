package com.makeus.elder.Splash.interfaces;

import com.makeus.elder.Splash.models.LocationResponse;
import com.makeus.elder.Splash.models.RequestLocation;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LocationRetrofitInterface {
    @POST("/elder/location")
    Call<LocationResponse> postLocation(@Body RequestLocation params);
}
