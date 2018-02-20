package com.gmail.herman.uladzimir.project.model.enumeration;

public enum FreightWagonType {
    COVERED_AND_GONDOLA(59.2, 15.7), HOPPERS_AND_CISTERNS(64.8, 12.9);

    private double weightTon;
    private double lengthMeter;

    FreightWagonType(double weightTon, double lengthMeter) {
        this.weightTon = weightTon;
        this.lengthMeter = lengthMeter;
    }

    public double getWeightTon() {
        return weightTon;
    }

    public double getLengthMeter() {
        return lengthMeter;
    }

}