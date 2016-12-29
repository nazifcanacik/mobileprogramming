package com.canacik.nazif.exchangepro;

/**
 * Created by Nazif ÇANACIK on 9.11.2016.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.canacik.nazif.exchangepro.Model.DataAdaptor;
import com.canacik.nazif.exchangepro.Model.Helper;
import com.canacik.nazif.exchangepro.Model.operation;
import com.canacik.nazif.exchangepro.Model.user;
import java.util.*;

public class UserAccountInfo extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useraccount);
        int userId = Helper.getUserId();
        List<operation> data = Helper.getDataList();

       final GridView gridView = (GridView) findViewById(R.id.grids);
        DataAdaptor myListAdapter = new DataAdaptor(UserAccountInfo.this,
                data);
        gridView.setAdapter(myListAdapter);
    }


}
