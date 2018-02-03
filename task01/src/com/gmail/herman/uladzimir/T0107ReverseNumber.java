package com.gmail.herman.uladzimir;

public class T0107ReverseNumber {
    public static void main(String[] args) {
        int n = 1234567;
        int reverse = getReverse(n);
        System.out.println("before: " + n + "\nafter: " + reverse);
    }

    static int getReverse(int n) {
        return (n % 10 * 1_000_000) + (n / 10 % 10 * 100_000) + (n / 100 % 10 * 10_000) +
                (n / 1000 % 10 * 1000) + (n / 10_000 % 10 * 100) +
                (n / 100_000 % 10 * 10) + (n / 1_000_000 % 10);
    }
}
