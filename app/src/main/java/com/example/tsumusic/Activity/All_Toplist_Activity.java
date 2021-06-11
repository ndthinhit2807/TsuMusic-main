package com.example.tsumusic.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.Adapter.Adapter_Allplaylists;
import com.example.tsumusic.Model.ToplistToday;
import com.example.tsumusic.R;
import com.example.tsumusic.Service.API_Service;
import com.example.tsumusic.Service.Service_Data;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class All_Toplist_Activity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerViewallplaylists;
    ArrayList<ToplistToday> mangplaylists;
    Adapter_Allplaylists adapter_allPlaylists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_playlist);
        Anhxa();
        init();
        GetData();
    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Danh sách top 100");
        toolbar.setTitleTextColor(getResources().getColor(R.color.purple_200));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Animatoo.animateSlideLeft(All_Toplist_Activity.this);
            }
        });
    }

    private void GetData() {
        Service_Data service_data = API_Service.getService();
        Call<List<ToplistToday>> callback = service_data.Getallplaylists();
        callback.enqueue(new Callback<List<ToplistToday>>() {
            @Override
            public void onResponse(Call<List<ToplistToday>> call, Response<List<ToplistToday>> response) {
                mangplaylists = (ArrayList<ToplistToday>) response.body();
                Log.d("test", mangplaylists.get(0).getTentoplist());
                adapter_allPlaylists = new Adapter_Allplaylists(All_Toplist_Activity.this, mangplaylists);
                recyclerViewallplaylists.setLayoutManager(new GridLayoutManager(All_Toplist_Activity.this, 2));  //Chia danh sách top 100 thành 2 cột
                recyclerViewallplaylists.setAdapter(adapter_allPlaylists);
            }

            @Override
            public void onFailure(Call<List<ToplistToday>> call, Throwable t) {
            }
        });
    }

    private void Anhxa() {
        toolbar = findViewById(R.id.tollbarallplaylists);
        recyclerViewallplaylists = findViewById(R.id.recyclerviewallplaylist);
    }
}