package com.canacik.nazif.exchangepro;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.canacik.nazif.exchangepro.Model.user;

/**
 * Created by Nazif ÇANACIK on 5.11.2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Exchange";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE user (kod INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT,password TEXT)";
        sqLiteDatabase.execSQL(sql);

        String sql2="CREATE TABLE operation (kod INTEGER PRIMARY KEY AUTOINCREMENT, userid INTEGER,give_amount TEXT,give_type TEXT,take_amount TEXT,take_type TEXT,date TEXT)";
        sqLiteDatabase.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //sqLiteDatabase.execSQL("DROP TABLE IF EXIST user,operatıon");
        //onCreate(sqLiteDatabase);
    }
}
