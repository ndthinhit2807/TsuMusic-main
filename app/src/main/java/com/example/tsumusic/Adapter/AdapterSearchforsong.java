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
import com.example.tsumusic.Activity.PlayMusicActivity;
import com.example.tsumusic.Model.Song;
import com.example.tsumusic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterSearchforsong extends RecyclerView.Adapter<AdapterSearchforsong.ViewHolder> {
    public AdapterSearchforsong(Context context, ArrayList<Song> mangbaihat) {
        this.context = context;
        this.mangbaihat = mangbaihat;
    }

    Context context;
    ArrayList<Song> mangbaihat;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.line_search, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = mangbaihat.get(position);
        holder.txttenbaihat.setText(song.getTenbaihat());
        holder.txttencasi.setText(song.getTencasi());
        Picasso.with(context).load(song.getUrlhinhbaihat()).into(holder.imgbaihat);
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txttenbaihat, txttencasi;
        ImageView imgbaihat;

        public ViewHolder(View itemView) {
            super(itemView);
            txttenbaihat = itemView.findViewById(R.id.textviewsearchdong1);
            txttencasi = itemView.findViewById(R.id.textviewsearchdong2);
            imgbaihat = itemView.findViewById(R.id.imageviewsearchhinhanh);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayMusicActivity.class);
                    intent.putExtra("Baihat", mangbaihat.get(getPosition()));    //Gửi key dữ liệu đi
                    context.startActivity(intent);
                    Animatoo.animateSlideUp(context);
                }
            });
        }
    }
}
