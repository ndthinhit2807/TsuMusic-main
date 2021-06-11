package com.example.tsumusic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Singer implements Serializable {

    @SerializedName("MACASI")
    @Expose
    private String macasi;
    @SerializedName("TENCASI")
    @Expose
    private String tencasi;
    @SerializedName("TIEUSU")
    @Expose
    private Object tieusu;
    @SerializedName("URLCASI")
    @Expose
    private String urlcasi;

    public String getMacasi() {
        return macasi;
    }

    public void setMacasi(String macasi) {
        this.macasi = macasi;
    }

    public String getTencasi() {
        return tencasi;
    }

    public void setTencasi(String tencasi) {
        this.tencasi = tencasi;
    }

    public Object getTieusu() {
        return tieusu;
    }

    public void setTieusu(Object tieusu) {
        this.tieusu = tieusu;
    }

    public String getUrlcasi() {
        return urlcasi;
    }

    public void setUrlcasi(String urlcasi) {
        this.urlcasi = urlcasi;
    }

}