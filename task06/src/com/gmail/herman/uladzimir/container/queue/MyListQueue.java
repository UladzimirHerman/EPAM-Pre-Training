package com.gmail.herman.uladzimir.container.queue;

import com.gmail.herman.uladzimir.container.ListContainer;
import com.gmail.herman.uladzimir.container.Queue;
import com.gmail.herman.uladzimir.container.exception.QueueIsEmptyException;
import com.gmail.herman.uladzimir.container.exception.QueueIsFullException;

import java.util.ArrayList;

public class MyListQueue<T> extends ListContainer<T> implements Queue<T> {

    public MyListQueue() {
        list = new ArrayList<T>(0);
    }

    public MyListQueue(int capacity) {
        list = new ArrayList<T>(capacity);
        this.capacity = capacity;
        fixedCapacity = true;
    }

    @Override
    public T peek() throws QueueIsEmptyException {

        if (isEmpty()) {
            throw new QueueIsEmptyException("MyListQueue.peek");
        }

        return list.get(size - 1);
    }

    @Override
    public void enqueue(T o) throws QueueIsFullException {

        if (isFull()) {
            if (fixedCapacity) {
                throw new QueueIsFullException("MyListQueue.enqueue");
            }
        }

        list.add(o);
        size++;
    }

    @Override
    public T dequeue() throws QueueIsEmptyException {

        if (isEmpty()) {
            throw new QueueIsEmptyException("MyListQueue.dequeue");
        }

        T o = list.get(0);
        list.remove(0);
        size--;
        return o;
    }

}