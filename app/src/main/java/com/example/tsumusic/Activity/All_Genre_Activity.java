package com.example.tsumusic.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.Adapter.Adapter_Allgenre;
import com.example.tsumusic.Model.Genre;
import com.example.tsumusic.R;
import com.example.tsumusic.Service.API_Service;
import com.example.tsumusic.Service.Service_Data;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class All_Genre_Activity extends AppCompatActivity {
    RecyclerView recyclerViewgenre;
    Toolbar toolbar;
    ArrayList<Genre> genreArrayList;
    Adapter_Allgenre adapter_all_genre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_genre);
        init();
        GetData();
    }

    private void GetData() {
        //gọi api
        Service_Data service_data = API_Service.getService();
        Call<List<Genre>> callback = service_data.GetData_All_Genre();
        callback.enqueue(new Callback<List<Genre>>() {
            @Override
            public void onResponse(Call<List<Genre>> call, Response<List<Genre>> response) {
                genreArrayList = (ArrayList<Genre>) response.body();
                adapter_all_genre = new Adapter_Allgenre(All_Genre_Activity.this, genreArrayList);
                recyclerViewgenre.setLayoutManager(new GridLayoutManager(All_Genre_Activity.this, 2));// chia thể loại thành 2 cột
                recyclerViewgenre.setAdapter(adapter_all_genre);
            }

            @Override
            public void onFailure(Call<List<Genre>> call, Throwable t) {
            }
        });
    }

    private void init() {
        recyclerViewgenre = findViewById(R.id.recycleviewgenre);
        toolbar = findViewById(R.id.tollbarallalbum);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Danh sách thể loại");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Animatoo.animateSlideLeft(All_Genre_Activity.this);
            }

        });
    }
}