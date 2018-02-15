package com.gmail.herman.uladzimir.model.util;

public class NumberUtil {

    public static boolean isNaturalNumber(int number) {
        return number > 0;
    }

    public static boolean isNotNullNumber(double number) {
        return number != 0;
    }

    public static boolean isPositiveNumber(int number) {
        return number > -1;
    }

    public static int countSumDigitsRecursively(int number) {
        return number >= 10 ? number % 10 + countSumDigitsRecursively(number / 10) : number;
    }

    public static int countSumDigitsIteratively(int number) {
        int sum = 0, numberDigits = (int) Math.ceil(Math.log10(number) + 0.5);

        for (int i = 0; i < numberDigits; i++) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

}