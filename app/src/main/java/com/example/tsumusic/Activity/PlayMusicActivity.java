package com.example.tsumusic.Activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.Adapter.ViewpagerListsongplay;
import com.example.tsumusic.Fragment.FragmentBottomsheetdialog;
import com.example.tsumusic.Fragment.FragmentListsongplay;
import com.example.tsumusic.Fragment.FragmentMusicdisc;
import com.example.tsumusic.Model.Song;
import com.example.tsumusic.R;
import com.example.tsumusic.Service.API_Service;
import com.example.tsumusic.Service.Service_Data;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayMusicActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView textCurrentTime, textTotalTime, txttencasi, txttenbaihat;
    SeekBar sktime;
    ImageButton imgplay, imgnext, imgprev, imgrandom, imgrepeat;
    ViewPager viewPagerplaymusic;
    int positon = 0;
    boolean repeatnhac = false;
    boolean checkrandom = false;
    boolean nextnhac = false;
    public static ArrayList<Song> mangbaihat = new ArrayList<>();
    public static ViewpagerListsongplay adapternhac;
    FragmentListsongplay fragment_listsongplay;
    FragmentMusicdisc fragment_musicdisc;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_play_song);
        GetDataIntent();
//        for(Song a : mangbaihat)
//        {
//            Log.wtf("hienbaihat",a.getTenbaihat());
//        }
        Anhxa();
        eventClick();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activityplaymusic, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nghesi:
                Toast.makeText(this, "Giới thiệu nghệ sĩ", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.thongtin:
//                Toast.makeText(this, "Thông tin bài hát", Toast.LENGTH_SHORT).show();
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(PlayMusicActivity.this);
                bottomSheetDialog.setContentView(R.layout.fragment_bottom_sheet);
                FragmentBottomsheetdialog myDialog
                        = new FragmentBottomsheetdialog();

                FragmentManager fm = getSupportFragmentManager();
                myDialog.show(fm, "FirstBottomSheetDialogFragment");
//                Intent intent = new Intent(this,HomeActivity.class);
//                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void eventClick() {
        final Handler handler = new Handler();
        // Log.d("LOGGGGG: ", mangbaihat.get(positon).getTenbaihat());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (adapternhac.getItem(1) != null) {
                    if (mangbaihat.size() > 0) {
                        //  if (fragment_musicdisc != null)
                        fragment_musicdisc.PlayNhac(mangbaihat.get(0).getUrlhinhbaihat());
                        handler.removeCallbacks(this);
                    } else {
                        handler.postDelayed(this, 200);
                    }
                }
            }
        }, 500);
//        Phát nhạc và dừng nhạc
        imgplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    imgplay.setImageResource(R.drawable.play_to_pause_linear_out_slow_in);
                } else {
                    mediaPlayer.start();
                    imgplay.setImageResource(R.drawable.pause_to_play);
                }

            }
        });
//        Lặp bài hát
        imgrepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (repeatnhac == false) {
                    if (checkrandom == true) {
                        checkrandom = false;
                        imgrepeat.setImageResource(R.drawable.ic_repeat_one);
                        imgrandom.setImageResource(R.drawable.ic_shuffle);
                        repeatnhac = true;
                    } else {
                        imgrepeat.setImageResource(R.drawable.ic_repeat_one);
                        repeatnhac = true;
                    }
                } else {
                    imgrepeat.setImageResource(R.drawable.ic_repeat);
                    repeatnhac = false;
                }
            }
        });
//        Phát bài hát ngẫu nghiên
        imgrandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkrandom == false) {
                    if (repeatnhac == true) {
                        repeatnhac = false;
                        imgrandom.setImageResource(R.drawable.ic_shuffle_activate);
                        imgrepeat.setImageResource(R.drawable.ic_repeat);
                        checkrandom=true;
                    }else {
                        imgrandom.setImageResource(R.drawable.ic_shuffle_activate);
                        checkrandom = true;

                    }
                } else {
                    imgrandom.setImageResource(R.drawable.ic_shuffle);
                    checkrandom = false;
                }
            }
        });
//        Seekbar thời gian bài hát
        sktime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
