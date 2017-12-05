package com.example.gertautasm.a7laboras;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.BatteryManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    int mnotificationId = 001;
    String CHANNEL_ID = "my_channel_01";

    private BroadcastReceiver battery = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra("level", 0);
            ProgressBar pb = (ProgressBar) findViewById(R.id.baras);
            pb.setProgress(level);
            TextView textView = (TextView) findViewById(R.id.tekstas);
            textView.setText("Battery level: " + Integer.toString(level) + "%");
            if (level < 25 & level >= 16) {
                Toast.makeText(context, "Baterija senka", Toast.LENGTH_LONG).show();
            } else if (level <= 15) {
                
                Notification.Builder not;

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    not = new Notification.Builder(context,"text");
                } else {
                    not = new Notification.Builder(context);
                }

                not.setSmallIcon(android.R.drawable.stat_notify_error);
                not.setAutoCancel(true);
                not.setContentTitle("Baterija miršta");
                not.setContentText("Spausti čia!");

                Intent intents = new Intent(context, Main2Activity.class);

                PendingIntent pi = PendingIntent.getActivity(context,1,intents, PendingIntent.FLAG_CANCEL_CURRENT);
                not.setContentIntent(pi);

                NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    nm.notify(1, not.build());
                }
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        registerReceiver(battery, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    public void sendNotification() {

    }
}


//
//    public void onReceive(Context context, Intent intent) {
//        Notification.Builder not;
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            not = new Notification.Builder(context,"text");
//        } else {
//            not = new Notification.Builder(context);
//        }
//
//        not.setSmallIcon(android.R.drawable.stat_notify_error);
//        not.setAutoCancel(true);
//        not.setContentTitle("Baterija miršta");
//        not.setContentText("Spausti čia!");
//
//        Intent intents = new Intent(context, MainActivity.class);
//
//        PendingIntent pi = PendingIntent.getActivity(context,1,intents, PendingIntent.FLAG_CANCEL_CURRENT);
//        not.setContentIntent(pi);
//
//        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            nm.notify(1, not.build());
//        }
//    }
