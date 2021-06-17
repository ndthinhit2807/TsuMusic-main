package com.example.tsumusic.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tsumusic.Model.Song;
import com.example.tsumusic.R;
import com.google.android.material.textview.MaterialTextView;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import java.util.ArrayList;

public class SonginfoActivity extends AppCompatActivity {
    TextView txttenbaihat,txttencasi,txtluotnghe,txtngayphathanh;
    ImageView imgbackbutton;
    float x1,y1,x2,y2;
    private  static  int MIN_DISTANCE =150;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_songinfo);
        txttenbaihat =findViewById(R.id.textviewtenbaihatdangnghe);
        txttencasi = findViewById(R.id.textviewtennghesihat);
        txtluotnghe = findViewById(R.id.textviewluotnghebaihat);
        imgbackbutton = findViewById(R.id.backbuttonsonginfo);
        txtngayphathanh = findViewById(R.id.textviewngayphathanhbaihat);
        SharedPreferences sharedPreferences = getSharedPreferences("passinfo", Context.MODE_PRIVATE);
        txttenbaihat.setText(sharedPreferences.getString("tenbaihat", null));
        txttencasi.setText(sharedPreferences.getString("tencasi", null));
        txtluotnghe.setText(sharedPreferences.getString("luotnghe", null));
        txtngayphathanh.setText(sharedPreferences.getString("ngayphathanh", null));
        backbutton();
    }

    private void backbutton() {
        imgbackbutton.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        ImageView view = (ImageView) v;
                        //overlay is black with transparency of 0x77 (119)
                        view.getDrawable().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        onBackPressed();
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

    //Vuốt xuống hoặc vuốt lên để back màn hình
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case  MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
                break;
            case  MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();

                float valueY =y2-y1;
                if(Math.abs(valueY)> MIN_DISTANCE){
                    if (y2>y1){
                        onBackPressed();
                    }
                    else
                    {
                        onBackPressed();
                    }
                }


        }
        return super.onTouchEvent(event);
    }



}