package com.example.tsumusic.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tsumusic.Model.Song;
import com.example.tsumusic.R;

import java.util.ArrayList;

public class SonginfoActivity extends AppCompatActivity {
    TextView txttenbaihat,txttencasi;
    public static ArrayList<Song> mangbaihat ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_songinfo);
        txttenbaihat =findViewById(R.id.baihattitle);
        txttencasi = findViewById(R.id.casititle);
          SharedPreferences sharedPreferences = getSharedPreferences("passinfo", Context.MODE_PRIVATE);
//        String namee = sharedPreferences.getString("user",null);
        txttenbaihat.setText(sharedPreferences.getString("tenbaihat", null));
        txttencasi.setText(sharedPreferences.getString("tencasi", null));
    }


}