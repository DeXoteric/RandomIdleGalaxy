package com.dexoteric.randomidlegalaxy.extras;

import java.util.Random;


public class Array {

    public static String randomPlanetType() {
         String[] planet = {
                "Terrestial",
                "Desert",
                "Ice",
                "Ocean",
                "Gas Giant"

        };
        Random r = new Random();
        int randomIndex = r.nextInt(planet.length);

        return planet[randomIndex];
    }

    public static String randomPlanetSize() {
        String[] size = {
                "Small",
                "Medium",
                "Large"
        };
        Random r = new Random();
        int randomIndex = r.nextInt(size.length);

        return size[randomIndex];
    }

    public static String randomPlanetResources() {
        String[] resources = {
                "Poor",
                "Normal",
                "Rich"
        };
        Random r = new Random();
        int randomIndex = r.nextInt(resources.length);

        return resources[randomIndex];
    }
}
