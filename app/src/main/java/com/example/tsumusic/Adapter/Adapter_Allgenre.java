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
import com.example.tsumusic.Model.Genre;
import com.example.tsumusic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_Allgenre extends RecyclerView.Adapter<Adapter_Allgenre.ViewHolder> {

    Context context;
    ArrayList<Genre> genreArrayList;
    View view;

    public Adapter_Allgenre(Context context, ArrayList<Genre> genreArrayList) {
        this.context = context;
        this.genreArrayList = genreArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.line_all_genre, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Genre genre = genreArrayList.get(position);
        Picasso.with(context).load(genre.getHinhtheloai()).into(holder.imgtheloai);
        holder.txttentheloai.setText(genre.getTentheloai());
    }

    @Override
    public int getItemCount() {
        return genreArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgtheloai;
        TextView txttentheloai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgtheloai = itemView.findViewById(R.id.imageviewhinhtheloai);
            txttentheloai = itemView.findViewById(R.id.textviewtentheloai);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ListSongActivity.class);
                    intent.putExtra("genre", genreArrayList.get(getPosition())); //Gửi key dữ liệu đi
                    context.startActivity(intent);
                }
            });
        }
    }
}
