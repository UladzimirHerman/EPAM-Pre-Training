package com.gmail.herman.uladzimir.model;

public class SumAndMultiply {

    public static int getSum(int n) {
        return (n % 10) + (n /= 10) % 10 + (n /= 10) % 10 + (n /= 10) % 10 + (n / 10) % 10;
    }

    public static int getMult(int n) {
        return (n % 10) * ((n /= 10) % 10) * ((n /= 10) % 10) * ((n /= 10) % 10) * ((n / 10) % 10);
    }
}