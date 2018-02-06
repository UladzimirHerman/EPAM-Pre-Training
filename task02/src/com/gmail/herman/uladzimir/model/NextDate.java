package com.gmail.herman.uladzimir.model;

public class NextDate {

    public static final int JANUARY = 1;
    public static final int FEBRUARY = 2;
    public static final int MARCH = 3;
    public static final int MAY = 5;
    public static final int JULY = 7;
    public static final int AUGUST = 8;
    public static final int OCTOBER = 10;
    public static final int DECEMBER = 12;
    public static final String ERROR_DATE = "Sorry, I don't work with incorrect data...";

    private static boolean isCorrectDate(int day, int month, int year) {
        boolean correct = false;

        if (day > 0 && day < 32 && month > 0 && month < 13 && year > 0) {

            if (month == FEBRUARY) {
                if (day < 29 || (isLeapYear(year) && day == 29)) {
                    correct = true;
                }
            } else if (day < 31) {
                correct = true;
            } else if (month == JANUARY || month == MARCH || month == MAY || month == JULY ||
                    month == AUGUST || month == OCTOBER || month == DECEMBER) {
                correct = true;
            }

        }

        return correct;
    }

    private static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || (year % 100 == 0 && year % 400 == 0));
    }

    public static String getNextDate(int day, int month, int year) {

        String result = ERROR_DATE;

        if (isCorrectDate(day, month, year)) {

            if (isCorrectDate(day + 1, month, year)) {
                day += 1;
            } else if (isCorrectDate(1, month + 1, year)) {
                day = 1;
                month += 1;
            } else {
                day = 1;
                month = 1;
                year += 1;
            }

            result = day + "/" + month + "/" + year;
        }

        return result;
    }

}