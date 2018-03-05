package com.gmail.herman.uladzimir.project.model.functional;

import com.gmail.herman.uladzimir.container.MyLinkedList;
import com.gmail.herman.uladzimir.container.exception.ListIsEmptyException;
import com.gmail.herman.uladzimir.container.exception.ObjectIsNullException;
import com.gmail.herman.uladzimir.container.exception.WrongIndexException;
import com.gmail.herman.uladzimir.project.model.entity.Train;

public class TrainWorker {

    private static TrainWorker unique;
    private MyLinkedList<Train> trains;

    private TrainWorker() {
        trains = new MyLinkedList<>();
    }

    public static TrainWorker getInstance() {
        if (unique == null) {
            unique = new TrainWorker();
        }
        return unique;
    }

    public MyLinkedList<Train> getAllTrain() {
        return trains;
    }

    public int countTrain() {
        return trains.size();
    }

    public boolean isEmptyTrainDepot() {
        return trains.isEmpty();
    }

    public Train getTrainByIndex(int index) throws ListIsEmptyException, WrongIndexException {
        return trains.get(index);
    }

    public void addTrain(Train... train) throws ObjectIsNullException {
        for(int i = 0; i < train.length; i++){
            trains.add(train[i]);
        }
    }

    public void removeTrainByIndex(int index) throws ListIsEmptyException, WrongIndexException {
        trains.remove(index);
    }

    public void removeAllTrain() throws ListIsEmptyException {
        trains.clear();
    }

    public boolean isTrainInDepot(Train train) throws ObjectIsNullException {
        return trains.contains(train);
    }

}