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

public class AdapterListsong extends RecyclerView.Adapter<AdapterListsong.ViewHolder> {
    Context context;
    ArrayList<Song> mangbaihat;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txttenbaihat, txtcasi, txtluotnghe;
        ImageView hinhbaihat;

        public ViewHolder(View itemview) {
            super(itemview);
            txtcasi = itemview.findViewById(R.id.textviewtencasi);
            txttenbaihat = itemview.findViewById(R.id.textviewtencakhuc);
            hinhbaihat = itemview.findViewById(R.id.textviewindex);
            txtluotnghe = itemview.findViewById(R.id.textviewlistsonghienthiluotnghe);
            itemview.setOnClickListener(new View.OnClickListener() {
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
