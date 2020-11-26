package com.makeus.elder.config;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.makeus.elder.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.makeus.elder.src.ApplicationClass.sSharedPreferences;

public class XAccessTokenInterceptor implements Interceptor {

    @Override
    @NonNull
    public Response intercept(@NonNull final Interceptor.Chain chain) throws IOException {
        final Request.Builder builder = chain.request().newBuilder();
        final int jwtToken = sSharedPreferences.getInt("idx", 0);
        System.out.println("Interceptor : " + jwtToken);

        if (jwtToken != 0) {
            builder.addHeader("idx", String.valueOf(jwtToken));
            System.out.println("Interceptor : " + jwtToken);
        }
        return chain.proceed(builder.build());
    }
}
