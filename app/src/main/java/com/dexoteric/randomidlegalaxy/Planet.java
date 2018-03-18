package com.dexoteric.randomidlegalaxy;



public class Planet {

    private final double POOR_QUALITY_MULTIPLIER = 0.75;
    private final double NORMAL_QUALITY_MULTIPLIER = 1.00;
    private final double RICH_QUALITY_MULTIPLIER = 1.25;

    private String name;
    private String type;
    private String size;
    private String quality;

    private double qualityMultiplier;



    // empty constructor
    public Planet() {
    }

    // constructor
    public Planet(String name, String type, String size, String quality) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public String getQuality() {
        return quality;
    }

    public double getQualityMultiplier() {
        switch (quality) {
            case "Poor":
                qualityMultiplier = POOR_QUALITY_MULTIPLIER;
                break;
            case "Normal":
                qualityMultiplier = NORMAL_QUALITY_MULTIPLIER;
                break;
            case "Rich":
                qualityMultiplier = RICH_QUALITY_MULTIPLIER;
                break;
        }
        return qualityMultiplier;
    }
}

