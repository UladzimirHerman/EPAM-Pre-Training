package com.gmail.herman.uladzimir.model.exception;

public class StackIsFullException extends Exception {

    public StackIsFullException(String msg) {
        super("StackIsFullException: " + msg);
    }

}