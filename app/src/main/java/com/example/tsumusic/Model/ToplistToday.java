package com.example.tsumusic.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class ToplistToday implements Serializable {

    @SerializedName("MATOPLIST")
    @Expose
    private String matoplist;
    @SerializedName("TENTOPLIST")
    @Expose
    private String tentoplist;
    @SerializedName("URLHINHTOPLIST")
    @Expose
    private String urlhinhtoplist;
    @SerializedName("ICONTOPLIST")
    @Expose
    private String icontoplist;

    public String getMatoplist() {
        return matoplist;
    }

    public void setMatoplist(String matoplist) {
        this.matoplist = matoplist;
    }

    public String getTentoplist() {
        return tentoplist;
    }

    public void setTentoplist(String tentoplist) {
        this.tentoplist = tentoplist;
    }

    public String getUrlhinhtoplist() {
        return urlhinhtoplist;
    }

    public void setUrlhinhtoplist(String urlhinhtoplist) {
        this.urlhinhtoplist = urlhinhtoplist;
    }

    public String getIcontoplist() {
        return icontoplist;
    }

    public void setIcontoplist(String icontoplist) {
        this.icontoplist = icontoplist;
    }

}
