package com.gmail.herman.uladzimir.container;

import com.gmail.herman.uladzimir.container.exception.ListIsEmptyException;
import com.gmail.herman.uladzimir.container.exception.ObjectIsNullException;
import com.gmail.herman.uladzimir.container.exception.WrongIndexException;

public interface MyList<T> {

    int size();

    boolean isEmpty();

    void clear() throws ListIsEmptyException;

    void add(T o) throws ObjectIsNullException;

    void remove(int index) throws WrongIndexException, ListIsEmptyException;

    T get(int index) throws WrongIndexException, ListIsEmptyException;

    int indexOf(T o) throws ObjectIsNullException;

    boolean contains(T o) throws ObjectIsNullException;

    T[] toArray(T[] array);

}