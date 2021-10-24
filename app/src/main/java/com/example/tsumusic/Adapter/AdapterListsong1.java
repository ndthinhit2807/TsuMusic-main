package com.example.tsumusic.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
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
import com.example.tsumusic.Model.UserPlaylist;
import com.example.tsumusic.R;
import com.example.tsumusic.Service.API_Service;
import com.example.tsumusic.Service.Service_Data;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterListsong1 extends RecyclerView.Adapter<AdapterListsong1.ViewHolder> {
    Context context;
    ArrayList<Song> mangbaihat;
    ArrayList<UserPlaylist> array_Userplaylist;
    ImageButton ibtn_Addplaylist , ibtn_Removeplaylist;
    View view;



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txttenbaihat, txtcasi, txtluotnghe;
        ImageView hinhbaihat,imgmore;

        public ViewHolder(View itemview) {
            super(itemview);
            txtcasi = itemview.findViewById(R.id.textviewtencasi1);
            txttenbaihat = itemview.findViewById(R.id.textviewtencakhuc1);
            hinhbaihat = itemview.findViewById(R.id.textviewindex1);
            txtluotnghe = itemview.findViewById(R.id.textviewlistsonghienthiluotnghe1);

            itemview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlaysongsActivity.class);
                    intent.putExtra("Baihat", mangbaihat.get(getPosition()));    //Gửi key dữ liệu đi
                    context.startActivity(intent);
                    Animatoo.animateSlideUp(context);
                }
            });
            ibtn_Removeplaylist = itemview.findViewById(R.id.btnremoveplaylist1);
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingGame", Context.MODE_PRIVATE);

                ibtn_Removeplaylist.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                            openAddPlaylistDialog(Gravity.CENTER,mangbaihat.get(getPosition()).getMabaihat());

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
    public AdapterListsong1(Context context, ArrayList<Song> mangbaihat) {
        this.context = context;
        this.mangbaihat = mangbaihat;
    }

    private void openAddPlaylistDialog(int gravity,String a) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_delete_song_playlist);

        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = gravity;
        window.setAttributes(layoutParams);

        if (Gravity.BOTTOM == gravity) {
            dialog.setCancelable(true);
        }

        TextView txt_dialog_nameplaylist, txt_dialog_namesong;
        Button btn_dialog_exit, btn_dialog_delete;

        txt_dialog_namesong = dialog.findViewById(R.id.txt_dialog_namesong);
        btn_dialog_exit = dialog.findViewById(R.id.btn_dialog_exitsong);
        btn_dialog_delete = dialog.findViewById(R.id.btn_dialog_deletesong);
        SharedPreferences sharedPreferences = context.getSharedPreferences("SettingGame", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        txt_dialog_namesong.setText(sharedPreferences.getString("song_name",null).toString());

        String username = sharedPreferences.getString("username", null);
        String email = sharedPreferences.getString("email", null);

        btn_dialog_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btn_dialog_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id_song = sharedPreferences.getString("idbaihat",null);
                String id_playlist = a;

                Service_Data service_data = API_Service.getService();
                Call<String> callback = service_data.add_song_playlist(id_song,id_playlist,username,email);
                callback.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Toast.makeText(context, "Thành Công", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(context, "Thất Bại", Toast.LENGTH_SHORT).show();
                    }
                });
                editor.remove("idbaihat").commit();
                ((Activity)context).finish();
                Intent intent = new Intent(context, Playlist_Activity.class);
                context.startActivity(intent);
            }
        });
        dialog.show();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.line_listsong1, parent, false);
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

