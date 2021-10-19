package com.example.tsumusic.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.Adapter.Adapter_Userplaylist;
import com.example.tsumusic.Model.ToplistToday;
import com.example.tsumusic.Model.User;
import com.example.tsumusic.Model.UserPlaylist;
import com.example.tsumusic.R;
import com.example.tsumusic.Service.API_Service;
import com.example.tsumusic.Service.Service_Data;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Playlist_Activity extends AppCompatActivity {

    RecyclerView recy_Playlist;
    Toolbar toolbar;
    Adapter_Userplaylist adapter_userplaylist;
    CircleImageView img_Playlist;
    TextView txt_add_playlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = getSharedPreferences("SettingGame", Context.MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        init();
        String username = sharedPreferences.getString("username", null);
        String email = sharedPreferences.getString("email", null);
//        Toast.makeText(this, sharedPreferences.getString("idbaihat", null), Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, getIntent().getStringExtra("Baihat"), Toast.LENGTH_SHORT).show();
        getData(username, email);
    }


    private void getData(String username, String email) {

        Service_Data service_data = API_Service.getService();
        Call<List<UserPlaylist>> callback = service_data.GetUserPlaylist(username, email);
        callback.enqueue(new Callback<List<UserPlaylist>>() {
            @Override
            public void onResponse(Call<List<UserPlaylist>> call, Response<List<UserPlaylist>> response) {
                ArrayList<UserPlaylist> array_userplaylist = (ArrayList<UserPlaylist>) response.body();
                adapter_userplaylist = new Adapter_Userplaylist(Playlist_Activity.this, array_userplaylist);
                recy_Playlist.setLayoutManager(new GridLayoutManager(Playlist_Activity.this, 1));
                recy_Playlist.setAdapter(adapter_userplaylist);
            }

            @Override
            public void onFailure(Call<List<UserPlaylist>> call, Throwable t) {

            }

        });
    }


    private void init() {
        recy_Playlist = findViewById(R.id.recy_Playlist);
        toolbar = findViewById(R.id.tool_Playlist);
        img_Playlist = findViewById(R.id.img_Createplaylist);
        txt_add_playlist = findViewById(R.id.text_Createplaylist);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Playlist");
        SharedPreferences sharedPreferences = getSharedPreferences("SettingGame", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.remove("idbaihat").commit();
                finish();
                Animatoo.animateSlideLeft(Playlist_Activity.this);
            }
        });
        img_Playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Playlist_Activity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        img_Playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddPlaylistDialog(Gravity.CENTER);
            }
        });

        txt_add_playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddPlaylistDialog(Gravity.CENTER);
            }
        });


    }

    private void openAddPlaylistDialog(int gravity) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_add_playlist);

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

        EditText edt_dialog_nameplaylist, edt_dialog_decriptionplaylist;
        Button btn_dialog_exit, btn_dialog_save;

        edt_dialog_nameplaylist = dialog.findViewById(R.id.edittext_dialog_nameplaylist);
        edt_dialog_decriptionplaylist = dialog.findViewById(R.id.edittext_dialog_decriptionpaylist);
        btn_dialog_exit = dialog.findViewById(R.id.btn_dialog_exit);
        btn_dialog_save = dialog.findViewById(R.id.btn_dialog_save);
        SharedPreferences sharedPreferences = getSharedPreferences("SettingGame", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String username = sharedPreferences.getString("username", null);
        String email = sharedPreferences.getString("email", null);

        btn_dialog_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Playlist_Activity.this, "Exit", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        btn_dialog_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String playlist_name = edt_dialog_nameplaylist.getText().toString();
                String playlist_description = edt_dialog_decriptionplaylist.getText().toString();
                String id_song = sharedPreferences.getString("idbaihat", null);
                if (id_song == null) {
                    Service_Data service_data = API_Service.getService();
                    Call<String> callback = service_data.add_playlist(playlist_name,playlist_description, username, email);
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {


                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                    finish();
                    Intent intent = new Intent(Playlist_Activity.this, Playlist_Activity.class);
                    startActivity(intent);
                }else {
                    Service_Data service_data = API_Service.getService();
                    Call<String> callback = service_data.add_song_playlist(id_song,playlist_name,playlist_description, username, email);
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {

                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                    Toast.makeText(Playlist_Activity.this, "song playlist", Toast.LENGTH_SHORT).show();
                    editor.remove("idbaihat").commit();
                    finish();
                    Intent intent = new Intent(Playlist_Activity.this, Playlist_Activity.class);
                    startActivity(intent);
                }


            }
        });

        dialog.show();
    }

    private void add_playlist() {

    }

}