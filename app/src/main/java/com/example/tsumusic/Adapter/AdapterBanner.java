package com.example.tsumusic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.Activity.ListSongActivity;
import com.example.tsumusic.Model.Banner;
import com.example.tsumusic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterBanner extends PagerAdapter {
    Context context;
    ArrayList<Banner> bannerArrayList;
    public AdapterBanner(Context context, ArrayList<Banner> bannerArrayList) {
        this.context = context;
        this.bannerArrayList = bannerArrayList;
    }

    @Override
    public int getCount() {
        return bannerArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.line_banner,null);
        ImageView imagebackgroundbanner = view.findViewById(R.id.imgbackgroudbanner);
        Picasso.with(context).load(bannerArrayList.get(position).getUrlhinhquangcao()).into(imagebackgroundbanner);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ListSongActivity.class);
                intent.putExtra("banner",bannerArrayList.get(position));//Gửi dữ liệu đi
                Animatoo.animateSlideUp(context);
                context.startActivity(intent);
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
