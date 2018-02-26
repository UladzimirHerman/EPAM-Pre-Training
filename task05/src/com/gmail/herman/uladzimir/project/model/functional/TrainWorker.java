package com.gmail.herman.uladzimir.project.model.functional;

import com.gmail.herman.uladzimir.container.MyArray;
import com.gmail.herman.uladzimir.project.model.entity.Train;

public class TrainWorker {

    private static TrainWorker unique;
    private MyArray<Train> trains;

    private TrainWorker() {
        trains = new MyArray<>();
    }

    public static TrainWorker getInstance() {
        if (null == unique) {
            unique = new TrainWorker();
        }
        return unique;
    }

    public Train[] getAllTrain() {
        Train[] trainArray = new Train[trains.getLength()];

        for (int i = 0; i < trainArray.length; i++) {
            trainArray[i] = trains.getByIndex(i);
        }

        return trainArray;
    }

    public int countTrain() {
        return trains.getLength();
    }

    public boolean isEmptyTrainDepot() {
        return trains.isEmpty();
    }

    public Train getTrainByIndex(int index) {
        return trains.getByIndex(index);
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

    public boolean isTrainInDepot(Train train) {
        return trains.contains(train);
    }

}