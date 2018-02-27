package com.gmail.herman.uladzimir.container;

import com.gmail.herman.uladzimir.container.exception.QueueIsEmptyException;
import com.gmail.herman.uladzimir.container.exception.QueueIsFullException;

public interface Queue<T> extends Container<T> {

    void enqueue(T o) throws QueueIsFullException;

    T dequeue() throws QueueIsEmptyException;

}