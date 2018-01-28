package com.gmail.herman.uladzimir;

public class Task01_06 {
    public static void main(String[] args) {
        int n = 123456;
        int dig1, dig2, dig3, dig4, dig5, dig6;
        double arithm, geom;

        dig1 = n % 10;
        dig2 = (n / 10) % 10;
        dig3 = (n / 100) % 10;
        dig4 = (n / 1000) % 10;
        dig5 = (n / 10000) % 10;
        dig6 = (n / 100000) % 10;

        arithm = (dig1 + dig2 + dig3 + dig4 + dig5 + dig6) / 6.0;
        geom = Math.pow((dig1 * dig2 * dig3 * dig4 * dig5 * dig6), (1 / 6.0));

        System.out.println("Arithmetic=" + arithm + "\nGeometric=" + geom);
    }
}
