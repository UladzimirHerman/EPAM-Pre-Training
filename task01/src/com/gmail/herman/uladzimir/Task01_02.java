package com.gmail.herman.uladzimir;

public class Task01_02 {
    public static void main(String[] args) {
        int r1 = 15, r2 = 10;
        double s1 = Math.PI * Math.pow(r1, 2);
        double s2 = Math.PI * Math.pow(r2, 2);
        double s = s1 - s2;

        System.out.println("Area of the ring: " + s);
    }
}