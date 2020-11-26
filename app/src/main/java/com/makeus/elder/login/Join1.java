package com.makeus.elder.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.makeus.elder.R;

import static com.makeus.elder.src.ApplicationClass.sSharedPreferences;

public class Join1 extends AppCompatActivity {
    Button button;
    EditText editText;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join1);
        button = findViewById(R.id.join1_btn_next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
        editText = findViewById(R.id.join1_name);

    }

    void next() {
        Intent intent = new Intent(this, Join2.class);
        s = editText.getText().toString();
        SharedPreferences.Editor editor = sSharedPreferences.edit();
        editor.putString("name", s);
        editor.commit();
        startActivity(intent);
        finish();
    }
}