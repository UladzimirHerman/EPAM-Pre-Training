package com.gmail.herman.uladzimir.project.model.entity;

import java.util.Objects;

public class Train {
    private String numTrain;
    private String route;
    private int quantityWagon;

    public Train() {
    }

    public Train(String numTrain, String route, int quantityWagon) {
        this.numTrain = numTrain;
        this.route = route;
        this.quantityWagon = quantityWagon;
    }

    public Train(Train o) {
        this.numTrain = o.numTrain;
        this.route = o.route;
        this.quantityWagon = o.quantityWagon;
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
}