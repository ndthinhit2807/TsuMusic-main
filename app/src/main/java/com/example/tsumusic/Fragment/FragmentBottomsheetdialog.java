package com.example.tsumusic.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tsumusic.Activity.SonginfoActivity;
import com.example.tsumusic.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textview.MaterialTextView;

public class FragmentBottomsheetdialog extends BottomSheetDialogFragment {
    private MaterialTextView txtusername,txtsonginfo,txtsingerinfo;
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
        txtusername = view.findViewById(R.id.drawer_user_name);
        txtsonginfo = view.findViewById(R.id.songnameinfo);
        super.onViewCreated(view, savedInstanceState);
        txtsonginfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SonginfoActivity.class);
                startActivity(intent);
            }
        });

    }
}
