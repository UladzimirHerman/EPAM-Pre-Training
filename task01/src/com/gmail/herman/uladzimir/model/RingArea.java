package com.gmail.herman.uladzimir.model;

public class RingArea {

    public static double findRingArea (int radius1, int radius2){
        return findCircleArea(radius1) - findCircleArea(radius2);
    }

    public static double findCircleArea (int radius){
        return Math.PI * Math.pow(radius, 2);
    }
}