//        Chuyển bài hát
        imgnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mangbaihat.size() > 0) {
                    if (mediaPlayer.isPlaying() || mediaPlayer != null) {
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                    if (positon < (mangbaihat.size())) {
                        imgplay.setImageResource(R.drawable.pause_to_play);
                        positon++;
                        if (repeatnhac == true) {
                            if (positon == 0) {
                                positon = mangbaihat.size();
                            }
                            positon -= 1;
                        }
                        if (checkrandom == true) {
                            Random random = new Random();
                            int index = random.nextInt(mangbaihat.size());
                            if (index == positon) {
                                positon = index - 1;
                            }
                            positon = index;
                        }
                        if (positon > mangbaihat.size() - 1) {
                            positon = 0;
                        }
                        Service_Data service_data = API_Service.getService();
                        Call<String> callback = service_data.getupdateluotnghe("1", mangbaihat.get(positon).getMabaihat());
                        callback.enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {

                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {

                            }
                        });
                        new PlayMp3().execute(mangbaihat.get(positon).getUrlbaihat());
                        fragment_musicdisc.PlayNhac(mangbaihat.get(positon).getUrlhinhbaihat());
                        //getSupportActionBar().setTitle(mangbaihat.get(positon).getTenbaihat());
                        Updatetime();
                    }
                }
                imgprev.setClickable(false);
                imgnext.setClickable(false);
                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgprev.setClickable(true);
                        imgnext.setClickable(true);
                    }
                }, 3000);
            }
        });
//        Quay lại bài hát trước
        imgprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mangbaihat.size() > 0) {
                    if (mediaPlayer.isPlaying() || mediaPlayer != null) {
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                    if (positon < (mangbaihat.size())) {
                        imgplay.setImageResource(R.drawable.pause_to_play);
                        positon--;
                        if (positon < 0) {
                            positon = mangbaihat.size() - 1;
                        }
                        if (repeatnhac == true) {
                            positon += 1;
                        }
                        if (checkrandom == true) {
                            Random random = new Random();
                            int index = random.nextInt(mangbaihat.size());
                            if (index == positon) {
                                positon = index - 1;
                            }
                            positon = index;
                        }
                        Service_Data service_data = API_Service.getService();
                        Call<String> callback = service_data.getupdateluotnghe("1", mangbaihat.get(positon).getMabaihat());
                        callback.enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {

                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {

                            }
                        });
                        fragment_musicdisc.PlayNhac(mangbaihat.get(positon).getUrlhinhbaihat());
                        new PlayMp3().execute(mangbaihat.get(positon).getUrlbaihat());
                        // getSupportActionBar().setTitle(mangbaihat.get(positon).getTenbaihat());
                        Updatetime();
                    }
                }
                imgprev.setClickable(false);
                imgnext.setClickable(false);
                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgprev.setClickable(true);
                        imgnext.setClickable(true);
                    }
                }, 1000);
            }
        });
    }

    private void GetDataIntent() {
        Intent intent = getIntent();
        mangbaihat.clear();
        if (intent != null) {
//            Nhận dữ liệu bài hát
            if (intent.hasExtra("Baihat")) {
                Song song = intent.getParcelableExtra("Baihat");
                mangbaihat.add(song);
                //update luot nghe bai hat
                Service_Data service_data = API_Service.getService();
                Call<String> callback = service_data.getupdateluotnghe("1", mangbaihat.get(positon).getMabaihat()); //Đếm lượt nghe
                callback.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                    }
                });
            }
//            nhận dữ liệu bài hát danh sách bài
            if (intent.hasExtra("cacbaihat")) {
                ArrayList<Song> songArrayList = intent.getParcelableArrayListExtra("cacbaihat");
                mangbaihat = songArrayList;
                Service_Data service_data = API_Service.getService();
                Call<String> callback = service_data.getupdateluotnghe("1", mangbaihat.get(positon).getMabaihat());// Đếm lượt nghe
                callback.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                    }
                });
            }
        }

    }

    private void Anhxa() {
        toolbar = findViewById(R.id.toolbarplaymusic);
        textCurrentTime = findViewById(R.id.textCurrentTime);
        textTotalTime = findViewById(R.id.textTotalTime);
        sktime = findViewById(R.id.playerSeeBar);
        imgplay = findViewById(R.id.buttonPlay);
        imgnext = findViewById(R.id.buttonNext);
        imgprev = findViewById(R.id.buttonPrev);
        imgrepeat = findViewById(R.id.buttonRepeat);
        imgrandom = findViewById(R.id.buttonShuffle);
        viewPagerplaymusic = findViewById(R.id.viewPagerplaymusic);
        txttenbaihat = findViewById(R.id.textviewtenbaihatplay);
        txttencasi = findViewById(R.id.textviewtencasihat);
//        findViewById(R.id.imageviewbutionxemthemthongtin).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(PlayMusicActivity.this);
//                bottomSheetDialog.setContentView(R.layout.fragment_bottom_sheet);
//                TextView txttenbaihat = bottomSheetDialog.findViewById(R.id.textviewtenbaihatdangnghe);
//                TextView txtcasi = bottomSheetDialog.findViewById(R.id.textviewtennghesihat);
//                TextView txttheloai = bottomSheetDialog.findViewById(R.id.textviewtheloainhac);
//                TextView txtngayphathanh = bottomSheetDialog.findViewById(R.id.textviewngayphathanhbaihat);
//                TextView txtluotnghe = bottomSheetDialog.findViewById(R.id.textviewluotnghebaihat);
//
//                FragmentBottomsheetdialog myDialog
//                        = new FragmentBottomsheetdialog();
//
//                FragmentManager fm = getSupportFragmentManager();
//                myDialog.show(fm, "FirstBottomSheetDialogFragment");
//            }
//        });
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);   //Ẩn title toolbar
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {

//                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
//                    mediaPlayer.stop();
//                    mangbaihat.clear();
//                }
//                finish();
//                Animatoo.animateSlideDown(PlayMusicActivity.this);
//            }
//        });
        ImageView imageView = (ImageView)findViewById(R.id.imageback);

        //set the ontouch listener
        imageView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        ImageView view = (ImageView) v;
                        //overlay is black with transparency of 0x77 (119)
                        view.getDrawable().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                            mediaPlayer.stop();
                            mangbaihat.clear();
                        }
                        finish();
                        Animatoo.animateSlideDown(PlayMusicActivity.this);
                        break;
                    }
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL: {
                        ImageView view = (ImageView) v;
                        //clear the overlay
                        view.getDrawable().clearColorFilter();
                        view.invalidate();
                        break;
                    }
                }

                return false;
            }
        });


        adapternhac = new ViewpagerListsongplay(getSupportFragmentManager());
        fragment_listsongplay = new FragmentListsongplay();
        fragment_musicdisc = new FragmentMusicdisc();
