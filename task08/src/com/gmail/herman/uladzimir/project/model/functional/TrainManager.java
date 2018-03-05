package com.gmail.herman.uladzimir.project.model.functional;

import com.gmail.herman.uladzimir.container.MyLinkedList;
import com.gmail.herman.uladzimir.container.exception.ListIsEmptyException;
import com.gmail.herman.uladzimir.container.exception.ObjectIsNullException;
import com.gmail.herman.uladzimir.container.exception.WrongIndexException;
import com.gmail.herman.uladzimir.project.model.entity.FreightTrain;
import com.gmail.herman.uladzimir.project.model.entity.PassengerTrain;
import com.gmail.herman.uladzimir.project.model.entity.Train;
import com.gmail.herman.uladzimir.project.model.factory.FreightTrainFactory;
import com.gmail.herman.uladzimir.project.model.factory.PassengerTrainFactory;
import com.gmail.herman.uladzimir.project.model.factory.TrainFactory;

import java.util.Random;

public class TrainManager {

    public static Train createTrain() {
        Random random = new Random();
        TrainFactory trainFactory;

        if (random.nextBoolean()) {
            trainFactory = new PassengerTrainFactory();
        } else {
            trainFactory = new FreightTrainFactory();
        }

        return trainFactory.createTrain();
    }

    public static void createTrainDepot(int quantityTrain) throws ObjectIsNullException {
        for (int i = 0; i < quantityTrain; i++) {
            TrainWorker.getInstance().addTrain(createTrain());
        }
    }

    public static MyLinkedList<Train> getAllTrain() {
        return TrainWorker.getInstance().getAllTrain();
    }

    public static String showAllTrain() throws ListIsEmptyException, WrongIndexException {
        String result = "";
        int numTrain = TrainWorker.getInstance().countTrain();

        for (int i = 0; i < numTrain; i++) {
            result += TrainWorker.getInstance().getTrainByIndex(i).toString() + "\n";
        }

        return result;
    }

    public static void addTrain(Train... train) throws ObjectIsNullException {
        TrainWorker.getInstance().addTrain(train);
    }

    public static boolean isEmptyTrainDepot() {
        return TrainWorker.getInstance().isEmptyTrainDepot();
    }

    public static Train getTrainByIndex(int index) throws ListIsEmptyException, WrongIndexException {
        return TrainWorker.getInstance().getTrainByIndex(index);
    }

    public static Train cloneTrain(Train train) {

        if (train instanceof PassengerTrain) {
            return new PassengerTrain((PassengerTrain) train);
        } else {
            return new FreightTrain((FreightTrain) train);
        }

    }

    public static boolean isTrainInDepot(Train train) throws ObjectIsNullException {
        return TrainWorker.getInstance().isTrainInDepot(train);
    }

    public static void removeTrainByIndex(int index) throws ListIsEmptyException, WrongIndexException {
        TrainWorker.getInstance().removeTrainByIndex(index);
    }

    public static void removeAllTrain() throws ListIsEmptyException {
        TrainWorker.getInstance().removeAllTrain();
    }

}