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
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.Activity.HomeActivity;
import com.example.tsumusic.Activity.ListSongActivity;
import com.example.tsumusic.Activity.LoginActivity;
import com.example.tsumusic.Activity.Playlist_Activity;
import com.example.tsumusic.Activity.PlaysongsActivity;
import com.example.tsumusic.Model.User;
import com.example.tsumusic.Model.UserPlaylist;
import com.example.tsumusic.R;
import com.example.tsumusic.Service.API_Service;
import com.example.tsumusic.Service.Service_Data;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        SharedPreferences sharedPreferences = context.getSharedPreferences("SettingGame", Context.MODE_PRIVATE);
        TextView text_nameplaylist, text_decription;
        RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView ) {
            super(itemView);
            text_nameplaylist = itemView.findViewById(R.id.text_nameplayplist);
            text_decription = itemView.findViewById(R.id.text_decription);
            relativeLayout = itemView.findViewById(R.id.relativeplaylist);
          if (sharedPreferences.getString("idbaihat",null)==null){
              itemView.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Intent intent = new Intent(context, ListSongActivity.class);
                      intent.putExtra("userplaylist",array_Userplaylist.get(getPosition()));// Gửi key dữ liệu đi
                      putStringValue("userplaylist",array_Userplaylist.get(getPosition()).getTendanhsach());// Gửi key dữ liệu đi
                      context.startActivity(intent);
                  }
              });
          }else{
              itemView.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                     openAddPlaylistDialog(Gravity.CENTER);
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

        private void openAddPlaylistDialog(int gravity) {
            final Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog_song_playlist);

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
            Button btn_dialog_exit, btn_dialog_save;

            txt_dialog_namesong = dialog.findViewById(R.id.txt_dialog_namesong);
            txt_dialog_nameplaylist = dialog.findViewById(R.id.txt_dialog_nameplaylist);
            btn_dialog_exit = dialog.findViewById(R.id.btn_dialog_exitsong);
            btn_dialog_save = dialog.findViewById(R.id.btn_dialog_savesong);
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingGame", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            txt_dialog_namesong.setText(sharedPreferences.getString("song_name",null).toString());
            txt_dialog_nameplaylist.setText(array_Userplaylist.get(getPosition()).getTendanhsach());

            String username = sharedPreferences.getString("username", null);
            String email = sharedPreferences.getString("email", null);

            btn_dialog_exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            btn_dialog_save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id_song = sharedPreferences.getString("idbaihat",null);
                    String id_playlist = array_Userplaylist.get(getPosition()).getMadanhsach();

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
    }
}
