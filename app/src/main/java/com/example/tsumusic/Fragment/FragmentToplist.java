package com.example.tsumusic.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.Activity.All_Toplist_Activity;
import com.example.tsumusic.Activity.ListSongActivity;
import com.example.tsumusic.Adapter.AdapterToplist;
import com.example.tsumusic.Model.ToplistToday;
import com.example.tsumusic.R;
import com.example.tsumusic.Service.API_Service;
import com.example.tsumusic.Service.Service_Data;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentToplist extends Fragment {
    View view;
    ListView lvtoplist;
    TextView txttitletoplist, txtmoretoplist;
    AdapterToplist adapter_toplist;
    ArrayList<ToplistToday> arraytoplist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_toplist, container);
        lvtoplist = view.findViewById(R.id.listviewtoplist);
        txttitletoplist = view.findViewById(R.id.txttitletoplist);
        txtmoretoplist = view.findViewById(R.id.txt_titlemoretoplist);
        GetData();
        txtmoretoplist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), All_Toplist_Activity.class);
                startActivity(intent);
                Animatoo.animateSlideRight(getActivity());
            }
        });
        return view;
    }
//  Gọi dũ liệu từ sever về
    private void GetData() {
        Service_Data service_data = API_Service.getService();
        Call<List<ToplistToday>> callback = service_data.Gettoplistplaylist();
        callback.enqueue(new Callback<List<ToplistToday>>() {
            @Override
            public void onResponse(Call<List<ToplistToday>> call, Response<List<ToplistToday>> response) {
                arraytoplist = (ArrayList<ToplistToday>) response.body();
                adapter_toplist = new AdapterToplist(getActivity(), android.R.layout.simple_list_item_1, arraytoplist);// gán dữ liều từ apdapter và fragment hiện thị dữ liệu(hình ảnh,tên) lên màn hình fragmentmain.xml
                lvtoplist.setAdapter(adapter_toplist);
                setListViewHeightBasedOnChildren(lvtoplist);
                lvtoplist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getActivity(), ListSongActivity.class);
                        intent.putExtra("itemplaylist", arraytoplist.get(position)); //Gửi key dữ liệu
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<ToplistToday>> call, Throwable t) {
            }
        });
    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            if (listItem != null) {
                listItem.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                listItem.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
                //listItem.measure(0, 0);
                totalHeight += listItem.getMeasuredHeight();
            }
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
