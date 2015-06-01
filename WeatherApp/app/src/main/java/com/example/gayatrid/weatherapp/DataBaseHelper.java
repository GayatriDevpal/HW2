package com.example.gayatrid.weatherapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.List;

/**
 * Created by Gayatri D on 5/27/2015.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    SQLiteDatabase db;
    private String[] projection = {
            Contract.WeatherEntry.ID,
            Contract.WeatherEntry.CITY,
            Contract.WeatherEntry.COUNTRY,
            Contract.WeatherEntry.FORECAST,
            Contract.WeatherEntry.DESCRIPTION,
            Contract.WeatherEntry.DAY,
            Contract.WeatherEntry.MIN,
            Contract.WeatherEntry.MAX,
            Contract.WeatherEntry.EVE,
            Contract.WeatherEntry.NIGHT,
            Contract.WeatherEntry.MORN,
            Contract.WeatherEntry.ICON,};


    private static final String DATABASE_CREATE =
            "CREATE TABLE " +
                    Contract.WeatherEntry.TABLE_NAME + " (" +
                    Contract.WeatherEntry.ID+" INTEGER PRIMARY KEY NOT NULL,"+
                    Contract.WeatherEntry.CITY+ " TEXT  NULL, " +
    Contract.WeatherEntry.COUNTRY+ " TEXT NULL, " +
    Contract.WeatherEntry.FORECAST+ " TEXT NULL, " +
    Contract.WeatherEntry.DESCRIPTION+ " TEXT NULL, " +
    Contract.WeatherEntry.DAY+ " TEXT NULL, " +
    Contract.WeatherEntry.MIN+ " TEXT NULL, " +
    Contract.WeatherEntry.MAX+ " TEXT NULL, " +
    Contract.WeatherEntry.EVE+ " TEXT NULL, " +
    Contract.WeatherEntry.NIGHT+ " TEXT NULL, " +
    Contract.WeatherEntry.MORN+ " TEXT NULL, " +
    Contract.WeatherEntry.ICON+ " TEXT NULL " + ")";



    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Contract.WeatherEntry.TABLE_NAME;

    public DataBaseHelper(Context context) {

        super(context, Contract.DATABASE_NAME, null, 1);
        db=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
    }

    public void insertPhotoEntry(WeatherDetails weather) {
        Log.d("insert photo entry",weather.toString());

        ContentValues cv = new ContentValues();

        cv.put(Contract.WeatherEntry.ID, weather.getId());
        cv.put(Contract.WeatherEntry.CITY, weather.getCity());
        cv.put(Contract.WeatherEntry.COUNTRY, weather.getCountry());
        cv.put(Contract.WeatherEntry.FORECAST, weather.getForecast());
        cv.put(Contract.WeatherEntry.DESCRIPTION, weather.getDescription());
        cv.put(Contract.WeatherEntry.DAY, weather.getDay());
        cv.put(Contract.WeatherEntry.MIN,weather.getMin());
        cv.put(Contract.WeatherEntry.MAX, weather.getMax());
        cv.put(Contract.WeatherEntry.EVE, weather.getEve());
        cv.put(Contract.WeatherEntry.NIGHT, weather.getNight());
        cv.put(Contract.WeatherEntry.MORN,weather.getMorn());
        cv.put(Contract.WeatherEntry.ICON, weather.getIcon());

        db.insert(Contract.WeatherEntry.TABLE_NAME, null, cv);
        Log.d("insert photo entry","after insert");
    }

    public Cursor getAllRows() {
        db = getReadableDatabase();
        return db.query(Contract.WeatherEntry.TABLE_NAME, projection, null, null, null, null, null);

//        Here's the method with arguments:
//        public Cursor query (String table, String[] columns, String selection, String[]
//        selectionArgs, String groupBy, String orderBy, String limit)

    }

    public Cursor getRowByID(long id) {
        db = getReadableDatabase();
        String[] ids = {String.valueOf(id)};
        return db.query(Contract.WeatherEntry.TABLE_NAME, projection, Contract.WeatherEntry._ID + "==?", ids, null, null, null);
    }

    public void deleteRow(long id) {
        SQLiteDatabase db = getWritableDatabase();
        String[] ids = {String.valueOf(id)};
        db.delete(Contract.WeatherEntry.TABLE_NAME, Contract.WeatherEntry._ID + "==?", ids);
    }

    public void addRows(List<WeatherDetails> weatherDetails) {
        for (WeatherDetails weather : weatherDetails) {
            insertPhotoEntry(weather);
        }
    }

    public void clearTable() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from " + Contract.WeatherEntry.TABLE_NAME);
    }

    public void dropTable() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(SQL_DELETE_ENTRIES);
    }


}