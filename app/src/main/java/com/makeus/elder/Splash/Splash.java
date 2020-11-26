package com.makeus.elder.Splash;

import android.content.Intent;
import android.os.Bundle;

import com.makeus.elder.GpsTracker;
import com.makeus.elder.MainActivity;
import com.makeus.elder.R;
import com.makeus.elder.Splash.interfaces.LocationActivityView;
import com.makeus.elder.Splash.models.RequestLocation;
import com.makeus.elder.login.LoginActivity;
import com.makeus.elder.src.BaseActivity;

import static com.makeus.elder.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.makeus.elder.src.ApplicationClass.sSharedPreferences;

public class Splash extends BaseActivity implements LocationActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        GpsTracker mGpsTracker = new GpsTracker(this);
        double latitude = mGpsTracker.getLatitude();    // 위도
        double longitude = mGpsTracker.getLongitude();  // 경도

        LocationService locationService = new LocationService(this);
        RequestLocation requestLocation = new RequestLocation();
        requestLocation.setLatitude(String.valueOf(latitude));
        requestLocation.setLongtitude(String.valueOf(longitude));
        locationService.postUser(requestLocation);
        System.out.println(latitude+"  "+longitude);

        Thread splash = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1500);
                    int num = sSharedPreferences.getInt("idx", -1);
                    if (num == -1)
                        next();
                    else
                        next2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        splash.start();
    }

    void next() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    void next2() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void validateUserSuccess(boolean isSuccess, int code, String message) {
        showCustomToast(message);
    }

    @Override
    public void validateUserFail(String msg) {
        showCustomToast(msg);
    }
}