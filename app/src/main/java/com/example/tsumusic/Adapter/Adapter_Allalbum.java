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

import com.example.tsumusic.Activity.ListSongActivity;
import com.example.tsumusic.Model.Album;
import com.example.tsumusic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_Allalbum extends RecyclerView.Adapter<Adapter_Allalbum.ViewHolder>{

    public Adapter_Allalbum(Context context, ArrayList<Album> mangalbum) {
        this.context = context;
        this.mangalbum = mangalbum;
    }

    Context context;
    ArrayList<Album> mangalbum;
    View view;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view  =inflater.inflate(R.layout.line_all_album,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = mangalbum.get(position);
        Picasso.with(context).load(album.getUrlalbum()).into(holder.imgalbum);
        holder.txttenalbum.setText(album.getTenalbum());
        holder.txttencasialbum.setText(album.getTencasi());
    }

    @Override
    public int getItemCount() {
        return mangalbum.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgalbum;
        TextView txttenalbum, txttencasialbum;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgalbum = itemView.findViewById(R.id.imageviewhinhallalbum);
            txttenalbum = itemView.findViewById(R.id.textviewtenallalbum);
            txttencasialbum = itemView.findViewById(R.id.textviewtencasiallalbum);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ListSongActivity.class);
                    intent.putExtra("album",mangalbum.get(getPosition()));// Gửi key dữ liệu đi
                    context.startActivity(intent);
                }
            });
        }
    }
}
