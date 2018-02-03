package com.gmail.herman.uladzimir;

public class T0101DinosaurWeight {
    public static final double GRAM_IN_KILO = 1000.;
    public static final double GRAM_IN_TON = 1_000_000.;

    public static void main(String[] args) {
        int gram = 2_572_436;
        double kilo = convertToKilo(gram);
        double ton = convertToTon(gram);
        System.out.println("grams: " + gram + ", kilos: " + kilo + ", tons: " + ton);
    }

    static double convertToKilo(int gram) {
        return gram / GRAM_IN_KILO;
    }

    static double convertToTon(int gram) {
        return gram / GRAM_IN_TON;
    }
}