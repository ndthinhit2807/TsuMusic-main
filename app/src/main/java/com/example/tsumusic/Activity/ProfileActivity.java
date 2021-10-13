package com.example.tsumusic.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    EditText name, username, email;
    CircleImageView circleImageView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);
        Anhxa();
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("user")) {
            }
        }
        Toolbar toolbar = findViewById(R.id.textTitle);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                Animatoo.animateSlideLeft(ProfileActivity.this);
            }
        });
//        Lưu phiên đăng nhập
        SharedPreferences sharedPreferences = getSharedPreferences("SettingGame", Context.MODE_PRIVATE);
//        String namee = sharedPreferences.getString("user",null);
        name.setText(sharedPreferences.getString("name", null));
        username.setText(sharedPreferences.getString("username", null));
        email.setText(sharedPreferences.getString("email", null));
        if (sharedPreferences.getString("image", null) == null) {
            Picasso.with(context).load(R.drawable.avata).into(circleImageView);
        }else {
            Picasso.with(context).load(sharedPreferences.getString("image", null)).into(circleImageView);
        }

    }
    // gắn các thuộc tính từ activity_profile.xml
    private void Anhxa() {
        SharedPreferences sharedPreferences = getSharedPreferences("SettingGame", Context.MODE_PRIVATE);
        name = findViewById(R.id.txtname_profile);
        username = findViewById(R.id.txtusername_profile);
        email = findViewById(R.id.txtemail_profile);
        circleImageView = findViewById(R.id.image_profile);
    }
}