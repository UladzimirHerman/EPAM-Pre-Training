package com.gmail.herman.uladzimir.container.exception;

public class StackIsEmptyException extends Exception {

    public StackIsEmptyException(String msg) {
        super("StackIsEmptyException: " + msg);
    }

}