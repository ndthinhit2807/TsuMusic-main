package com.example.tsumusic.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tsumusic.Adapter.AdapterSongsuggestions;
import com.example.tsumusic.Model.Song;
import com.example.tsumusic.R;
import com.example.tsumusic.Service.API_Service;
import com.example.tsumusic.Service.Service_Data;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentSongsuggestions extends Fragment {
    View view;
    ArrayList<Song> mangbaihat;
    AdapterSongsuggestions adapter_songsuggestions;
    RecyclerView recyclerViewSongsuggestions;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_song_suggestions, container, false);
        GetData();
        recyclerViewSongsuggestions = view.findViewById(R.id.recyclesongsuggestions);
        return view;
    }
    private void GetData() {
        Service_Data service_data = API_Service.getService();
        Call<List<Song>> callback = service_data.Getsongsuggestions();
        callback.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                mangbaihat = (ArrayList<Song>) response.body();
                adapter_songsuggestions = new AdapterSongsuggestions(getActivity(), mangbaihat);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                recyclerViewSongsuggestions.setLayoutManager(linearLayoutManager);
                recyclerViewSongsuggestions.setAdapter(adapter_songsuggestions);
            }
            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }
}
