package com.example.tsumusic.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.Activity.AppinformationActivity;
import com.example.tsumusic.Activity.ChangepasswordActivity;
import com.example.tsumusic.Activity.Playlist_Activity;
import com.example.tsumusic.Activity.ProfileActivity;
import com.example.tsumusic.Activity.LoginActivity;
import com.example.tsumusic.Activity.UserguideActivity;
import com.example.tsumusic.R;

public class FragmentInformation extends Fragment {
    View view;
    Button signin, signout, changepwd, information, playlist, informationapp, userguide, information_playlist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_information, container, false);
        signin = view.findViewById(R.id.sigin);
        signout = view.findViewById(R.id.sigout);
        changepwd = view.findViewById(R.id.information_changepassword);
        information = view.findViewById(R.id.information_user);
        playlist = view.findViewById(R.id.information_playlist);
        informationapp = view.findViewById(R.id.btninformationapp);
        userguide = view.findViewById(R.id.buttonguideapp);
        information_playlist = view.findViewById(R.id.information_playlist);
        signout.setEnabled(false);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("SettingGame", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        userguide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserguideActivity.class);
                startActivity(intent);
                Animatoo.animateSlideRight(getActivity());
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                Animatoo.animateSlideRight(getActivity());
                getActivity().finish();

            }
        });
        if (sharedPreferences.getString("username", null) != null) {
            signin.setText(sharedPreferences.getString("name", null));
            signin.setAllCaps(false);
//            signin.setClickable(false);
            signout.setVisibility(view.VISIBLE);
            signout.setEnabled(true);
        }
//        Intent intent = getActivity().getIntent();
//        if (intent.getExtras() != null) {
//            signin.setText(sharedPreferences.getString("username",null));
//
//            signin.setClickable(false);
//            signout.setVisibility(view.VISIBLE);
//            signout.setEnabled(true);
//        }
//       ??i ?????n m??n h??nh Thay ?????i m???t kh???u
        changepwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedPreferences.getString("username", null) != null) {
                    Intent intent1 = new Intent(getActivity(), ChangepasswordActivity.class);
                    startActivity(intent1);
                    Animatoo.animateSlideRight(getActivity());
                } else {
                    Toast.makeText(getActivity(), "B???n c???n ????ng nh???p tr?????c", Toast.LENGTH_SHORT).show();
                }
            }
        });
//       ??i ?????n m??n h??nh ????ng xu???t
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signin.setText("????ng nh???p");
                signin.setEnabled(true);
                signout.setEnabled(false);
                signout.setVisibility(View.INVISIBLE);
                editor.clear().commit();
            }
        });
//       ??i ?????n m??n h??nh Xem th??ng tin c?? nh??n
        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedPreferences.getString("username", null) != null) {
                    Intent intent = new Intent(getActivity(), ProfileActivity.class);
                    startActivity(intent);
                    Animatoo.animateSlideRight(getActivity());
                } else {
                    Toast.makeText(getActivity(), "B???n c???n ????ng nh???p tr?????c", Toast.LENGTH_SHORT).show();
                }
            }
        });
//        ??i ?????n m??n h??nh th??ng tin ???ng d???ng
        informationapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AppinformationActivity.class);
                startActivity(intent);
                Animatoo.animateSlideRight(getActivity());
            }
        });
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Playlist_Activity.class);
                startActivity(intent);
                Animatoo.animateSlideRight(getActivity());
            }
        });

        information_playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedPreferences.getString("username", null) == null) {

                    Toast.makeText(getActivity(), "B???n c???n ????ng nh???p tr?????c", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent1 = new Intent(getActivity(), Playlist_Activity.class);
                    startActivity(intent1);
                    Animatoo.animateSlideRight(getActivity());
                }
            }
        });

        return view;
    }
}