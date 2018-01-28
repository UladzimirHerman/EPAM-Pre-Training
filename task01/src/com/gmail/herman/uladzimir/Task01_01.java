package com.gmail.herman.uladzimir;

public class Task01_01 {
    public static void main(String[] args) {
        int weight_gr = 2_572_436;
        float weight_kg = (float) weight_gr / 1000;
        float weight_tn = (float) weight_gr / 1000_000;

        System.out.println("grams: " + weight_gr + ", kilograms: " + weight_kg + ", tons: " + weight_tn);
    }
}