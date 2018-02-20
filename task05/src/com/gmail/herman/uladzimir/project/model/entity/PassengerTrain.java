package com.gmail.herman.uladzimir.project.model.entity;

import com.gmail.herman.uladzimir.project.model.enumeration.PassengerWagonType;

public class PassengerTrain extends Train {
    private PassengerWagonType passengerWagonType;
    private double ticketPrice;
    private double filling;

    public PassengerTrain() {
    }

    public PassengerTrain(String numTrain, String route, int quantityWagon,
                          PassengerWagonType passengerWagonType, double ticketPrice, double filling) {
        super(numTrain, route, quantityWagon);
        this.passengerWagonType = passengerWagonType;
        this.ticketPrice = ticketPrice;
        this.filling = filling;
    }

    public PassengerTrain(PassengerTrain o) {
        super(o.getNumTrain(), o.getRoute(), o.getQuantityWagon());
        this.passengerWagonType = o.passengerWagonType;
        this.ticketPrice = o.ticketPrice;
        this.filling = o.filling;
    }

    public PassengerWagonType getPassengerWagonType() {
        return passengerWagonType;
    }

    public void setPassengerWagonType(PassengerWagonType passengerWagonType) {
        this.passengerWagonType = passengerWagonType;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public double getFilling() {
        return filling;
    }

    public void setFilling(double filling) {
        this.filling = filling;
    }

    @Override
    public String toString() {
        return "Passenger train №" + super.getNumTrain() +
                ", route: " + super.getRoute() +
                ", type: " + getPassengerWagonType() +
                ", wagons: " + super.getQuantityWagon() +
                ", ticket price: $" + getTicketPrice() +
                ", filling: " + getFilling() + ".";
    }

}