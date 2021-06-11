package com.example.tsumusic.Fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tsumusic.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class FragmentMusicdisc extends Fragment {
    View view;
    CircleImageView circleImageView;
    ObjectAnimator objectAnimator;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_musicdisc,container,false);
        circleImageView = view.findViewById(R.id.imageviewcircle);
        objectAnimator = ObjectAnimator.ofFloat(circleImageView,"rotation",0f,360f);    //Đĩa quay 360 độ
        objectAnimator.setDuration(21000);  //Set thời gian đĩa quay hết 1 vòng
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setRepeatMode(ValueAnimator.RESTART);
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.start();
        return view;
    }
    public void PlayNhac(String hinhanh) {
        Picasso.with(getActivity()).load(hinhanh).into(circleImageView);
    }
}
