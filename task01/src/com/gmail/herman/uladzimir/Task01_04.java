package com.gmail.herman.uladzimir;

public class Task01_04 {
    public static void main(String[] args) {
        int n = 9872;
        int dig1, dig2, dig3, dig4;

        dig1 = n % 10;
        dig2 = n / 10 % 10;
        dig3 = n / 100 % 10;
        dig4 = n / 1000 % 10;

        boolean sequence = (dig1 > dig2 && dig2 > dig3 && dig3 > dig4) || (dig1 < dig2 && dig2 < dig3 && dig3 < dig4);

        System.out.println("Sequence in " + n + ": " + sequence);
    }
}
