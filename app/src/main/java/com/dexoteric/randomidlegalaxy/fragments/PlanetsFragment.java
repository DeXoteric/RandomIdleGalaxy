package com.dexoteric.randomidlegalaxy.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dexoteric.randomidlegalaxy.MainActivity;
import com.dexoteric.randomidlegalaxy.database.Planet;
import com.dexoteric.randomidlegalaxy.R;
import com.dexoteric.randomidlegalaxy.adapters.Divider;
import com.dexoteric.randomidlegalaxy.adapters.PlanetAdapter;

import java.util.List;



public class PlanetsFragment extends Fragment {

    private static final String TAG = "lifecycleMessage";
    RecyclerView recyclerPlanets;
    RecyclerView.Adapter adapterPlanets;

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


//        MainActivity.planetDatabase.planetDao().insertPlanet(new Planet("Capital", "Capital", "Capital", "Capital"));

        List<Planet> planets = MainActivity.planetDatabase.planetDao().getAllPlanets();

        recyclerPlanets = getActivity().findViewById(R.id.rv_planets);
        recyclerPlanets.addItemDecoration(new Divider(getActivity(), LinearLayoutManager.HORIZONTAL));
        adapterPlanets = new PlanetAdapter(planets);
        recyclerPlanets.setAdapter(adapterPlanets);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerPlanets.setLayoutManager(manager);
    }

}

