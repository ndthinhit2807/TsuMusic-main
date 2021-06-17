package com.example.tsumusic.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Song implements Parcelable {

    @SerializedName("MABAIHAT")
    @Expose
    private String mabaihat;
    @SerializedName("TENBAIHAT")
    @Expose
    private String tenbaihat;
    @SerializedName("MIEUTA")
    @Expose
    private Object mieuta;
    @SerializedName("LOIBAIHAT")
    @Expose
    private String loibaihat;
    @SerializedName("URLBAIHAT")
    @Expose
    private String urlbaihat;
    @SerializedName("LUOTNGHE")
    @Expose
    private String luotnghe;
    @SerializedName("URLHINHBAIHAT")
    @Expose
    private String urlhinhbaihat;
    @SerializedName("MANHACSI")
    @Expose
    private String manhacsi;
    @SerializedName("MATOPLIST")
    @Expose
    private String matoplist;
    @SerializedName("MAALBUM")
    @Expose
    private String maalbum;
    @SerializedName("NGAYPHATHANH")
    @Expose
    private String ngayphathanh;
    @SerializedName("URLBANNER")
    @Expose
    private String urlbanner;
    @SerializedName("TENCASI")
    @Expose
    private String tencasi;

    protected Song(Parcel in) {
        mabaihat = in.readString();
        tenbaihat = in.readString();
        loibaihat = in.readString();
        urlbaihat = in.readString();
        luotnghe = in.readString();
        urlhinhbaihat = in.readString();
        manhacsi = in.readString();
        matoplist = in.readString();
        maalbum = in.readString();
        ngayphathanh = in.readString();
        urlbanner = in.readString();
        tencasi = in.readString();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    public String getMabaihat() {
        return mabaihat;
    }

    public void setMabaihat(String mabaihat) {
        this.mabaihat = mabaihat;
    }

    public String getTenbaihat() {
        return tenbaihat;
    }

    public void setTenbaihat(String tenbaihat) {
        this.tenbaihat = tenbaihat;
    }

    public Object getMieuta() {
        return mieuta;
    }

    public void setMieuta(Object mieuta) {
        this.mieuta = mieuta;
    }

    public String getLoibaihat() {
        return loibaihat;
    }

    public void setLoibaihat(String loibaihat) {
        this.loibaihat = loibaihat;
    }

    public String getUrlbaihat() {
        return urlbaihat;
    }

    public void setUrlbaihat(String urlbaihat) {
        this.urlbaihat = urlbaihat;
    }

    public String getLuotnghe() {
        return luotnghe;
    }

    public void setLuotnghe(String luotnghe) {
        this.luotnghe = luotnghe;
    }

    public String getUrlhinhbaihat() {
        return urlhinhbaihat;
    }

    public void setUrlhinhbaihat(String urlhinhbaihat) {
        this.urlhinhbaihat = urlhinhbaihat;
    }

    public String getManhacsi() {
        return manhacsi;
    }

    public void setManhacsi(String manhacsi) {
        this.manhacsi = manhacsi;
    }

    public String getMatoplist() {
        return matoplist;
    }

    public void setMatoplist(String matoplist) {
        this.matoplist = matoplist;
    }

    public String getMaalbum() {
        return maalbum;
    }

    public void setMaalbum(String maalbum) {
        this.maalbum = maalbum;
    }

    public String getNgayphathanh() {
        return ngayphathanh;
    }

    public void setNgayphathanh(String ngayphathanh) {
        this.ngayphathanh = ngayphathanh;
    }

    public String getUrlbanner() {
        return urlbanner;
    }

    public void setUrlbanner(String urlbanner) {
        this.urlbanner = urlbanner;
    }

    public String getTencasi() {
        return tencasi;
    }

    public void setTencasi(String tencasi) {
        this.tencasi = tencasi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mabaihat);
        dest.writeString(tenbaihat);
        dest.writeString(loibaihat);
        dest.writeString(urlbaihat);
        dest.writeString(luotnghe);
        dest.writeString(urlhinhbaihat);
        dest.writeString(manhacsi);
        dest.writeString(matoplist);
        dest.writeString(maalbum);
        dest.writeString(ngayphathanh);
        dest.writeString(urlbanner);
        dest.writeString(tencasi);
    }
}
