package com.example.tsumusic.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.Activity.All_Album_Activity;
import com.example.tsumusic.Adapter.AdapterAlbum;
import com.example.tsumusic.Model.Album;
import com.example.tsumusic.R;
import com.example.tsumusic.Service.API_Service;
import com.example.tsumusic.Service.Service_Data;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentAlbumhot extends Fragment {
    View view;
    RecyclerView recyclerviewalbum;
    TextView txtxemthemalbum;
    AdapterAlbum albumadapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_album, container, false);
        recyclerviewalbum = view.findViewById(R.id.recycleviewalbum);
        txtxemthemalbum = view.findViewById(R.id.txt_titlemore);
        txtxemthemalbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), All_Album_Activity.class);
                startActivity(intent);
                Animatoo.animateSlideRight(getActivity());
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("SettingGame", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
            }
        });
        GetData();
        return view;
    }

    private void GetData() {
        Service_Data service_data = API_Service.getService();
        Call<List<Album>> callback = service_data.GetDataAlbumhot();
        callback.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> mangalbumhot = (ArrayList<Album>) response.body();
                albumadapter = new AdapterAlbum(getActivity(), mangalbumhot);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(linearLayoutManager.HORIZONTAL);
                recyclerviewalbum.setLayoutManager(linearLayoutManager);
                recyclerviewalbum.setAdapter(albumadapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }
}
