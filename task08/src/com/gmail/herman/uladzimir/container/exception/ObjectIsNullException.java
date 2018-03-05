package com.gmail.herman.uladzimir.container.exception;

public class ObjectIsNullException extends Exception {

    public ObjectIsNullException(String msg) {
        super("ObjectIsNullException: " + msg);
    }

}