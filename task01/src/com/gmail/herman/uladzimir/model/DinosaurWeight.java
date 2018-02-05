package com.gmail.herman.uladzimir.model;

public class DinosaurWeight {
    public static final double GRAM_IN_KILO = 1000.;
    public static final double GRAM_IN_TON = 1_000_000.;

    public static double convertToKilo(int gram) {
        return gram / GRAM_IN_KILO;
    }

    public static double convertToTon(int gram) {
        return gram / GRAM_IN_TON;
    }
}