package com.gmail.herman.uladzimir.project.model.functional;

import com.gmail.herman.uladzimir.container.MyLinkedList;
import com.gmail.herman.uladzimir.container.exception.ListIsEmptyException;
import com.gmail.herman.uladzimir.container.exception.WrongIndexException;
import com.gmail.herman.uladzimir.project.model.entity.Train;
import com.gmail.herman.uladzimir.project.model.exception.TrainIsNotExistException;

public class TrainSearcher {

    //O(n)
    public static Train searchTrainByNumTrainLinear(String numTrain)
            throws TrainIsNotExistException, ListIsEmptyException, WrongIndexException {
        MyLinkedList<Train> trains = TrainManager.getAllTrain();

        for (int i = 0; i < trains.size(); i++) {
            if (trains.get(i).getNumTrain().equals(numTrain)) {
                return trains.get(i);
            }
        }

        throw new TrainIsNotExistException("TrainSearcher.searchTrainByNumTrainLinear");
    }

    //O(log n)
    public static Train searchTrainByNumTrainBinary(String numTrain)
            throws ListIsEmptyException, WrongIndexException {
        MyLinkedList<Train> trains = TrainManager.getAllTrain();
        int lowerIndex = 0, higherIndex = trains.size() - 1;
        Train result = null;

        while (lowerIndex <= higherIndex) {
            int middleIndex = (lowerIndex + higherIndex) / 2;
            if (trains.get(middleIndex).getNumTrain().compareTo(numTrain) < 0) {
                lowerIndex = middleIndex + 1;
            } else if (trains.get(middleIndex).getNumTrain().compareTo(numTrain) > 0) {
                higherIndex = middleIndex - 1;
            } else if (trains.get(middleIndex).getNumTrain().compareTo(numTrain) == 0) {
                result = trains.get(middleIndex);
                break;
            }
        }

        return result;
    }

}