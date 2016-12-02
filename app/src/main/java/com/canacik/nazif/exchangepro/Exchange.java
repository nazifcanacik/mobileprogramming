package com.canacik.nazif.exchangepro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.canacik.nazif.exchangepro.Model.Helper;
import com.canacik.nazif.exchangepro.Model.user;

import java.util.*;

public class Exchange extends AppCompatActivity {

    public  static  String uName = "";
    public  static  String pass = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);

        final EditText etUsername = (EditText) findViewById(R.id.etUserName);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bLogin = (Button) findViewById(R.id.bLogin);
        final TextView registerLink = (TextView) findViewById(R.id.tvRegisterHere);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                  uName= etUsername.getText().toString();
                  pass = etPassword.getText().toString();

                user obj= new user(getApplicationContext());
                user result = obj.Login(uName,pass);
                if (result==null) {

                    Intent registerIntent2 = new Intent(Exchange.this, RegisterActivity.class);

                    Exchange.this.startActivity(registerIntent2);
                }else {
                    int id = result.getKod();
                    Helper.setUserId(id);
                    Intent registerIntent = new Intent(Exchange.this, UserAreaActivity.class);
                    Exchange.this.startActivity(registerIntent);
                }


            }
        });
        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(Exchange.this, RegisterActivity.class);

                Exchange.this.startActivity(registerIntent);

            }
        });
    }
}
