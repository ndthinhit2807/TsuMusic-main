package com.example.tsumusic.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.Activity.SonginfoActivity;
import com.example.tsumusic.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textview.MaterialTextView;

public class FragmentBottomsheetdialog extends BottomSheetDialogFragment {
    private MaterialTextView txtsonginfo,txtsingerinfo,txtusername;
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
         txtusername= view.findViewById(R.id.drawer_user_name);
        txtsonginfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SonginfoActivity.class);
                startActivity(intent);
                Animatoo.animateSlideUp(getActivity());
            }
        });
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("SettingGame", Context.MODE_PRIVATE);
        txtusername.setText(sharedPreferences.getString("name", null));
        super.onViewCreated(view, savedInstanceState);
    }
}
