package com.example.tsumusic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.Activity.Playlist_Activity;
import com.example.tsumusic.Activity.PlaysongsActivity;
import com.example.tsumusic.Model.Song;
import com.example.tsumusic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterSearchforsongs extends RecyclerView.Adapter<AdapterSearchforsongs.ViewHolder> {
    public AdapterSearchforsongs(Context context, ArrayList<Song> mangbaihat) {
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
        ImageView imgbaihat,imgaddplaylist;

        public ViewHolder(View itemView) {
            super(itemView);
            txttenbaihat = itemView.findViewById(R.id.textviewsearchdong1);
            txttencasi = itemView.findViewById(R.id.textviewsearchdong2);
            imgbaihat = itemView.findViewById(R.id.imageviewsearchhinhanh);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlaysongsActivity.class);
                    intent.putExtra("Baihat", mangbaihat.get(getPosition()));    //Gửi key dữ liệu đi
                    context.startActivity(intent);
                    Animatoo.animateSlideUp(context);

                }
            });

            imgaddplaylist = itemView.findViewById(R.id.search_song_addplaylist);
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingGame", Context.MODE_PRIVATE);
            imgaddplaylist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (sharedPreferences.getString("username", null) != null) {
                        Intent intent = new Intent(context, Playlist_Activity.class);
//                    intent.putExtra("Baihat", mangbaihat.get(getPosition()).getMabaihat());    //Gửi key dữ liệu đi
                        putStringValue("idbaihat",mangbaihat.get(getPosition()).getMabaihat());
                        putStringValue("song_name",mangbaihat.get(getPosition()).getTenbaihat());
                        context.startActivity(intent);
                    } else {
                        Toast.makeText(context, "Bạn cần đăng nhập trước", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        public void putStringValue(String key, String value) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingGame", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(key, value);
            editor.apply();

        }
    }
}
