package com.example.gayatrid.weatherapp;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Gayatri D on 5/27/2015.
 */
public class WeatherAdapter extends CursorAdapter {

    public WeatherAdapter(Context c, Cursor cursor){
        super(c, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.row, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView title = (TextView) view.findViewById(R.id.title_text);
        String titleText = cursor.getString(cursor.getColumnIndexOrThrow(Contract.WeatherEntry.FORECAST));
        String listText = cursor.getString(cursor.getColumnIndexOrThrow(Contract.WeatherEntry.DATE))+"\n"+titleText;
//                +"\n"+ "Min :"+
//                           cursor.getString(cursor.getColumnIndexOrThrow(Contract.WeatherEntry.MIN)) +" Max:"+
//                           cursor.getString(cursor.getColumnIndexOrThrow(Contract.WeatherEntry.MAX));
        title.setText(listText);

        ImageView imageView=(ImageView) view.findViewById(R.id.imageViewRow);


                try {
                    imageView.setImageResource(R.drawable.class.getField(titleText.toLowerCase()).getInt(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }

    }
}