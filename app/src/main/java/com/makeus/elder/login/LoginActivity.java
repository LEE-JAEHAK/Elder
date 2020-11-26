package com.makeus.elder.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.makeus.elder.R;
import com.makeus.elder.login.interfaces.LoginActivityView;
import com.makeus.elder.login.models.RequestUser;
import com.makeus.elder.src.BaseActivity;

import static com.makeus.elder.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.makeus.elder.src.ApplicationClass.sSharedPreferences;

public class LoginActivity extends BaseActivity implements LoginActivityView {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        button = findViewById(R.id.login_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });

    }

    public void loginStart(String at) {
        System.out.println("login start = " + at);
        LoginService loginService = new LoginService(this);
        RequestUser requestUser = new RequestUser();
        requestUser.setAccess_token(at);
        loginService.postUser(requestUser);
    }

    @Override
    public void validateUserSuccess(String jwt, boolean isSuccess, int code, String message) {
        System.out.println("JWT = " + jwt);
        if (isSuccess) {
            showCustomToast(message);
            SharedPreferences.Editor editor = sSharedPreferences.edit();
            editor.putString(X_ACCESS_TOKEN, jwt);
            editor.commit();
            next();
        } else showCustomToast(message);
    }

    @Override
    public void validateUserFail(String msg) {
        showCustomToast(msg);
    }

    void next() {
        Intent intent = new Intent(this, Join1.class);
        startActivity(intent);
        finish();
    }
}