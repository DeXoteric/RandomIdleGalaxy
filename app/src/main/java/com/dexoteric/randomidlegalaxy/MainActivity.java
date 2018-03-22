package com.dexoteric.randomidlegalaxy;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dexoteric.randomidlegalaxy.database.Planet;
import com.dexoteric.randomidlegalaxy.database.PlanetDatabase;
import com.dexoteric.randomidlegalaxy.fragments.HelpFragment;
import com.dexoteric.randomidlegalaxy.fragments.PlanetsFragment;
import com.dexoteric.randomidlegalaxy.fragments.ResearchFragment;
import com.dexoteric.randomidlegalaxy.fragments.SettingsFragment;
import com.dexoteric.randomidlegalaxy.fragments.SummaryFragment;
import com.dexoteric.randomidlegalaxy.fragments.TestFragment;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "lifecycleMessage";
    public static Bundle myBundle = new Bundle();
    public static String languageToLoad;
    public static FragmentManager fm;
    public static FragmentTransaction ft;
    public static List<Planet> planets;
    public PlanetsFragment fragPlanets = new PlanetsFragment();
    public ResearchFragment fragResearch = new ResearchFragment();
    public SummaryFragment fragSummary = new SummaryFragment();
    public SettingsFragment fragSettings = new SettingsFragment();
    public HelpFragment fragHelp = new HelpFragment();
    public TestFragment fragTest = new TestFragment();
    private int id;
    //  listener dla przycisków w głównym menu
    private View.OnClickListener btnClickListener = v -> {
        id = v.getId();
        fm = getFragmentManager();
        ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out, android.R.animator.fade_in, android.R.animator.fade_out);

        switch (id) {
            case R.id.btn_planets:
                ft.replace(R.id.fragment_frame, fragPlanets);
                ft.commit();
                break;
            case R.id.btn_research:
                ft.replace(R.id.fragment_frame, fragResearch);
                ft.commit();
                String text = (String) myBundle.get("id_User");
                TextView textView = findViewById(R.id.textView2);
                if (text != null) textView.setText(text);
                break;
            case R.id.btn_summary:
                ft.replace(R.id.fragment_frame, fragSummary);
                ft.commit();
                break;
            case R.id.btn_settings:
                ft.replace(R.id.fragment_frame, fragSettings);
                ft.commit();
                break;
            case R.id.btn_help:
                ft.replace(R.id.fragment_frame, fragHelp);
                ft.commit();
                break;
            case R.id.btn_test:
                ft.replace(R.id.fragment_frame, fragTest);
                ft.commit();
                break;
        }

