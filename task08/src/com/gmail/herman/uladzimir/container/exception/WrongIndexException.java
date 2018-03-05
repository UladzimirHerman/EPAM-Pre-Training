package com.gmail.herman.uladzimir.container.exception;

public class WrongIndexException extends Exception {

    public WrongIndexException(String msg) {
        super("WrongIndexException: " + msg);
    }

}