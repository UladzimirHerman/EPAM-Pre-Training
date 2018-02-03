package com.gmail.herman.uladzimir;

public class T0204NextDate {
    public static void main(String[] args) {
        int day = 31, month = 1, year = 2018;
        workWithDate(day, month, year);
    }

    static void workWithDate(int day, int month, int year) {

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

            printDate(day, month, year);

        } else {
            System.out.println("Sorry, I don't work with incorrect data...");
        }

    }

    static boolean isCorrectDate(int day, int month, int year) {
        boolean correct = false;

        if (day > 0 && day < 32 && month > 0 && month < 13 && year > 0) {

            if (month == 2) {
                boolean leapYear = isLeapYear(year);
                if (day < 29 || (leapYear && day == 29)) {
                    correct = true;
                }
            } else if (day < 31) {
                correct = true;
            } else if (month == 1 || month == 3 || month == 5 || month == 7 ||
                    month == 8 || month == 10 || month == 12) {
                correct = true;
            }

        }

        return correct;
    }

    static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || (year % 100 == 0 && year % 400 == 0));
    }

    static void printDate(int day, int month, int year) {
        System.out.println("Next date: " + day + "/" + month + "/" + year);
    }
}
