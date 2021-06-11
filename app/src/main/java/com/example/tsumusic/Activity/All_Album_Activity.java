package com.example.tsumusic.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.Adapter.Adapter_Allalbum;
import com.example.tsumusic.Model.Album;
import com.example.tsumusic.R;
import com.example.tsumusic.Service.API_Service;
import com.example.tsumusic.Service.Service_Data;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class All_Album_Activity extends AppCompatActivity {
    RecyclerView recyclerViewallalbum;
    Toolbar toolbar;
    ArrayList<Album> mangalbum;
    Adapter_Allalbum adapter_allAlbum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_album);
        init();
        GetData();
    }

    private void GetData() {
        Service_Data service_data = API_Service.getService();
        Call<List<Album>> callback = service_data.GetPlaylistAlbum();
        callback.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                mangalbum = (ArrayList<Album>) response.body();
               Log.d("mmmm",mangalbum.get(0).getTenalbum());
                adapter_allAlbum = new Adapter_Allalbum(All_Album_Activity.this,mangalbum);
                recyclerViewallalbum.setLayoutManager(new GridLayoutManager(All_Album_Activity.this,2));// chia danh sách album thành 2 cột
                recyclerViewallalbum.setAdapter(adapter_allAlbum);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }

    private void init() {
        recyclerViewallalbum  = findViewById(R.id.recycleallalbuum);
        toolbar = findViewById(R.id.tollbarallalbum);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Danh sách album");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Animatoo.animateSlideLeft(All_Album_Activity.this);
            }
        });
    }
}