package com.gmail.herman.uladzimir.container;

import java.util.Arrays;
import java.util.Objects;

public class MyArray<T> {

    private T[] array;
    private int length;

    public MyArray() {
        array = (T[]) new Object[0];
        length = array.length;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void add(T... o) {
        T[] newArray = (T[]) new Object[array.length + o.length];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        for (int i = 0; i < o.length; i++) {
            newArray[array.length + i] = o[i];
        }

        array = newArray.clone();
        length = array.length;
    }

    public void remove(int index) {
        T[] newArray = (T[]) new Object[array.length - 1];

        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                newArray[j] = array[i];
                j++;
            }
        }

        array = newArray.clone();
        length = array.length;
    }

    public void removeAll() {
        T[] newArray = (T[]) new Object[0];

        array = newArray.clone();
        length = array.length;
    }

    public T getByIndex(int index) {
        return array[index];
    }

    public int indexOf(T o) {

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }

        return -1;
    }

    public boolean contains(T o) {
        return indexOf(o) != -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArray<?> myArray = (MyArray<?>) o;
        return length == myArray.length &&
                Arrays.equals(array, myArray.array);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(length);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
}