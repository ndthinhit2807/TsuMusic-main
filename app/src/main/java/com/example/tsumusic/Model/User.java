package com.example.tsumusic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("user_name")
    private String user_name;

    @Expose
    @SerializedName("password")
    private String password;

    @Expose
    @SerializedName("email")
    private String email;

    @Expose
    @SerializedName("url_image")
    private String url_image;

    @Expose
    @SerializedName("response")
    private String response;

    public User(String name, String user_name, String password, String email, String url_image, String response) {
        this.name = name;
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.url_image = url_image;
        this.response = response;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
