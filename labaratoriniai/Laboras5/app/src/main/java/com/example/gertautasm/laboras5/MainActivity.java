package com.example.gertautasm.laboras5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainMenu = new MainFragment();
        AntrasFragment antrasFragment = new AntrasFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container,antrasFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.container,mainMenu).commit();
    }
}
