package com.dexoteric.randomidlegalaxy.arrays;


import java.util.Random;

public class RandomPlanetName {

    private String randomPlanetName;

    private void randomPlanetName(){
        char[] charsOne = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder sbOne = new StringBuilder();
        Random rOne = new Random();
        for (int i = 0; i < 2; i++)
        {
            char c = charsOne[rOne.nextInt(charsOne.length)];
            sbOne.append(c);
        }
        String randomPlanetNameOne = sbOne.toString();

        char[] charsTwo = "0123456789".toCharArray();
        StringBuilder sbTwo = new StringBuilder();
        Random rTwo = new Random();
        for (int i = 0; i < 3; i++)
        {
            char c = charsTwo[rTwo.nextInt(charsTwo.length)];
            sbTwo.append(c);
        }
        String randomPlanetNameTwo = sbTwo.toString();

        randomPlanetName = randomPlanetNameOne + "-" + randomPlanetNameTwo;
    }

    public String getRandomPlanetName() {
        randomPlanetName();
        return randomPlanetName;
    }
}
