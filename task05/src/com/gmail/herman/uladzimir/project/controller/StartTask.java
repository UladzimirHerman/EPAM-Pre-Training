package com.gmail.herman.uladzimir.project.controller;

import com.gmail.herman.uladzimir.project.model.entity.PassengerTrain;
import com.gmail.herman.uladzimir.project.model.entity.Train;
import com.gmail.herman.uladzimir.project.model.exception.TrainIsNotExistException;
import com.gmail.herman.uladzimir.project.model.exception.TrainIsNotPassengerException;
import com.gmail.herman.uladzimir.project.model.functional.TrainManager;
import com.gmail.herman.uladzimir.project.model.functional.TrainStatistics;
import com.gmail.herman.uladzimir.project.view.View;

public class StartTask {
    public static void main(String[] args) {

        //create trains depot and print description all trains
        int quantityTrain = 3;
        View.print("Train depot is empty: " + TrainManager.isEmptyTrainDepot());
        TrainManager.createTrainDepot(quantityTrain);
        View.print("Just created train depot! Amount of trains: " + TrainStatistics.countTrain());
        View.print("Train depot is empty: " + TrainManager.isEmptyTrainDepot());
        System.out.println("\nAll trains:\n" + TrainManager.showAllTrain());

        //create clone of train
        int index = 0;
        View.print("Create clone of train - clone train[" + index + "].");
        Train cloneTrain = TrainManager.cloneTrain(TrainManager.getTrainByIndex(index));
        View.print("New clone-train: " + cloneTrain.toString());
        View.print("Amount of trains: " + TrainStatistics.countTrain());

        //change train number by train index
        String numTrain = "0001A";
        View.print("\nChange train's number - change train[" + index + "].\n" +
                "BEFORE: " + TrainManager.getTrainByIndex(index));
        TrainManager.getTrainByIndex(index).setNumTrain(numTrain);
        View.print(" AFTER: " + TrainManager.getTrainByIndex(index));
        View.print("Amount of trains: " + TrainStatistics.countTrain());

        //create new train
        View.print("\nCreate new train.");
        Train newTrain = TrainManager.createTrain();
        View.print("New train: " + newTrain.toString());
        View.print("Amount of trains: " + TrainStatistics.countTrain());

        //add new train and clone-train in train depot and print description all trains
        View.print("\nClone-train №" + cloneTrain.getNumTrain() +
                " is in train depot: " + TrainManager.isTrainInDepot(cloneTrain));
        View.print("New train №" + newTrain.getNumTrain() +
                " is in train depot: " + TrainManager.isTrainInDepot(newTrain));
        View.print("Add clone-train №" + cloneTrain.getNumTrain() +
                " and new train №" + newTrain.getNumTrain() + " in train depot.");
        TrainManager.addTrain(cloneTrain, newTrain);
        View.print("Clone-train №" + cloneTrain.getNumTrain() +
                " is in train depot: " + TrainManager.isTrainInDepot(cloneTrain));
        View.print("New train №" + newTrain.getNumTrain() +
                " is in train depot: " + TrainManager.isTrainInDepot(newTrain));
        View.print("Amount of trains: " + TrainStatistics.countTrain());
        System.out.println("All trains:\n" + TrainManager.showAllTrain());

        //delete train by train index
        View.print("Delete train by train index - delete train[" + index + "].");
        View.print("Train for delete: " + TrainManager.getTrainByIndex(index));
        TrainManager.removeTrainByIndex(index);
        View.print("Amount of trains: " + TrainStatistics.countTrain());
        View.print("All trains:\n" + TrainManager.showAllTrain());

        //find train by train number
        String wrongNumTrain = "0000Z";
        try {
            View.print("Find train №" + newTrain.getNumTrain() + ": " +
                    TrainStatistics.findTrainByNumTrain(newTrain.getNumTrain()));
            View.print("Find train №" + wrongNumTrain + ": ");
            View.print(TrainStatistics.findTrainByNumTrain(wrongNumTrain));
        } catch (TrainIsNotExistException e) {
            View.print(e.getMessage());
        }

        //find trains by diapason wagons
        int min = 15, max = 25;
        View.print("\nFind trains, which have " + min + "-" + max + " wagons:");
        View.print(TrainManager.showAllTrain
                (TrainStatistics.findTrainByDiapasonWagons(min, max)));

        //some statistics
        //attention! each wagon has its own parameters! more wagons != the longest train etc.
        View.print("The longest train has " +
                TrainStatistics.countTrainLength(TrainStatistics.findLongestTrain()) +
                " meters long. Train info: " + TrainStatistics.findLongestTrain().toString());
        View.print("The shortest train has " +
                TrainStatistics.countTrainLength(TrainStatistics.findShortestTrain()) +
                " meters long. Train info: " + TrainStatistics.findShortestTrain().toString());
        View.print("The heaviest train has " +
                TrainStatistics.countTrainWeight(TrainStatistics.findHeaviestTrain()) +
                " tons weight. Train info: " + TrainStatistics.findHeaviestTrain().toString());
        View.print("The easiest train has " +
                TrainStatistics.countTrainWeight(TrainStatistics.findEasiestTrain()) +
                " tons weight. Train info: " + TrainStatistics.findEasiestTrain().toString());
        try {
            View.print("The biggest profit for tickets is $" +
                    TrainStatistics.countProfitPassengerTrain((PassengerTrain)
                            TrainStatistics.findPassengersTrainWithBiggestProfit()) +
                    ". Train info: " + TrainStatistics.findPassengersTrainWithBiggestProfit().toString());
        } catch (TrainIsNotPassengerException e) {
            View.print(e.getMessage());
        }

        //remove all trains
        View.print("\nRemove all trains.");
        TrainManager.removeAllTrain();
        View.print("Amount of trains: " + TrainStatistics.countTrain());
        View.print("World of trains is empty: " + TrainManager.isEmptyTrainDepot());

    }
}