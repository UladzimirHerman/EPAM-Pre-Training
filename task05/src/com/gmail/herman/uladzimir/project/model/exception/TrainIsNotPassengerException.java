package com.gmail.herman.uladzimir.project.model.exception;

public class TrainIsNotPassengerException extends Exception {

    public TrainIsNotPassengerException(String msg) {
        super("TrainIsNotPassengerException: " + msg);
    }

}