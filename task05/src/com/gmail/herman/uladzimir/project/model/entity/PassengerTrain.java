package com.gmail.herman.uladzimir.project.model.entity;

import com.gmail.herman.uladzimir.project.model.enumeration.PassengerWagonType;

import java.util.Objects;

public class PassengerTrain extends Train {
    private PassengerWagonType passengerWagonType;
    private int capacityWagon;
    private double ticketPrice;
    private double filling;

    public PassengerTrain() {
    }

    public PassengerTrain(String numTrain, String route, int quantityWagon,
                          double weightWagon, double lengthWagon,
                          PassengerWagonType passengerWagonType, int capacityWagon,
                          double ticketPrice, double filling) {
        super(numTrain, route, quantityWagon, weightWagon, lengthWagon);
        this.passengerWagonType = passengerWagonType;
        this.capacityWagon = capacityWagon;
        this.ticketPrice = ticketPrice;
        this.filling = filling;
    }

    public PassengerTrain(PassengerTrain o) {
        super(o.getNumTrain(), o.getRoute(), o.getQuantityWagon(),
                o.getWeightWagon(), o.getLengthWagon());
        this.passengerWagonType = o.passengerWagonType;
        this.capacityWagon = o.capacityWagon;
        this.ticketPrice = o.ticketPrice;
        this.filling = o.filling;
    }

    public PassengerWagonType getPassengerWagonType() {
        return passengerWagonType;
    }

    public void setPassengerWagonType(PassengerWagonType passengerWagonType) {
        this.passengerWagonType = passengerWagonType;
    }

    public int getCapacityWagon() {
        return capacityWagon;
    }

    public void setCapacityWagon(int capacityWagon) {
        this.capacityWagon = capacityWagon;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassengerTrain that = (PassengerTrain) o;
        return Double.compare(that.ticketPrice, ticketPrice) == 0 &&
                passengerWagonType == that.passengerWagonType;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), passengerWagonType, ticketPrice);
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