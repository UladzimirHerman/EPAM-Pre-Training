package com.gmail.herman.uladzimir.model;

import com.gmail.herman.uladzimir.model.exception.NumberNotNaturalException;
import com.gmail.herman.uladzimir.model.util.NumberUtil;

public class NumberWorker {

    public static int getBigNumber(int number) throws NumberNotNaturalException {
        int bigNum = 0;

        if (NumberUtil.isNaturalNumber(number)) {
            int numberDigits = (int) Math.ceil(Math.log10(number) + 0.5);

            for (int i = 0; i < numberDigits; i++) {
                if (bigNum < number % 10) {
                    bigNum = number % 10;
                }
                number /= 10;
            }

        } else {
            throw new NumberNotNaturalException("NumberWorker.getBigNumber");
        }

        return bigNum;
    }

    public static boolean isPalindromeNumber(int number) throws NumberNotNaturalException {
        return number == getReverseNumber(number);
    }

    private static int getReverseNumber(int number) throws NumberNotNaturalException {
        int reverse = 0;

        if (NumberUtil.isNaturalNumber(number)) {
            int numberDigits = (int) Math.ceil(Math.log10(number));

            if (numberDigits == 0) {
                reverse = number;
            } else {
                for (int i = 0; i < numberDigits; i++) {
                    reverse += (number % 10) * (int) Math.pow(10, numberDigits - 1 - i);
                    number /= 10;
                }
            }

        } else {
            throw new NumberNotNaturalException("NumberWorker.getReverseNumber");
        }

        return reverse;
    }

    public static boolean isSimpleNumber(int number) throws NumberNotNaturalException {
        return countDivider(number) == 2;
    }

    private static int countDivider(int number) throws NumberNotNaturalException {
        int count = 0;

        if (NumberUtil.isNaturalNumber(number)) {

            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    count++;
                }
            }

        } else {
            throw new NumberNotNaturalException("NumberWorker.countDivider");
        }

        return count;
    }

    public static String getAllSimpleDividers(int number) throws NumberNotNaturalException {
        String listNum = "";

        if (NumberUtil.isNaturalNumber(number)) {

            for (int i = 2; i <= number; i++) {
                if (number % i == 0 && isSimpleNumber(i)) {
                    listNum += i + " ";
                }
            }

        } else {
            throw new NumberNotNaturalException("NumberWorker.getAllSimpleDividers");
        }

        return listNum;
    }

    public static int getGreatestCommonDivisor(int numberOne, int numberTwo) throws NumberNotNaturalException {
        int divisor;

        if (NumberUtil.isNaturalNumber(numberOne) && NumberUtil.isNaturalNumber(numberTwo)) {

            while (numberTwo != 0) {
                int temp = numberOne % numberTwo;
                numberOne = numberTwo;
                numberTwo = temp;
            }

            divisor = numberOne;
        } else {
            throw new NumberNotNaturalException("NumberWorker.getGreatestCommonDivisor");
        }

        return divisor;
    }

    public static int getLeastCommonMultiple(int numberOne, int numberTwo) throws NumberNotNaturalException {
        int multiply;

        if (NumberUtil.isNaturalNumber(numberOne) && NumberUtil.isNaturalNumber(numberTwo)) {
            multiply = numberOne * numberTwo;

            for (int i = 2; i <= multiply; i++) {
                if (i % numberOne == 0 && i % numberTwo == 0) {
                    multiply = i;
                }
            }

        } else {
            throw new NumberNotNaturalException("NumberWorker.getLeastCommonMultiple");
        }

        return multiply;
    }

    public static int countDifferentNumber(int number) throws NumberNotNaturalException {
        int count;

        if (NumberUtil.isNaturalNumber(number)) {
            int numberDigits = (int) Math.ceil(Math.log10(number));
            String strDigits = "";

            if (numberDigits == 0) {
                count = number;
            } else {
                for (int i = 0; i < numberDigits; i++) {
                    if (!strDigits.contains(number % 10 + "")) {
                        strDigits += number % 10 + "";
                    }
                    number /= 10;
                }

                count = strDigits.length();
            }

        } else {
            throw new NumberNotNaturalException("NumberWorker.countDifferentNumber");
        }

        return count;
    }

}