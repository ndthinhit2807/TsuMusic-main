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
                ChangepassUser();//khi b???m button g???i s??? ki???m tra r??ng bu???c m???t kh???u
            }
        });
    }

    //    ki???m tra password
    public boolean isValidPassword(String newpwd) {
        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$"; //Password ph???i c?? ??t nh???t 6 k?? t???. ph???i c?? k?? t??? hoa, th?????ng, s??? v?? kh??ng c?? kho???ng tr???ng
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(newpwd);
        return matcher.matches();
    }

    //    hi???n th??ng b??o fail
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

    //    Thay ?????i m???t kh???u
    private void ChangepassUser() {
        oldpwd1 = oldpwd.getEditText().getText().toString().trim();
        newpwd1 = newpwd.getEditText().getText().toString().trim();
        confirmpwd1 = confirmpwd.getEditText().getText().toString().trim();

//        Ki???m tra password c?? c?? null kh??ng
        if (oldpwd1.isEmpty()) {
            oldpwd.setError("Nh???p m???t kh???u!");
            oldpwd.requestFocus();
            return;
        }
//         Ki???m tra password c?? c?? null kh??ng
        else if (newpwd1.isEmpty()) {
            newpwd.setError("Nh???p m???t kh???u!");
            newpwd.requestFocus();
            return;
//          Ki???m tra ????? d??i password
        } else if (newpwd1.length() < 6 || newpwd1.length() > 20) {
            newpwd.setError("Nh???p m???t kh???u t??? 6 ????n 20 k?? t???!");
            newpwd.requestFocus();
            return;

        } else if (!isValidPassword(newpwd1)) {
            newpwd.setError("M???t kh???u ph???i c?? ??t nh???t 1 k?? t??? th?????ng, hoa, s???, ?????c bi???t!");
            newpwd.requestFocus();
            return;
        } else if (confirmpwd1.isEmpty()) {
            confirmpwd.setError("Nh???p m???t kh???u!");
            confirmpwd.requestFocus();
            return;
        } else {
            SharedPreferences sharedPreferences = getSharedPreferences("SettingGame", Context.MODE_PRIVATE);
            String username = sharedPreferences.getString("username", null);
            Call<User> callback = API_Service.getService().changepassword(oldpwd1, newpwd1, confirmpwd1, username);
            callback.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
//                        M???t kh???u m???i v?? m???t kh???u x??c nh???n tr??ng nhau th?? ?????i m???t kh???u th??nh c??ng
                    if (response.body().getResponse().equals("oke")) {

                        Toast.makeText(ChangepasswordActivity.this, "?????i m???t kh???u th??nh c??ng", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ChangepasswordActivity.this, HomeActivity.class);
                        startActivity(intent);
//                        M???t kh???u c?? ch??a ????ng trong h??? th???ng
                    } else if (response.body().getResponse().equals("notexsits")) {
                        oldpwd.setError("M???t kh???u c?? kh??ng ????ng!");
                        oldpwd.requestFocus();
                    } else if (response.body().getResponse().equals("error")) {
                        showToastFailure("L???i kh??ng x??c ?????nh!");

                    } else if (response.body().getResponse().equals("notsame")) {
//                        showToastFailure("M???t kh???u m???i kh??ng gi???ng nhau!");
                        confirmpwd.setError("M???t kh???u m???i kh??ng gi???ng nhau!");
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