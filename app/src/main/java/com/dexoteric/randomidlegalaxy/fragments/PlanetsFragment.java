package com.dexoteric.randomidlegalaxy.fragments;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dexoteric.randomidlegalaxy.R;
import com.dexoteric.randomidlegalaxy.adapters.Divider;
import com.dexoteric.randomidlegalaxy.adapters.PlanetAdapter;
import com.dexoteric.randomidlegalaxy.database.Planet;
import com.dexoteric.randomidlegalaxy.database.PlanetDatabase;

import static com.dexoteric.randomidlegalaxy.MainActivity.planets;


public class PlanetsFragment extends Fragment {

    private static final String TAG = "lifecycleMessage";

    RecyclerView recyclerPlanets;
    RecyclerView.Adapter adapterPlanets;

    // wyświetla dane z bazy danych według pozycji z recyclera planet
    private PlanetAdapter.ClickCallback clickCallback = new PlanetAdapter.ClickCallback() {
        @Override
        public void onItemClick(int position) {

            TextView planetInfo = getActivity().findViewById(R.id.tv_planet_info);
            if (position == 0) {
                planetInfo.setText("Capital" + "\n");
                planetInfo.append("Unique" + "\n");
                planetInfo.append("Unique" + "\n");
                planetInfo.append("Unique");
            } else {
                planetInfo.setText(planets.get(position).getRoomPlanetName() + "\n");
                planetInfo.append(planets.get(position).getRoomPlanetType() + "\n");
                planetInfo.append(planets.get(position).getRoomPlanetSize() + "\n");
                planetInfo.append(planets.get(position).getRoomPlanetQuality());
            }

            TextView acriteInfo = getActivity().findViewById(R.id.tv_acrite);
            acriteInfo.setText("Acrite: " + "Stock - "+ planets.get(position).getRoomAcriteStock()
            + " Total - " + planets.get(position).getRoomAcriteInitial()
            + " Per Second - " + planets.get(position).getRoomAcritePerSecond());


        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "fragmentPlanets.onCreateView");
        return inflater.inflate(R.layout.fragment_planets, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "fragmentPlanets.onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "fragmentPlanets.onActivityCreated");

        new MyTask().execute();


        // init recyclera planet
//        recyclerPlanets = getActivity().findViewById(R.id.rv_planets);
//        recyclerPlanets.addItemDecoration(new Divider(getActivity(), LinearLayoutManager.HORIZONTAL));
//        adapterPlanets = new PlanetAdapter(planets, clickCallback);
//        recyclerPlanets.setAdapter(adapterPlanets);
//        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
//        recyclerPlanets.setLayoutManager(manager);


    }

    private class MyTask extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {

            // init bazy danych planet
            PlanetDatabase planetDatabase = PlanetDatabase.getDatabase(getActivity());


            // dodaje stolicę do bazy danych jeśli ta jest pusta (po resecie gry)
            if (planetDatabase.planetDao().count() == 0) {
                planetDatabase.planetDao().addPlanet(new Planet("Capital", "Capital", "Capital", "Capital",10,1.0f,0));
            }

            // wczytuje całą bazę danych planet
            planets = planetDatabase.planetDao().getAllPlanets();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            // init recyclera planet
            recyclerPlanets = getActivity().findViewById(R.id.rv_planets);
            recyclerPlanets.addItemDecoration(new Divider(getActivity(), LinearLayoutManager.HORIZONTAL));
            adapterPlanets = new PlanetAdapter(planets, clickCallback);
            recyclerPlanets.setAdapter(adapterPlanets);
            LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
            recyclerPlanets.setLayoutManager(manager);
            adapterPlanets.notifyDataSetChanged();

        }
    }

}

