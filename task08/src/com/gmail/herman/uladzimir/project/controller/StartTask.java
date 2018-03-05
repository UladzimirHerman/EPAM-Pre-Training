package com.gmail.herman.uladzimir.project.controller;


import com.gmail.herman.uladzimir.container.exception.ListIsEmptyException;
import com.gmail.herman.uladzimir.container.exception.ObjectIsNullException;
import com.gmail.herman.uladzimir.container.exception.WrongIndexException;
import com.gmail.herman.uladzimir.project.model.entity.Train;
import com.gmail.herman.uladzimir.project.model.exception.TrainIsNotExistException;
import com.gmail.herman.uladzimir.project.model.functional.TrainManager;
import com.gmail.herman.uladzimir.project.model.functional.TrainSearcher;
import com.gmail.herman.uladzimir.project.model.functional.TrainSorter;
import com.gmail.herman.uladzimir.project.model.functional.TrainWorker;
import com.gmail.herman.uladzimir.project.view.View;

public class StartTask {
    public static void main(String[] args) {

        //demonstration of the functional classes TrainSorter and TrainSearcher
        //on the engine MyLinkedList
        try {
            int quantityTrain = 5;
            View.print("Train depot is empty: " + TrainManager.isEmptyTrainDepot());
            TrainManager.createTrainDepot(quantityTrain);
            View.print("Just created train depot! Amount of trains: " +
                    TrainWorker.getInstance().countTrain());
            View.print("Train depot is empty: " + TrainManager.isEmptyTrainDepot());
            View.print("\nAll trains:\n" + TrainManager.showAllTrain());

            //bubble sort
            TrainSorter.sortBubble();
            View.print("All trains after bubble sort:\n" + TrainManager.showAllTrain());

            //insertion sort
            Train newTrain = TrainManager.createTrain();
            View.print("Add new train: " + newTrain);
            TrainManager.addTrain(newTrain);
            TrainSorter.sortInsertion();
            View.print("\nAll trains after insertion sort:\n" + TrainManager.showAllTrain());

            //selection sort
            newTrain = TrainManager.createTrain();
            View.print("Add new train: " + newTrain);
            TrainManager.addTrain(newTrain);
            TrainSorter.sortSelection();
            View.print("\nAll trains after selection sort:\n" + TrainManager.showAllTrain());

            //merge sort
            newTrain = TrainManager.createTrain();
            View.print("Add new train: " + newTrain);
            TrainManager.addTrain(newTrain);
            TrainSorter.sortMerge();
            View.print("\nAll trains after merge sort:\n" + TrainManager.showAllTrain());

            //quick sort
            newTrain = TrainManager.createTrain();
            View.print("Add new train: " + newTrain);
            TrainManager.addTrain(newTrain);
            TrainSorter.sortQuick();
            View.print("\nAll trains after quick sort:\n" + TrainManager.showAllTrain());


            View.print("Linear search train №" + TrainManager.getTrainByIndex(3).getNumTrain() + ": " +
                    TrainSearcher.searchTrainByNumTrainLinear(TrainManager.getTrainByIndex(3).getNumTrain()));
            View.print("Binary search train №" + TrainManager.getTrainByIndex(4).getNumTrain() + ": " +
                    TrainSearcher.searchTrainByNumTrainBinary(TrainManager.getTrainByIndex(4).getNumTrain()));

        } catch (ObjectIsNullException | ListIsEmptyException |
                WrongIndexException | TrainIsNotExistException e) {
            View.print(e.getMessage());
        }

    }
}