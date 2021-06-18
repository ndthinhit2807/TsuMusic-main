package com.example.tsumusic.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.R;

public class LyricActivity extends AppCompatActivity {
    TextView txtloibaihat;
    ImageView imgbackbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyric_);txtloibaihat = findViewById(R.id.textviewloibaihat);
        imgbackbutton = findViewById(R.id.backbutton);
        SharedPreferences sharedPreferences = getSharedPreferences("passinfo", Context.MODE_PRIVATE);
        txtloibaihat.setText(sharedPreferences.getString("loibaihat", null));
        backbutton();

    }

     private void backbutton() {
        imgbackbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        ImageView view = (ImageView) v;
                        //overlay is black with transparency of 0x77 (119)
                        view.getDrawable().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        onBackPressed();
                        Animatoo.animateSlideDown(LyricActivity.this);
                        break;
                    }
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL: {
                        ImageView view = (ImageView) v;
                        //clear the overlay
                        view.getDrawable().clearColorFilter();
                        view.invalidate();
                        break;
                    }
                }

                return false;
            }
        });

    }
}