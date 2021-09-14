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

    //Ràng buộc password
    public boolean isValidPassword(String password1) {
        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password1);
        return matcher.matches();
    }
    //hiện thông báo fail
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
        //Kiểm tra rỗng
        if (name1.isEmpty()) {
            name.setError("Nhập họ tên!");
            name.requestFocus();
            return;
        }
        //Kiểm tra độ dài
        else if (name1.length() > 50) {
            name.setError("Họ tên vượt quá độ dài cho phép!");
            name.requestFocus();
            return;
        }
//                Kiểm tra rỗng
        else if (user_name1.isEmpty()) {
            user_name.setError("Nhập tên đăng nhập!");
            user_name.requestFocus();
            return;
        }
//                Kiểm tra độ dài
        else if (user_name1.length() > 50) {
            user_name.setError("Tài khoản quá độ dài cho phép!");
            user_name.requestFocus();
            return;
        }
//                Kiểm tra rỗng
        else if (password1.isEmpty()) {
            password.setError("Nhập mật khẩu!");
            password.requestFocus();
            return;
        }
//                 Kiểm tra độ dài
        else if (password1.length() < 6) {
            password.setError("Nhập mật khẩu từ 6 đén 20 ký tự!");
            password.requestFocus();
            return;
        }
//                Kiểm tra độ dài
        else if (password1.length() > 20) {
            password.setError("Nhập mật khẩu từ 6 đến 20 ký tự!");
            password.requestFocus();
            return;
        }
//                kiểm tra ràng buộc pass
        else if (!isValidPassword(password1)) {
            password.setError("Mật khẩu phải có ít nhất 1 ký tự thường, hoa, số, đặc biệt!");
            password.requestFocus();
            return;
        }
//                Kiểm tra rỗng
        else if (email1.isEmpty()) {
            email.setError("Nhập email!");
            email.requestFocus();
            return;
        }
//        Kiểm tra độ dài
        else if (email1.length() > 50) {
            email.setError("Email vượt quá độ dài cho phép!");
            email.requestFocus();
            return;
        }
//        Kiểm tra ràng buộc
        else if (!Patterns.EMAIL_ADDRESS.matcher(email1).matches()) {
            email.setError("Email không hợp lệ!");
            email.requestFocus();
            return;
        } else {
            Call<User> callback = API_Service.getService().register(name1, user_name1, password1, email1);
            callback.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    // Thoả mãn điều các điều kiện ràng buộc thì thêm dữ liệu vào database
                    if (response.body().getResponse().equals("inserted")) {
                        Toast.makeText(SignUpActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
//                    Kiểm tra dữ liệu đã có trong database chưa
                    else if (response.body().getResponse().equals("exists")) {
                        showToastFailure("Tên đăng nhập được sử dụng!");
//                      Kiểm tra dữ liệu đã có trong database chưa
                    } else if (response.body().getResponse().equals("exists1")) {
                        showToastFailure("Email đã được sử dụng!");
                    } else if (response.body().getResponse().equals("error")) {
                        showToastFailure("Lỗi không xác định!");
                    }
                }
                @Override
                public void onFailure(Call<User> call, Throwable t) {
                }
            });
        }
    }
}