package com.gmail.herman.uladzimir.container.stack;

import com.gmail.herman.uladzimir.container.ListContainer;
import com.gmail.herman.uladzimir.container.Stack;
import com.gmail.herman.uladzimir.container.exception.StackIsEmptyException;
import com.gmail.herman.uladzimir.container.exception.StackIsFullException;

import java.util.ArrayList;
import java.util.List;

public class MyListStack<T> extends ListContainer<T> implements Stack<T> {

    public MyListStack() {
        list = new ArrayList<T>(0);
    }

    public MyListStack(int capacity) {
        list = new ArrayList<T>(capacity);
        this.capacity = capacity;
        fixedCapacity = true;
    }

    @Override
    public T peek() throws StackIsEmptyException {

        if (isEmpty()) {
            throw new StackIsEmptyException("MyListStack.peek");
        }

        return list.get(size - 1);
    }

    @Override
    public void push(T o) throws StackIsFullException {

        if (isFull() && fixedCapacity) {
            throw new StackIsFullException("MyListStack.push");
        }

        list.add(o);
        size++;
    }

    @Override
    public T pop() throws StackIsEmptyException {

        if (isEmpty()) {
            throw new StackIsEmptyException("MyListStack.pop");
        }

        T o = list.get(size-1);

        if (!fixedCapacity) {
            list.remove(size-1);
        } else {
            List<T> tempList = new ArrayList<>(size - 1);
            tempList.addAll(list.subList(0, size - 1));
            list = new ArrayList<>(tempList.size());
            list.addAll(tempList);
        }

        size--;
        return o;
    }

}