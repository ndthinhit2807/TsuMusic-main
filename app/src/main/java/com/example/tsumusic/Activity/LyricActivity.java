package com.example.tsumusic.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tsumusic.R;

public class LyricActivity extends AppCompatActivity {
    TextView txtloibaihat;
    ImageView imgbackbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyric_);
        txtloibaihat = findViewById(R.id.textviewloibaihat);
        imgbackbutton = findViewById(R.id.backbutton);
        SharedPreferences sharedPreferences = getSharedPreferences("passinfo", Context.MODE_PRIVATE);
        txtloibaihat.setText(sharedPreferences.getString("loibaihat", null));
    }
}