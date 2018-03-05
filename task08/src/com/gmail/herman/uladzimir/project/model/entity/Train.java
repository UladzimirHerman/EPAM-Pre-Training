package com.gmail.herman.uladzimir.project.model.entity;

import java.util.Objects;

public class Train implements Comparable<Train>{
    private String numTrain;
    private String route;
    private int quantityWagon;
    private double weightWagon;
    private double lengthWagon;

    public Train() {
    }

    public Train(String numTrain, String route, int quantityWagon,
                 double weightWagon, double lengthWagon) {
        this.numTrain = numTrain;
        this.route = route;
        this.quantityWagon = quantityWagon;
        this.weightWagon = weightWagon;
        this.lengthWagon = lengthWagon;
    }

    public Train(Train o) {
        this.numTrain = o.numTrain;
        this.route = o.route;
        this.quantityWagon = o.quantityWagon;
        this.weightWagon = o.weightWagon;
        this.lengthWagon = o.lengthWagon;
    }

    public String getNumTrain() {
        return numTrain;
    }

    public void setNumTrain(String numTrain) {
        this.numTrain = numTrain;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getQuantityWagon() {
        return quantityWagon;
    }

    public void setQuantityWagon(int quantityWagon) {
        this.quantityWagon = quantityWagon;
    }

    public double getWeightWagon() {
        return weightWagon;
    }

    public void setWeightWagon(double weightWagon) {
        this.weightWagon = weightWagon;
    }

    public double getLengthWagon() {
        return lengthWagon;
    }

    public void setLengthWagon(double lengthWagon) {
        this.lengthWagon = lengthWagon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return Objects.equals(numTrain, train.numTrain) &&
                Objects.equals(route, train.route);
    }

    @Override
    public int hashCode() {

        return Objects.hash(numTrain, route);
    }

    //sorting by train number
    @Override
    public int compareTo(Train o) {
        return numTrain.compareTo(o.numTrain);
    }

}