package com.dexoteric.randomidlegalaxy.adapters;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dexoteric.randomidlegalaxy.database.Planet;
import com.dexoteric.randomidlegalaxy.R;

import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetHolder> {

    private List<Planet> planets;

    public PlanetAdapter(List<Planet> planets) {
        this.planets = planets;
    }



    @NonNull
    @Override
    public PlanetAdapter.PlanetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.planet, parent, false);
        return new PlanetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetAdapter.PlanetHolder holder, int position) {

        holder.planetName.setText(planets.get(position).getRoomPlanetName());

        if (planets.get(position).getRoomPlanetType().equals("Capital")){
            holder.planetType.setImageResource(R.drawable.icon_planet_capital);
        } else if (planets.get(position).getRoomPlanetType().equals("Terrestial")){
            holder.planetType.setImageResource(R.drawable.icon_planet_terrestial);
        } else if (planets.get(position).getRoomPlanetType().equals("Ice")){
            holder.planetType.setImageResource(R.drawable.icon_planet_ice);
        } else if (planets.get(position).getRoomPlanetType().equals("Ocean")){
            holder.planetType.setImageResource(R.drawable.icon_planet_ocean);
        } else if (planets.get(position).getRoomPlanetType().equals("Desert")){
            holder.planetType.setImageResource(R.drawable.icon_planet_desert);
        } else if (planets.get(position).getRoomPlanetType().equals("Gas Giant")){
            holder.planetType.setImageResource(R.drawable.icon_planet_gas);
        } else {
            holder.planetType.setImageResource(R.drawable.icon_planet_unique);
        }

         if (planets.get(position).getRoomPlanetSize().equals("Small")){
            holder.planetSize.setImageResource(R.drawable.icon_red);
        } else if (planets.get(position).getRoomPlanetSize().equals("Medium")){
            holder.planetSize.setImageResource(R.drawable.icon_white);
        } else if (planets.get(position).getRoomPlanetSize().equals("Large")){
            holder.planetSize.setImageResource(R.drawable.icon_green);
        } else {
             holder.planetSize.setImageResource(R.drawable.icon_unique);
        }

        if (planets.get(position).getRoomPlanetQuality().equals("Poor")){
            holder.planetQuality.setImageResource(R.drawable.icon_red);
        } else if (planets.get(position).getRoomPlanetQuality().equals("Normal")){
            holder.planetQuality.setImageResource(R.drawable.icon_white);
        } else if (planets.get(position).getRoomPlanetQuality().equals("Rich")){
            holder.planetQuality.setImageResource(R.drawable.icon_green);
        } else {
            holder.planetQuality.setImageResource(R.drawable.icon_unique);
        }

    }


    @Override
    public int getItemCount() {
        return planets.size();
    }

    class PlanetHolder extends RecyclerView.ViewHolder {

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


        }

    }
}