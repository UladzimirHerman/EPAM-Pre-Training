package com.gmail.herman.uladzimir.container.exception;

public class QueueIsFullException extends Exception {

    public QueueIsFullException(String msg) {
        super("QueueIsFullException: " + msg);
    }

}