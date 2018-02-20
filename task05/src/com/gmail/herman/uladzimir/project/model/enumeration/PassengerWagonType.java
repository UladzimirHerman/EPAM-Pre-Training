package com.gmail.herman.uladzimir.project.model.enumeration;

public enum PassengerWagonType {
    BUSINESS(56.8, 23.0, 40), ECONOMY(54.0, 19.5, 56);

    private double weightTon;
    private double lengthMeter;
    private int placePassenger;

    PassengerWagonType(double weightTon, double lengthMeter, int placePassenger){
        this.weightTon = weightTon;
        this.lengthMeter = lengthMeter;
        this.placePassenger = placePassenger;
    }

    public double getWeightTon() {
        return weightTon;
    }

    public double getLengthMeter() {
        return lengthMeter;
    }

    public int getPlacePassenger() {
        return placePassenger;
    }
}