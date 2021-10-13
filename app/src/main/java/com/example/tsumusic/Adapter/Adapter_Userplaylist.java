package com.example.tsumusic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.Activity.ListSongActivity;
import com.example.tsumusic.Model.User;
import com.example.tsumusic.Model.UserPlaylist;
import com.example.tsumusic.R;

import java.util.ArrayList;

public class Adapter_Userplaylist extends RecyclerView.Adapter<Adapter_Userplaylist.ViewHolder>{

    Context context;
    ArrayList<UserPlaylist> array_Userplaylist;

    public Adapter_Userplaylist(Context context, ArrayList<UserPlaylist> array_Userplaylist) {
        this.context = context;
        this.array_Userplaylist = array_Userplaylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.line_playlist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserPlaylist userPlaylist = array_Userplaylist.get(position);
        holder.text_nameplaylist.setText(userPlaylist.getTendanhsach());
        holder.text_decription.setText(userPlaylist.getMieuta());

    }

    @Override
    public int getItemCount() {
        return array_Userplaylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView text_nameplaylist, text_decription;

        public ViewHolder(@NonNull View itemView ) {
            super(itemView);
            text_nameplaylist = itemView.findViewById(R.id.text_nameplayplist);
            text_decription = itemView.findViewById(R.id.text_decription);

        }
    }
}
