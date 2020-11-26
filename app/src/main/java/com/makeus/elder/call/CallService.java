package com.makeus.elder.call;


import com.makeus.elder.call.interfaces.CallActivityView;
import com.makeus.elder.call.interfaces.CallRetrofitInterface;
import com.makeus.elder.call.models.CallResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.makeus.elder.src.ApplicationClass.getRetrofit;


public class CallService {
    final CallActivityView callActivityView;

    public CallService(CallActivityView callActivityView) {
        this.callActivityView = callActivityView;
    }

    public void getcall() {
        final CallRetrofitInterface callRetrofitInterface = getRetrofit().create(CallRetrofitInterface.class);
        callRetrofitInterface.getcall().enqueue(new Callback<CallResponse>() {
            @Override
            public void onResponse(Call<CallResponse> call, Response<CallResponse> response) {
                final CallResponse callResponse = response.body();
                callActivityView.validateGroupSuccess(callResponse.getResult(), callResponse.getIsSuccess(), callResponse.getCode(), callResponse.getMessage());
            }

            @Override
            public void onFailure(Call<CallResponse> call, Throwable t) {
                callActivityView.validateGroupFail(t.getMessage());
            }
        });
    }
}
