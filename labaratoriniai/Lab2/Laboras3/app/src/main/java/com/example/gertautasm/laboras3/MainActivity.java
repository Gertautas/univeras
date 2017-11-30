package com.example.gertautasm.laboras3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    String[] visi_f = {"Fundamentiniu mokslu fakultetas", "Aplinkos inzinerijos fakultetas", "Antano gustaicio aviacijos institutas", "Architekturos fakultetas", "Elektronikos fakultetas", "Kurybiniu industriju fakultetas", "Mechanikos fakultetas", "Statybos fakultetas", "Transporto inzinerijos fakultetas", "Verslo vadybos fakultetas"};
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button2);

        final TextView pavadinimas = (TextView) findViewById(R.id.pavadinimas);
        final AutoCompleteTextView fakultetas = (AutoCompleteTextView) findViewById(R.id.fakult);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final TimePicker timePicker = (TimePicker) findViewById(R.id.simpleTimePicker);
        final Switch reg = (Switch) findViewById(R.id.switch2);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, visi_f);

        fakultetas.setAdapter(adapter);

        addListenerOnRatingBar();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pav = pavadinimas.getText().toString();
                String fklt = fakultetas.getText().toString();
                String spn = spinner.getSelectedItem().toString();
                String reg_ats;
                Toast t1,t2,t3;
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();

                if(reg.isChecked())
                    reg_ats =reg.getTextOn().toString();
                else
                    reg_ats  = reg.getTextOff().toString();

//                t1 =Toast.makeText(MainActivity.this, pav, Toast.LENGTH_LONG);
//                t2 =Toast.makeText(MainActivity.this, fklt, Toast.LENGTH_LONG);
//                t3= Toast.makeText(MainActivity.this, String.valueOf(ratingBar.getRating()),Toast.LENGTH_LONG);
                Toast.makeText(getApplicationContext(),"Pavadinimas: " + pav + "\n" +  "Fakultetas: " + fklt + "\n" + "Sudetingumas: " +  String.valueOf(ratingBar.getRating()) + "\n" + "Diena: " +  spn + "\n" + "Valandu: " + hour
                + "Minuciu: " + minute + "\n" + "Registruotis: " + reg_ats ,Toast.LENGTH_LONG).show();
//                Toast.makeText(MainActivity.this,spn,Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(),"Valandu: " + hour
//                + "Minuciu: " + minute,Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), "Registruotis: " + reg_ats,Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void addListenerOnRatingBar() {
        ratingBar = (RatingBar) findViewById(R.id.ratingbar);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
            }
        });
    }
}
