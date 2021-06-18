package com.example.tsumusic.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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

public class ChangepasswordActivity extends AppCompatActivity {
    TextInputLayout oldpwd, newpwd, confirmpwd;
    String oldpwd1, newpwd1, confirmpwd1;
    Button btnSubmit;
    Toolbar toolbar;
    private MMToast mmToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        oldpwd = (TextInputLayout) findViewById(R.id.old_password);
        newpwd = (TextInputLayout) findViewById(R.id.new_password);
        confirmpwd = (TextInputLayout) findViewById(R.id.confirm_password);
        toolbar = findViewById(R.id.textTitle);
        btnSubmit = findViewById(R.id.btnSubmit);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                Animatoo.animateSlideLeft(ChangepasswordActivity.this);
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangepassUser();//khi bấm button gửi sẽ kiểm tra ràng buộc mật khẩu
            }
        });
    }

    //    kiểm tra password
    public boolean isValidPassword(String newpwd) {
        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$"; //Password phải có ít nhất 6 ký tự. phải có ký tự hoa, thường, số và không có khoảng trắng
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(newpwd);
        return matcher.matches();
    }

    //    hiện thông báo fail
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

    //    Thay đổi mật khẩu
    private void ChangepassUser() {
        oldpwd1 = oldpwd.getEditText().getText().toString().trim();
        newpwd1 = newpwd.getEditText().getText().toString().trim();
        confirmpwd1 = confirmpwd.getEditText().getText().toString().trim();

//        Kiểm tra password cũ có null không
        if (oldpwd1.isEmpty()) {
            oldpwd.setError("Nhập mật khẩu!");
            oldpwd.requestFocus();
            return;
        }
//         Kiểm tra password cũ có null không
        else if (newpwd1.isEmpty()) {
            newpwd.setError("Nhập mật khẩu!");
            newpwd.requestFocus();
            return;
//          Kiểm tra độ dài password
        } else if (newpwd1.length() < 6) {
            newpwd.setError("Nhập mật khẩu từ 6 đén 20 ký tự!");
            newpwd.requestFocus();
            return;
        } else if (newpwd1.length() > 20) {
            newpwd.setError("Nhập mật khẩu từ 6 đến 20 ký tự!");
            newpwd.requestFocus();
            return;
        } else if (!isValidPassword(newpwd1)) {
            newpwd.setError("Mật khẩu phải có ít nhất 1 ký tự thường, hoa, số, đặc biệt!");
            newpwd.requestFocus();
            return;
        } else if (confirmpwd1.isEmpty()) {
            confirmpwd.setError("Nhập mật khẩu!");
            confirmpwd.requestFocus();
            return;
        } else {
            SharedPreferences sharedPreferences = getSharedPreferences("SettingGame", Context.MODE_PRIVATE);
            String username = sharedPreferences.getString("username", null);
            Call<User> callback = API_Service.getService().changepassword(oldpwd1, newpwd1, confirmpwd1, username);
            callback.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
//                        Mật khẩu mới và mật khẩu xác nhận trùng nhau thì đổi mật khẩu thành công
                    if (response.body().getResponse().equals("oke")) {

                        Toast.makeText(ChangepasswordActivity.this, "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ChangepasswordActivity.this, HomeActivity.class);
                        startActivity(intent);
//                        Mật khẩu cũ chưa đúng trong hệ thống
                    } else if (response.body().getResponse().equals("notexsits")) {
                        oldpwd.setError("Mật khẩu cũ không đúng!");
                        oldpwd.requestFocus();
                    } else if (response.body().getResponse().equals("error")) {
                        showToastFailure("Lỗi không xác định!");

                    } else if (response.body().getResponse().equals("notsame")) {
//                        showToastFailure("Mật khẩu mới không giống nhau!");
                        confirmpwd.setError("Mật khẩu mới không giống nhau!");
                        confirmpwd.requestFocus();
                    }
                }
                @Override
                public void onFailure(Call<User> call, Throwable t) {
                }
            });
        }

    }
}