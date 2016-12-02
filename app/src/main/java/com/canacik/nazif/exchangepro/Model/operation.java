package com.canacik.nazif.exchangepro.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.canacik.nazif.exchangepro.DatabaseHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Nazif ÇANACIK on 2.12.2016.
 */

public class operation extends DatabaseHelper {
    private String give_amount;
    private String give_type;
    private String take_amount;
    private String take_type;
    private String date;
    private Integer userid;
    private Integer kod;

    public operation(Context context) {
        super(context);
    }

    public String getGive_type() {
        return give_type;
    }

    public void setGive_type(String give_type) {
        this.give_type = give_type;
    }

    public String getGive_amount() {
        return give_amount;
    }

    public void setGive_amount(String give_amount) {
        this.give_amount = give_amount;
    }

    public String getTake_amount() {
        return take_amount;
    }

    public void setTake_amount(String take_amount) {
        this.take_amount = take_amount;
    }

    public String getTake_type() {
        return take_type;
    }

    public void setTake_type(String take_type) {
        this.take_type = take_type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getKod() {
        return kod;
    }

    public void setKod(Integer kod) {
        this.kod = kod;
    }

    public void Insert() {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("userid", this.getUserid());
        values.put("give_amount", this.getGive_amount());
        values.put("give_type", this.getGive_type());
        values.put("take_amount", this.getTake_amount());
        values.put("take_type", this.getTake_type());
        Date date = new Date();
        values.put("date",date.toString());
        db.insert("operation", DATABASE_NAME, values);
        db.close();
    }

    public List<operation> ListAll() {
        List<operation> list = new ArrayList<operation>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query("operation", new String[]{"kod", "userid", "give_amount","give_type","take_amount","take_type","date"}, null, null, null, null, null);
        while (cursor.moveToNext()) {

            this.setKod(cursor.getInt(0));
            this.setUserid(cursor.getInt(1));
            this.setGive_amount(cursor.getString(2));
            this.setGive_type(cursor.getString(3));
            this.setTake_amount(cursor.getString(4));
            this.setTake_type(cursor.getString(5));
            this.setDate(cursor.getString(6));
            list.add(this);
        }
        return list;
    }
}
