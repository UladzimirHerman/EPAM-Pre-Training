package com.gmail.herman.uladzimir.model;

public class InterchangeNumber {

    public static String exchangeNumber(int a, int b) {
        a = a - b;
        b = b + a;
        a = b - a;
        return "a=" + a + ", b=" + b;
    }
}