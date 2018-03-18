package com.dexoteric.randomidlegalaxy.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dexoteric.randomidlegalaxy.MainActivity;
import com.dexoteric.randomidlegalaxy.Planet;
import com.dexoteric.randomidlegalaxy.R;
import com.dexoteric.randomidlegalaxy.arrays.RandomPlanetName;
import com.dexoteric.randomidlegalaxy.arrays.RandomPlanetQuality;
import com.dexoteric.randomidlegalaxy.arrays.RandomPlanetSize;
import com.dexoteric.randomidlegalaxy.arrays.RandomPlanetType;


public class TestFragment extends Fragment implements View.OnClickListener {


    private static final String TAG = "lifecycleMessage";
    Communicator comm; // fragment communication
    private String planetName, planetSize, planetResources;
    private TextView tvPlanet;
    private Button btnNewPlanet;

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

        comm = (Communicator) getActivity(); // fragment communication

        btnNewPlanet = getActivity().findViewById(R.id.btnNewPlanet);
        btnNewPlanet.setOnClickListener(this);
        tvPlanet = getActivity().findViewById(R.id.tvPlanet);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btnNewPlanet:
                RandomPlanetName planetName = new RandomPlanetName();
                RandomPlanetType planetType = new RandomPlanetType();
                RandomPlanetSize planetSize = new RandomPlanetSize();
                RandomPlanetQuality planetQuality = new RandomPlanetQuality();

                Planet planet = new Planet(planetName.getRandomPlanetName(), planetType.getRandomPlanetType(), planetSize.getRandomPlanetSize(), planetQuality.getRandomPlanetQuality());

                tvPlanet.setText(
                        "Planet: "
                                + planet.getName()
                                + " - "
                                + "Type: "
                                + planet.getType()
                                + " - "
                                + "Size: "
                                + planet.getSize()
                                + " - "
                                + "Quality: "
                                + planet.getQuality()
                                + " - "
                                + "Multiplier: "
                                + "x"+planet.getQualityMultiplier()
                );
                String text = tvPlanet.getText().toString();
                MainActivity.myBundle.putString("id_User", text);
//                comm.respond(tvPlanet.getText().toString()); // fragment communication
                break;
        }
    }
}
