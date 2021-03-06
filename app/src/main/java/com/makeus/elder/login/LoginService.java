package com.makeus.elder.login;


import com.makeus.elder.login.interfaces.LoginActivityView;
import com.makeus.elder.login.interfaces.LoginRetrofitInterface;
import com.makeus.elder.login.models.LoginResponse;
import com.makeus.elder.login.models.RequestUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.makeus.elder.src.ApplicationClass.getRetrofit;


public class LoginService {
    final LoginActivityView loginActivityView;

    public LoginService(LoginActivityView loginActivityView) {
        this.loginActivityView = loginActivityView;
    }

    void postUser(RequestUser requestUser) {
        final LoginRetrofitInterface loginRetrofitInterface = getRetrofit().create(LoginRetrofitInterface.class);
        loginRetrofitInterface.postUser(requestUser).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                final LoginResponse loginResponse = response.body();
                if (loginResponse == null) {
                    loginActivityView.validateUserFail(response.message());
                    return;
                }
                loginActivityView.validateUserSuccess(loginResponse.getInsertId(), loginResponse.getIsSuccess(), loginResponse.getCode(), loginResponse.getMessage());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                loginActivityView.validateUserFail(t.getMessage());
            }
        });
    }
}
