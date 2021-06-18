package com.example.tsumusic.Fragment;

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
import com.example.tsumusic.Activity.ProfileActivity;
import com.example.tsumusic.Activity.LoginActivity;
import com.example.tsumusic.R;

public class FragmentInformation extends Fragment {
    View view;
    Button signin, signout, changepwd, information, playlist, informationapp;

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
        signout.setEnabled(false);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("SettingGame", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                Animatoo.animateSlideRight(getActivity());
            }
        });
        if (sharedPreferences.getString("username", null) != null) {
            signin.setText(sharedPreferences.getString("username", null));
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
//       Đi đến màn hình Thay đổi mật khẩu
        changepwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedPreferences.getString("username", null) != null) {
                    Intent intent1 = new Intent(getActivity(), ChangepasswordActivity.class);
                    startActivity(intent1);
                    Animatoo.animateSlideRight(getActivity());
                } else {
                    Toast.makeText(getActivity(), "Bạn cần đăng nhập trước", Toast.LENGTH_SHORT).show();
                }
            }
        });
//       Đi đến màn hình Đăng xuất
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signin.setText("Đăng nhập");
                signin.setEnabled(true);
                signout.setEnabled(false);
                signout.setVisibility(View.INVISIBLE);
                editor.clear().commit();
            }
        });
//       Đi đến màn hình Xem thông tin cá nhân
        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedPreferences.getString("username", null) != null) {
                    Intent intent = new Intent(getActivity(), ProfileActivity.class);
                    startActivity(intent);
                    Animatoo.animateSlideRight(getActivity());
                } else {
                    Toast.makeText(getActivity(), "Bạn cần đăng nhập trước", Toast.LENGTH_SHORT).show();
                }
            }
        });
//        Đi đến màn hình thông tin ứng dụng
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
                Toast.makeText(getActivity(), "Chức năng đang phát triển", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}