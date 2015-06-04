package com.example.gayatrid.weatherapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Gayatri D on 5/26/2015.
 */
public class WeatherDetails {

    static String city,country;
    String forecast,description,day,min,max,night,eve,morn,icon;
     int id=0;

    public WeatherDetails(JSONObject jsonWeather) throws JSONException {

        JSONArray data=jsonWeather.optJSONArray("weather");
        JSONObject data1=(JSONObject)data.get(0);

        JSONObject temp=jsonWeather.getJSONObject("temp");

        this.description=data1.optString("description");
        this.day=temp.optString("day");
        this.min=temp.optString("min");
        this.max=temp.optString("max");
        this.night=temp.optString("night");
        this.eve=temp.optString("eve");
        this.morn=temp.optString("morn");
        this.icon=this.forecast;
        this.forecast= data1.optString("main");
        this.id=jsonWeather.optInt("dt");


    }


    public static ArrayList<WeatherDetails> makeWeatherReport(String weatherData) throws JSONException
    {
        ArrayList<WeatherDetails> weatherReport=new ArrayList<>();
        JSONObject data=new JSONObject(weatherData);
        JSONArray reportArray=data.optJSONArray("list");
        JSONObject cityDetails=data.getJSONObject("city");

        for(int i=0;i<reportArray.length();i++)
        {
            WeatherDetails weatherDetails=new WeatherDetails( (JSONObject) reportArray.get(i));
            Log.d("weather details", weatherData);
            weatherDetails.city=cityDetails.optString("name");
            weatherDetails.country=cityDetails.optString("country");
            weatherReport.add(weatherDetails);
        }

        return weatherReport;

    }



    public static String getCity() {
        return city;
    }

    public static String getCountry() {
        return country;
    }

    public int getId() {
        return id;
    }

    public String getForecast() {
        return forecast;
    }

    public String getDescription() {
        return description;
    }

    public String getDay() {
        return day;
    }

    public String getMin() {
        return min;
    }

    public String getMax() {
        return max;
    }

    public String getNight() {
        return night;
    }

    public String getEve() {
        return eve;
    }

    public String getMorn() {
        return morn;
    }

    public String getIcon() {
        return icon;
    }

    @Override
    public String toString()
    {
        String result="";
        result=result+"fore cast "+this.forecast;
        result=result+"description "+this.description;
        result=result+"min temp "+this.min;
        result=result+"max temp "+this.max;
        result=result+"night temp "+this.night;
        result=result+"morning temp "+this.morn;
        result=result+"eve temp "+this.eve;
        result=result+"day temp "+this.day;
        result=result+"City "+city;
        result=result+"Country "+country;

        return result;
    }


}
