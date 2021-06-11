package com.example.tsumusic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Album implements Serializable {

    @SerializedName("MAALBUM")
    @Expose
    private String maalbum;
    @SerializedName("TENALBUM")
    @Expose
    private String tenalbum;
    @SerializedName("URLALBUM")
    @Expose
    private String urlalbum;
    @SerializedName("TENCASI")
    @Expose
    private String tencasi;

    public String getMaalbum() {
        return maalbum;
    }

    public void setMaalbum(String maalbum) {
        this.maalbum = maalbum;
    }

    public String getTenalbum() {
        return tenalbum;
    }

    public void setTenalbum(String tenalbum) {
        this.tenalbum = tenalbum;
    }

    public String getUrlalbum() {
        return urlalbum;
    }

    public void setUrlalbum(String urlalbum) {
        this.urlalbum = urlalbum;
    }

    public String getTencasi() {
        return tencasi;
    }

    public void setTencasi(String tencasi) {
        this.tencasi = tencasi;
    }

}
