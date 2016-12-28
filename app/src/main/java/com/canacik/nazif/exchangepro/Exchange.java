package com.canacik.nazif.exchangepro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.os.Handler;
import android.view.View.OnClickListener;
import android.widget.Toast;


import com.canacik.nazif.exchangepro.Model.Helper;
import com.canacik.nazif.exchangepro.Model.user;

import java.util.*;

public class Exchange extends AppCompatActivity {

    public static String uName = "";
    public static String pass = "";

    private Button button;
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private RelativeLayout RelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);





        final Button Login = (Button) findViewById(R.id.bLogin);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.activity_exchange);
        final EditText etUsername = (EditText) findViewById(R.id.etUserName);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bLogin = (Button) findViewById(R.id.bLogin);
        final TextView registerLink = (TextView) findViewById(R.id.tvRegisterHere);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                uName = etUsername.getText().toString();
                pass = etPassword.getText().toString();
                user obj = new user(getApplicationContext());
                user result = obj.Login(uName, pass);
                if (result == null) {

                    Intent registerIntent2 = new Intent(Exchange.this, RegisterActivity.class);
                    Exchange.this.startActivity(registerIntent2);

                    Toast.makeText(getApplicationContext(),"Please Register",Toast.LENGTH_LONG).show();


                } else {


                    int id = result.getKod();
                    Helper.setUserId(id);
                    Intent registerIntent = new Intent(Exchange.this, UserAreaActivity.class);
                    Exchange.this.startActivity(registerIntent);

                    Toast.makeText(getApplicationContext(),"Welcome",Toast.LENGTH_LONG).show();

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

