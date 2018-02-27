package com.gmail.herman.uladzimir.container;

import com.gmail.herman.uladzimir.container.exception.QueueIsEmptyException;
import com.gmail.herman.uladzimir.container.exception.StackIsEmptyException;

public abstract class ArrayContainer<T> implements Container<T> {

    protected T[] array;
    protected int capacity;
    protected int size = 0;
    protected boolean fixedCapacity;

    @Override
    public abstract T peek() throws StackIsEmptyException, QueueIsEmptyException;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {

        if (fixedCapacity) {
            return size == capacity;
        }

        return size == array.length;
    }

}