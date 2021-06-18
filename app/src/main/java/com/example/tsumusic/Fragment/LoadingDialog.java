package com.example.tsumusic.Fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.example.tsumusic.R;


public class LoadingDialog {

    private Activity activity;
    private AlertDialog dialog;

    public LoadingDialog(Activity myActivity) {
        activity = myActivity;
    }

    public void StartLoadingDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);    //Khởi tạo thông báo
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialog_loadscreen, null));
        builder.setCancelable(true);
        dialog = builder.create();
        dialog.show();
    }

    public void dismissDialog() {
        dialog.dismiss();
    }

}
