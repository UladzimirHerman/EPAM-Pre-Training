package com.gmail.herman.uladzimir.model.container;

import com.gmail.herman.uladzimir.model.exception.StackIsEmptyException;
import com.gmail.herman.uladzimir.model.exception.StackIsFullException;

public interface Stack<T> extends Container<T> {

    void push(T o) throws StackIsFullException;

    T pop() throws StackIsEmptyException;

}