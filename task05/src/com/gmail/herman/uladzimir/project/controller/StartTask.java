package com.gmail.herman.uladzimir.project.controller;

import com.gmail.herman.uladzimir.project.model.entity.Train;
import com.gmail.herman.uladzimir.project.model.functional.TrainWorld;
import com.gmail.herman.uladzimir.project.view.View;

public class StartTask {
    public static void main(String[] args) {

        //create world of trains and print description all trains
        int quantityTrain = 3;
        TrainWorld trainWorld = new TrainWorld();
        View.print("World of trains is empty: " + trainWorld.isEmptyWorld());
        trainWorld.createTrainWorld(quantityTrain);
        View.print("Just created world of trains! Amount of trains: " + trainWorld.countTrain());
        View.print("World of trains is empty: " + trainWorld.isEmptyWorld());
        View.print("All trains:\n" + trainWorld.showAllTrain());

        //create clone of train
        int index = 0;
        View.print("Create clone of train - clone train[" + index + "].");
        Train cloneTrain = trainWorld.cloneTrain(trainWorld.getTrainByIndex(index));
        View.print("New clone-train: " + cloneTrain.toString());
        View.print("TRAINS HASHCODES: train=" + trainWorld.getTrainByIndex(index).hashCode() +
                ", clone-train=" + cloneTrain.hashCode());
        View.print("Amount of trains: " + trainWorld.countTrain());

        //change train number by train index
        String numTrain = "0001A";
        View.print("\nChange train's number - change train[" + index + "].\n" +
                "BEFORE: " + trainWorld.getTrainByIndex(index));
        trainWorld.getTrainByIndex(index).setNumTrain(numTrain);
        View.print(" AFTER: " + trainWorld.getTrainByIndex(index));
        View.print("Amount of trains: " + trainWorld.countTrain());

        //create new train
        View.print("\nCreate new train.");
        Train newTrain = trainWorld.createTrain();
        View.print("New train: " + newTrain.toString());
        View.print("Amount of trains: " + trainWorld.countTrain());

        //add new train and clone-train in world of trains and print description all trains
        View.print("\nClone-train №" + cloneTrain.getNumTrain() +
                " in world of trains: " + trainWorld.checkTrain(cloneTrain));
        View.print("New train №" + newTrain.getNumTrain() +
                " in world of trains: " + trainWorld.checkTrain(newTrain));

        View.print("Add clone-train №" + cloneTrain.getNumTrain() +
                " and new train №" + newTrain.getNumTrain() + " in world of trains.");
        trainWorld.addTrain(cloneTrain, newTrain);
        View.print("Clone-train №" + cloneTrain.getNumTrain() +
                " in world of trains: " + trainWorld.checkTrain(cloneTrain));
        View.print("New train №" + newTrain.getNumTrain() +
                " in world of trains: " + trainWorld.checkTrain(newTrain));

        View.print("Amount of trains: " + trainWorld.countTrain());
        View.print("All trains:\n" + trainWorld.showAllTrain());

        //delete train by train index
        View.print("Delete train by train index - delete train[" + index + "].");
        View.print("Train for delete: " + trainWorld.getTrainByIndex(index));
        trainWorld.removeTrainByIndex(index);
        View.print("Amount of trains: " + trainWorld.countTrain());
        View.print("All trains:\n" + trainWorld.showAllTrain());

        //find train by train number
        String wrongNumTrain = "0000Z";
        View.print("Find train №" + newTrain.getNumTrain() + ": " +
                trainWorld.findTrainByNumTrain(newTrain.getNumTrain()));
        View.print("Find train №" + wrongNumTrain + ": " +
                trainWorld.findTrainByNumTrain(wrongNumTrain));

        //find trains by diapason wagons
        int min = 15, max = 25;
        View.print("\nFind trains, which have " + min + "-" + max + " wagons:");
        View.print(trainWorld.showAllTrain
                (trainWorld.findTrainByDiapasonWagons(min, max)));

        //some statistics
        //attention! each wagon has its own parameters! more wagons != the longest train etc.
        View.print(trainWorld.findLongestTrain());
        View.print(trainWorld.findShortestTrain());
        View.print(trainWorld.findHeaviestTrain());
        View.print(trainWorld.findEasiestTrain());
        View.print(trainWorld.findPassengersTrainWithBiggestProfit());

        //remove all trains
        View.print("\nRemove all trains.");
        trainWorld.removeAllTrain();
        View.print("Amount of trains: " + trainWorld.countTrain());
        View.print("World of trains is empty: " + trainWorld.isEmptyWorld());

    }
}