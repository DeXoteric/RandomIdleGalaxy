package com.dexoteric.randomidlegalaxy.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dexoteric.randomidlegalaxy.R;

import static com.dexoteric.randomidlegalaxy.MainActivity.planets;


public class ResearchFragment extends Fragment {

    public TextView testText;
    private static final String TAG = "lifecycleMessage";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "fragmentResearch.onCreateView");
        return inflater.inflate(R.layout.fragment_research, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "fragmentResearch.onViewCreated");

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "fragmentResearch.onActivityCreated");



        testText = getActivity().findViewById(R.id.textView2);
        testText.setText(planets.get(0).getRoomPlanetName() + "\n");
        testText.append(planets.get(1).getRoomPlanetName() + "\n");
        testText.append(planets.get(2).getRoomPlanetName() + "\n");
        testText.append(planets.get(3).getRoomPlanetName() + "\n");


    }

    // fragment communication
    public void changeData (String data){

//        textView2.setText(data);
    }

}
