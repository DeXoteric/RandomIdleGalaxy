package com.dexoteric.randomidlegalaxy;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
        View view = inflater.inflate(R.layout.fragment_research, container, false);

        Button btnNewPlanet = view.findViewById(R.id.btnNewPlanet);
        tvPlanet = view.findViewById(R.id.tvPlanet);
        btnNewPlanet.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                planetName = "Capital";
                planetSize = "Medium";
                planetResources = "Normal";
                tvPlanet.setText("Planet: " + planetName + " - " + "Size: " + planetSize + " - " + "Resources: " + planetResources + " amount.");
                System.out.println(tvPlanet.getText());
            }
        });
        return view;

    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "fragment.onActivityCreated");
        if (savedInstanceState != null) {
            tvPlanet.setText(savedInstanceState.getCharSequence("planet"));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "fragment.onSaveInstanceState");
        outState.putCharSequence("planet", tvPlanet.getText() );
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "fragment.onDetach");

    }
}
