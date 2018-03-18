package com.dexoteric.randomidlegalaxy.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dexoteric.randomidlegalaxy.MainActivity;
import com.dexoteric.randomidlegalaxy.R;

import java.util.Locale;


public class SettingsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button en = getActivity().findViewById(R.id.lang_en);
        Button pl = getActivity().findViewById(R.id.lang_pl);


        //TODO fix it!
        en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.languageToLoad = "en";
                Locale locale = new Locale(MainActivity.languageToLoad);
                Locale.setDefault(locale);
                Configuration config = getActivity().getResources().getConfiguration();
                config.locale = locale;
                getActivity().getResources().updateConfiguration(config, getActivity().getResources().getDisplayMetrics());
                SharedPreferences languagepref = getActivity().getSharedPreferences("com.dexoteric.randomidlegalaxy", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = languagepref.edit();
                editor.putString("languageToLoad",MainActivity.languageToLoad ).apply();

            }
        });


        pl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.languageToLoad = "pl";
                Locale locale = new Locale(MainActivity.languageToLoad);
                Locale.setDefault(locale);
                Configuration config = getActivity().getResources().getConfiguration();
                config.locale = locale;
                getActivity().getResources().updateConfiguration(config, getActivity().getResources().getDisplayMetrics());
                SharedPreferences languagepref = getActivity().getSharedPreferences("com.dexoteric.randomidlegalaxy",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = languagepref.edit();
                editor.putString("languageToLoad",MainActivity.languageToLoad ).apply();
            }
        });
    }
}
