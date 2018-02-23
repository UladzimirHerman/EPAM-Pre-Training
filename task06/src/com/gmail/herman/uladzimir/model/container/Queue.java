package com.gmail.herman.uladzimir.model.container;

public interface Queue<T> extends Container<T> {

    void enqueue();

    T dequeue();
}