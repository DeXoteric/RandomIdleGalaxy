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
import com.dexoteric.randomidlegalaxy.R;
import com.dexoteric.randomidlegalaxy.extras.Array;


public class TestFragment extends Fragment implements View.OnClickListener{


    private String planetName, planetSize, planetResources;
     private TextView tvPlanet;
    private Button btnNewPlanet;
    Communicator comm; // fragment communication
    private static final String TAG = "lifecycleMessage";


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
                planetName = Array.randomPlanetType();
                planetSize = Array.randomPlanetSize();
                planetResources = Array.randomPlanetResources();
                tvPlanet.setText("Planet: " + planetName + " - " + "Size: " + planetSize + " - " + "Resources: " + planetResources + ".");
                String text = tvPlanet.getText().toString();
                MainActivity.myBundle.putString("id_User", text);
//                comm.respond(tvPlanet.getText().toString()); // fragment communication
                break;
        }
    }
}
