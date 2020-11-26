package com.makeus.elder.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.makeus.elder.R;
import com.makeus.elder.contact.interfaces.ContactActivityView;
import com.makeus.elder.contact.models.RequestContact;
import com.makeus.elder.src.BaseActivity;

import static com.makeus.elder.src.ApplicationClass.sSharedPreferences;

public class Call extends BaseActivity implements ContactActivityView {
    ImageView imageView1,imageView2,imageView3,imageView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call);
        imageView1=findViewById(R.id.call_iv_hospital);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state("아프다");
            }
        });
        imageView2=findViewById(R.id.call_iv_sleep);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state("졸리다");
            }
        });
        imageView3=findViewById(R.id.call_iv_outdoor);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state("외출한다");
            }
        });
        imageView4=findViewById(R.id.call_iv_hungry);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state("배고프다");
            }
        });

    }

    public void state(String s) {
        ContactService contactService = new ContactService(this);
        RequestContact requestContact = new RequestContact();
        requestContact.setState(s);
        contactService.postUser(requestContact);
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