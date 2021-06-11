package com.example.tsumusic.Fragment;

import android.content.Intent;
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
import com.example.tsumusic.Activity.All_Genre_Activity;
import com.example.tsumusic.Adapter.AdapterGenre;
import com.example.tsumusic.Model.Genre;
import com.example.tsumusic.R;
import com.example.tsumusic.Service.API_Service;
import com.example.tsumusic.Service.Service_Data;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentGenre extends Fragment {
    View view;
    RecyclerView recyclerviewtheloai;
    TextView txtxemthemtheloai;
    AdapterGenre adapter_genre;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_genre,container,false);
        recyclerviewtheloai = view.findViewById(R.id.recycleviewgenre);
        txtxemthemtheloai = view.findViewById(R.id.txt_titlemoregenre);
        txtxemthemtheloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), All_Genre_Activity.class);
                startActivity(intent);
                Animatoo.animateSlideRight(getActivity());
            }
        });
        GetData();
        return view;
    }
    private void GetData() {
        Service_Data service_data = API_Service.getService();
        Call<List<Genre>> callback = service_data.GetData_Genre();
        callback.enqueue(new Callback<List<Genre>>() {
            @Override
            public void onResponse(Call<List<Genre>> call, Response<List<Genre>> response) {
                ArrayList<Genre> genreArrayList = (ArrayList<Genre>) response.body();
                adapter_genre = new AdapterGenre(getActivity(),genreArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(linearLayoutManager.HORIZONTAL);
                recyclerviewtheloai.setLayoutManager(linearLayoutManager);
                recyclerviewtheloai.setAdapter(adapter_genre);
            }
            @Override
            public void onFailure(Call<List<Genre>> call, Throwable t) {
            }
        });
    }
    }