//        switch (id) {
//            case R.id.btn_planets:
//                if (fragPlanets != null) ft.show(fragPlanets);
//                if (fragResearch != null) ft.hide(fragResearch);
//                if (fragSummary != null) ft.hide(fragSummary);
//                if (fragSettings != null) ft.hide(fragSettings);
//                if (fragHelp != null) ft.hide(fragHelp);
//                if (fragTest != null) ft.hide(fragTest);
//                ft.commit();
//                break;
//            case R.id.btn_research:
//                if (fragPlanets != null) ft.hide(fragPlanets);
//                if (fragResearch != null) ft.show(fragResearch);
//                if (fragSummary != null) ft.hide(fragSummary);
//                if (fragSettings != null) ft.hide(fragSettings);
//                if (fragHelp != null) ft.hide(fragHelp);
//                if (fragTest != null) ft.hide(fragTest);
//                ft.commit();
//                String text = (String) myBundle.get("id_User");
//                TextView textView = findViewById(R.id.textView2);
//                if (text != null) textView.setText(text);
//                break;
//            case R.id.btn_summary:
//                if (fragPlanets != null) ft.hide(fragPlanets);
//                if (fragResearch != null) ft.hide(fragResearch);
//                if (fragSummary != null) ft.show(fragSummary);
//                if (fragSettings != null) ft.hide(fragSettings);
//                if (fragHelp != null) ft.hide(fragHelp);
//                if (fragTest != null) ft.hide(fragTest);
//                ft.commit();
//                break;
//            case R.id.btn_settings:
//                if (fragPlanets != null) ft.hide(fragPlanets);
//                if (fragResearch != null) ft.hide(fragResearch);
//                if (fragSummary != null) ft.hide(fragSummary);
//                if (fragSettings != null) ft.show(fragSettings);
//                if (fragHelp != null) ft.hide(fragHelp);
//                if (fragTest != null) ft.hide(fragTest);
//                ft.commit();
//                break;
//            case R.id.btn_help:
//                if (fragPlanets != null) ft.hide(fragPlanets);
//                if (fragResearch != null) ft.hide(fragResearch);
//                if (fragSummary != null) ft.hide(fragSummary);
//                if (fragSettings != null) ft.hide(fragSettings);
//                if (fragHelp != null) ft.show(fragHelp);
//                if (fragTest != null) ft.hide(fragTest);
//                ft.commit();
//                break;
//            case R.id.btn_test:
//                if (fragPlanets != null) ft.hide(fragPlanets);
//                if (fragResearch != null) ft.hide(fragResearch);
//                if (fragSummary != null) ft.hide(fragSummary);
//                if (fragSettings != null) ft.hide(fragSettings);
//                if (fragHelp != null) ft.hide(fragHelp);
//                if (fragTest != null) ft.show(fragTest);
//                ft.commit();
//                break;
//        }
        menuButtonLayoutOnClick(); // przywołanie metody
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");

        // wczytuje wybrany język
        SharedPreferences languagepref = getSharedPreferences("com.dexoteric.randomidlegalaxy", MODE_PRIVATE);
        languageToLoad = languagepref.getString("languageToLoad", "en");
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = getBaseContext().getResources().getConfiguration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        setContentView(R.layout.activity_main);

        // init baza danych planet

        new MyTask().execute();


        fm = getFragmentManager();
        ft = fm.beginTransaction();

        // dodaje fragment na starcie aplikacji
        if (savedInstanceState == null) {
            Log.i(TAG, "savedInstanceState == null");

            ft.replace(R.id.fragment_frame, fragPlanets);
            ft.commit();
            findViewById(R.id.btn_planets).setBackground(getResources().getDrawable(R.drawable.button_selected));
        }

        // ustawia UI
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        // init buttony i ich clicklistenery
        Button btnPlanets = findViewById(R.id.btn_planets);
        Button btnResearch = findViewById(R.id.btn_research);
        Button btnSummary = findViewById(R.id.btn_summary);
        Button btnHelp = findViewById(R.id.btn_help);
        Button btnSettings = findViewById(R.id.btn_settings);
        Button btnTest = findViewById(R.id.btn_test);

        btnPlanets.setOnClickListener(btnClickListener);
        btnResearch.setOnClickListener(btnClickListener);
        btnSummary.setOnClickListener(btnClickListener);
        btnSettings.setOnClickListener(btnClickListener);
        btnHelp.setOnClickListener(btnClickListener);
        btnTest.setOnClickListener(btnClickListener);

        // przywołuje metodę na początku aplikacji
        currentTime();

        // wyświetla aktualny czas i odświeża co sekundę
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(() -> {
                            currentTime(); // przywołuje metodę co sekundę
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Log.i(TAG, "onWindowFocusChanged");
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    protected void onDestroy() {
        PlanetDatabase.destroyDatabaseInstance();
        super.onDestroy();
    }

    // metoda zmieniająca layout przycisku w zależności który fragment jest aktywny
    private void menuButtonLayoutOnClick() {
        if (id == R.id.btn_planets) {
            findViewById(R.id.btn_planets).setBackground(getResources().getDrawable(R.drawable.button_selected));
        } else {
            findViewById(R.id.btn_planets).setBackground(getResources().getDrawable(R.drawable.button_enabled));
        }

        if (id == R.id.btn_research) {
            findViewById(R.id.btn_research).setBackground(getResources().getDrawable(R.drawable.button_selected));
        } else {
            findViewById(R.id.btn_research).setBackground(getResources().getDrawable(R.drawable.button_enabled));
        }

        if (id == R.id.btn_summary) {
            findViewById(R.id.btn_summary).setBackground(getResources().getDrawable(R.drawable.button_selected));
        } else {
            findViewById(R.id.btn_summary).setBackground(getResources().getDrawable(R.drawable.button_enabled));
        }

        if (id == R.id.btn_test) {
            findViewById(R.id.btn_test).setBackground(getResources().getDrawable(R.drawable.button_selected));
        } else {
            findViewById(R.id.btn_test).setBackground(getResources().getDrawable(R.drawable.button_enabled));
        }

        if (id == R.id.btn_help) {
            findViewById(R.id.btn_help).setBackground(getResources().getDrawable(R.drawable.button_selected));
        } else {
            findViewById(R.id.btn_help).setBackground(getResources().getDrawable(R.drawable.button_enabled));
        }

        if (id == R.id.btn_settings) {
            findViewById(R.id.btn_settings).setBackground(getResources().getDrawable(R.drawable.button_selected));
        } else {
            findViewById(R.id.btn_settings).setBackground(getResources().getDrawable(R.drawable.button_enabled));
        }
    }

    // metoda wyświetlająca aktualny czas
    private void currentTime() {
        TextView currentTime = findViewById(R.id.tv_current_time);
        long time = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String timeString = sdf.format(time);
        String displayText = getString(R.string.current_time) + timeString;
        currentTime.setText(displayText);
    }

    private class MyTask extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            PlanetDatabase planetDatabase = PlanetDatabase.getDatabase(getApplicationContext());
            planets = planetDatabase.planetDao().getAllPlanets();
            return null;
        }

    }

}
