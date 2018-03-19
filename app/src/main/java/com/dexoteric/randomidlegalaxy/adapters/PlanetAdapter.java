package com.dexoteric.randomidlegalaxy.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dexoteric.randomidlegalaxy.R;
import com.dexoteric.randomidlegalaxy.arrays.RandomPlanetName;
import com.dexoteric.randomidlegalaxy.arrays.RandomPlanetQuality;
import com.dexoteric.randomidlegalaxy.arrays.RandomPlanetSize;
import com.dexoteric.randomidlegalaxy.arrays.RandomPlanetType;

import java.util.ArrayList;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetHolder> {
    private final int NUMBER_OF_LOOPS = 50;
    private LayoutInflater mInflater;
    private ArrayList<String> mPlanetName = new ArrayList<>();
    private ArrayList<String> mPlanetType = new ArrayList<>();
    private ArrayList<String> mPlanetSize = new ArrayList<>();
    private ArrayList<String> mPlanetQuality = new ArrayList<>();
    private Context mContext;


    public PlanetAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mPlanetName = generatePlanetName();
        mPlanetType = generatePlanetType();
        mPlanetSize = generatePlanetSize();
        mPlanetQuality = generatePlanetQuality();
        this.mContext = context;

    }

    private ArrayList<String> generatePlanetName() {

        ArrayList<String> planetName = new ArrayList<>();
        planetName.add("Capital");
        for (int i = 1; i < NUMBER_OF_LOOPS; i++) {
            RandomPlanetName randomPlanetName = new RandomPlanetName();
            planetName.add(randomPlanetName.getRandomPlanetName());
        }
        return planetName;

    }

    private ArrayList<String> generatePlanetType() {

        ArrayList<String> planetType = new ArrayList<>();
        planetType.add("Capital");
        for (int i = 1; i < NUMBER_OF_LOOPS; i++) {
            RandomPlanetType randomPlanetType = new RandomPlanetType();
            planetType.add(randomPlanetType.getRandomPlanetType());
        }
        return planetType;
    }

    private ArrayList<String> generatePlanetSize() {

        ArrayList<String> planetSize = new ArrayList<>();
        planetSize.add("Capital");
        for (int i = 1; i < NUMBER_OF_LOOPS; i++) {
            RandomPlanetSize randomPlanetSize = new RandomPlanetSize();
            planetSize.add(randomPlanetSize.getRandomPlanetSize());
        }
        return planetSize;
    }

    private ArrayList<String> generatePlanetQuality() {

        ArrayList<String> planetQuality = new ArrayList<>();
        planetQuality.add("Capital");
        for (int i = 1; i < NUMBER_OF_LOOPS; i++) {
            RandomPlanetQuality randomPlanetQuality = new RandomPlanetQuality();
            planetQuality.add(randomPlanetQuality.getRandomPlanetQuality());
        }
        return planetQuality;
    }


    @NonNull
    @Override
    public PlanetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.planet, parent, false);
        return new PlanetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetHolder holder, int position) {
        // nazwa planety według pozycji
        holder.planetName.setText(mPlanetName.get(position));

        // ikona planety według typu
        if (mPlanetType.get(position).equals("Capital")) {
            holder.planetType.setImageResource(R.drawable.icon_planet_capital);
        } else if (mPlanetType.get(position).equals("Terrestial")) {
            holder.planetType.setImageResource(R.drawable.icon_planet_terrestial);
        } else if (mPlanetType.get(position).equals("Ocean")) {
            holder.planetType.setImageResource(R.drawable.icon_planet_ocean);
        } else if (mPlanetType.get(position).equals("Ice")) {
            holder.planetType.setImageResource(R.drawable.icon_planet_ice);
        } else if (mPlanetType.get(position).equals("Gas Giant")) {
            holder.planetType.setImageResource(R.drawable.icon_planet_gas);
        } else if (mPlanetType.get(position).equals("Desert")) {
            holder.planetType.setImageResource(R.drawable.icon_planet_desert);
        } else {
            holder.planetType.setImageResource(R.drawable.icon_planet_unique);
        }

        // ikona wielkosci planety
        if (mPlanetSize.get(position).equals("Small")) {
            holder.planetSize.setImageResource(R.drawable.icon_red);
        } else if (mPlanetSize.get(position).equals("Medium")) {
            holder.planetSize.setImageResource(R.drawable.icon_white);
        } else if (mPlanetSize.get(position).equals("Large")) {
            holder.planetSize.setImageResource(R.drawable.icon_green);
        } else {
            holder.planetSpecial.setVisibility(View.VISIBLE);
            holder.planetSize.setVisibility(View.INVISIBLE);
            holder.planetQuality.setVisibility(View.INVISIBLE);
        }


        // ikona jakosci planety
        if (mPlanetQuality.get(position).equals("Poor")) {
            holder.planetQuality.setImageResource(R.drawable.icon_red);
        } else if (mPlanetQuality.get(position).equals("Normal")) {
            holder.planetQuality.setImageResource(R.drawable.icon_white);
        } else if (mPlanetQuality.get(position).equals("Rich")) {
            holder.planetQuality.setImageResource(R.drawable.icon_green);
        } else {
            holder.planetSpecial.setVisibility(View.VISIBLE);
            holder.planetSize.setVisibility(View.INVISIBLE);
            holder.planetQuality.setVisibility(View.INVISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return mPlanetName.size();
    }

    class PlanetHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView planetName;
        TextView planetSpecial;
        ImageView planetType;
        ImageView planetSize;
        ImageView planetQuality;


        PlanetHolder(View itemView) {
            super(itemView);
            planetName = itemView.findViewById(R.id.tv_planet_name);
            planetSpecial = itemView.findViewById(R.id.tv_special);
            planetType = itemView.findViewById(R.id.iv_planet_type);
            planetSize = itemView.findViewById(R.id.iv_planet_size);
            planetQuality = itemView.findViewById(R.id.iv_planet_quality);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            String toast = planetName.getText().toString();


            Toast.makeText(mContext, toast + " clicked!", Toast.LENGTH_SHORT).show();


        }

    }
}