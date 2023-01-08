package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import android.os.Bundle;
import android.widget.TextView;

public class ActivitySpiegazione extends AppCompatActivity {
    private TextView titolo,spiegazione;

    @Override
    protected void onCreate(Bundle savedInstanceState) {  //Faccio apparire spiegazione esercizio
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiegazione);
        Bundle valueextra=getIntent().getExtras();
        String newtit=valueextra.getString("Titolo");
        String newtest=valueextra.getString("Testo");
        titolo=findViewById(R.id.titolo_spieg);
        spiegazione=findViewById(R.id.spiegazione_spieg);
        titolo.setText(newtit);
        spiegazione.setText(newtest);
    }
}