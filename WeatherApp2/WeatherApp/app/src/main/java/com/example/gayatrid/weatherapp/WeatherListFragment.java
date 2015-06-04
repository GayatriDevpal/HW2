package com.example.gayatrid.weatherapp;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Gayatri D on 5/27/2015.
 */
public class WeatherListFragment extends Fragment implements AdapterView.OnItemClickListener {
    Cursor cursor;
    ListView lv;
    WeatherAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.weatherlist_fragment, container, false);
        MainActivity activity = (MainActivity) this.getActivity();


        //Main code
        DataBaseHelper dbHelper = new DataBaseHelper(getActivity());
        cursor = dbHelper.getAllRows();


        getActivity().startManagingCursor(cursor);

        adapter = new WeatherAdapter(activity, cursor);

        lv = (ListView) view.findViewById(R.id.weatherList);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);

        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        cursor.moveToFirst();
        cursor.move(i);
        String forecast = cursor.getString(cursor.getColumnIndexOrThrow(Contract.WeatherEntry.FORECAST));

        PhotoFragment pf = new PhotoFragment();
        Bundle args = new Bundle();
        args.putString("URL", forecast);
        pf.setArguments(args);
        pf.setArguments(args);

        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, pf);
        ft.addToBackStack("Image");
        ft.commit();
    }

}