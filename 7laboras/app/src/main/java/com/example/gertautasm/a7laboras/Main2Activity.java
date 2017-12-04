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

    private BroadcastReceiver battery = new BroadcastReceiver() {
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra("level",0);
            ProgressBar pb = (ProgressBar) findViewById(R.id.baras);
            pb.setProgress(level);
            TextView textView = (TextView) findViewById(R.id.tekstas);
            textView.setText("Battery level: " + Integer.toString(level) + "%");
            if(level< 25 & level >= 16){
                Toast.makeText(context,"Baterija senka",Toast.LENGTH_LONG).show();
            }else if(level <= 15){
                createNotification();
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        registerReceiver(battery,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
    public void createNotification(){
      NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
              .setSmallIcon(R.drawable.icon)
              .setContentTitle("Low Battery")
              .setContentText("Your batter level is below 15% ");

      Intent intent = new Intent(this,Main2Activity.class);
      PendingIntent content = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
      builder.setContentIntent(content);

      NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
      manager.notify(0,builder.build());
    }
}
