package com.gmail.herman.uladzimir.model.container;

import java.util.ArrayList;
import java.util.List;

public class MyListStack<T> implements Stack<T> {

    private List<T> list;
    private int size;

    public MyListStack() {
        list = new ArrayList<T>(0);
        size = list.size();
    }

    @Override
    public void push(T o) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return list.get(0);
        }
        return null;
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
        int full = 0;

        for (int i = 0; i < size; i++) {
            if (list.get(i) != null) {
                full++;
            }
        }

        return size == full;
    }
}