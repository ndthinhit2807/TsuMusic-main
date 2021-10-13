package com.example.tsumusic.Service;

import com.example.tsumusic.Model.Album;
import com.example.tsumusic.Model.Banner;
import com.example.tsumusic.Model.Genre;
import com.example.tsumusic.Model.Song;
import com.example.tsumusic.Model.Singer;
import com.example.tsumusic.Model.ToplistToday;
import com.example.tsumusic.Model.User;
import com.example.tsumusic.Model.UserPlaylist;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Service_Data {

    @GET("bannersong.php")
    Call<List<Banner>> GetDataBanner();

    @GET("topforcurrentday.php")
    Call<List<ToplistToday>> Gettoplistplaylist();

    @GET("allplaylists.php")
    Call<List<ToplistToday>> Getallplaylists();

    @GET("albumhot.php")
    Call<List<Album>> GetDataAlbumhot();

    @GET("genre.php")
    Call<List<Genre>> GetData_Genre();

    @GET("all_genre.php")
    Call<List<Genre>> GetData_All_Genre();

    @GET("singer.php")
    Call<List<Singer>> GetData_Singer();

    @GET("all_singer.php")
    Call<List<Singer>> GetData_All_Singer();

    @GET("Allalbum.php")
    Call<List<Album>> GetPlaylistAlbum();

    @GET("Song_suggestions.php")
    Call<List<Song>> Getsongsuggestions();

    @GET("all_song.php")
    Call<List<Song>> GetData_All_Song();

    @FormUrlEncoded
    @POST("listsong.php")
    Call<List<Song>> getdanhsachbaihattheongay(@Field("idtoplist") String idtoplist);

    @FormUrlEncoded
    @POST("listsong.php")
    Call<List<Song>> GetListsong_Singer(@Field("idsinger") String idsinger);


    @FormUrlEncoded
    @POST("listsong.php")
    Call<List<Song>> GetListsong_Banner(@Field("idbanner") String idbanner);

    @FormUrlEncoded
    @POST("listsong.php")
    Call<List<Song>> GetListsong_Userplaylist(@Field("iduserplaylist") String username);

    @FormUrlEncoded
    @POST("listsong.php")
    Call<List<Song>> Getallalbum(@Field("idplaylistalbum") String idplaylistalbum);

    @FormUrlEncoded
    @POST("listsong.php")
    Call<List<Song>> GetListsong_Genre(@Field("idgenre") String idgenre);

    @FormUrlEncoded
    @POST("Searchforsong.php")
    Call<List<Song>> getsearchbaihat(@Field("tukhoa") String tukhoa);

    @FormUrlEncoded
    @POST("Searchforsinger.php")
    Call<List<Singer>> getsearchcasi(@Field("tukhoa") String tukhoa);

    @FormUrlEncoded
    @POST("updateluotnghe.php")
    Call<String> getupdateluotnghe(@Field("luotnghe") String luotnghe, @Field("idbaihat") String idbaihat);

    @FormUrlEncoded
    @POST("playlist_user.php")
//    Call<List<UserPlaylist>> GetUserPlaylist(@Field("username") String username);
    Call<List<UserPlaylist>> GetUserPlaylist(@Field("username") String username,@Field("email") String email);
//    Call<List<UserPlaylist>> GetUserPlaylist();

    @FormUrlEncoded
    @POST("signup.php")
    Call<User> register(
            @Field("name") String name,
            @Field("user_name") String user_name,
            @Field("password") String password,
            @Field("email") String email
    );

    @FormUrlEncoded
    @POST("signin.php")
    Call<User> logininfo(@Field("user_name") String user_name,
                         @Field("email") String email,
                         @Field("password") String password);

    @FormUrlEncoded
    @POST("changepassword.php")
    Call<User> changepassword(
            @Field("oldpassword") String oldpassword,
            @Field("newpassword") String newpassword,
            @Field("confirmpassword") String confirmpassword,
            @Field("user_name") String user_name
    );
}
