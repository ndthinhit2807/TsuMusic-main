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
import com.example.tsumusic.Model.Genre;
import com.example.tsumusic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
// Truyền dữ liệu vào Listongactivity
public class AdapterGenre extends RecyclerView.Adapter<AdapterGenre.ViewHolder> {
    View view;
    Context context;
    ArrayList<Genre> genreArrayList;

    public AdapterGenre(Context context, ArrayList<Genre> genreArrayList) {
        this.context = context;
        this.genreArrayList = genreArrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imghinhtheloai;
        TextView txttentheloai;

        public ViewHolder(View itemview) {
            super(itemview);
            imghinhtheloai = itemview.findViewById(R.id.imageviewhinhtheloai);
            txttentheloai = itemview.findViewById(R.id.textviewtentheloai);
            itemview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ListSongActivity.class);
                    intent.putExtra("genre", genreArrayList.get(getPosition())); //Gửi dữ liệu đi
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
        view = inflater.inflate(R.layout.line_genre, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Genre genre = genreArrayList.get(position);
        holder.txttentheloai.setText(genre.getTentheloai());
        Picasso.with(context).load(genre.getHinhtheloai()).into(holder.imghinhtheloai);
    }

    @Override
    public int getItemCount() {
        return genreArrayList.size();
    }


}
