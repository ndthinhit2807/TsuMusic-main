package com.example.tsumusic.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.tsumusic.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class FragmentBottomsheetdialog extends BottomSheetDialogFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //Tạo View của Fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet, container);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
