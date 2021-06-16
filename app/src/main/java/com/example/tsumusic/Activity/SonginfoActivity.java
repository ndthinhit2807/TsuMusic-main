package com.example.tsumusic.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

import com.example.tsumusic.Model.Song;
import com.example.tsumusic.R;
import com.google.android.material.textview.MaterialTextView;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import java.util.ArrayList;

public class SonginfoActivity extends AppCompatActivity {
    TextView txttenbaihat,txttencasi,txtluotnghe,txtngayphathanh;
    float x1,y1,x2,y2;
    private  static  int MIN_DISTANCE =150;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_songinfo);
        txttenbaihat =findViewById(R.id.textviewtenbaihatdangnghe);
        txttencasi = findViewById(R.id.textviewtennghesihat);
        txtluotnghe = findViewById(R.id.textviewluotnghebaihat);
        txtngayphathanh = findViewById(R.id.textviewngayphathanhbaihat);
          SharedPreferences sharedPreferences = getSharedPreferences("passinfo", Context.MODE_PRIVATE);
        txttenbaihat.setText(sharedPreferences.getString("tenbaihat", null));
        txttencasi.setText(sharedPreferences.getString("tencasi", null));
        txtluotnghe.setText(sharedPreferences.getString("luotnghe", null));
        txtngayphathanh.setText(sharedPreferences.getString("ngayphathanh", null));
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