package com.example.tsumusic.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout ed1, ed2;
    String user,email, pass;
    Button btLogin;
    Toolbar toolbar;
    Context mcontex;
    private MMToast mmToast;

    // Lưu phiên đăng nhập
    public void putStringValue(String key, String value) {
        SharedPreferences sharedPreferences = getSharedPreferences("SettingGame", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.textCreateAccount).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
                Animatoo.animateSlideRight(LoginActivity.this);
            }
        });
        findViewById(R.id.textviewforgotpassword).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ForgotpasswordActivity.class));
                Animatoo.animateSlideRight(LoginActivity.this);
            }
        });
        ed1 = findViewById(R.id.Username1);
        ed2 = findViewById(R.id.PassWord);
        btLogin = findViewById(R.id.btnsignin);
        toolbar = findViewById(R.id.textTitle);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                Animatoo.animateSlideLeft(LoginActivity.this);
            }
        });
//        Button xác thực đăng nhập
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Kiểm tra null
                if (TextUtils.isEmpty(ed1.getEditText().getText().toString()) && TextUtils.isEmpty(ed2.getEditText().getText().toString())) {
                    showToastFailure("Nhập tên đăng nhập/Mật khẩu");
                    ed1.setError(null);
                    ed2.setError(null);

                } else {
                    seeProfile();
                }
            }
        });
    }

    //    Hiện thông báo fail
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

    private void seeProfile() {
        user = ed1.getEditText().getText().toString().trim();
        pass = ed2.getEditText().getText().toString().trim();
        email = ed1.getEditText().getText().toString().trim();
//        Kiểm tra null
        if (user.isEmpty()) {
            ed1.setError("Enter Username");
            ed1.requestFocus();
            return;
        }
        else{
            ed1.setError(null);
        }
        //Kiểm tra null
        if (pass.isEmpty()) {

            ed2.setError("Enter password");
            ed2.requestFocus();
            return;
        }
        else {
            ed2.setError(null);
        }

        //      Gọi dữ liệu từ sever về
        Call<User> callback = API_Service.getService().logininfo(user, email, pass);
        callback.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
//                Đúng tên đăng nhập mật khẩu thì đăng nhập thành công
                if (user.getResponse().equals("ok")) {
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công!!!", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            putStringValue("username", user.getUser_name());
                            putStringValue("name", user.getName());
                            putStringValue("email", user.getEmail());
                            putStringValue("image",user.getUrl_image());
                            intent.putExtra("username", user.getUser_name());
                            startActivity(intent);
                            finish();
                        }
                    }, 100);
                }
//                Nhập sai mật khẩu hoặc tài khoản
                else if (user.getResponse().equals("failed")) {
                    showToastFailure("Tên đăng nhập hoặc mật khẩu không đúng!");
                    //Toast.makeText(SignInActivity.this, user.getResponse() + ",Tài khoản hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Đăng nhập thất bại!", Toast.LENGTH_SHORT);
            }
        });
    }
}