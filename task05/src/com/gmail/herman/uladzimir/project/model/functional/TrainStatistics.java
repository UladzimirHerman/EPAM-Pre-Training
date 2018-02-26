package com.gmail.herman.uladzimir.project.model.functional;

import com.gmail.herman.uladzimir.project.model.entity.PassengerTrain;
import com.gmail.herman.uladzimir.project.model.entity.Train;
import com.gmail.herman.uladzimir.project.model.exception.TrainIsNotExistException;
import com.gmail.herman.uladzimir.project.model.exception.TrainIsNotPassengerException;

public class TrainStatistics {

    public static int countTrain() {
        return TrainWorker.getInstance().countTrain();
    }

    public static Train findTrainByNumTrain(String numTrain) throws TrainIsNotExistException {
        Train trains[] = TrainManager.getAllTrain();

        for (int i = 0; i < trains.length; i++) {
            if (trains[i].getNumTrain().equals(numTrain)) {
                return trains[i];
            }
        }

        throw new TrainIsNotExistException("TrainStatistics.findTrainByNumTrain");
    }

    public static Train[] findTrainByDiapasonWagons(int min, int max) {
        int minNum = Math.min(min, max), maxNum = Math.max(min, max);
        Train trains[] = TrainManager.getAllTrain();
        Train newTrains[] = new Train[trains.length];
        int j = 0;

        for (int i = 0; i < trains.length; i++) {
            if (trains[i].getQuantityWagon() >= minNum &&
                    trains[i].getQuantityWagon() <= maxNum) {
                newTrains[j] = trains[i];
                j++;
            }

        }

        Train[] trainByWagon = new Train[j];
        System.arraycopy(newTrains, 0, trainByWagon, 0, trainByWagon.length);

        return trainByWagon;
    }

    public static double countTrainLength(Train train) {
        return train.getQuantityWagon() * train.getLengthWagon();
    }

    public static double countTrainWeight(Train train) {
        return train.getQuantityWagon() * train.getWeightWagon();
    }

    public static double countProfitPassengerTrain(PassengerTrain passengerTrain) {
        return passengerTrain.getQuantityWagon() * passengerTrain.getCapacityWagon() *
                passengerTrain.getTicketPrice() * passengerTrain.getFilling();
    }

    public static Train findLongestTrain() {
        double length = Double.MIN_VALUE, temp;
        Train trains[] = TrainManager.getAllTrain();
        Train train = trains[0];

        for (int i = 0; i < trains.length; i++) {
            temp = countTrainLength(trains[i]);

            if (temp > length) {
                length = temp;
                train = trains[i];
            }

        }

        return train;
    }

    public static Train findShortestTrain() {
        double length = Double.MAX_VALUE, temp;
        Train trains[] = TrainManager.getAllTrain();
        Train train = trains[0];

        for (int i = 0; i < trains.length; i++) {
            temp = countTrainLength(trains[i]);

            if (temp < length) {
                length = temp;
                train = trains[i];
            }

        }

        return train;
    }

    public static Train findHeaviestTrain() {
        double weight = Double.MIN_VALUE, temp;
        Train trains[] = TrainManager.getAllTrain();
        Train train = trains[0];

        for (int i = 0; i < trains.length; i++) {
            temp = countTrainWeight(trains[i]);

            if (temp > weight) {
                weight = temp;
                train = trains[i];
            }

        }

        return train;
    }

    public static Train findEasiestTrain() {
        double weight = Double.MAX_VALUE, temp;
        Train trains[] = TrainManager.getAllTrain();
        Train train = trains[0];

        for (int i = 0; i < trains.length; i++) {
            temp = countTrainWeight(trains[i]);

            if (temp < weight) {
                weight = temp;
                train = trains[i];
            }

        }

        return train;
    }

    public static Train findPassengersTrainWithBiggestProfit() throws TrainIsNotPassengerException {
        double profit = Double.MIN_VALUE, temp;
        Train trains[] = TrainManager.getAllTrain();
        Train train = trains[0];

        for (int i = 0; i < trains.length; i++) {
            if (trains[i] instanceof PassengerTrain) {
                temp = countProfitPassengerTrain((PassengerTrain) trains[i]);
                if (temp > profit) {
                    profit = temp;
                    train = trains[i];
                }
            }
        }

        if (profit == Double.MIN_VALUE) {
            throw new TrainIsNotPassengerException("TrainStatistics.findPassengersTrainWithBiggestProfit");
        }

        return train;
    }

}