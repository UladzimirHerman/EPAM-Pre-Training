package com.gmail.herman.uladzimir.model.exception;

public class NumberNotPositiveException extends Exception {

    public NumberNotPositiveException(String msg) {
        super("NumberNotPositiveException: " + msg);
    }

}