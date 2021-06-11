package com.example.tsumusic.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.R;

public class AppinformationActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info);
        toolbar = findViewById(R.id.toolbarappinformation);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);// Quay lại màn hình trước
        getSupportActionBar().setTitle("Thông tin ứng dụng");
        toolbar.setTitleTextColor(getResources().getColor(R.color.black));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Animatoo.animateSlideLeft(AppinformationActivity.this);
            }
        });
    }

}