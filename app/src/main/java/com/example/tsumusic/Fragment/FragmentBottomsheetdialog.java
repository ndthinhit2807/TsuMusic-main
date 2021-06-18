package com.example.tsumusic.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.audiofx.AudioEffect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.Activity.SonginfoActivity;
import com.example.tsumusic.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textview.MaterialTextView;
import com.squareup.picasso.Picasso;

public class FragmentBottomsheetdialog extends BottomSheetDialogFragment {
    private MaterialTextView txtsonginfo, txtusername,txtequalizer;
    ImageView imglogo;
    private static final int REQUEST_CODE_OPEN_EQUALIZER = 599;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //Tạo View của Fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet, container);


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        txtsonginfo = view.findViewById(R.id.songnameinfo);
        txtusername = view.findViewById(R.id.drawer_user_name);
        imglogo = view.findViewById(R.id.drawer_user_logo);
        txtequalizer = view.findViewById(R.id.equalizer);
        txtsonginfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SonginfoActivity.class);
                startActivity(intent);
                Animatoo.animateSlideUp(getActivity());
            }
        });
//
        txtequalizer.setOnClickListener(v -> {
            final Intent intent = new Intent(AudioEffect.ACTION_DISPLAY_AUDIO_EFFECT_CONTROL_PANEL);
            if (null != getContext()) {
                if ((intent.resolveActivity(getContext().getPackageManager()) != null))
                    startActivityForResult(intent, REQUEST_CODE_OPEN_EQUALIZER);
                else
                    Toast.makeText(getContext(), getString(R.string.equalizer_error), Toast.LENGTH_SHORT).show();
            }
        });

//
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("SettingGame", Context.MODE_PRIVATE);
        txtusername.setText(sharedPreferences.getString("name", null));
        if (sharedPreferences.getString("urlimage", null) != null) {
            Picasso.with(getActivity()).load(sharedPreferences.getString("urlimage", null)).into(imglogo);
        }
        super.onViewCreated(view, savedInstanceState);
    }
}
