package com.gmail.herman.uladzimir;

public class T0201DragonHead {
    public static final int AGE_OF_FIRST_SLOWDOWN = 200;
    public static final int AGE_OF_SECOND_SLOWDOWN = 300;
    public static final int FAST_GROWTH = 3;
    public static final int NORMAL_GROWTH = 2;
    public static final int SLOW_GROWTH = 1;

    public static void main(String[] args) {
        int years = 5;
        int heads = countHeads(years);
        int eyes = countEyes(heads);
        printResult(years, heads, eyes);
    }

    static boolean isAlive(int years) {
        return years > 0 ? true : false;
    }

    static int countHeads(int years) {
        int heads = 0;

        if (isAlive(years)) {
            if (years < AGE_OF_FIRST_SLOWDOWN) {
                heads = FAST_GROWTH * years;
            } else if (years > AGE_OF_SECOND_SLOWDOWN) {
                heads = AGE_OF_FIRST_SLOWDOWN * FAST_GROWTH +
                        (AGE_OF_SECOND_SLOWDOWN - AGE_OF_FIRST_SLOWDOWN) * NORMAL_GROWTH +
                        (years - AGE_OF_SECOND_SLOWDOWN) * SLOW_GROWTH;
            } else {
                heads = AGE_OF_FIRST_SLOWDOWN * FAST_GROWTH +
                        (years - AGE_OF_FIRST_SLOWDOWN) * NORMAL_GROWTH;
            }
        }

        return heads;
    }

    static int countEyes(int heads) {
        return heads > 0 ? heads * 2 : 0;
    }

    static void printResult(int years, int heads, int eyes) {

        if (isAlive(years)) {
            System.out.println("years: " + years + "\nheads: " + heads + "\neyes: " + eyes);
        } else{
            System.out.println("The dragon wasn't born yet!");
        }

    }
}