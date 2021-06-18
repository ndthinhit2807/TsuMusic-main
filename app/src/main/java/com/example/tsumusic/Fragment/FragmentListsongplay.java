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

import com.example.tsumusic.Activity.PlaysongsActivity;
import com.example.tsumusic.Adapter.AdapterPlaysongs;
import com.example.tsumusic.Model.Song;
import com.example.tsumusic.R;

import java.util.ArrayList;

public class FragmentListsongplay extends Fragment {
    View view;
    RecyclerView recyclerViewlistsongplay;
    AdapterPlaysongs adapter_playmusic;
    ArrayList<Song> mangbaihat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_listsong_play, container, false);
        recyclerViewlistsongplay = view.findViewById(R.id.recyclerviewplaylistsong);
        if (PlaysongsActivity.mangbaihat.size() > 0) {
            adapter_playmusic = new AdapterPlaysongs(getActivity(), PlaysongsActivity.mangbaihat);
            recyclerViewlistsongplay.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerViewlistsongplay.setAdapter(adapter_playmusic);
        }
        return view;
    }

}
