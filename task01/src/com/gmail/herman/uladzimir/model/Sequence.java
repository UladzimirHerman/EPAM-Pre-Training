package com.gmail.herman.uladzimir.model;

public class Sequence {

    public static boolean isSequence(int n){

        int dig1 = n % 10;
        int dig2 = n / (int) Math.pow(10, 1) % 10;
        int dig3 = n / (int) Math.pow(10, 2) % 10;
        int dig4 = n / (int) Math.pow(10, 3) % 10;

        return (dig1 > dig2 && dig2 > dig3 && dig3 > dig4) ||
                (dig1 < dig2 && dig2 < dig3 && dig3 < dig4);
    }
}