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

import com.example.tsumusic.Adapter.AdapterSinger;
import com.example.tsumusic.Model.Singer;
import com.example.tsumusic.R;
import com.example.tsumusic.Service.API_Service;
import com.example.tsumusic.Service.Service_Data;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentSinger extends Fragment {
    View view;
    RecyclerView recyclerviewsinger;
    AdapterSinger singer_adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_singer, container, false);
        recyclerviewsinger = view.findViewById(R.id.recycleviewsinger);
        GetData();
        return view;
    }

    private void GetData() {
        Service_Data service_data = API_Service.getService();
        Call<List<Singer>> callback = service_data.GetData_Singer();
        callback.enqueue(new Callback<List<Singer>>() {
            @Override
            public void onResponse(Call<List<Singer>> call, Response<List<Singer>> response) {
                ArrayList<Singer> singerArrayList = (ArrayList<Singer>) response.body();
                singer_adapter = new AdapterSinger(getActivity(), singerArrayList);
                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
                recyclerviewsinger.setLayoutManager(layoutManager);
                recyclerviewsinger.setAdapter(singer_adapter);
            }
            @Override
            public void onFailure(Call<List<Singer>> call, Throwable t) {
            }
        });
    }
}