//        thêm fragment đĩa và danh sách bài hát
        adapternhac.AddFragment(fragment_musicdisc);
        adapternhac.AddFragment(fragment_listsongplay);
        fragment_musicdisc = (FragmentMusicdisc) adapternhac.getItem(positon);
        viewPagerplaymusic.setAdapter(adapternhac);
        if (mangbaihat.size() > 0) {
//       getSupportActionBar().setTitle(mangbaihat.get(positon).getTenbaihat());
            new PlayMp3().execute(mangbaihat.get(positon).getUrlbaihat());
            imgplay.setImageResource(R.drawable.pause_to_play);
        }
    }

    class PlayMp3 extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            return strings[0];
        }

        @Override
        protected void onPostExecute(String baihat) {
            super.onPostExecute(baihat);
            try {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mediaPlayer.stop();
                        mediaPlayer.reset();
                    }
                });
                mediaPlayer.setDataSource(baihat);
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.start();
            TimeSong();
            Updatetime();
        }
    }
//    vô hiệu hoá button back
    @Override
    public void onBackPressed() {
    }
    //Dừng nhạc
//    @Override
//    protected void onStop() {
//        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
//            mediaPlayer.stop();
//            //mangbaihat.clear();
//        }
//        super.onStop();
//    }

    // Chỉnh thời gian bài hát
    private void TimeSong() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        textTotalTime.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
        sktime.setMax(mediaPlayer.getDuration());
        txttenbaihat.setText(mangbaihat.get(positon).getTenbaihat());
        txttencasi.setText(mangbaihat.get(positon).getTencasi());
    }

    //    Thời gian hiện tại đang phát của bài hát
    private void Updatetime() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null) {
                    sktime.setProgress(mediaPlayer.getCurrentPosition());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
                    textCurrentTime.setText(simpleDateFormat.format(mediaPlayer.getCurrentPosition()));
                    handler.postDelayed(this, 3);
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            nextnhac = true;
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                }
            }
        }, 300);
        Handler handler1 = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (nextnhac == true) {
                    if (positon < (mangbaihat.size())) {
                        imgplay.setImageResource(R.drawable.pause_to_play);
                        positon++;
                        if (repeatnhac == true) {
                            if (positon == 0) {
                                positon = mangbaihat.size();
                            }
                            positon -= 1;
                        }
                        if (checkrandom == true) {
                            Random random = new Random();
                            int index = random.nextInt(mangbaihat.size());
                            if (index == positon) {
                                positon = index - 1;
                            }
                            positon = index;
                        }
                        if (positon > mangbaihat.size() - 1) {
                            positon = 0;
                        }
                        fragment_musicdisc.PlayNhac(mangbaihat.get(positon).getUrlhinhbaihat());
                        new PlayMp3().execute(mangbaihat.get(positon).getUrlbaihat());
                        //getSupportActionBar().setTitle(mangbaihat.get(positon).getTenbaihat());
                    }
                    imgprev.setClickable(false);
                    imgnext.setClickable(false);
                    Handler handler1 = new Handler();
                    handler1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            imgprev.setClickable(true);
                            imgnext.setClickable(true);
                        }
                    }, 1000);
                    nextnhac = false;
                    handler1.removeCallbacks(this);
                } else {
                    handler1.postDelayed(this, 1000);
                }
            }
        }, 1000);
    }
}