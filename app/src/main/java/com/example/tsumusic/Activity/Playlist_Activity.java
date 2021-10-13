package com.example.tsumusic.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.Adapter.Adapter_Userplaylist;
import com.example.tsumusic.Model.ToplistToday;
import com.example.tsumusic.Model.User;
import com.example.tsumusic.Model.UserPlaylist;
import com.example.tsumusic.R;
import com.example.tsumusic.Service.API_Service;
import com.example.tsumusic.Service.Service_Data;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Playlist_Activity extends AppCompatActivity {

    RecyclerView recy_Playlist;
    Toolbar toolbar;
    Adapter_Userplaylist adapter_userplaylist;
    User user;
//    SharedPreferences sharedPreferences = getSharedPreferences("SettingGame", Context.MODE_PRIVATE);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        SharedPreferences sharedPreferences = getSharedPreferences("SettingGame", Context.MODE_PRIVATE);
        init();
        String username = sharedPreferences.getString("username",null);
        String email = sharedPreferences.getString("email",null);

        getData(username,email);
    }


    private void getData(String username,String email) {

        Service_Data service_data = API_Service.getService();
        Call<List<UserPlaylist>> callback = service_data.GetUserPlaylist(username,email);
        callback.enqueue(new Callback<List<UserPlaylist>>() {
            @Override
            public void onResponse(Call<List<UserPlaylist>> call, Response<List<UserPlaylist>> response) {
                ArrayList<UserPlaylist> array_userplaylist = (ArrayList<UserPlaylist>) response.body();
                adapter_userplaylist = new Adapter_Userplaylist(Playlist_Activity.this,array_userplaylist);
                recy_Playlist.setLayoutManager(new GridLayoutManager(Playlist_Activity.this,1));
                recy_Playlist.setAdapter(adapter_userplaylist);
            }

            @Override
            public void onFailure(Call<List<UserPlaylist>> call, Throwable t) {

            }
        });
    }


    private void init() {
        recy_Playlist  = findViewById(R.id.recy_Playlist);
        toolbar = findViewById(R.id.tool_Playlist);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Playlist");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Animatoo.animateSlideLeft(Playlist_Activity.this);
            }
        });
    }

}