package vgtu.iip.lab2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.AndroidTestRunner;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class AntraActivity extends AppCompatActivity {
    EditText irasymoTekstas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antra);
    }

    public void grazintiRezultatus(View w){
        Log.i("TODO", "Realizuoti rezultatu grazinima");
        //TODO sukurti intent, nurodant papildomai grazinamus duomenis ir nustatant, kad rezultatas yra OK
       irasymoTekstas = (EditText) findViewById(R.id.ivedimui);
       Intent intent = new Intent(this,PirmaActivity.class);
        intent.putExtra("result",irasymoTekstas.getText().toString());
        setResult(Activity.RESULT_OK,intent);
        finish();



    }
}
