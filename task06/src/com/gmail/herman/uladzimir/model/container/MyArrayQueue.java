package com.gmail.herman.uladzimir.model.container;

public class MyArrayQueue<T> implements Queue<T> {

    private T[] array;
    private int length;

    public MyArrayQueue() {
        array = (T[]) new Object[0];
        length = array.length;
    }

    @Override
    public void enqueue() {

    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return array[0];
        }
        return null;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public boolean isFull() {
        int full = 0;

        for (int i = 0; i < length; i++) {
            if (array[i] != null) {
                full++;
            }
        }

        return length == full;
    }
}