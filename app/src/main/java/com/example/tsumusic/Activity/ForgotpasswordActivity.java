package com.example.tsumusic.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.R;
import com.example.tsumusic.Service.Urls;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ForgotpasswordActivity extends AppCompatActivity {
    TextInputLayout emailput;
    String email;
    Button btnsubmit;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        btnsubmit = (Button) findViewById(R.id.btnSubmitfgpwd);
        emailput = (TextInputLayout) findViewById(R.id.edtemail);
        toolbar = findViewById(R.id.textTitle);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                Animatoo.animateSlideLeft(ForgotpasswordActivity.this);
            }
        });
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Forgot_password();
            }
        });
    }

    public void massage(String massage) {
        Toast.makeText(this, massage, Toast.LENGTH_SHORT).show();
    }

    private void Forgot_password() {
        ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
        View v = new View(this);
        v.setBackgroundColor(Color.RED);
        email = emailput.getEditText().getText().toString().trim();
//        Kiểm tra email có null không
        if (email.isEmpty()) {
            emailput.setError("Nhập email!");
            emailput.requestFocus();
            return;
        }
//        Kiểm tra độ dài cho phép nhập của email
        else if (email.length() > 50) {
            emailput.setError("Email vượt quá độ dài cho phép!");
            emailput.requestFocus();
            return;
        }
//        kiểm tra tính hợp lệ của email
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailput.setError("Email không hợp lệ!");
            emailput.requestFocus();
            return;
        }
//       sau khi check ràng buộc => kiểm tra email gửi thành công hoặc lỗi
        else {
            Intent intent = new Intent(ForgotpasswordActivity.this, LoginActivity.class);
            startActivity(intent);
//            Toast.makeText(this, "Đã gửi email", Toast.LENGTH_SHORT).show();
//            trả về giá trị chuôi link từ server
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Urls.Fogot_password_url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject object = new JSONObject(response);
//                                nếu email trùng với email có trên hệ thống sẽ gửi email đến email của người dùng và thông báo gửi thành công
                                String mail = object.getString("mail");
                                if (mail.equals("send")) {
                                    Toast.makeText(ForgotpasswordActivity.this, "Đã gửi mail thành công", Toast.LENGTH_SHORT).show();
                                } else {
                                    massage(response);

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
//                        nhận lại những problem bên trong request của bạn từ server
                    }, new Response.ErrorListener() {
                @Override
//                Thông báo gửi email fail
                public void onErrorResponse(VolleyError error) {
                    massage(error.toString());
//                    show error
//                    error.printStackTrace();
                }
            }) {
                @Nullable
                @Override
//               Map dùng để lưu trữ và truy xuất dữ liệu theo cặp key và value
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> forgotparam = new HashMap<>();
//                    gửi key email
                    forgotparam.put("email", email);
                    return forgotparam;
                }
            };
//           Lấy dự liệu về
            RequestQueue requestQueue = Volley.newRequestQueue(ForgotpasswordActivity.this);
            requestQueue.add(stringRequest);
        }
    }
}
