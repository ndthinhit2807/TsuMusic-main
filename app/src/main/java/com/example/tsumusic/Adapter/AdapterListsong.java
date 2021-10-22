package com.example.tsumusic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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

public class AdapterListsong extends RecyclerView.Adapter<AdapterListsong.ViewHolder> {
    Context context;
    ArrayList<Song> mangbaihat;
    ImageButton imageButton;
    View view;


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txttenbaihat, txtcasi, txtluotnghe;
        ImageView hinhbaihat,imgmore;

        public ViewHolder(View itemview) {
            super(itemview);
            txtcasi = itemview.findViewById(R.id.textviewtencasi);
            txttenbaihat = itemview.findViewById(R.id.textviewtencakhuc);
            hinhbaihat = itemview.findViewById(R.id.textviewindex);
            txtluotnghe = itemview.findViewById(R.id.textviewlistsonghienthiluotnghe);

            itemview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlaysongsActivity.class);
                    intent.putExtra("Baihat", mangbaihat.get(getPosition()));    //Gửi key dữ liệu đi
                    context.startActivity(intent);
                    Animatoo.animateSlideUp(context);
                }
            });
            imageButton = itemview.findViewById(R.id.btnaddplaylist);
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingGame", Context.MODE_PRIVATE);
            imageButton.setOnClickListener(new View.OnClickListener() {
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

    }
    public void putStringValue(String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("SettingGame", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();

    }
    public AdapterListsong(Context context, ArrayList<Song> mangbaihat) {
        this.context = context;
        this.mangbaihat = mangbaihat;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.line_listsong, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = mangbaihat.get(position);
        holder.txttenbaihat.setText(song.getTenbaihat());
        holder.txtcasi.setText(song.getTencasi());


//        Tính lượt view hiện thị
        if (Integer.parseInt(song.getLuotnghe()) < 999) {
            holder.txtluotnghe.setText((song.getLuotnghe()));
        }
        if (Integer.parseInt(song.getLuotnghe()) > 999 && Integer.parseInt(song.getLuotnghe()) < 1000000) {
            Integer luotnghe = Integer.valueOf(song.getLuotnghe()) / 1000;
            if (Integer.valueOf(song.getLuotnghe()) % 1000 > 99 && Integer.valueOf(song.getLuotnghe()) % 1000 < 1000) {
                Integer phandu = Integer.valueOf(song.getLuotnghe()) % 1000 / 100;
                holder.txtluotnghe.setText(luotnghe.toString() + "." + phandu.toString() + "K");
            } else {
                holder.txtluotnghe.setText(luotnghe.toString() + "K");
            }
        }
        if (Integer.parseInt(song.getLuotnghe()) > 999999 && Integer.parseInt(song.getLuotnghe()) < 1000000000) {
            Integer luotnghe = Integer.valueOf(song.getLuotnghe()) / 1000000;
            if (Integer.valueOf(song.getLuotnghe()) % 1000000 > 99999 && Integer.valueOf(song.getLuotnghe()) % 1000000 < 1000000) {
                Integer phandu = Integer.valueOf(song.getLuotnghe()) % 1000000 / 100000;
                holder.txtluotnghe.setText(luotnghe.toString() + "." + phandu.toString() + "M");
            } else {
                holder.txtluotnghe.setText(luotnghe.toString() + "M");
            }
        }
        System.out.println(song.getLuotnghe());
        Picasso.with(context).load(song.getUrlhinhbaihat()).into(holder.hinhbaihat);
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }
}
