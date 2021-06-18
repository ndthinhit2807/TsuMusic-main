package com.example.tsumusic.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tsumusic.Adapter.AdapterSearchforsinger;
import com.example.tsumusic.Adapter.AdapterSearchforsongs;
import com.example.tsumusic.Model.Singer;
import com.example.tsumusic.Model.Song;
import com.example.tsumusic.R;
import com.example.tsumusic.Service.API_Service;
import com.example.tsumusic.Service.Service_Data;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tab_Search_Fragment extends Fragment {
    View view;
    Toolbar toolbar;
    RecyclerView recyclerViewsearch;
    TextView txtkhongcodulieu;
    AdapterSearchforsongs adapter_searchforsong;
    AdapterSearchforsinger adapter_searchforsinger;
    ArrayList<Song> mangbaihat;
    ArrayList<Singer> mangcasi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);
        toolbar = view.findViewById(R.id.tollbarsearchbaihat);
        recyclerViewsearch = view.findViewById(R.id.recyclesearch);
        toolbar.setTitle("Tìm Kiếm Bài Hát, Ca Sĩ");
        txtkhongcodulieu = view.findViewById(R.id.textviewkhongcodulieu);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.search_view, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Gõ từ khoá để tìm kiếm...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            hiển thị dữ liệu tìm kiếm khi ấn submit,enter
            @Override
            public boolean onQueryTextSubmit(String query) {
                Searchcasi(query);
                Searchbaihat(query);
                return true;
            }
//             Hiển thị dữ liệu tìm kiếm ngay khi chữ thay đổi
            @Override
            public boolean onQueryTextChange(String s) {
                Searchcasi(s);
                Searchbaihat(s);
                return true;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
    //Gọi dữ liệu từ sever về
    private void Searchbaihat(String tukhoa) {
        Service_Data service_data = API_Service.getService();
        Call<List<Song>> callback = service_data.getsearchbaihat(tukhoa);
        callback.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                mangbaihat = (ArrayList<Song>) response.body();
                if (mangbaihat.size() > 0) {
                    adapter_searchforsong = new AdapterSearchforsongs(getActivity(), mangbaihat);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerViewsearch.setLayoutManager(linearLayoutManager);
                    recyclerViewsearch.setAdapter(adapter_searchforsong);
                    txtkhongcodulieu.setVisibility(View.GONE);
                    recyclerViewsearch.setVisibility(View.VISIBLE);
                } else {
                    recyclerViewsearch.setVisibility(View.GONE);
                    txtkhongcodulieu.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }

    private void Searchcasi(String tukhoa) {
        Service_Data service_data = API_Service.getService();
        Call<List<Singer>> callback = service_data.getsearchcasi(tukhoa);
        callback.enqueue(new Callback<List<Singer>>() {
            @Override
            public void onResponse(Call<List<Singer>> call, Response<List<Singer>> response) {
                mangcasi = (ArrayList<Singer>) response.body();
                if (mangcasi.size() > 0) {
                    adapter_searchforsinger = new AdapterSearchforsinger(getActivity(), mangcasi);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerViewsearch.setLayoutManager(linearLayoutManager);
                    recyclerViewsearch.setAdapter(adapter_searchforsinger);
                    txtkhongcodulieu.setVisibility(View.GONE);
                    recyclerViewsearch.setVisibility(View.VISIBLE);
                } else {
                    recyclerViewsearch.setVisibility(View.GONE);
                    txtkhongcodulieu.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Singer>> call, Throwable t) {
            }

        });
    }
}
