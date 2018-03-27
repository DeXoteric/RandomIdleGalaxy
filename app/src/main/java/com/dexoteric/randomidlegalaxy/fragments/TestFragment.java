package com.dexoteric.randomidlegalaxy.fragments;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dexoteric.randomidlegalaxy.R;
import com.dexoteric.randomidlegalaxy.arrays.RandomPlanetName;
import com.dexoteric.randomidlegalaxy.arrays.RandomPlanetQuality;
import com.dexoteric.randomidlegalaxy.arrays.RandomPlanetSize;
import com.dexoteric.randomidlegalaxy.arrays.RandomPlanetType;
import com.dexoteric.randomidlegalaxy.database.Planet;
import com.dexoteric.randomidlegalaxy.database.PlanetDatabase;


public class TestFragment extends Fragment implements View.OnClickListener {


    private static final String TAG = "lifecycleMessage";

    private Button btnNewPlanet, btnDeletePlanet;
    private PlanetDatabase planetDatabase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "fragmentTest.onCreateView");
        return inflater.inflate(R.layout.fragment_test, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "fragmentTest.onViewCreated");

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "fragmentTest.onActivityCreated");


        planetDatabase = PlanetDatabase.getDatabase(getActivity());


        btnNewPlanet = getActivity().findViewById(R.id.btnNewPlanet);
        btnNewPlanet.setOnClickListener(this);

        btnDeletePlanet = getActivity().findViewById(R.id.btnDeletePlanet);
        btnDeletePlanet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        new MyTask().execute(v);

    }

    private class MyTask extends AsyncTask<View, Void, Void> {


        @Override
        protected Void doInBackground(View... views) {
            View v = views[0];

            int id = v.getId();

            switch (id) {
                case R.id.btnNewPlanet:

                    RandomPlanetName planetName = new RandomPlanetName();
                    RandomPlanetType planetType = new RandomPlanetType();
                    RandomPlanetSize planetSize = new RandomPlanetSize();
                    RandomPlanetQuality planetQuality = new RandomPlanetQuality();

                    Planet planet = new Planet();
                    planet.setRoomPlanetName(planetName.getRandomPlanetName());
                    planet.setRoomPlanetType(planetType.getRandomPlanetType());
                    planet.setRoomPlanetSize(planetSize.getRandomPlanetSize());
                    planet.setRoomPlanetQuality(planetQuality.getRandomPlanetQuality());
                    planet.setRoomAcriteInitial(0);
                    planet.setRoomAcritePerSecond(0.0f);
                    planet.setRoomAcriteStock(0);

                    planetDatabase.planetDao().addPlanet(planet);
                    break;


                case R.id.btnDeletePlanet:

                    planetDatabase.planetDao().deleteAllPlanets();
//                MainActivity.planetDatabase.planetDao().addPlanet(new Planet("Capital", "Capital", "Capital", "Capital"));
                    break;
            }
            return null;
        }
    }

}
