package com.gmail.herman.uladzimir.container;

public class Node<T extends Comparable> implements Comparable<T> {
    Node left, right;
    T o;

    Node(T o) {
        this.o = o;
    }

    @Override
    public int compareTo(T o) {
        return this.o.compareTo(o);
    }

}