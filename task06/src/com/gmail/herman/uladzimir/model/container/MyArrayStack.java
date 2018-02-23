package com.gmail.herman.uladzimir.model.container;

import com.gmail.herman.uladzimir.model.exception.StackIsEmptyException;
import com.gmail.herman.uladzimir.model.exception.StackIsFullException;

public class MyArrayStack<T> implements Stack<T> {

    private T[] array;
    private int capacity;
    private int size;
    private boolean fixedCapacity;

    public MyArrayStack() {
        array = (T[]) new Object[0];
        size = 0;
    }

    public MyArrayStack(int capacity) {
        array = (T[]) new Object[capacity];
        this.capacity = capacity;
        fixedCapacity = true;
        size = 0;
    }

    @Override
    public void push(T o) throws StackIsFullException {

        if (isFull()) {
            if (fixedCapacity) {
                throw new StackIsFullException("MyArrayStack.push");
            }

            T newArray[] = (T[]) new Object[array.length + 1];

            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }

            newArray[array.length] = o;
            array = newArray.clone();
        } else {
            array[size] = o;
        }

        size++;
    }

    @Override
    public T pop() throws StackIsEmptyException {

        if (isEmpty()) {
            throw new StackIsEmptyException("MyArrayStack.pop");
        }

        T o = array[size - 1];

        if (fixedCapacity) {
            array[size - 1] = null;
        } else {
            T newArray[] = (T[]) new Object[array.length - 1];

            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = array[i];
            }

            array = newArray.clone();
        }

        size--;
        return o;
    }

    @Override
    public T peek() throws StackIsEmptyException {

        if (isEmpty()) {
            throw new StackIsEmptyException("MyArrayStack.peek");
        }

        return array[size - 1];
    }

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