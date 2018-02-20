package com.gmail.herman.uladzimir.project.model.entity;

import com.gmail.herman.uladzimir.project.model.enumeration.FreightWagonType;

public class FreightTrain extends Train {
    private FreightWagonType freightWagonType;
    private boolean dangerousGoods;

    public FreightTrain() {
    }

    public FreightTrain(String numTrain, String route, int quantityWagon,
                        FreightWagonType freightWagonType, boolean dangerousGoods) {
        super(numTrain, route, quantityWagon);
        this.freightWagonType = freightWagonType;
        this.dangerousGoods = dangerousGoods;
    }

    public FreightTrain(FreightTrain o) {
        super(o.getNumTrain(), o.getRoute(), o.getQuantityWagon());
        this.freightWagonType = o.freightWagonType;
        this.dangerousGoods = o.dangerousGoods;
    }

    public FreightWagonType getFreightWagonType() {
        return freightWagonType;
    }

    public void setFreightWagonType(FreightWagonType freightWagonType) {
        this.freightWagonType = freightWagonType;
    }

    public boolean isDangerousGoods() {
        return dangerousGoods;
    }

    public void setDangerousGoods(boolean dangerousGoods) {
        this.dangerousGoods = dangerousGoods;
    }

    @Override
    public String toString() {
        return "Freight train №" + super.getNumTrain() +
                ", route: " + super.getRoute() +
                ", type: " + getFreightWagonType() +
                ", wagons: " + super.getQuantityWagon() +
                ", there are dangerous goods: " + isDangerousGoods() + ".";
    }

}