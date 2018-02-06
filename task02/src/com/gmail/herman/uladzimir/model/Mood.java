package com.gmail.herman.uladzimir.model;

import java.util.Random;

public class Mood {

    public static final int NUMBER_OF_MOODS = 5;
    public static final String JOYFUL_MOOD = "<(￣︶￣)>";
    public static final String LOVELY_MOOD = "(◕‿◕)♡";
    public static final String EMBARRASSED_MOOD = "(⌒_⌒;)";
    public static final String CURIOUS_MOOD = "ლ(ಠ_ಠ ლ)";
    public static final String INDIFFERENCE_MOOD = "¯\\_(ツ)_/¯";
    public static final String UNDEFINED_MOOD = "Sorry, mood isn't defined";

    public static String getMood() {
        String mood;

        switch (new Random().nextInt(NUMBER_OF_MOODS)) {
            case 0:
                mood = JOYFUL_MOOD;
                break;
            case 1:
                mood = LOVELY_MOOD;
                break;
            case 2:
                mood = EMBARRASSED_MOOD;
                break;
            case 3:
                mood = CURIOUS_MOOD;
                break;
            case 4:
                mood = INDIFFERENCE_MOOD;
                break;
            default:
                mood = UNDEFINED_MOOD;
                break;
        }

        return mood;
    }

}