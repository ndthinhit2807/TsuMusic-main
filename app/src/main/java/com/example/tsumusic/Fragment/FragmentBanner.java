package com.example.tsumusic.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.tsumusic.Adapter.AdapterBanner;
import com.example.tsumusic.Model.Banner;
import com.example.tsumusic.R;
import com.example.tsumusic.Service.API_Service;
import com.example.tsumusic.Service.Service_Data;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentBanner extends Fragment {
    View view;
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    AdapterBanner adapter_banner;
    Handler handler;
    Runnable runnable;
    int currentItem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_banner, container, false);
        Getdata();
        Anhxa();
        return view;
    }

    private void Anhxa() {
        viewPager = view.findViewById(R.id.banner_viewpager);
        circleIndicator = view.findViewById(R.id.banner_indiacator);
    }
//    Gọi dữ liệu từ sever về
    private void Getdata() {
        Service_Data service_data = API_Service.getService();
        Call<List<Banner>> callback = service_data.GetDataBanner();
        callback.enqueue(new Callback<List<Banner>>() {
            @Override
            public void onResponse(Call<List<Banner>> call, Response<List<Banner>> response) {
                ArrayList<Banner> banner = (ArrayList<Banner>) response.body();
                adapter_banner = new AdapterBanner(getActivity(), banner);// lấy dự liệu từ adapter về fragment và fragment hiển thị dữ liệu ra ngoài fragmentmain
                viewPager.setAdapter(adapter_banner);
                circleIndicator.setViewPager(viewPager);
                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        currentItem = viewPager.getCurrentItem();
                        currentItem++;
                        if (currentItem >= viewPager.getAdapter().getCount()) {
                            currentItem = 0;
                        }
                        viewPager.setCurrentItem(currentItem, true);
                        handler.postDelayed(runnable, 10000);// thời gian chuyển bài hát
                    }
                };
                handler.postDelayed(runnable, 10000);
            }

            @Override
            public void onFailure(Call<List<Banner>> call, Throwable t) {
            }
        });
    }


}
