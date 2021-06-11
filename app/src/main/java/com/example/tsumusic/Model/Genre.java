package com.example.tsumusic.Model;

import android.os.Parcel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Genre implements Serializable {

    @SerializedName("MATHELOAI")
    @Expose
    private String matheloai;
    @SerializedName("TENTHELOAI")
    @Expose
    private String tentheloai;
    @SerializedName("MIEUTA")
    @Expose
    private String mieuta;
    @SerializedName("HINHTHELOAI")
    @Expose
    private String hinhtheloai;

    protected Genre(Parcel in) {
        matheloai = in.readString();
        tentheloai = in.readString();
        mieuta = in.readString();
        hinhtheloai = in.readString();
    }


    public String getMatheloai() {
        return matheloai;
    }

    public void setMatheloai(String matheloai) {
        this.matheloai = matheloai;
    }

    public String getTentheloai() {
        return tentheloai;
    }

    public void setTentheloai(String tentheloai) {
        this.tentheloai = tentheloai;
    }

    public String getMieuta() {
        return mieuta;
    }

    public void setMieuta(String mieuta) {
        this.mieuta = mieuta;
    }

    public String getHinhtheloai() {
        return hinhtheloai;
    }

    public void setHinhtheloai(String hinhtheloai) {
        this.hinhtheloai = hinhtheloai;
    }


}