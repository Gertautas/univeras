package vgtu.iip.lab2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PirmaActivity extends AppCompatActivity {

    final static int IVEDIMAS = 1;
    TextView isvedimoLaukas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pirma);
        isvedimoLaukas = (TextView) findViewById(R.id.tekstas);

    }

    public void atvertiVeiklaRezultatuGavimui(View w){
        Log.i("TODO", "reikia realizuoti startActivityForresults");
        //TODO sukurti intent ir ji paleisti, laukiant rezultatu
        Intent writeTextIntent = new Intent(this, AntraActivity.class);
        startActivityForResult(writeTextIntent,IVEDIMAS);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("TODO", "Grizo is AntraActivity");
        //TODO patikrinti nuo kokios veiklos ir kokius rezultatus gavo, tada pasiimti siunciama reiksme ir ja paduoti vietoj sekancioje eiluteje irasyto teksto
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            isvedimoLaukas.setText(data.getStringExtra("result"));
        }
    }


    public void sukurtiExplicitIntent(View w){
        String tekstas = isvedimoLaukas.getText().toString();
        Log.i("TODO", "reikia sukurti explicit intent su perduodamais duomenimis");
        //TODO sukurti explicit intent, su putExtra perduoti tekstas kintamaji ir tada paleisti, nelaukiant rezultatu
        Intent intent = new Intent(this,TreciaActivity.class);
        intent.putExtra("Message",tekstas);
        startActivity(intent);

    }
    public void sukurtiImplicitIntent(View w){
        String duomenysSiuntimui = isvedimoLaukas.getText().toString();
        Log.i("TODO", "reikia sukurti implicit intent");
        //TODO sukurti explicit intent, jame perduoti kintamaji duomenysSiuntimui (tekstiniai duomenys)
        //TODO tada kitas intent bus tam, kad vartotojas galetu rinktis norima programa ir ja paleisti nelaukaint rezultatu
        Intent siusti = new Intent();
        siusti.setAction(Intent.ACTION_SEND);
        siusti.putExtra(Intent.EXTRA_TEXT,duomenysSiuntimui);
        siusti.setType("text/plain");
        startActivity(siusti);

    }
}
