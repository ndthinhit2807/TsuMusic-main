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
import com.example.tsumusic.Model.Album;
import com.example.tsumusic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterAlbum extends RecyclerView.Adapter<AdapterAlbum.ViewHolder>{
    View view;
    Context context;
    ArrayList<Album> mangalbum;

    public AdapterAlbum(Context context, ArrayList<Album> mangalbum) {
        this.context = context;
        this.mangalbum = mangalbum;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imghinhalbum;
        TextView txttenalbum, txtcasialbum;
        public ViewHolder(View itemview){
            super(itemview);
            imghinhalbum = itemview.findViewById(R.id.imageviewhinhalbum);
            txttenalbum = itemview.findViewById(R.id.textviewtenalbum);
            txtcasialbum = itemview.findViewById(R.id.texttencasialbum);
            itemview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ListSongActivity.class);
                    intent.putExtra("album",mangalbum.get(getPosition()));
                    Animatoo.animateSlideRight(context);
                    context.startActivity(intent);
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.line_album,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album  = mangalbum.get(position);
        holder.txtcasialbum.setText(album.getTencasi());
        holder.txttenalbum.setText(album.getTenalbum());
        Picasso.with(context).load(album.getUrlalbum()).into(holder.imghinhalbum);
    }
    @Override
    public int getItemCount() {
        return mangalbum.size();
    }


}
