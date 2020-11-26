package com.makeus.elder.call;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.makeus.elder.R;
import com.makeus.elder.call.CallService;
import com.makeus.elder.call.interfaces.CallActivityView;
import com.makeus.elder.call.models.CallResponse;
import com.makeus.elder.src.BaseActivity;

import java.util.ArrayList;

public class Schedule extends BaseActivity implements CallActivityView {
    TextView textView,textView2,textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);
        textView = findViewById(R.id.schedule_tv_date);
        textView2 = findViewById(R.id.schedule_tv_time);
        textView3 = findViewById(R.id.schedule_tv_contents);

        CallService callService = new CallService(this);
        callService.getcall();
    }

    @Override
    public void validateGroupSuccess(CallResponse.Result result, boolean isSuccess, int code, String message) {
        showCustomToast(message);
        if(isSuccess){
            textView.setText(result.getVisit_date());
            textView2.setText(result.getVisit_time());
            textView3.setText(result.getVisit_content());
        }
    }

    @Override
    public void validateGroupFail(String msg) {
        showCustomToast(msg);
    }
}