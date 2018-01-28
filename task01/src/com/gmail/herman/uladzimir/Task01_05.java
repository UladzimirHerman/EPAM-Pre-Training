package com.gmail.herman.uladzimir;

public class Task01_05 {
    public static void main(String[] args) {
        int n = 52312, sum, mult;
        int dig1, dig2, dig3, dig4, dig5;

        dig1 = n % 10;
        dig2 = (n / 10) % 10;
        dig3 = (n / 100) % 10;
        dig4 = (n / 1000) % 10;
        dig5 = (n / 10000) % 10;

        sum = dig1 + dig2 + dig3 + dig4 + dig5;
        mult = dig1 * dig2 * dig3 * dig4 * dig5;

        System.out.println("sum=" + sum + ", multiply=" + mult);
    }
}
