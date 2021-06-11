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

public class AdapterSinger extends RecyclerView.Adapter<AdapterSinger.ViewHolder> {
    View view;
    Context context;
    ArrayList<Singer> singerArrayList;

    public AdapterSinger(Context context, ArrayList<Singer> singerArrayList) {
        this.context = context;
        this.singerArrayList = singerArrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgcasi;
        TextView txttencasi;

        public ViewHolder(View itemview) {
            super(itemview);
            imgcasi = itemview.findViewById(R.id.imageviewhinhcasi);
            txttencasi = itemview.findViewById(R.id.textviewtencasi);
            itemview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ListSongActivity.class);
                    intent.putExtra("singer", singerArrayList.get(getPosition()));  //Gửi key dữ liệu đi
                    context.startActivity(intent);
                    Animatoo.animateSlideRight(context);
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.line_singer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Singer singer = singerArrayList.get(position);
        holder.txttencasi.setText(singer.getTencasi());
        Picasso.with(context).load(singer.getUrlcasi()).into(holder.imgcasi);
    }

    @Override
    public int getItemCount() {
        return singerArrayList.size();
    }
}
