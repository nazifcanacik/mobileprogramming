package com.canacik.nazif.exchangepro;

/**
 * Created by Nazif ÇANACIK on 9.11.2016.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.canacik.nazif.exchangepro.Model.Helper;
import com.canacik.nazif.exchangepro.Model.user;
import java.util.*;

public class UserAccountInfo extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useraccount);
        int userId = Helper.getUserId();
      //  final Button button = (Button) findViewById(R.id.button);
    }


}
