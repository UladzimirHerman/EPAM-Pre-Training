package com.gmail.herman.uladzimir.project.model.functional;

import com.gmail.herman.uladzimir.project.model.enumeration.PersonName;
import com.gmail.herman.uladzimir.project.model.enumeration.PersonSurname;

import java.util.Random;

public class PersonInitializer {

    private static final int MIN_AGE = 20;
    private static final int MAX_AGE = 35;

    public static String initializeName() {
        Random random = new Random();
        int names = PersonName.values().length;
        int name = random.nextInt(names);
        String result = "";

        for (PersonName personName : PersonName.values()) {
            if (name == personName.ordinal()) {
                result = personName.name();
            }
        }

        return result;
    }

    public static String initializeSurname() {
        Random random = new Random();
        int surnames = PersonSurname.values().length;
        int surname = random.nextInt(surnames);
        String result = "";

        for (PersonSurname personSurname : PersonSurname.values()) {
            if (surname == personSurname.ordinal()) {
                result = personSurname.name();
            }
        }

        return result;
    }

    public static int initializeAge() {
        return MIN_AGE + new Random().nextInt(MAX_AGE - MIN_AGE + 1);
    }

}