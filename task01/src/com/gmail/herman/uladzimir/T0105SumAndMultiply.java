package com.gmail.herman.uladzimir;

public class T0105SumAndMultiply {
    public static void main(String[] args) {
        int n = 81224;
        int sum = getSum(n);
        int mult = getMult(n);
        System.out.println("sum=" + sum + ", multiply=" + mult);
    }

    static int getSum(int n) {
        return (n % 10) + (n / 10 % 10) + (n / 100 % 10) + (n / 1000 % 10) + (n / 10000 % 10);
    }

    static int getMult(int n) {
        return (n % 10) * (n / 10 % 10) * (n / 100 % 10) * (n / 1000 % 10) * (n / 10000 % 10);
    }
}
