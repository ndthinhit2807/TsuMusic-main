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
//      Ki???m tra email c?? null kh??ng
        if (email.isEmpty()) {
            emailput.setError("Nh???p email!");
            emailput.requestFocus();
            return;
        }
//        Ki???m tra ????? d??i cho ph??p nh???p c???a email
        else if (email.length() > 50) {
            emailput.setError("Email v?????t qu?? ????? d??i cho ph??p!");
            emailput.requestFocus();
            return;
        }
//        ki???m tra t??nh h???p l??? c???a email
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailput.setError("Email kh??ng h???p l???!");
            emailput.requestFocus();
            return;
        }
//      sau khi check r??ng bu???c => ki???m tra email g???i th??nh c??ng ho???c l???i
        else {
            Intent intent = new Intent(ForgotpasswordActivity.this, LoginActivity.class);
            startActivity(intent);
//            Toast.makeText(this, "???? g???i email", Toast.LENGTH_SHORT).show();
//            tr??? v??? gi?? tr??? chu??i link t??? server
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Urls.Fogot_password_url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject object = new JSONObject(response);
//                                n???u email tr??ng v???i email c?? tr??n h??? th???ng s??? g???i email ?????n email c???a ng?????i d??ng v?? th??ng b??o g???i th??nh c??ng
                                String mail = object.getString("mail");
                                if (mail.equals("send")) {
                                    Toast.makeText(ForgotpasswordActivity.this, "???? g???i mail th??nh c??ng", Toast.LENGTH_SHORT).show();
                                } else {
                                    massage(response);

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
//                        nh???n l???i nh???ng problem b??n trong request c???a b???n t??? server
                    }, new Response.ErrorListener() {
                @Override
//                Th??ng b??o g???i email fail
                public void onErrorResponse(VolleyError error) {
                    massage(error.toString());
//                    show error
//                    error.printStackTrace();
                }
            }) {
                @Nullable
                @Override
//               Map d??ng ????? l??u tr??? v?? truy xu???t d??? li???u theo c???p key v?? value
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> forgotparam = new HashMap<>();
//                    g???i key email
                    forgotparam.put("email", email);
                    return forgotparam;
                }
            };
//           L???y d??? li???u v???
            RequestQueue requestQueue = Volley.newRequestQueue(ForgotpasswordActivity.this);
            requestQueue.add(stringRequest);
        }
    }
}
