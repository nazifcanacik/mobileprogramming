package com.canacik.nazif.exchangepro.Model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.canacik.nazif.exchangepro.R;

import java.util.List;

/**
 * Created by Nazif ÇANACIK on 29.12.2016.
 */

public class DataAdaptor extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<operation> dersListesi;

    public DataAdaptor(Activity activity, List<operation> courses) {

        mInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        dersListesi = courses;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return dersListesi.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return dersListesi.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View rowview;
        rowview = mInflater.inflate(R.layout.listitems, null);

        TextView give=(TextView) rowview.findViewById(R.id.give);
        TextView take=(TextView) rowview.findViewById(R.id.take);
        TextView date=(TextView) rowview.findViewById(R.id.date);

        operation ders=dersListesi.get(position);

        give.setText("Given: "+ders.getGive_amount() +" "+ders.getGive_type() );
        take.setText("Taken: "+ders.getTake_amount() +" "+ders.getTake_type() );
        date.setText("Date: "+ders.getDate() );



        return rowview;



    }
}
