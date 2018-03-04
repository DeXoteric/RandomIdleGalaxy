package com.dexoteric.randomidlegalaxy;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class ResearchFragment extends Fragment {


    private String planetName, planetSize, planetResources;
    private TextView tvPlanet;
    private static final String TAG = "lifecycleMessage";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i(TAG, "fragmentResearch.onCreateView");
        return inflater.inflate(R.layout.fragment_research, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "fragmentResearch.onViewCreated");
        Button btnNewPlanet = view.findViewById(R.id.btnNewPlanet);
        tvPlanet = view.findViewById(R.id.tvPlanet);
        btnNewPlanet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                planetName = "Capital";
                planetSize = "Medium";
                planetResources = "Normal";
                tvPlanet.setText("Planet: " + planetName + " - " + "Size: " + planetSize + " - " + "Resources: " + planetResources + " amount.");
                System.out.println(tvPlanet.getText());
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "fragmentResearch.onActivityCreated");
//        if (savedInstanceState != null) {
//            tvPlanet.setText(savedInstanceState.getCharSequence("planet"));
//        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "fragmentResearch.onSaveInstanceState");
//        outState.putCharSequence("planet", tvPlanet.getText() );
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "fragmentResearch.onDetach");

    }
}
