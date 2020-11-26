package com.makeus.elder.Splash;


import com.makeus.elder.Splash.interfaces.LocationActivityView;
import com.makeus.elder.Splash.interfaces.LocationRetrofitInterface;
import com.makeus.elder.Splash.models.LocationResponse;
import com.makeus.elder.Splash.models.RequestLocation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.makeus.elder.src.ApplicationClass.getRetrofit;


public class LocationService {
    final LocationActivityView locationActivityView;

    public LocationService(LocationActivityView locationActivityView) {
        this.locationActivityView = locationActivityView;
    }

    void postUser(RequestLocation requestLocation) {
        final LocationRetrofitInterface locationRetrofitInterface = getRetrofit().create(LocationRetrofitInterface.class);
        locationRetrofitInterface.postLocation(requestLocation).enqueue(new Callback<LocationResponse>() {
            @Override
            public void onResponse(Call<LocationResponse> call, Response<LocationResponse> response) {
                final LocationResponse locationResponse = response.body();
                if (locationResponse == null) {
                    locationActivityView.validateUserFail(response.message());
                    return;
                }
                locationActivityView.validateUserSuccess(locationResponse.getIsSuccess(), locationResponse.getCode(), locationResponse.getMessage());
            }

            @Override
            public void onFailure(Call<LocationResponse> call, Throwable t) {
                locationActivityView.validateUserFail(t.getMessage());
            }
        });
    }
}
