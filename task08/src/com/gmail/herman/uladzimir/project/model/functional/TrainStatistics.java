package com.gmail.herman.uladzimir.project.model.functional;

import com.gmail.herman.uladzimir.container.MyLinkedList;
import com.gmail.herman.uladzimir.container.exception.ListIsEmptyException;
import com.gmail.herman.uladzimir.container.exception.WrongIndexException;
import com.gmail.herman.uladzimir.project.model.entity.PassengerTrain;
import com.gmail.herman.uladzimir.project.model.entity.Train;
import com.gmail.herman.uladzimir.project.model.exception.TrainIsNotExistException;
import com.gmail.herman.uladzimir.project.model.exception.TrainIsNotPassengerException;

public class TrainStatistics {

    public static int countTrain() {
        return TrainWorker.getInstance().countTrain();
    }

    public static Train findTrainByNumTrain(String numTrain) throws TrainIsNotExistException, ListIsEmptyException, WrongIndexException {
        MyLinkedList<Train> trains = TrainManager.getAllTrain();

        for (int i = 0; i < trains.size(); i++) {
            if (trains.get(i).getNumTrain().equals(numTrain)) {
                return trains.get(i);
            }
        }

        throw new TrainIsNotExistException("TrainStatistics.findTrainByNumTrain");
    }

    public static Train[] findTrainByDiapasonWagons(int min, int max) throws ListIsEmptyException, WrongIndexException {
        int minNum = Math.min(min, max), maxNum = Math.max(min, max);
        MyLinkedList<Train> trains = TrainManager.getAllTrain();
        Train newTrains[] = new Train[trains.size()];
        int j = 0;

        for (int i = 0; i < trains.size(); i++) {
            if (trains.get(i).getQuantityWagon() >= minNum &&
                    trains.get(i).getQuantityWagon() <= maxNum) {
                newTrains[j] = trains.get(i);
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

    public static Train findLongestTrain() throws ListIsEmptyException, WrongIndexException {
        double length = Double.MIN_VALUE, temp;
        MyLinkedList<Train> trains = TrainManager.getAllTrain();
        Train train = trains.get(0);

        for (int i = 0; i < trains.size(); i++) {
            temp = countTrainLength(trains.get(i));

            if (temp > length) {
                length = temp;
                train = trains.get(i);
            }

        }

        return train;
    }

    public static Train findShortestTrain() throws ListIsEmptyException, WrongIndexException {
        double length = Double.MAX_VALUE, temp;
        MyLinkedList<Train> trains = TrainManager.getAllTrain();
        Train train = trains.get(0);

        for (int i = 0; i < trains.size(); i++) {
            temp = countTrainLength(trains.get(i));

            if (temp < length) {
                length = temp;
                train = trains.get(i);
            }

        }

        return train;
    }

    public static Train findHeaviestTrain() throws ListIsEmptyException, WrongIndexException {
        double weight = Double.MIN_VALUE, temp;
        MyLinkedList<Train> trains = TrainManager.getAllTrain();
        Train train = trains.get(0);

        for (int i = 0; i < trains.size(); i++) {
            temp = countTrainWeight(trains.get(i));

            if (temp > weight) {
                weight = temp;
                train = trains.get(i);
            }

        }

        return train;
    }

    public static Train findEasiestTrain() throws ListIsEmptyException, WrongIndexException {
        double weight = Double.MAX_VALUE, temp;
        MyLinkedList<Train> trains = TrainManager.getAllTrain();
        Train train = trains.get(0);

        for (int i = 0; i < trains.size(); i++) {
            temp = countTrainWeight(trains.get(i));

            if (temp < weight) {
                weight = temp;
                train = trains.get(i);
            }

        }

        return train;
    }

    public static Train findPassengersTrainWithBiggestProfit() throws TrainIsNotPassengerException, ListIsEmptyException, WrongIndexException {
        double profit = Double.MIN_VALUE, temp;
        MyLinkedList<Train> trains = TrainManager.getAllTrain();
        Train train = trains.get(0);

        for (int i = 0; i < trains.size(); i++) {
            if (trains.get(i) instanceof PassengerTrain) {
                temp = countProfitPassengerTrain((PassengerTrain) trains.get(i));
                if (temp > profit) {
                    profit = temp;
                    train = trains.get(i);
                }
            }
        }

        if (profit == Double.MIN_VALUE) {
            throw new TrainIsNotPassengerException("TrainStatistics.findPassengersTrainWithBiggestProfit");
        }

        return train;
    }

}