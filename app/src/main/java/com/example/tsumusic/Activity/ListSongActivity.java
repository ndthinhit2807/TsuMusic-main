package com.example.tsumusic.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.Adapter.AdapterListsong;
import com.example.tsumusic.Model.Album;
import com.example.tsumusic.Model.Banner;
import com.example.tsumusic.Model.Genre;
import com.example.tsumusic.Model.Singer;
import com.example.tsumusic.Model.Song;
import com.example.tsumusic.Model.ToplistToday;
import com.example.tsumusic.R;
import com.example.tsumusic.Service.API_Service;
import com.example.tsumusic.Service.Service_Data;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListSongActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerViewdanhsachbaihat;
    FloatingActionButton floatingActionButton;
    ImageView imglistsong;
    ArrayList<Song> mangbaihat;
    AdapterListsong adapter_listsong;
    Album album = null;
    ToplistToday toplistToday = null;
    Singer singer = null;
    Genre genre = null;
    Banner banner = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_song);

        Anhxa();
        // init();
        floatingActionButton.setEnabled(false);
        DataIntent();
        if (toplistToday != null && !toplistToday.getTentoplist().equals("")) {
            setValueInView(toplistToday.getTentoplist(), toplistToday.getIcontoplist());
            GetDataToplist(toplistToday.getMatoplist());
        }
        if (singer != null && !singer.getTencasi().equals("")) {
            setValueInView(singer.getTencasi(), singer.getUrlcasi());
            GetDataSinger(singer.getMacasi());
        }
        if (album != null && !album.getTenalbum().equals("")) {
            setValueInView(album.getTenalbum(), album.getUrlalbum());
            GetDataAllalbum(album.getMaalbum());
        }
        if (genre != null && !genre.getTentheloai().equals("")) {
            setValueInView(genre.getTentheloai(), genre.getHinhtheloai());
            GetListsong_Genre(genre.getMatheloai());
        }
        if (banner != null && !banner.getMaquangcao().equals("")) {
            setValueInView(banner.getMaquangcao(), banner.getUrlhinhquangcao());
            GetListsong_Banner(banner.getMaquangcao());
        }

        eventClick();
    }
//    Gọi dữ liệu của top list từ sever về
    private void GetDataToplist(String idtoplist) {
        Service_Data service_data = API_Service.getService();
        Call<List<Song>> callback = service_data.getdanhsachbaihattheongay(idtoplist);
        callback.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                mangbaihat = (ArrayList<Song>) response.body();
                adapter_listsong = new AdapterListsong(ListSongActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(ListSongActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(adapter_listsong);
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {
            }
        });
    }
    //    Gọi dữ liệu của ca sĩ từ sever về
    private void GetDataSinger(String idsinger) {
        Service_Data dataservice = API_Service.getService();
        Call<List<Song>> callback = dataservice.GetListsong_Singer(idsinger);
        callback.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                mangbaihat = (ArrayList<Song>) response.body();
                // Log.d("uuu",mangbaihat.get(0).getTenbaihat());
                adapter_listsong = new AdapterListsong(ListSongActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(ListSongActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(adapter_listsong);
                eventClick();
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }
//    Gọi dữ liệu của album từ sever về
    private void GetDataAllalbum(String idplaylistalbum) {
        Service_Data service_data = API_Service.getService();
        Call<List<Song>> callback = service_data.Getallalbum(idplaylistalbum);
        callback.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                mangbaihat = (ArrayList<Song>) response.body();
                adapter_listsong = new AdapterListsong(ListSongActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(ListSongActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(adapter_listsong);
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }

    private void GetListsong_Genre(String idgenre) {
        Service_Data service_data = API_Service.getService();
        Call<List<Song>> callback = service_data.GetListsong_Genre(idgenre);
        callback.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                mangbaihat = (ArrayList<Song>) response.body();
                adapter_listsong = new AdapterListsong(ListSongActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(ListSongActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(adapter_listsong);
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }

    private void GetListsong_Banner(String idbanner) {
        Service_Data service_data = API_Service.getService();
        Call<List<Song>> callback = service_data.GetListsong_Banner(idbanner);
        callback.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                mangbaihat = (ArrayList<Song>) response.body();
                adapter_listsong = new AdapterListsong(ListSongActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(ListSongActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(adapter_listsong);
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }

    private void Anhxa() {
        coordinatorLayout = findViewById(R.id.coordinatorlistsong);
        collapsingToolbarLayout = findViewById(R.id.collapsingToolbarLayout);
        toolbar = findViewById(R.id.toolbarlist);
        recyclerViewdanhsachbaihat = findViewById(R.id.recyclelistsong);
        floatingActionButton = findViewById(R.id.floatingbutton);
        imglistsong = findViewById(R.id.imgviewlistsong);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Bài hát");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Animatoo.animateSlideLeft(ListSongActivity.this);
            }
        });
//          floatingActionButton.setEnabled(false);
    }
//    Set hình và tên cho toplist,album,ca sĩ
    private void setValueInView(String ten, String hinh) {
        collapsingToolbarLayout.setTitle(ten);
        try {
            URL url = new URL(hinh);
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                collapsingToolbarLayout.setBackground(bitmapDrawable);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Picasso.with(this).load(hinh).into(imglistsong);
    }
//    Gửi các key dữ liệu đi
    private void DataIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("itemplaylist")) {
                toplistToday = (ToplistToday) intent.getSerializableExtra("itemplaylist");
                //Toast.makeText(this, toplistToday.getTentoplist(), Toast.LENGTH_SHORT).show();
            }
            if (intent.hasExtra("album")) {
                album = (Album) intent.getSerializableExtra("album");
                //Toast.makeText(this, album.getTenalbum(), Toast.LENGTH_SHORT).show();
            }
            if (intent.hasExtra("genre")) {
                genre = (Genre) intent.getSerializableExtra("genre");
                // Toast.makeText(this, genre.getTentheloai(), Toast.LENGTH_SHORT).show();
            }
            if (intent.hasExtra("singer")) {
                singer = (Singer) intent.getSerializableExtra("singer");
                // Toast.makeText(this, singer.getTencasi(), Toast.LENGTH_SHORT).show();
            }
            if (intent.hasExtra("banner")) {
                banner = (Banner) intent.getSerializableExtra("banner");
                // Toast.makeText(this, singer.getTencasi(), Toast.LENGTH_SHORT).show();
            }
        }

    }

//    Phát tất cả bài hát trong danh sách và đi đến màn hình chơi nhạc
    private void eventClick() {
        floatingActionButton.setEnabled(true);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListSongActivity.this, PlayMusicActivity.class);
                intent.putExtra("cacbaihat", mangbaihat); //gửi ket dữ liệu list bài hát
                startActivity(intent);
                Animatoo.animateSlideUp(ListSongActivity.this);
            }
        });

    }
}
