package com.gmail.herman.uladzimir.container.exception;

public class TreeIsEmptyException extends Exception {

    public TreeIsEmptyException(String msg) {
        super("TreeIsEmptyException: " + msg);
    }

}