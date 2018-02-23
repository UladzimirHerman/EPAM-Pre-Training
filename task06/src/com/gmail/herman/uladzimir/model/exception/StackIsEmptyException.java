package com.gmail.herman.uladzimir.model.exception;

public class StackIsEmptyException extends Exception {

    public StackIsEmptyException(String msg) {
        super("StackIsEmptyException: " + msg);
    }

}