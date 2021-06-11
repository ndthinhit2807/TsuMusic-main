package com.example.tsumusic.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tsumusic.Adapter.Adapter_Allsong;
import com.example.tsumusic.Model.Song;
import com.example.tsumusic.R;
import com.example.tsumusic.Service.API_Service;
import com.example.tsumusic.Service.Service_Data;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentAllsong extends Fragment {
    View view;
    ArrayList<Song> mangbaihat;
    Adapter_Allsong all_song_adapter;
    RecyclerView recyclerViewSongsuggestions;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_all_song, container, false);
        GetData();
        recyclerViewSongsuggestions = view.findViewById(R.id.recyclesongsuggestions);
        return view;
    }

    private void GetData() {
        Service_Data service_data = API_Service.getService();
        Call<List<Song>> callback = service_data.GetData_All_Song();
        callback.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                mangbaihat = (ArrayList<Song>) response.body();
                all_song_adapter = new Adapter_Allsong(getActivity(), mangbaihat);
                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
                recyclerViewSongsuggestions.setLayoutManager(layoutManager);
                recyclerViewSongsuggestions.setAdapter(all_song_adapter);
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {
            }
        });
    }
}
