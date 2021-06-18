package com.example.tsumusic.Activity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.tsumusic.Adapter.AdapterViewPager;
import com.example.tsumusic.Fragment.FragmentAllsong;
import com.example.tsumusic.Fragment.FragmentInformation;
import com.example.tsumusic.Fragment.LoadingDialog;
import com.example.tsumusic.Fragment.FragmentSinger;
import com.example.tsumusic.Fragment.Tab_Main_Fragment;
import com.example.tsumusic.Fragment.Tab_Search_Fragment;
import com.example.tsumusic.R;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Hiện dialog chờ cho app load dữ liệu xong
        final LoadingDialog loadingDialog = new LoadingDialog(HomeActivity.this);
        mapping();
        loadingDialog.StartLoadingDialog();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingDialog.dismissDialog();
            }
        }, 3000);
        mapping();
        init();
        setupTabIcons();
    }

    @Override
    public void onBackPressed() {
    }

    //  phân chia các fragment,activity theo các nút bottom
    private void init() {
        AdapterViewPager adapter_viewPager = new AdapterViewPager(getSupportFragmentManager());
        adapter_viewPager.addFragment(new Tab_Main_Fragment(), "Trang Chủ");
        adapter_viewPager.addFragment(new FragmentAllsong(), "Bài Hát");
        adapter_viewPager.addFragment(new FragmentSinger(), "Nghệ sĩ");
        adapter_viewPager.addFragment(new Tab_Search_Fragment(), "Tìm Kiếm");
        adapter_viewPager.addFragment(new FragmentInformation(), "Cá Nhân");
        viewPager.setAdapter(adapter_viewPager);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(3);
    }

    //   Set màu cho TabLayout + ViewPage
    private void setupTabIcons() { //set màu icon
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#FF6347"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_song);
        tabLayout.getTabAt(1).getIcon().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_microphone);
        tabLayout.getTabAt(2).getIcon().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_music);
        tabLayout.getTabAt(3).getIcon().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_user);
        tabLayout.getTabAt(4).getIcon().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#FF6347"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    //Ánh xạ dữ liệu từ viewpager và tablayout
    private void mapping() {
        tabLayout = findViewById(R.id.mainTabLayout);
        viewPager = findViewById(R.id.mainViewPager);
    }
}