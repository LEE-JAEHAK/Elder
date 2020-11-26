package com.makeus.elder.Splash;

import android.content.Intent;
import android.os.Bundle;

import com.makeus.elder.R;
import com.makeus.elder.login.LoginActivity;
import com.makeus.elder.src.BaseActivity;

public class Splash extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread splash = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1500);
                    next();
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

}