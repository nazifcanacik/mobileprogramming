package com.canacik.nazif.exchangepro;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class UserAreaActivity extends Activity {
    private String[] moneytype={"KM","$","€"};
    private Spinner spinn;
    private ArrayAdapter<String> dataAdapterForIller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        spinn = (Spinner) findViewById(R.id.spinner1);


        //Spinner'lar için adapterleri hazırlıyoruz.
        dataAdapterForIller = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, moneytype);
        //Listelenecek verilerin görünümünü belirliyoruz.
        dataAdapterForIller.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Hazırladğımız Adapter'leri Spinner'lara ekliyoruz.
        spinn.setAdapter(dataAdapterForIller);

        //final EditText etUsername = (EditText) findViewById(R.id.etUserName);
        //final EditText etAge = (EditText) findViewById(R.id.etAge);
        //final TextView welcomeMessage = (TextView) findViewById(R.id.tvWelcomeMsg);


    }
}
