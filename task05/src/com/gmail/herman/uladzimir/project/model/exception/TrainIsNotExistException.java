package com.gmail.herman.uladzimir.project.model.exception;

public class TrainIsNotExistException extends Exception {

    public TrainIsNotExistException(String msg) {
        super("TrainIsNotExistException: " + msg);
    }

}