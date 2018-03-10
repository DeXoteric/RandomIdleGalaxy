package com.dexoteric.randomidlegalaxy.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dexoteric.randomidlegalaxy.R;

import java.util.ArrayList;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetHolder> {
    private final int NUMBER_OF_LOOPS = 9;
    private LayoutInflater mInflater;
    private ArrayList<String> mPlanetName = new ArrayList<>();
    private ArrayList<String> mText = new ArrayList<>();
    private Context mContext;


    public PlanetAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mPlanetName = generatePlanetName();
        mText = generateText();
        this.mContext = context;

    }

    private  ArrayList<String> generatePlanetName() {

        ArrayList<String> dummyValues = new ArrayList<>();
        dummyValues.add("Capital Planet");
        for (int i = 1; i < NUMBER_OF_LOOPS; i++) {
            dummyValues.add("Planet name: " + i);
        }
        return dummyValues;
    }

    private  ArrayList<String> generateText() {

        ArrayList<String> dummyValues = new ArrayList<>();
        dummyValues.add("Capital Text");
        for (int i = 1; i < NUMBER_OF_LOOPS; i++) {
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

    class PlanetHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mTextReallyLongName;
        TextView mTextView;


        PlanetHolder(View itemView) {
            super(itemView);
            mTextReallyLongName = itemView.findViewById(R.id.reallylongname);
            mTextView = itemView.findViewById(R.id.textText);
            mTextReallyLongName.setOnClickListener(this);
            mTextView.setOnClickListener(this);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            String toast = mTextReallyLongName.getText().toString();
            String toast2 = mTextView.getText().toString();
            int id = v.getId();

            switch (id) {
                case R.id.reallylongname:
                    Toast.makeText(mContext, toast + " clicked!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.textText:
                    Toast.makeText(mContext, toast2 + " clicked!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.ll_planet_recyclerview:
                    Toast.makeText(mContext, toast + " icon clicked!", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

    }
}