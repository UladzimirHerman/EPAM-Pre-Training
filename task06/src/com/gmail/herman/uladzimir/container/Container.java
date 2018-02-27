package com.gmail.herman.uladzimir.container;

import com.gmail.herman.uladzimir.container.exception.QueueIsEmptyException;
import com.gmail.herman.uladzimir.container.exception.StackIsEmptyException;

public interface Container<T> {

    T peek() throws StackIsEmptyException, QueueIsEmptyException;

    int size();

    boolean isEmpty();

    boolean isFull();

}