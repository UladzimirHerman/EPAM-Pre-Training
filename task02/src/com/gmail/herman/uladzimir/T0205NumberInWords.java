package com.gmail.herman.uladzimir;

import java.util.Scanner;

public class T0205NumberInWords {
    public static void main(String[] args) {
        int n = getNumber();
        showNumberAsWord(n);
    }

    static int getNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the natural number [1; 999]: ");
        int n = 0;

        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        }

        return n;
    }

    static void showNumberAsWord(int n) {

        if (isCorrectNumber(n)) {
            String answer = "";

            int hundreds = n / 100;
            int mod_hundreds = n % 100;
            int tens = n % 100 / 10;
            int units = n % 100 % 10;

            if (hundreds > 0) {
                answer = getWordToTen(hundreds) + " hundred";
            }

            if (mod_hundreds < 10) {
                answer += getWordToTen(mod_hundreds);
            } else if (mod_hundreds < 20) {
                answer += getWordFromTenToTwenty(mod_hundreds);
            } else {
                answer += getTensAsWord(tens);
                if (units != 0) {
                    answer += getWordToTen(units);
                }
            }

            System.out.println("This number in words:" + answer);
        } else {
            System.out.println("Sorry, i don't work with incorrect data...");
        }

    }

    static boolean isCorrectNumber(int n) {
        return n > 0 && n < 1000 ? true : false;
    }

    static String getWordToTen(int number) {
        String name = "";

        switch (number) {
            case 1:
                name = " one";
                break;
            case 2:
                name = " two";
                break;
            case 3:
                name = " three";
                break;
            case 4:
                name = " four";
                break;
            case 5:
                name = " five";
                break;
            case 6:
                name = " six";
                break;
            case 7:
                name = " seven";
                break;
            case 8:
                name = " eight";
                break;
            case 9:
                name = " nine";
                break;
        }

        return name;
    }

    static String getWordFromTenToTwenty(int number) {
        String name = "";

        switch (number) {
            case 10:
                name = " ten";
                break;
            case 11:
                name = " eleven";
                break;
            case 12:
                name = " twelve";
                break;
            case 13:
                name = " thirteen";
                break;
            case 14:
                name = " fourteen";
                break;
            case 15:
                name = " fifteen";
                break;
            case 16:
                name = " sixteen";
                break;
            case 17:
                name = " seventeen";
                break;
            case 18:
                name = " eighteen";
                break;
            case 19:
                name = " nineteen";
                break;
        }

        return name;
    }

    static String getTensAsWord(int number) {
        String name = "";

        switch (number) {
            case 2:
                name = " twenty";
                break;
            case 3:
                name = " thirty";
                break;
            case 4:
                name = " forty";
                break;
            case 5:
                name = " fifty";
                break;
            case 6:
                name = " sixty";
                break;
            case 7:
                name = " seventy";
                break;
            case 8:
                name = " eighty";
                break;
            case 9:
                name = " ninety";
                break;
        }

        return name;
    }
}
