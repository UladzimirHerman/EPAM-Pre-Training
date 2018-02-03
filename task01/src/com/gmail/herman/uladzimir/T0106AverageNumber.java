package com.gmail.herman.uladzimir;

public class T0106AverageNumber {
    public static void main(String[] args) {
        int n = 123456;
        double arithmetic = getArithmetic(n);
        double geometric = getGeometric(n);
        System.out.println("arithmetic=" + arithmetic + "\ngeometric=" + geometric);
    }

    static double getArithmetic(int n) {
        return ((n % 10) + (n / 10 % 10) + (n / 100 % 10) + (n / 1000 % 10) +
                (n / 10_000 % 10) + (n / 100_000 % 10)) / 6.;
    }

    static double getGeometric(int n) {
        return Math.pow(((n % 10) * (n / 10 % 10) * (n / 100 % 10) * (n / 1000 % 10) *
                (n / 10_000 % 10) * (n / 100_000 % 10)), (1 / 6.));
    }
}
