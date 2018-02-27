package com.gmail.herman.uladzimir.container;

import com.gmail.herman.uladzimir.container.exception.QueueIsEmptyException;
import com.gmail.herman.uladzimir.container.exception.StackIsEmptyException;

import java.util.List;

public abstract class ListContainer<T> implements Container<T> {

    protected List<T> list;
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

        return size == list.size();
    }

}