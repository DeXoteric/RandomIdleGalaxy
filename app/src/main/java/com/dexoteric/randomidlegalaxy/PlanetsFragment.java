package com.dexoteric.randomidlegalaxy;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dexoteric.randomidlegalaxy.adapters.PlanetAdapter;


public class PlanetsFragment extends Fragment {

    private static final String TAG = "lifecycleMessage";
    RecyclerView mRecyclerPlanets;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i(TAG, "fragmentPlanets.onCreateView");

        View rootView = inflater.inflate(R.layout.fragment_planets, container, false);
        mRecyclerPlanets = rootView.findViewById(R.id.rv_planets);
        mRecyclerPlanets.setAdapter(new PlanetAdapter(getActivity()));
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerPlanets.setLayoutManager(manager);
        return rootView;
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

    }


}

