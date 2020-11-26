package com.makeus.elder.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.makeus.elder.MainActivity;
import com.makeus.elder.R;
import com.makeus.elder.login.interfaces.LoginActivityView;
import com.makeus.elder.login.models.RequestUser;
import com.makeus.elder.src.BaseActivity;

import static com.makeus.elder.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.makeus.elder.src.ApplicationClass.sSharedPreferences;

public class Join2 extends BaseActivity implements LoginActivityView {
    Button button;
    EditText editText;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join2);

        button = findViewById(R.id.join2_btn_submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginStart();
            }
        });
        editText = findViewById(R.id.join2_phonenum);

    }

    void next() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void loginStart() {
        LoginService loginService = new LoginService(this);
        RequestUser requestUser = new RequestUser();
        String name = sSharedPreferences.getString("name","");
        s = editText.getText().toString();
        System.out.println(name+s);
        requestUser.setName(name);
        requestUser.setPhone(s);
        requestUser.setType("ELDER");
        loginService.postUser(requestUser);
    }
    @Override
    public void validateUserSuccess(int insertId, boolean isSuccess, int code, String message) {
        if (isSuccess) {
            showCustomToast(message);
            SharedPreferences.Editor editor = sSharedPreferences.edit();
            editor.putInt("idx", insertId);
            editor.commit();
            next();
        } else showCustomToast(message);
    }

    @Override
    public void validateUserFail(String msg) {
        showCustomToast(msg);
    }
}