package com.example.gertautasm.a7laboras;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    String bat = "";

    private BroadcastReceiver battery = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra("level",0);
            ProgressBar pb = (ProgressBar) findViewById(R.id.baras);
            pb.setProgress(level);
            TextView textView = (TextView) findViewById(R.id.tekstas);
            textView.setText("Battery level: " + Integer.toString(level) + "%");
            bat = String.valueOf(level);
            
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        registerReceiver(battery,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
}
