package com.gmail.herman.uladzimir.container.exception;

public class StackIsFullException extends Exception {

    public StackIsFullException(String msg) {
        super("StackIsFullException: " + msg);
    }

}