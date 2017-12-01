package com.example.gertautasm.lab6;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    TextView textView3;
    int skaicius = 0;


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


                break;
        }
        return super.onContextItemSelected(item);
    }

    public void Count1(){
        int count = 0;
        String tekstas1 = textView.getText().toString();
        for(int j=0;j<tekstas1.length(); j++){
            char character = tekstas1.charAt(j);
            count++;
        }
        textView2.setText("Simboliu skaicius tekste: " + String.valueOf(count));
    }

    public void Count2(){
        int count2 = 0;
        String tekstas2 = textView2.getText().toString();
        for(int j=0;j<tekstas2.length(); j++){
            char character = tekstas2.charAt(j);
            count2++;
        }
        textView2.setText("Simboliu skaicius tekste: " + String.valueOf(count2));
    }



    Thread t = new Thread(){
        @Override
        public void run(){

            while (skaicius < textView.length()){
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
            }
        }
    };



}
