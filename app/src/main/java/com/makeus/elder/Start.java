package com.makeus.elder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.makeus.elder.Splash.Splash;
import com.makeus.elder.call.Schedule;

public class Start extends AppCompatActivity {
    TextView textView;
    ImageButton imageButton1,imageButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        imageButton1 = findViewById(R.id.center_iv_go_homepage);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.miraeseum.or.kr/"));
                startActivity(intent);
            }
        });

        imageButton2 = findViewById(R.id.center_iv_go_youtube);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/channel/UCo2z8iYOZCgbQ-SL8lbsmqw"));
                startActivity(intent);
            }
        });

        textView = findViewById(R.id.center_tv_start);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
    }
    void next() {
        Intent intent = new Intent(this, Splash.class);
        startActivity(intent);
        finish();
    }
}