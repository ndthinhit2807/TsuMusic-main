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
import com.example.tsumusic.Model.ToplistToday;
import com.example.tsumusic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_Allplaylists extends RecyclerView.Adapter<Adapter_Allplaylists.ViewHolder> {


    Context context;
    ArrayList<ToplistToday> mangplaylist;

    public Adapter_Allplaylists(Context context, ArrayList<ToplistToday> mangplaylist) {
        this.context = context;
        this.mangplaylist = mangplaylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.line_all_playlists, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ToplistToday playlist = mangplaylist.get(position);
        Picasso.with(context).load(playlist.getIcontoplist()).into(holder.imghinhnen);
        holder.txttenplaylist.setText(playlist.getTentoplist());
    }

    @Override
    public int getItemCount() {
        return mangplaylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imghinhnen;
        TextView txttenplaylist;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imghinhnen = itemView.findViewById(R.id.imageviewhinhplaylist);
            txttenplaylist = itemView.findViewById(R.id.textviewtendanhsachcacplaylists);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ListSongActivity.class);
                    intent.putExtra("itemplaylist", mangplaylist.get(getPosition()));   //Gửi key dữ liệu đi
                    context.startActivity(intent);
                }
            });
        }
    }
}
