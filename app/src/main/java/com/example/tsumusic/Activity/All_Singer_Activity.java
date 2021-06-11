package com.example.tsumusic.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.Adapter.Adapter_Allsinger;
import com.example.tsumusic.Model.Singer;
import com.example.tsumusic.R;
import com.example.tsumusic.Service.API_Service;
import com.example.tsumusic.Service.Service_Data;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class All_Singer_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    Toolbar toolbar;
    ArrayList<Singer> singerArrayList;
    Adapter_Allsinger all_singer_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_singer);
        init();
        GetData();
    }

    private void GetData() {
        Service_Data service_data = API_Service.getService();
        Call<List<Singer>> callback = service_data.GetData_All_Singer();
        callback.enqueue(new Callback<List<Singer>>() {
            @Override
            public void onResponse(Call<List<Singer>> call, Response<List<Singer>> response) {
                singerArrayList = (ArrayList<Singer>) response.body();
                all_singer_adapter = new Adapter_Allsinger(All_Singer_Activity.this, singerArrayList);
                recyclerView.setLayoutManager(new GridLayoutManager(All_Singer_Activity.this, 2));   //Chia danh sách nghệ sĩ thành 2 cột
                recyclerView.setAdapter(all_singer_adapter);
            }

            @Override
            public void onFailure(Call<List<Singer>> call, Throwable t) {
            }
        });
    }

    private void init() {
        recyclerView = findViewById(R.id.recycleviewallsinger);
        toolbar = findViewById(R.id.tollbarallalbum);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Danh sách ca sĩ");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Animatoo.animateSlideLeft(All_Singer_Activity.this);
            }
        });
    }
}