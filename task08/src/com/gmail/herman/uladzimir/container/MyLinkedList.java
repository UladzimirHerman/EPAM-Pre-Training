package com.gmail.herman.uladzimir.container;

import com.gmail.herman.uladzimir.container.exception.ListIsEmptyException;
import com.gmail.herman.uladzimir.container.exception.ObjectIsNullException;
import com.gmail.herman.uladzimir.container.exception.WrongIndexException;

import java.util.Objects;

public class MyLinkedList<T> implements MyList<T> {

    private class Node {

        private T o;
        private Node nextNode;

        private Node(T o) {
            this.o = o;
            this.nextNode = null;
        }

        private T getObject() {
            return o;
        }

    }

    private Node firstNode;
    private Node lastNode;
    private int size;

    public MyLinkedList() {
        firstNode = null;
        lastNode = null;
        size = 0;
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
    public void clear() throws ListIsEmptyException {

        if (isEmpty()) {
            throw new ListIsEmptyException("MyLinkedList.clear");
        }

        Node current = firstNode;

        for (int i = 0; i < size; i++) {
            current = null;
        }

        size = 0;
    }

    @Override
    public void add(T o) throws ObjectIsNullException {

        if (o == null) {
            throw new ObjectIsNullException("MyLinkedList.add");
        }

        if (isEmpty()) {
            firstNode = new Node(o);
            lastNode = firstNode;
        } else {
            Node previous = lastNode;
            lastNode = new Node(o);
            previous.nextNode = lastNode;
        }

        size++;
    }

    @Override
    public void remove(int index) throws WrongIndexException, ListIsEmptyException {

        if (index < 0 || index >= size) {
            throw new WrongIndexException("MyLinkedList.remove");
        }

        if (isEmpty()) {
            throw new ListIsEmptyException("MyLinkedList.remove");
        }

        if (index == 0) {
            firstNode = firstNode.nextNode;
        } else if (index == size - 1) {
            lastNode = new Node(get(size - 2));
        } else {
            Node current = firstNode;

            for (int i = 0; i < index - 1; i++) {
                current = current.nextNode;
            }

            current.nextNode = current.nextNode.nextNode;
        }

        size--;
    }

    @Override
    public T get(int index) throws ListIsEmptyException, WrongIndexException {
        if (index < 0 || index >= size) {
            throw new WrongIndexException("MyLinkedList.get");
        }

        if (isEmpty()) {
            throw new ListIsEmptyException("MyLinkedList.get");
        }

        if (index == 0) {
            return firstNode.getObject();
        }

        Node current = firstNode;

        for (int i = 0; i < index; i++) {
            if (current.nextNode == null) {
                return null;
            }
            current = current.nextNode;
        }

        return current.getObject();
    }

    @Override
    public int indexOf(T o) throws ObjectIsNullException {

        if (o == null) {
            throw new ObjectIsNullException("MyLinkedList.indexOf");
        }

        Node current = firstNode;
        for (int i = 0; i < size; i++) {
            if (o.equals(current.getObject())) {
                return i;
            }
            current = current.nextNode;
        }

        return -1;
    }

    @Override
    public boolean contains(T o) throws ObjectIsNullException {
        return indexOf(o) != -1;
    }

    @Override
    public T[] toArray(T[] array) {

        for (int i = 0; i < size; i++) {
            try {
                array[i] = get(i);
            } catch (ListIsEmptyException | WrongIndexException e) {
                //this catch will never be used and it exists because of get(i)
            }
        }

        return array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyLinkedList<?> that = (MyLinkedList<?>) o;
        return size == that.size &&
                Objects.equals(firstNode, that.firstNode) &&
                Objects.equals(lastNode, that.lastNode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstNode, lastNode, size);
    }

}