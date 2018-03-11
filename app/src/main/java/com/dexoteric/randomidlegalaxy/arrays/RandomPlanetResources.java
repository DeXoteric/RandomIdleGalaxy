package com.dexoteric.randomidlegalaxy.arrays;

import java.util.Random;

public class RandomPlanetResources {

    private String randomPlanetResources;

    private void randomPlanetResources() {
        String[] resources = {
                "Poor",
                "Normal",
                "Rich"
        };
        Random r = new Random();
        int randomIndex = r.nextInt(resources.length);
        randomPlanetResources = resources[randomIndex];
    }

    public String getRandomPlanetResources() {
        randomPlanetResources();
        return randomPlanetResources;
    }
}
