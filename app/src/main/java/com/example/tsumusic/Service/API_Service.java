package com.example.tsumusic.Service;

public class API_Service {
    //    private static String base_url = "https://tsumusics.000webhostapp.com/Server/";
    private static String base_url = "https://tsumusics.com/Server/";
    public static Service_Data getService() {
        return API_RetrofitClient.getClient(base_url).create(Service_Data.class);
    }
}

