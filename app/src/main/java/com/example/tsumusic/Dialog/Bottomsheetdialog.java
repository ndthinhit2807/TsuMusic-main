package com.example.tsumusic.Dialog;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.audiofx.AudioEffect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tsumusic.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textview.MaterialTextView;
import com.squareup.picasso.Picasso;

public class Bottomsheetdialog extends BottomSheetDialogFragment {
    private MaterialTextView txtsonginfo, txtusername, txtequalizer;
    private ImageView imglogo;
    private static final int REQUEST_CODE_OPEN_EQUALIZER = 599;
    private MMToast mmToast;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //Tạo View của Fragment
        return inflater.inflate(R.layout.dialog_bottomsheet, container);


    }

    protected void showToastFailure(String msg) {
        if (mmToast == null) {
            MMToast.Builder builder = new MMToast.Builder(getActivity())
                    .setMessage(msg)
                    .setSuccess(false);
            mmToast = builder.create();
        } else {
            mmToast.cancel();
            MMToast.Builder builder = new MMToast.Builder(getActivity())
                    .setMessage(msg)
                    .setSuccess(false);
            mmToast = builder.create();
        }
        mmToast.show();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        txtsonginfo = view.findViewById(R.id.songnameinfo);
        txtusername = view.findViewById(R.id.drawer_user_name);
        imglogo = view.findViewById(R.id.drawer_user_logo);
        txtequalizer = view.findViewById(R.id.equalizer);
//        txtsonginfo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), SonginfoActivity.class);
//                startActivity(intent);
//                Animatoo.animateSlideUp(getActivity());
//            }
//        });
        txtsonginfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = View.inflate(getActivity(),R.layout.dialog_bottomsheet_songinfo,null);
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity());
                bottomSheetDialog.setContentView(view);
//                if (bottomSheetDialog.isShowing()){
                    bottomSheetDialog.dismiss();
//                } else {
//                    bottomSheetDialog.show();
//                }
                TextView txttenbai =(TextView) view.findViewById(R.id.textviewtenbaihatdangnghe);
                TextView txtcasi =(TextView) view.findViewById(R.id.textviewtennghesihat);
                TextView txtluotnghe =(TextView) view.findViewById(R.id.textviewluotnghebaihat);
                TextView txtngayphathanh =(TextView) view.findViewById(R.id.textviewngayphathanhbaihat);
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("passinfo", Context.MODE_PRIVATE);
                txttenbai.setText(sharedPreferences.getString("tenbaihat", null));
                txtcasi.setText(sharedPreferences.getString("tencasi", null));
                txtluotnghe.setText(sharedPreferences.getString("luotnghe", null));
                txtngayphathanh.setText(sharedPreferences.getString("ngayphathanh", null));
            }
        });
        txtequalizer.setOnClickListener(v -> {
            final Intent intent = new Intent(AudioEffect.ACTION_DISPLAY_AUDIO_EFFECT_CONTROL_PANEL);
            if (null != getContext()) {
                if ((intent.resolveActivity(getContext().getPackageManager()) != null))
                    startActivityForResult(intent, REQUEST_CODE_OPEN_EQUALIZER);
                else
                    showToastFailure("Equalizer mặc định không tìm thấy!");
            }
        });
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("SettingGame", Context.MODE_PRIVATE);
        txtusername.setText(sharedPreferences.getString("name", null));
        if (sharedPreferences.getString("urlimage", null) != null) {
            Picasso.with(getActivity()).load(sharedPreferences.getString("urlimage", null)).error(R.drawable.ic_logoapp01).into(imglogo);
        }
        super.onViewCreated(view, savedInstanceState);
    }


}
