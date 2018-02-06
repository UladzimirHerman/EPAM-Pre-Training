package com.gmail.herman.uladzimir.model;

public class DragonHead {
    public static final int AGE_OF_FIRST_SLOWDOWN = 200;
    public static final int AGE_OF_SECOND_SLOWDOWN = 300;
    public static final int FAST_GROWTH = 3;
    public static final int NORMAL_GROWTH = 2;
    public static final int SLOW_GROWTH = 1;

    private static boolean isAlive(int years) {
        return years > 0;
    }

    public static int countHeads(int years) {
        int heads = 0;

        if (isAlive(years)) {
            if (years < AGE_OF_FIRST_SLOWDOWN) {
                heads = FAST_GROWTH * years;
            } else if (years > AGE_OF_SECOND_SLOWDOWN) {
                heads = AGE_OF_FIRST_SLOWDOWN * FAST_GROWTH +
                        AGE_OF_SECOND_SLOWDOWN * NORMAL_GROWTH - AGE_OF_FIRST_SLOWDOWN * NORMAL_GROWTH -
                        AGE_OF_SECOND_SLOWDOWN * SLOW_GROWTH + years * SLOW_GROWTH;
            } else {
                heads = AGE_OF_FIRST_SLOWDOWN * FAST_GROWTH -
                        AGE_OF_FIRST_SLOWDOWN * NORMAL_GROWTH + years * NORMAL_GROWTH;
            }
        }

        return heads;
    }

    public static int countEyes(int heads) {
        return heads > 0 ? heads * 2 : 0;
    }

}