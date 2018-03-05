package com.gmail.herman.uladzimir.container.exception;

public class ListIsEmptyException extends Exception {

    public ListIsEmptyException(String msg) {
        super("ListIsEmptyException: " + msg);
    }

}