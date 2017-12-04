package com.example.gertautasm.a7laboras;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.BatteryManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private BroadcastReceiver battery = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra("level",0);
            ProgressBar pb = (ProgressBar) findViewById(R.id.baras);
            pb.setProgress(level);
            TextView textView = (TextView) findViewById(R.id.tekstas);
            textView.setText("Battery level: " + Integer.toString(level) + "%");
            if(level< 25){
                Toast.makeText(context,"Baterija senka",Toast.LENGTH_LONG).show();
            }else if(level <=15){
                notification();
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        registerReceiver(battery,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
    public void notification(){
        NotificationCompat.Builder notBuilder = new NotificationCompat.Builder(Main2Activity.this)
                .setSmallIcon(android.R.drawable.stat_notify_error)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                .setContentTitle("Low battery")
                .setContentText("Your battery is below 15% ");
        notBuilder.setDefaults(
                Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
        NotificationManagerCompat notificationmanager = NotificationManagerCompat.from(Main2Activity.this);
        notificationmanager.notify(1,notBuilder.build());
    }
}
