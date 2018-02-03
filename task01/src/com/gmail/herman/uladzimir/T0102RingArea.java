package com.gmail.herman.uladzimir;

public class T0102RingArea {
    public static void main(String[] args) {
        int radius1 = 3, radius2 = 2;
        double result = findRingArea(radius1, radius2);
        System.out.println("Area of the ring: " + result);
    }

    static double findRingArea (int radius1, int radius2){
        return findCircleArea(radius1) - findCircleArea(radius2);
    }

    static double findCircleArea (int radius){
        return Math.PI * Math.pow(radius, 2);
    }
}