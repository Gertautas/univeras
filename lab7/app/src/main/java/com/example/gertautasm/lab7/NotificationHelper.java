package com.example.gertautasm.lab7;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;

/**
 * Created by gertautasm on 2017-12-07.
 */

public class NotificationHelper extends ContextWrapper{

    private static final String CHANNEL_ID =  "com.example.gertautasm.lab7";
    private static final  String CHANNEL_NAME ="Kanalas";
    private NotificationManager manager;
    public NotificationHelper(Context base) {
        super(base);
        createChannels();
    }
    public void createChannels(){
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
        notificationChannel.enableLights(true);
        notificationChannel.enableVibration(true);
        notificationChannel.setLightColor(Color.GREEN);
        notificationChannel.setLockscreenVisibility(android.app.Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(notificationChannel);
    }

    public NotificationManager getManager() {
        if(manager == null)
            manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        return manager;
    }

    public android.app.Notification.Builder getNotificaion(){
        return new android.app.Notification.Builder(getApplicationContext(),CHANNEL_ID)
                .setContentText("Low battery")
                .setContentTitle("Your battery is lower than 15%. Please charge")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setAutoCancel(true);
    }
}

