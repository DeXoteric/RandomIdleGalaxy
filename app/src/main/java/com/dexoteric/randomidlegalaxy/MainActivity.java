package com.dexoteric.randomidlegalaxy;

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


    PlanetsFragment fragPlanets = new PlanetsFragment();
    ResearchFragment fragResearch = new ResearchFragment();
    SummaryFragment fragSummary = new SummaryFragment();
    SettingsFragment fragSettings = new SettingsFragment();
    HelpFragment fragHelp = new HelpFragment();


    // Start: ClickListener
    private View.OnClickListener btnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            switch (id) {
                case R.id.btn_planets:
                    if (fragPlanets != null) ft.show(fragPlanets);
                    if (fragResearch != null) ft.hide(fragResearch);
                    if (fragSummary != null) ft.hide(fragSummary);
                    if (fragSettings != null) ft.hide(fragSettings);
                    if (fragHelp != null) ft.hide(fragHelp);
                    ft.commit();
                    break;
                case R.id.btn_research:
                    if (fragPlanets != null) ft.hide(fragPlanets);
                    if (fragResearch != null) ft.show(fragResearch);
                    if (fragSummary != null) ft.hide(fragSummary);
                    if (fragSettings != null) ft.hide(fragSettings);
                    if (fragHelp != null) ft.hide(fragHelp);
                    ft.commit();
                    break;
                case R.id.btn_summary:
                    if (fragPlanets != null) ft.hide(fragPlanets);
                    if (fragResearch != null) ft.hide(fragResearch);
                    if (fragSummary != null) ft.show(fragSummary);
                    if (fragSettings != null) ft.hide(fragSettings);
                    if (fragHelp != null) ft.hide(fragHelp);
                    ft.commit();
                    break;
                case R.id.btn_settings:
                    if (fragPlanets != null) ft.hide(fragPlanets);
                    if (fragResearch != null) ft.hide(fragResearch);
                    if (fragSummary != null) ft.hide(fragSummary);
                    if (fragSettings != null) ft.show(fragSettings);
                    if (fragHelp != null) ft.hide(fragHelp);
                    ft.commit();
                    break;
                case R.id.btn_help:
                    if (fragPlanets != null) ft.hide(fragPlanets);
                    if (fragResearch != null) ft.hide(fragResearch);
                    if (fragSummary != null) ft.hide(fragSummary);
                    if (fragSettings != null) ft.hide(fragSettings);
                    if (fragHelp != null) ft.show(fragHelp);
                    ft.commit();
                    break;
            }
        }
    };
    // End: ClickListener

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


        // Begin: dodaje fragmenty na starcie aplikacji
        if (savedInstanceState == null) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.fragment_frame, fragPlanets, "tagPlanets");
            ft.add(R.id.fragment_frame, fragResearch, "tagResearch");
            ft.add(R.id.fragment_frame, fragSummary, "tagSummary");
            ft.add(R.id.fragment_frame, fragSettings, "tagSettings");
            ft.add(R.id.fragment_frame, fragHelp, "tagHelp");
            ft.show(fragPlanets);
            ft.hide(fragResearch);
            ft.hide(fragSummary);
            ft.hide(fragSettings);
            ft.hide(fragHelp);
            ft.commit();
        } // End: dodaje fragmenty na starcie aplikacji

        Button btnPlanets = findViewById(R.id.btn_planets);
        Button btnResearch = findViewById(R.id.btn_research);
        Button btnSummary = findViewById(R.id.btn_summary);
        Button btnHelp = findViewById(R.id.btn_help);
        Button btnSettings = findViewById(R.id.btn_settings);

        btnPlanets.setOnClickListener(btnClickListener);
        btnResearch.setOnClickListener(btnClickListener);
        btnSummary.setOnClickListener(btnClickListener);
        btnSettings.setOnClickListener(btnClickListener);
        btnHelp.setOnClickListener(btnClickListener);

        currentTime(); // przywołuje metodę na początku aplikacji

        // Begin: wyświetla aktualny czas i odświeża co sekundę
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
        TextView currentTime = findViewById(R.id.tv_current_time);
        long time = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String timeString = sdf.format(time);
        currentTime.setText("Current time " + timeString);
    }
    // End: metoda wyświetlająca aktualny czas

}
