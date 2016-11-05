package com.canacik.nazif.exchangepro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.canacik.nazif.exchangepro.Model.user;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        final EditText etUsername = (EditText) findViewById(R.id.etUserName);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uName= etUsername.getText().toString();
                String pass= etPassword.getText().toString();

                user obj= new user(getApplicationContext());

                obj.setPassword(pass);
                obj.setUsername(uName);
                obj.Insert();


            }
        });

    }



}
