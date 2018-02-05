package com.gmail.herman.uladzimir.model;

public class ReverseNumber {

    public static int getReverse(int n) {
        int reverse = n % 10;
        reverse = reverse * 10 + ((n /= 10) % 10);
        reverse = reverse * 10 + ((n /= 10) % 10);
        reverse = reverse * 10 + ((n /= 10) % 10);
        reverse = reverse * 10 + ((n /= 10) % 10);
        reverse = reverse * 10 + ((n /= 10) % 10);
        reverse = reverse * 10 + ((n / 10) % 10);
        return reverse;
    }
}