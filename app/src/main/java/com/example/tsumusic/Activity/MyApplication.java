package com.example.tsumusic.Activity;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
// Cái này dùng để gửi notification các thiết bị từ android 8 trở đi
public class MyApplication extends Application {
    public  static  final String CHANNEL_ID = "channel_service_example";
    @Override
    public void onCreate() {
        super.onCreate();
        CreateChannelNotification();
    }
    private void CreateChannelNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
           NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                   "Channel_Service_example", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager!=null){
            manager.createNotificationChannel(channel);}
        }
    }
}
