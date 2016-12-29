package com.canacik.nazif.exchangepro;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.canacik.nazif.exchangepro.Model.Helper;
import com.canacik.nazif.exchangepro.Model.operation;

import java.io.Console;
import java.util.List;

public class UserAreaActivity extends Activity {
    private String[] moneytype={"KM","$","€"};
    private Spinner spinn;
    private Spinner spinn2;
    private Button btnSave;
    private Button btnGoAccount;
    private EditText give;
    private EditText take;
    private ArrayAdapter<String> dataAdapterForIller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        spinn = (Spinner) findViewById(R.id.spinner1);
        spinn2 = (Spinner) findViewById(R.id.spinner2);
        btnSave=(Button) findViewById(R.id.btnSave);
        give=(EditText) findViewById(R.id.etGiveAmount);
        take=(EditText) findViewById(R.id.etTakeAmount);
        btnGoAccount=(Button) findViewById(R.id.btnGoAccount);

        //Spinner'lar için adapterleri hazırlıyoruz.
        dataAdapterForIller = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, moneytype);
        //Listelenecek verilerin görünümünü belirliyoruz.
        dataAdapterForIller.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Hazırladğımız Adapter'leri Spinner'lara ekliyoruz.
        spinn2.setAdapter(dataAdapterForIller);
        spinn.setAdapter(dataAdapterForIller);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String giveAmount = give.getText().toString() ;
                String takeAmount =take.getText().toString();
                String take_type = spinn.getSelectedItem().toString();
                String give_type = spinn2.getSelectedItem().toString();
                operation  obj = new operation(getApplicationContext());
                obj.setGive_type(give_type);
                obj.setTake_type(take_type);
                obj.setTake_amount(takeAmount);
                obj.setGive_amount(giveAmount);
                obj.Insert();
                System.out.print("saved");
            }
        });

        btnGoAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                operation tt = new operation(getApplicationContext());
                List<operation> data=tt.ListAll();
                if (data==null || data.size()==0)
                {

                    Toast.makeText(getApplicationContext(),"boş bu",Toast.LENGTH_LONG).show();
                }else
                {
                    Helper.setDataList(data);
                    Toast.makeText(getApplicationContext(),"dolu",Toast.LENGTH_LONG).show();
                }

                Intent registerIntent2 = new Intent(UserAreaActivity.this, UserAccountInfo.class);
                UserAreaActivity.this.startActivity(registerIntent2);

            }
        });
        //final EditText etUsername = (EditText) findViewById(R.id.etUserName);
        //final EditText etAge = (EditText) findViewById(R.id.etAge);
        //final TextView welcomeMessage = (TextView) findViewById(R.id.tvWelcomeMsg);



    }
}
