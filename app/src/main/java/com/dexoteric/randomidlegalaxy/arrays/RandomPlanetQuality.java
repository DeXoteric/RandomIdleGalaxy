package com.dexoteric.randomidlegalaxy.arrays;

import java.util.Random;

public class RandomPlanetQuality {

    private String randomPlanetQuality;

    private void randomPlanetQuality() {
        String[] resources = {
                "Poor",
                "Normal",
                "Rich"
        };
        Random r = new Random();
        int randomIndex = r.nextInt(resources.length);
        randomPlanetQuality = resources[randomIndex];
    }

    public String getRandomPlanetQuality() {
        randomPlanetQuality();
        return randomPlanetQuality;
    }
}
