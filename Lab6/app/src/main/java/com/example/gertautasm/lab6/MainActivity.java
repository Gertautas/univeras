package com.example.gertautasm.lab6;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    TextView textView3;
    int skaicius,skaicius2;
    Calendar calendar = Calendar.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView= (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3= (TextView) findViewById(R.id.textView3);

        this.registerForContextMenu(textView2);
        this.registerForContextMenu(textView);



    }

    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            Date currentTime = new Date();
            int min = currentTime.getMinutes();
            int hour = currentTime.getHours();
            int minute = min - i1;
            int valanda =hour - i;
            textView.setText("skirtumas tarp dabar ir nurodyto laiko yra " + valanda + " valandos ir " + minute + " minutes");
            builder.setMessage("skirtumas tarp dabar ir nurodyto laiko yra " + valanda + " valandos ir " + minute + " minutes");
            builder.create();
            builder.show();
        }
    };



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v.getId() == R.id.textView)
        {
            this.getMenuInflater().inflate(R.menu.menu,menu);
        }else if (v.getId() == R.id.textView2){
            this.getMenuInflater().inflate(R.menu.menu2,menu);
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.skaiciuoti:
                return (true);
            case R.id.exit:
                finish();
            case R.id.subas:
                new TimePickerDialog(MainActivity.this,onTimeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),true).show();
                return(true);
        }
        return(super.onOptionsItemSelected(item));
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int selectedItemId = item.getItemId();
        switch (selectedItemId) {
            case R.id.option1:
                Count1();
                break;
            case R.id.option2:
                t.start();
                break;
            case R.id.option3:
                Count2();
                break;
            case  R.id.option4:
                t2.start();
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void Count1(){
        int count = 0;
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        String tekstas1 = textView.getText().toString();
        for(int j=0;j<tekstas1.length(); j++){
            char character = tekstas1.charAt(j);
            count++;
        }
        textView2.setText("Simboliu skaicius tekste: " + String.valueOf(count));
        builder.setMessage("Simboliu skaicius tekste: " + String.valueOf(count));
        builder.create();
        builder.show();
    }

    public void Count2(){
        int count2 = 0;
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        String tekstas2 = textView2.getText().toString();
        for(int j=0;j<tekstas2.length(); j++){
            char character = tekstas2.charAt(j);
            count2++;
        }
        textView2.setText("Simboliu skaicius tekste: " + String.valueOf(count2));
        builder.setMessage("Simboliu skaicius tekste: " + String.valueOf(count2));
        builder.create();
        builder.show();
    }




    Thread t = new Thread(){
        @Override
        public void run(){
                skaicius=0;
            if (skaicius < textView.length()){
                try {
                    String vaizd = textView.getText().toString();

                    for(int i=0;i<vaizd.length(); i++){
                        char c = vaizd.charAt(i);
                        textView3.setText(String.valueOf(c));
                        Thread.sleep(1000);
                        skaicius++;

                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                t.interrupt();
            }
        }
    };

    Thread t2 = new Thread(){
        @Override
        public void run(){
            skaicius2=0;
            if (skaicius2 < textView2.length()){
                try {
                    String vaizd = textView2.getText().toString();

                    for(int i=0;i<vaizd.length(); i++){
                        char c = vaizd.charAt(i);
                        textView3.setText(String.valueOf(c));
                        Thread.sleep(1000);
                        skaicius2++;

                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                t2.stop();
            }
        }
    };


}
