package com.canacik.nazif.exchangepro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import com.canacik.nazif.exchangepro.Model.Helper;
import com.canacik.nazif.exchangepro.Model.user;

import java.util.*;

public class Exchange extends AppCompatActivity {

    public  static  String uName = "";
    public  static  String pass = "";

    private Button Login;
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);

        Login = (Button) findViewById(R.id.bLogin);
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_exchange);

        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.login,null);

                popupWindow = new PopupWindow(container,400,400,true);
                popupWindow.showAtLocation(relativeLayout, Gravity.NO_GRAVITY,500,500);
                container.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        popupWindow.dismiss();
                        return true;
                    }
                });
            }
        });

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


                    Login.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view){
                            layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                            ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.login,null);

                            popupWindow = new PopupWindow(container,300,300,true);
                            popupWindow.showAtLocation(relativeLayout, Gravity.NO_GRAVITY,400,400);
                            container.setOnTouchListener(new View.OnTouchListener() {
                                @Override
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    popupWindow.dismiss();
                                    return true;
                                }
                            });
                        }
                    });

                }else {

                    int id = result.getKod();
                    Helper.setUserId(id);
                    Intent registerIntent = new Intent(Exchange.this, UserAreaActivity.class);
                    Exchange.this.startActivity(registerIntent);

                    Login.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view){
                            layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                            ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.login,null);

                            popupWindow = new PopupWindow(container,300,300,true);
                            popupWindow.showAtLocation(relativeLayout, Gravity.NO_GRAVITY,400,400);
                            container.setOnTouchListener(new View.OnTouchListener() {
                                @Override
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    popupWindow.dismiss();
                                    return true;
                                }
                            });
                        }
                    });

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
