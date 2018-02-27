package com.gmail.herman.uladzimir.container.stack;

import com.gmail.herman.uladzimir.container.ArrayContainer;
import com.gmail.herman.uladzimir.container.Stack;
import com.gmail.herman.uladzimir.container.exception.StackIsEmptyException;
import com.gmail.herman.uladzimir.container.exception.StackIsFullException;

public class MyArrayStack<T> extends ArrayContainer<T> implements Stack<T> {

    public MyArrayStack() {
        array = (T[]) new Object[0];
    }

    public MyArrayStack(int capacity) {
        array = (T[]) new Object[capacity];
        this.capacity = capacity;
        fixedCapacity = true;
    }

    @Override
    public T peek() throws StackIsEmptyException {

        if (isEmpty()) {
            throw new StackIsEmptyException("MyArrayStack.peek");
        }

        return array[size - 1];
    }

    @Override
    public void push(T o) throws StackIsFullException {

        if (isFull()) {
            if (fixedCapacity) {
                throw new StackIsFullException("MyArrayStack.push");
            }

            T tempArray[] = (T[]) new Object[array.length + 1];

            for (int i = 0; i < array.length; i++) {
                tempArray[i] = array[i];
            }

            tempArray[array.length] = o;
            array = tempArray.clone();
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
            T tempArray[] = (T[]) new Object[array.length - 1];

            for (int i = 0; i < tempArray.length; i++) {
                tempArray[i] = array[i];
            }

            array = tempArray.clone();
        }

        size--;
        return o;
    }

}