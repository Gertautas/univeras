package com.example.gertautasm.lab7;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    NotificationHelper helper;
    Button go;
    int level;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new NotificationHelper(this);
        go = (Button) findViewById(R.id.pradeti);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerReceiver(battery,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

            }
        });
    }

    private BroadcastReceiver battery = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            pb(intent);
            if(level< 25 & level >= 16){
                Toast.makeText(context,"Baterija senka",Toast.LENGTH_LONG).show();
            }else if(level <= 15){
                Notification.Builder builder = helper.getNotificaion();
                helper.getManager().notify(new Random().nextInt(),builder.build());

            }
        }
    };
    public void pb(Intent intent){
        level = intent.getIntExtra("level",0);
        ProgressBar pb = (ProgressBar) findViewById(R.id.baras);
        pb.setProgress(level);
        TextView textView = (TextView) findViewById(R.id.tekstas);
        textView.setText("Battery level: " + Integer.toString(level) + "%");
    }

}



