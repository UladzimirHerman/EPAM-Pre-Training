package com.gmail.herman.uladzimir;

public class Task01_07 {
    public static void main(String[] args) {
        int n = 1234567, reverse;
        int dig1, dig2, dig3, dig4, dig5, dig6, dig7;

        System.out.println("Before: " + n);

        dig1 = n % 10;
        dig2 = (n / 10) % 10;
        dig3 = (n / 100) % 10;
        dig4 = (n / 1000) % 10;
        dig5 = (n / 10000) % 10;
        dig6 = (n / 100_000) % 10;
        dig7 = (n / 1000_000) % 10;

        reverse = dig1 * 1000_000 + dig2 * 100_000 + dig3 * 10000 + dig4 * 1000 + dig5 * 100 + dig6 * 10 + dig7;
        System.out.println("After: " + reverse);
    }
}
