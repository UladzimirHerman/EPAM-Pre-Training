package com.gmail.herman.uladzimir;

public class Task01_03 {
    public static void main(String[] args) {
        int a = 28, b = 17;

        System.out.println("Before: a=" + a + ", b=" + b);
        a -= b;
        b += a;
        a = b - a;
        System.out.println("After: a=" + a + ", b=" + b);
    }
}
