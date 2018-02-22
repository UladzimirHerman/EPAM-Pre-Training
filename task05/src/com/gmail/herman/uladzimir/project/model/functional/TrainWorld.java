package com.gmail.herman.uladzimir.project.model.functional;

import com.gmail.herman.uladzimir.container.MyArray;
import com.gmail.herman.uladzimir.project.model.entity.FreightTrain;
import com.gmail.herman.uladzimir.project.model.entity.PassengerTrain;
import com.gmail.herman.uladzimir.project.model.entity.Train;
import com.gmail.herman.uladzimir.project.model.factory.FreightTrainFactory;
import com.gmail.herman.uladzimir.project.model.factory.PassengerTrainFactory;
import com.gmail.herman.uladzimir.project.model.factory.TrainFactory;

import java.util.Random;

public class TrainWorld {

    private MyArray<Train> trains;

    public TrainWorld() {
        trains = new MyArray<>();
    }

    public void createTrainWorld(int quantityTrain) {
        Random random = new Random();

        for (int i = 0; i < quantityTrain; i++) {
            TrainFactory trainFactory;

            if (random.nextBoolean()) {
                trainFactory = new PassengerTrainFactory();
            } else {
                trainFactory = new FreightTrainFactory();
            }

            trains.add(trainFactory.createTrain());
        }

    }

    public Train createTrain() {
        Random random = new Random();
        TrainFactory trainFactory;

        if (random.nextBoolean()) {
            trainFactory = new PassengerTrainFactory();
        } else {
            trainFactory = new FreightTrainFactory();
        }

        return trainFactory.createTrain();
    }

    public Train cloneTrain(Train train) {

        if (train instanceof PassengerTrain) {
            return new PassengerTrain((PassengerTrain) train);
        } else {
            return new FreightTrain((FreightTrain) train);
        }

    }

    public String showAllTrain() {
        String result = "";

        for (int i = 0; i < trains.getLength(); i++) {
            result += trains.getByIndex(i).toString() + "\n";
        }

        return result;
    }

    public String showAllTrain(Train[] trainArray) {
        String result = "";

        if (trainArray.length > 0) {
            for (int i = 0; i < trainArray.length; i++) {
                result += trainArray[i].toString() + "\n";
            }
        } else {
            result = "There aren't such wagons.\n";
        }

        return result;
    }

    public int countTrain() {
        return trains.getLength();
    }

    public boolean isEmptyWorld() {
        return trains.isEmpty();
    }

