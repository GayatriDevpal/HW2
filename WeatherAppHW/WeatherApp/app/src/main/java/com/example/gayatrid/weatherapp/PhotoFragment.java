package com.example.gayatrid.weatherapp;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

/**
 * Created by Gayatri D on 5/27/2015.
 */
public class PhotoFragment extends Fragment {
    private String icon;
    private ImageView mImageView;
    private String mImageString;
    private Bitmap mBitmap;
    private ProgressBar progress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.photo_fragment, container, false);
        mImageView = (ImageView) view.findViewById(R.id.imageView);
        progress = (ProgressBar)view.findViewById(R.id.progressBar2);

        Bundle bundle = getArguments();
        icon = bundle.getString("URL", "");
        Log.i(Constants.TAG, "url in fragment: " + icon);

        switch(icon)
        {
            case "Clouds": mImageView.setBackground(getResources().getDrawable(R.drawable.clouds));
                break;

            case "Rain": mImageView.setBackground(getResources().getDrawable(R.drawable.rain));
                break;

            case "Clear": mImageView.setBackground(getResources().getDrawable(R.drawable.clear));
                break;
            default:
                break;

        }

        return view;
    }


}