package com.example.tsumusic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.Activity.ListSongActivity;
import com.example.tsumusic.Model.Singer;
import com.example.tsumusic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterSearchforsinger extends RecyclerView.Adapter<AdapterSearchforsinger.ViewHolder>{
    public AdapterSearchforsinger(Context context, ArrayList<Singer> mangcasi) {
        this.context = context;
        this.mangcasi = mangcasi;
    }

    Context context;
    ArrayList<Singer> mangcasi;
    @NonNull
    @Override
    public AdapterSearchforsinger.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.line_search,parent,false);
        return new AdapterSearchforsinger.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSearchforsinger.ViewHolder holder, int position) {
        Singer singer = mangcasi.get(position);
        holder.txttencasi.setText(singer.getTencasi());
        Picasso.with(context).load(singer.getUrlcasi()).into(holder.imghinhcasi);
    }

    @Override
    public int getItemCount() {
        return mangcasi.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txttencasi;
        ImageView imghinhcasi;
        public ViewHolder(View itemView){
            super(itemView);
            txttencasi = itemView.findViewById(R.id.textviewsearchdong1);
            imghinhcasi = itemView.findViewById(R.id.imageviewsearchhinhanh);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ListSongActivity.class);
                    intent.putExtra("singer",mangcasi.get(getPosition()));//Gửi key dữ liệu
                    Animatoo.animateSlideRight(context);
                    context.startActivity(intent);
                }
            });
        }
    }
}
