package com.gmail.herman.uladzimir.container;

import com.gmail.herman.uladzimir.container.exception.StackIsEmptyException;
import com.gmail.herman.uladzimir.container.exception.StackIsFullException;

public interface Stack<T> extends Container<T> {

    void push(T o) throws StackIsFullException;

    T pop() throws StackIsEmptyException;

}