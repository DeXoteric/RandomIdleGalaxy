package com.dexoteric.randomidlegalaxy.arrays;


import java.util.Random;

public class RandomPlanetType {

    private String randomPlanetType;


    private void randomPlanetType() {
        String[] planet = {
                "Terrestial",
                "Desert",
                "Ice",
                "Ocean",
                "Gas Giant"

        };
        Random r = new Random();
        int randomIndex = r.nextInt(planet.length);
        randomPlanetType = planet[randomIndex];
    }

    public String getRandomPlanetType() {
        randomPlanetType();
        return this.randomPlanetType;
    }
}
