package com.dexoteric.randomidlegalaxy.arrays;

import java.util.Random;


public class RandomPlanetSize {


    private String randomPlanetSize;

    private void randomPlanetSize() {
        String[] size = {
                "Small",
                "Medium",
                "Large"
        };
        Random r = new Random();
        int randomIndex = r.nextInt(size.length);
        randomPlanetSize = size[randomIndex];

    }

    public String getRandomPlanetSize() {
        randomPlanetSize();
        return randomPlanetSize;
    }
}
