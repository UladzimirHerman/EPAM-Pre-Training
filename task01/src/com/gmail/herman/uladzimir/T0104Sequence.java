package com.gmail.herman.uladzimir;

public class T0104Sequence {
    public static void main(String[] args) {
        int n = 9731;
        boolean sequence = isSequence(n);
        System.out.println("Sequence in " + n + ": " + sequence);
    }

    static boolean isSequence(int n){
        int dig1 = n % 10;
        int dig2 = n / 10 % 10;
        int dig3 = n / 100 % 10;
        int dig4 = n / 1000 % 10;

        boolean sequence = (dig1 > dig2 && dig2 > dig3 && dig3 > dig4) ||
                (dig1 < dig2 && dig2 < dig3 && dig3 < dig4);

        return sequence;
    }
}
