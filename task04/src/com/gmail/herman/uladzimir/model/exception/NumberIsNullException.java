package com.gmail.herman.uladzimir.model.exception;

public class NumberIsNullException extends Exception{

    public NumberIsNullException(String msg) {
        super("NumberIsNullException: " + msg);
    }

}