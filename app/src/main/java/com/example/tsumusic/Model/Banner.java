package com.example.tsumusic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Banner implements Serializable {

@SerializedName("MAQUANGCAO")
@Expose
private String maquangcao;
@SerializedName("URLHINHQUANGCAO")
@Expose
private String urlhinhquangcao;
@SerializedName("MIEUTA")
@Expose
private Object mieuta;
@SerializedName("MABAIHAT")
@Expose
private String mabaihat;

public String getMaquangcao() {
return maquangcao;
}

public void setMaquangcao(String maquangcao) {
this.maquangcao = maquangcao;
}

public String getUrlhinhquangcao() {
return urlhinhquangcao;
}

public void setUrlhinhquangcao(String urlhinhquangcao) {
this.urlhinhquangcao = urlhinhquangcao;
}

public Object getMieuta() {
return mieuta;
}

public void setMieuta(Object mieuta) {
this.mieuta = mieuta;
}

public String getMabaihat() {
return mabaihat;
}

public void setMabaihat(String mabaihat) {
this.mabaihat = mabaihat;
}

}