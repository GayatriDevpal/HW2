package com.example.gayatrid.weatherapp;

import android.provider.BaseColumns;

/**
 * Created by Gayatri D on 5/27/2015.
 */
public class Contract{
    public static final String DATABASE_NAME = "weatherApp2.db";
    WeatherEntry weatherEntry= new WeatherEntry();

    public static final class WeatherEntry implements BaseColumns {
        public int test = 7;

        public static final String TABLE_NAME = "weather_entry";
        public static final String ID = "_id";
        public static final String  FORECAST = "forecast";
        public static final String DESCRIPTION = "description";
        public static final String DAY = "day";
        public static final String MIN = "min";
        public static final String MAX = "max";
        public static final String NIGHT = "night";
        public static final String EVE = "eve";
        public static final String MORN = "morn";
        public static final String ICON = "icon";
        public static final String CITY = "city";
        public static final String COUNTRY = "country";

    }

}