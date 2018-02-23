package com.gmail.herman.uladzimir.model.container;

import com.gmail.herman.uladzimir.model.exception.StackIsEmptyException;

public interface Container<T> {

    T peek() throws StackIsEmptyException;

    int size();

    boolean isEmpty();

    boolean isFull();

}