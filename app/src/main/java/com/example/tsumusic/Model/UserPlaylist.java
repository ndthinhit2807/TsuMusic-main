package com.example.tsumusic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserPlaylist implements Serializable {

    @SerializedName("MADANHSACH")
    @Expose
    private String madanhsach;
    @SerializedName("MATHANHVIEN")
    @Expose
    private String mathanhvien;
    @SerializedName("TENDANHSACH")
    @Expose
    private String tendanhsach;
    @SerializedName("MIEUTA")
    @Expose
    private String mieuta;
    @SerializedName("NGAYTAO")
    @Expose
    private String ngaytao;

    public String getMadanhsach() {
        return madanhsach;
    }

    public void setMadanhsach(String madanhsach) {
        this.madanhsach = madanhsach;
    }

    public String getMathanhvien() {
        return mathanhvien;
    }

    public void setMathanhvien(String mathanhvien) {
        this.mathanhvien = mathanhvien;
    }

    public String getTendanhsach() {
        return tendanhsach;
    }

    public void setTendanhsach(String tendanhsach) {
        this.tendanhsach = tendanhsach;
    }

    public String getMieuta() {
        return mieuta;
    }

    public void setMieuta(String mieuta) {
        this.mieuta = mieuta;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

}