package com.example.gertautasm.a7laboras;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;


public class Main2Activity extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
            createNotification(context);
    }
    public void createNotification(Context context){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.icon)
                .setContentTitle("Low Battery")
                .setContentText("Your batter level is below 15% ");

        PendingIntent content = PendingIntent.getActivity(context,0,new Intent(context,MainActivity.class),0);
        builder.setContentIntent(content);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0,builder.build());
    }
}
