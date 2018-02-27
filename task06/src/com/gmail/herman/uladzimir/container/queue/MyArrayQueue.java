package com.gmail.herman.uladzimir.container.queue;

import com.gmail.herman.uladzimir.container.ArrayContainer;
import com.gmail.herman.uladzimir.container.Queue;
import com.gmail.herman.uladzimir.container.exception.QueueIsEmptyException;
import com.gmail.herman.uladzimir.container.exception.QueueIsFullException;

public class MyArrayQueue<T> extends ArrayContainer<T> implements Queue<T> {

    public MyArrayQueue() {
        array = (T[]) new Object[0];
    }

    public MyArrayQueue(int capacity) {
        array = (T[]) new Object[capacity];
        this.capacity = capacity;
        fixedCapacity = true;
    }

    @Override
    public T peek() throws QueueIsEmptyException {

        if (isEmpty()) {
            throw new QueueIsEmptyException("MyArrayQueue.peek");
        }

        return array[0];
    }

    @Override
    public void enqueue(T o) throws QueueIsFullException {

        if (isFull()) {

            if (fixedCapacity) {
                throw new QueueIsFullException("MyArrayQueue.enqueue");
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
    public T dequeue() throws QueueIsEmptyException {

        if(isEmpty()){
            throw new QueueIsEmptyException("MyArrayQueue.dequeue");
        }

        T o = array[0];

        for (int i = 0; i < array.length - 1; i++){
            array[i] = array [i+1];
        }

        if(!fixedCapacity){
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