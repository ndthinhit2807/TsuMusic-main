package com.example.tsumusic.Startup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tsumusic.Activity.HomeActivity;
import com.example.tsumusic.R;

public class SplashActivity extends AppCompatActivity {

    View view;
    Intent intent;
    ImageView imglogo;
    TextView textViewappname;
    Animation topanimation, bottomanimation;
    private static int SPLASH_CREEN = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starload);
        imglogo = findViewById(R.id.imageviewlogoapp);
        textViewappname = findViewById(R.id.textviewappname);
        //Ẩn navigationbar và status bar
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        @SuppressLint("WrongConstant") final boolean isEnter = getSharedPreferences("sp", Context.MODE_APPEND).getBoolean("firstEnter", false);
        topanimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomanimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        imglogo.setAnimation(topanimation);
        textViewappname.setAnimation(bottomanimation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                Lần đầu cài đặt phần mềm sẽ hiện màn hình welcome, lần sau sẽ chỉ hiện màn hình splash
                if (isEnter) {
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                } else {
                    startActivity(new Intent(SplashActivity.this, WelcomeActivity.class));
                }
                finish();
            }
        }, SPLASH_CREEN);
    }
}