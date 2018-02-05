package com.gmail.herman.uladzimir.model;

public class AverageNumber {

    public static double getArithmetic(int n) {
        return (n % 10 + (n /= 10) % 10 + (n /= 10) % 10 + (n /= 10) % 10 +
                (n /= 10) % 10 + (n / 10) % 10) / 6.;
    }

    public static double getGeometric(int n) {
        return Math.pow(((n % 10) * ((n /= 10) % 10) * ((n /= 10) % 10) *
                ((n /= 10) % 10) * ((n /= 10) % 10) * ((n / 10) % 10)), (1 / 6.));
    }
}