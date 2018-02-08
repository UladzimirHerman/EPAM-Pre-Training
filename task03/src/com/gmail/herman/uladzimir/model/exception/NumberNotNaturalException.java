package com.gmail.herman.uladzimir.model.exception;

public class NumberNotNaturalException extends Exception {

    public NumberNotNaturalException(String msg) {
        super("NumberNotNaturalException: " + msg);
    }

}