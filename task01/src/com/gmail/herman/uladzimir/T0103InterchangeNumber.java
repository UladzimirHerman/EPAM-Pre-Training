package com.gmail.herman.uladzimir;

public class T0103InterchangeNumber {
    public static void main(String[] args) {
        int a = 28, b = 17;
        printNumber(a, b);
        exchangeNumber(a, b);
    }

    static void exchangeNumber(int a, int b) {
        a = a - b;
        b = b + a;
        a = b - a;
        printNumber(a, b);
    }

    static void printNumber(int a, int b) {
        System.out.println("a=" + a + ", b=" + b);
    }
}