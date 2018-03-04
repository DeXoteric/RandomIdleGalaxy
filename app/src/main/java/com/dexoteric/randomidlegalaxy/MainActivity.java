package com.dexoteric.randomidlegalaxy;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "lifecycleMessage";

    Button btnPlanets, btnResearch, btnSummary, btnSettings, btnHelp;
    Fragment fragPlanets, fragResearch, fragSettings, fragSummary, fragHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Begin: tymczasowy język polski
        Locale locale = new Locale("pl");
        Configuration config = getBaseContext().getResources().getConfiguration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        // End: tymczasowy język polski

        setContentView(R.layout.activity_main);

        buttonsMainMenu(); // przywołuje metodę kontrolującą przyciski głównego menu

        // Begin: dodaje fragment na starcie aplikacji
        if (savedInstanceState == null) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.fragmentPlanets, new PlanetsFragment());
            ft.add(R.id.fragmentResearch, new ResearchFragment());
            ft.add(R.id.fragmentSummary, new SummaryFragment());
            ft.add(R.id.fragmentSettings, new SettingsFragment());
            ft.add(R.id.fragmentHelp, new HelpFragment());
            ft.commit();
        }
        // End: dodaje fragment na starcie aplikacji


        // Begin: wyświetla aktualny czas i odświeża co sekundę
        currentTime(); // przywołuje metodę na początku aplikacji

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                currentTime(); // przywołuje metodę co sekundę
                            }
                        });
                    }
                } catch (InterruptedException ignored) {
                }
            }
        };
        thread.start();
        // End: wyświetla aktualny czas i odświeża co sekundę
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

    // Begin: metoda wyświetlająca aktualny czas
    private void currentTime() {
        TextView currentTime = findViewById(R.id.tvCurrentTime);
        long time = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String timeString = sdf.format(time);
        currentTime.setText("Current time " + timeString);
    }
    // End: metoda wyświetlająca aktualny czas


    // Begin: metoda kontrolująca przyciski głównego menu
    private void buttonsMainMenu() {

        btnPlanets = findViewById(R.id.btnPlanets);
        btnResearch = findViewById(R.id.btnResearch);
        btnSummary = findViewById(R.id.btnSummary);
        btnHelp = findViewById(R.id.btnHelp);
        btnSettings = findViewById(R.id.btnSettings);

        btnPlanets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                fragPlanets = getFragmentManager().findFragmentById(R.id.fragmentPlanets);
                fragResearch = getFragmentManager().findFragmentById(R.id.fragmentResearch);
                fragSummary = getFragmentManager().findFragmentById(R.id.fragmentSummary);
                fragSettings = getFragmentManager().findFragmentById(R.id.fragmentSettings);
                fragHelp = getFragmentManager().findFragmentById(R.id.fragmentHelp);
                if (fragPlanets == null) ft.add(R.id.fragmentPlanets, new PlanetsFragment());
                if (fragPlanets != null) ft.show(fragPlanets);
                if (fragResearch != null) ft.hide(fragResearch);
                if (fragSummary != null) ft.hide(fragSummary);
                if (fragSettings != null) ft.hide(fragSettings);
                if (fragHelp != null) ft.hide(fragHelp);
                ft.commit();
            }
        });

        btnResearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                fragPlanets = getFragmentManager().findFragmentById(R.id.fragmentPlanets);
                fragResearch = getFragmentManager().findFragmentById(R.id.fragmentResearch);
                fragSummary = getFragmentManager().findFragmentById(R.id.fragmentSummary);
                fragSettings = getFragmentManager().findFragmentById(R.id.fragmentSettings);
                fragHelp = getFragmentManager().findFragmentById(R.id.fragmentHelp);
                if (fragResearch == null) ft.add(R.id.fragmentResearch, new ResearchFragment());
                if (fragPlanets != null) ft.hide(fragPlanets);
                if (fragResearch != null) ft.show(fragResearch);
                if (fragSummary != null) ft.hide(fragSummary);
                if (fragSettings != null) ft.hide(fragSettings);
                if (fragHelp != null) ft.hide(fragHelp);
                ft.commit();
            }
        });

        btnSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                fragPlanets = getFragmentManager().findFragmentById(R.id.fragmentPlanets);
                fragResearch = getFragmentManager().findFragmentById(R.id.fragmentResearch);
                fragSummary = getFragmentManager().findFragmentById(R.id.fragmentSummary);
                fragSettings = getFragmentManager().findFragmentById(R.id.fragmentSettings);
                fragHelp = getFragmentManager().findFragmentById(R.id.fragmentHelp);
                if (fragSummary == null) ft.add(R.id.fragmentSummary, new SummaryFragment());
                if (fragPlanets != null) ft.hide(fragPlanets);
                if (fragResearch != null) ft.hide(fragResearch);
                if (fragSummary != null) ft.show(fragSummary);
                if (fragSettings != null) ft.hide(fragSettings);
                if (fragHelp != null) ft.hide(fragHelp);
                ft.commit();
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                fragPlanets = getFragmentManager().findFragmentById(R.id.fragmentPlanets);
                fragResearch = getFragmentManager().findFragmentById(R.id.fragmentResearch);
                fragSummary = getFragmentManager().findFragmentById(R.id.fragmentSummary);
                fragSettings = getFragmentManager().findFragmentById(R.id.fragmentSettings);
                fragHelp = getFragmentManager().findFragmentById(R.id.fragmentHelp);
                if (fragHelp == null) ft.add(R.id.fragmentHelp, new HelpFragment());
                if (fragPlanets != null) ft.hide(fragPlanets);
                if (fragResearch != null) ft.hide(fragResearch);
                if (fragSummary != null) ft.hide(fragSummary);
                if (fragSettings != null) ft.hide(fragSettings);
                if (fragHelp != null) ft.show(fragHelp);
                ft.commit();
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                fragPlanets = getFragmentManager().findFragmentById(R.id.fragmentPlanets);
                fragResearch = getFragmentManager().findFragmentById(R.id.fragmentResearch);
                fragSummary = getFragmentManager().findFragmentById(R.id.fragmentSummary);
                fragSettings = getFragmentManager().findFragmentById(R.id.fragmentSettings);
                fragHelp = getFragmentManager().findFragmentById(R.id.fragmentHelp);
                if (fragSettings == null) ft.add(R.id.fragmentSettings, new SettingsFragment());
                if (fragPlanets != null) ft.hide(fragPlanets);
                if (fragResearch != null) ft.hide(fragResearch);
                if (fragSummary != null) ft.hide(fragSummary);
                if (fragSettings != null) ft.show(fragSettings);
                if (fragHelp != null) ft.hide(fragHelp);
                ft.commit();
            }
        });
    }
    // End: metoda kontrolująca przyciski głównego menu


}
