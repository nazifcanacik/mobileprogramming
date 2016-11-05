package com.canacik.nazif.exchangepro.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.canacik.nazif.exchangepro.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nazif ÇANACIK on 5.11.2016.
 */

public class user extends DatabaseHelper {
    private String username;
    private String password;
    private Integer kod;

    public user(Context context) {
        super(context);
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getKod() {
        return kod;
    }

    public void setKod(Integer kod) {
        this.kod = kod;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void Insert() {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", this.getUsername());
        values.put("password", this.getPassword());
        //TODO:Aynı kullanıcı adı varsa eklenmıcek. Control
        db.insert("user", DATABASE_NAME, values);
        db.close();
    }


    public void Clean(){
        String query = "Delete from user";
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("user",null,null);
    }
    public List<user> ListAll() {
        List<user> userList = new ArrayList<user>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query("user", new String[]{"kod", "username", "password"}, null, null, null, null, null);
        while (cursor.moveToNext()) {

            this.setKod(cursor.getInt(0));
            this.setUsername(cursor.getString(1));
            this.setPassword(cursor.getString(2));
            userList.add(this);
        }
        return userList;
    }

    public user Login(String username, String password) {

        SQLiteDatabase db = this.getWritableDatabase();

        String selectQuery ="select * from user where username=? ";
        Cursor c = db.rawQuery(selectQuery, new String[]{username});
        if (c.moveToFirst()) {
            this.setKod(c.getInt(0));
            this.setUsername(c.getString(1));
            this.setPassword(c.getString(2));
        }else   {

            return  null;
        }
        c.close();
        return this;
    }


}
