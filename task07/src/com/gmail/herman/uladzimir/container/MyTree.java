package com.gmail.herman.uladzimir.container;

import com.gmail.herman.uladzimir.container.exception.TreeIsEmptyException;

public class MyTree<T extends Comparable> {
    private Node root;

    public MyTree() {
    }

    public int size() {
        return sizeRecursively(root);
    }

    private int sizeRecursively(Node current) {
        return current == null ?
                0 : sizeRecursively(current.left) + sizeRecursively(current.right) + 1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        root = null;
    }

    public boolean contains(T o) throws TreeIsEmptyException {

        if (isEmpty()) {
            throw new TreeIsEmptyException("MyTree.contains");
        }

        return containsRecursively(root, o);
    }

    private boolean containsRecursively(Node current, T o) {

        if (current == null) {
            return false;
        }

        if (o.compareTo(current.o) == 0) {
            return true;
        }

        return o.compareTo(current.o) < 0 ?
                containsRecursively(current.left, o) : containsRecursively(current.right, o);
    }

    public void add(T o) {
        root = addRecursively(root, o);
    }

    private Node addRecursively(Node current, T o) {

        if (current != null) {

            if (o.compareTo(current.o) < 0) {
                current.left = addRecursively(current.left, o);
            } else {
                current.right = addRecursively(current.right, o);
            }

            return current;
        } else {
            return new Node(o);
        }

    }

    public void remove(T o) throws TreeIsEmptyException {

        if (isEmpty()) {
            throw new TreeIsEmptyException("MyTree.remove");
        }

        removeRecursively(root, o);
    }

    private Node removeRecursively(Node current, T o) {

        if (current == null) {
            return null;
        }

        if (o.compareTo(current.o) == 0) {

            if (current.left == null && current.right == null) {
                return null;
            }

            if (current.left == null) {
                return current.right;
            }

            if (current.right == null) {
                return current.left;
            }

            T minObject = findMinObject(current.right);
            current.o = minObject;
            current.right = removeRecursively(current.right, minObject);

            return current;
        }

        if (o.compareTo(current.o) < 0) {
            current.left = removeRecursively(current.left, o);
            return current;
        }

        //o.compareTo(current.o) > 0
        current.right = removeRecursively(current.right, o);
        return current;
    }

    private T findMinObject(Node current) {
        return current.left != null ?
                findMinObject(current.left) : (T) current.o;
    }

    public StringBuilder circumventPreOrder() {
        StringBuilder stringBuilder = new StringBuilder();
        return circumventPreOrderRecursively(root, stringBuilder);
    }

    private StringBuilder circumventPreOrderRecursively(Node node, StringBuilder stringBuilder) {

        if (node != null) {
            stringBuilder.append(node.o + "\n");
            circumventPreOrderRecursively(node.left, stringBuilder);
            circumventPreOrderRecursively(node.right, stringBuilder);
        }

        return stringBuilder;
    }

    public StringBuilder circumventPostOrder() {
        StringBuilder stringBuilder = new StringBuilder();
        return circumventPostOrderRecursively(root, stringBuilder);
    }

    private StringBuilder circumventPostOrderRecursively(Node node, StringBuilder stringBuilder) {

        if (node != null) {
            circumventPostOrderRecursively(node.left, stringBuilder);
            circumventPostOrderRecursively(node.right, stringBuilder);
            stringBuilder.append(node.o + "\n");
        }

        return stringBuilder;
    }

    public StringBuilder circumventInOrder() {
        StringBuilder stringBuilder = new StringBuilder();
        return circumventInOrderRecursively(root, stringBuilder);
    }

    private StringBuilder circumventInOrderRecursively(Node node, StringBuilder stringBuilder) {

        if (node != null) {
            circumventInOrderRecursively(node.left, stringBuilder);
            stringBuilder.append(node.o + "\n");
            circumventInOrderRecursively(node.right, stringBuilder);
        }

        return stringBuilder;
    }

}