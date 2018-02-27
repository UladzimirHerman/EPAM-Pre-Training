package com.gmail.herman.uladzimir.container.exception;

public class QueueIsEmptyException extends Exception {

    public QueueIsEmptyException(String msg) {
        super("QueueIsEmptyException: " + msg);
    }

}