    public Train getTrainByIndex(int index) {

        if (index >= 0 && index < trains.getLength()) {
            return trains.getByIndex(index);
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    public void addTrain(Train... train) {
        trains.add(train);
    }

    public void removeTrainByIndex(int index) {
        trains.remove(index);
    }

    public void removeAllTrain() {
        trains.removeAll();
    }

    public boolean checkTrain(Train train) {
        return trains.contains(train);
    }

    public Train findTrainByNumTrain(String numTrain) {

        for (int i = 0; i < trains.getLength(); i++) {
            if (trains.getByIndex(i).getNumTrain().equals(numTrain)) {
                return trains.getByIndex(i);
            }
        }

        return null;
    }

    public Train[] findTrainByDiapasonWagons(int min, int max) {
        Train[] temp = new Train[trains.getLength()];
        int j = 0;

        for (int i = 0; i < trains.getLength(); i++) {
            if (trains.getByIndex(i).getQuantityWagon() >= min &&
                    trains.getByIndex(i).getQuantityWagon() <= max) {
                temp[j] = trains.getByIndex(i);
                j++;
            }
        }

        Train[] trainByWagon = new Train[j];
        for (int i = 0; i < trainByWagon.length; i++) {
            trainByWagon[i] = temp[i];
        }

        return trainByWagon;
    }

    public String findLongestTrain() {
        double longMeter = 0, temp;
        String result = "";
        PassengerTrain passengerTrain;
        FreightTrain freightTrain;

        for (int i = 0; i < trains.getLength(); i++) {

            if (trains.getByIndex(i) instanceof PassengerTrain) {
                passengerTrain = (PassengerTrain) trains.getByIndex(i);
                temp = passengerTrain.getQuantityWagon() *
                        passengerTrain.getPassengerWagonType().getLengthMeter();

                if (temp > longMeter) {
                    longMeter = temp;
                    result = "The longest train: Passenger train №" + passengerTrain.getNumTrain() +
                            ", route: " + passengerTrain.getRoute() + " has " + longMeter + " meters long.";
                }

            } else {
                freightTrain = (FreightTrain) trains.getByIndex(i);
                temp = freightTrain.getQuantityWagon() *
                        freightTrain.getFreightWagonType().getLengthMeter();

                if (temp > longMeter) {
                    longMeter = temp;
                    result = "The longest train: Freight train №" + freightTrain.getNumTrain() +
                            ", route: " + freightTrain.getRoute() + " has " + longMeter + " meters long.";
                }
            }

        }

        return result;
    }

    public String findShortestTrain() {
        double longMeter = 10000, temp;
        String result = "";
        PassengerTrain passengerTrain;
        FreightTrain freightTrain;

        for (int i = 0; i < trains.getLength(); i++) {

            if (trains.getByIndex(i) instanceof PassengerTrain) {
                passengerTrain = (PassengerTrain) trains.getByIndex(i);
                temp = passengerTrain.getQuantityWagon() *
                        passengerTrain.getPassengerWagonType().getLengthMeter();

                if (temp < longMeter) {
                    longMeter = temp;
                    result = "The shortest train: Passenger train №" + passengerTrain.getNumTrain() +
                            ", route: " + passengerTrain.getRoute() + " has " + longMeter + " meters long.";
                }

            } else {
                freightTrain = (FreightTrain) trains.getByIndex(i);
                temp = freightTrain.getQuantityWagon() *
                        freightTrain.getFreightWagonType().getLengthMeter();

                if (temp < longMeter) {
                    longMeter = temp;
                    result = "The shortest train: Freight train №" + freightTrain.getNumTrain() +
                            ", route: " + freightTrain.getRoute() + " has " + longMeter + " meters long.";
                }
            }

        }

        return result;
    }

    public String findHeaviestTrain() {
        double weightTon = 0, temp;
        String result = "";
        PassengerTrain passengerTrain;
        FreightTrain freightTrain;

        for (int i = 0; i < trains.getLength(); i++) {

            if (trains.getByIndex(i) instanceof PassengerTrain) {
                passengerTrain = (PassengerTrain) trains.getByIndex(i);
                temp = passengerTrain.getQuantityWagon() *
                        passengerTrain.getPassengerWagonType().getWeightTon();

                if (temp > weightTon) {
                    weightTon = temp;
                    result = "The heaviest train: Passenger train №" + passengerTrain.getNumTrain() +
                            ", route: " + passengerTrain.getRoute() + " has " + weightTon + " tons weight.";
                }

            } else {
                freightTrain = (FreightTrain) trains.getByIndex(i);
                temp = freightTrain.getQuantityWagon() *
                        freightTrain.getFreightWagonType().getWeightTon();

                if (temp > weightTon) {
                    weightTon = temp;
                    result = "The heaviest train: Freight train №" + freightTrain.getNumTrain() +
                            ", route: " + freightTrain.getRoute() + " has " + weightTon + " tons weight.";
                }
            }

        }

        return result;
    }

    public String findEasiestTrain() {
        double weightTon = 10000, temp;
        String result = "";
        PassengerTrain passengerTrain;
        FreightTrain freightTrain;

        for (int i = 0; i < trains.getLength(); i++) {

            if (trains.getByIndex(i) instanceof PassengerTrain) {
                passengerTrain = (PassengerTrain) trains.getByIndex(i);
                temp = passengerTrain.getQuantityWagon() *
                        passengerTrain.getPassengerWagonType().getWeightTon();

                if (temp < weightTon) {
                    weightTon = temp;
                    result = "The easiest train: Passenger train №" + passengerTrain.getNumTrain() +
                            ", route: " + passengerTrain.getRoute() + " has " + weightTon + " tons weight.";
                }

            } else {
                freightTrain = (FreightTrain) trains.getByIndex(i);
                temp = freightTrain.getQuantityWagon() *
                        freightTrain.getFreightWagonType().getWeightTon();

                if (temp < weightTon) {
                    weightTon = temp;
                    result = "The easiest train: Freight train №" + freightTrain.getNumTrain() +
                            ", route: " + freightTrain.getRoute() + " has " + weightTon + " tons weight.";
                }
            }

        }

        return result;
    }

    public String findPassengersTrainWithBiggestProfit() {
        double profit = 0, temp;
        String result = "The train with biggest profit for tickets: " +
                "Sorry, I don't find passenger train!";
        PassengerTrain passengerTrain;

        for (int i = 0; i < trains.getLength(); i++) {

            if (trains.getByIndex(i) instanceof PassengerTrain) {
                passengerTrain = (PassengerTrain) trains.getByIndex(i);
                temp = passengerTrain.getQuantityWagon() *
                        passengerTrain.getPassengerWagonType().getPlacePassenger() *
                        passengerTrain.getTicketPrice() * passengerTrain.getFilling();

                if (temp > profit) {
                    profit = temp;
                    result = "The train with biggest profit for tickets: Passenger train №" +
                            passengerTrain.getNumTrain() + ", route: " + passengerTrain.getRoute() +
                            " earns $" + profit + ".";
                }

            }

        }

        return result;
    }

}