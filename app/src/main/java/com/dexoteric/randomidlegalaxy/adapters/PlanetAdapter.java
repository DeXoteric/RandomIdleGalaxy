package com.dexoteric.randomidlegalaxy.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dexoteric.randomidlegalaxy.R;

import java.util.ArrayList;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetHolder> {
    private LayoutInflater mInflater;
    private ArrayList<String> mPlanetName = new ArrayList<>();
    private ArrayList<String> mText = new ArrayList<>();
    

    public PlanetAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mPlanetName = generatePlanetName();
        mText = generateText();

    }

    public static ArrayList<String> generatePlanetName() {

        ArrayList<String> dummyValues = new ArrayList<>();
        dummyValues.add("Capital Planet");
        for (int i = 1; i < 51; i++) {
            dummyValues.add("Planet name: " + i);
        }
        return dummyValues;
    }

    public static ArrayList<String> generateText() {

        ArrayList<String> dummyValues = new ArrayList<>();
        dummyValues.add("Capital Text");
        for (int i = 1; i < 51; i++) {
            dummyValues.add("Text: " + i);
        }
        return dummyValues;
    }


    @NonNull
    @Override
    public PlanetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.planet, parent, false);
        return new PlanetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetHolder holder, int position) {
        holder.mTextReallyLongName.setText(mPlanetName.get(position));
        holder.mTextView.setText(mText.get(position));
    }

    @Override
    public int getItemCount() {
        return mPlanetName.size();
    }

    public static class PlanetHolder extends RecyclerView.ViewHolder {

        TextView mTextReallyLongName;
        TextView mTextView;


        public PlanetHolder(View itemView) {
            super(itemView);
            mTextReallyLongName = itemView.findViewById(R.id.reallylongname);
            mTextView = itemView.findViewById(R.id.textText);
        }
    }

}
