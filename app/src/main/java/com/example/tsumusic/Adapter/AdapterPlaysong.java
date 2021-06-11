package com.example.tsumusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tsumusic.Model.Song;
import com.example.tsumusic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterPlaysong extends RecyclerView.Adapter<AdapterPlaysong.ViewHolder> {
    Context context;
    ArrayList<Song> mangbaihat;

    public AdapterPlaysong(Context context, ArrayList<Song> mangbaihat) {
        this.context = context;
        this.mangbaihat = mangbaihat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.line_listsong_play, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song baihat = mangbaihat.get(position);
        holder.txttencasi.setText(baihat.getTencasi());
        holder.txtsongname.setText(baihat.getTenbaihat());
        Picasso.with(context).load(baihat.getUrlhinhbaihat()).into(holder.imglistsong);
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtsongname, txttencasi;
        Context context;
        ImageView imglistsong;
        public ViewHolder(View itemview) {
            super(itemview);
            txttencasi = itemview.findViewById(R.id.textviewtencasilistplay);
            txtsongname = itemview.findViewById(R.id.textviewtenbaihatlistplay);
            imglistsong = itemview.findViewById(R.id.imageviewhinhbaihatlistplay);
        }
    }
}
