package com.example.tsumusic.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.Dialog.MMToast;
import com.example.tsumusic.Model.User;
import com.example.tsumusic.R;
import com.example.tsumusic.Service.API_Service;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    TextInputLayout name, user_name, password, email;
    String name1, user_name1, password1, email1;
    Button btCreate;
    private MMToast mmToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        findViewById(R.id.textSingIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                Animatoo.animateSlideLeft(SignUpActivity.this);
            }
        });
        name = (TextInputLayout) findViewById(R.id.CreateName);
        user_name = (TextInputLayout) findViewById(R.id.CreateUserName);
        password = (TextInputLayout) findViewById(R.id.CreatePassWord);
        email = (TextInputLayout) findViewById(R.id.email);
        btCreate = findViewById(R.id.btnCreate);
        btCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

        Toolbar toolbar = findViewById(R.id.textTitle);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                Animatoo.animateSlideLeft(SignUpActivity.this);
            }
        });
    }

    //R??ng bu???c password
    public boolean isValidPassword(String password1) {
        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password1);
        return matcher.matches();
    }
    //hi???n th??ng b??o fail
    protected void showToastFailure(String msg) {
        if (mmToast == null) {
            MMToast.Builder builder = new MMToast.Builder(this)
                    .setMessage(msg)
                    .setSuccess(false);
            mmToast = builder.create();
        } else {
            mmToast.cancel();
            MMToast.Builder builder = new MMToast.Builder(this)
                    .setMessage(msg)
                    .setSuccess(false);
            mmToast = builder.create();
        }
        mmToast.show();
    }

    private void registerUser() {
        name1 = name.getEditText().getText().toString().trim();
        user_name1 = user_name.getEditText().getText().toString().trim();
        password1 = password.getEditText().getText().toString().trim();
        email1 = email.getEditText().getText().toString().trim();
        //Ki???m tra r???ng
        if (name1.isEmpty()) {
            name.setError("Nh???p h??? t??n!");
            name.requestFocus();
            return;
        }
        //Ki???m tra ????? d??i
        else if (name1.length() > 50) {
            name.setError("H??? t??n v?????t qu?? ????? d??i cho ph??p!");
            name.requestFocus();
            return;
        }
//                Ki???m tra r???ng
        else if (user_name1.isEmpty()) {
            user_name.setError("Nh???p t??n ????ng nh???p!");
            user_name.requestFocus();
            return;
        }
//                Ki???m tra ????? d??i
        else if (user_name1.length() > 50) {
            user_name.setError("T??i kho???n qu?? ????? d??i cho ph??p!");
            user_name.requestFocus();
            return;
        }
//                Ki???m tra r???ng
        else if (password1.isEmpty()) {
            password.setError("Nh???p m???t kh???u!");
            password.requestFocus();
            return;
        }
//                 Ki???m tra ????? d??i
        else if (password1.length() < 6) {
            password.setError("Nh???p m???t kh???u t??? 6 ????n 20 k?? t???!");
            password.requestFocus();
            return;
        }
//                Ki???m tra ????? d??i
        else if (password1.length() > 20) {
            password.setError("Nh???p m???t kh???u t??? 6 ?????n 20 k?? t???!");
            password.requestFocus();
            return;
        }
//                ki???m tra r??ng bu???c pass
        else if (!isValidPassword(password1)) {
            password.setError("M???t kh???u ph???i c?? ??t nh???t 1 k?? t??? th?????ng, hoa, s???, ?????c bi???t!");
            password.requestFocus();
            return;
        }
//                Ki???m tra r???ng
        else if (email1.isEmpty()) {
            email.setError("Nh???p email!");
            email.requestFocus();
            return;
        }
//        Ki???m tra ????? d??i
        else if (email1.length() > 50) {
            email.setError("Email v?????t qu?? ????? d??i cho ph??p!");
            email.requestFocus();
            return;
        }
//        Ki???m tra r??ng bu???c
        else if (!Patterns.EMAIL_ADDRESS.matcher(email1).matches()) {
            email.setError("Email kh??ng h???p l???!");
            email.requestFocus();
            return;
        } else {
            Call<User> callback = API_Service.getService().register(name1, user_name1, password1, email1);
            callback.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    // Tho??? m??n ??i???u c??c ??i???u ki???n r??ng bu???c th?? th??m d??? li???u v??o database
                    if (response.body().getResponse().equals("inserted")) {
                        Toast.makeText(SignUpActivity.this, "????ng k?? th??nh c??ng", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
//                    Ki???m tra d??? li???u ???? c?? trong database ch??a
                    else if (response.body().getResponse().equals("exists")) {
                        showToastFailure("T??n ????ng nh???p ???????c s??? d???ng!");
//                      Ki???m tra d??? li???u ???? c?? trong database ch??a
                    } else if (response.body().getResponse().equals("exists1")) {
                        showToastFailure("Email ???? ???????c s??? d???ng!");
                    } else if (response.body().getResponse().equals("error")) {
                        showToastFailure("L???i kh??ng x??c ?????nh!");
                    }
                }
                @Override
                public void onFailure(Call<User> call, Throwable t) {
                }
            });
        }
    }
}