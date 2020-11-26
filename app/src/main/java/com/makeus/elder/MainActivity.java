package com.makeus.elder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.makeus.elder.call.Schedule;
import com.makeus.elder.contact.Call;

import static com.makeus.elder.src.ApplicationClass.sSharedPreferences;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout constraintLayout;
    ConstraintLayout constraintLayout2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        constraintLayout = findViewById(R.id.main_constraint_schedule);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
        constraintLayout2 = findViewById(R.id.main_constraint_call);
        System.out.println(sSharedPreferences.getInt("idx",0));
        constraintLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next2();
            }
        });
    }
    void next() {
        Intent intent = new Intent(this, Schedule.class);
        startActivity(intent);
    }
    void next2() {
        Intent intent = new Intent(this, Call.class);
        startActivity(intent);
    }
}