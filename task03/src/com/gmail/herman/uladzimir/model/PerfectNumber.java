package com.gmail.herman.uladzimir.model;

import com.gmail.herman.uladzimir.model.exception.NumberNotNaturalException;
import com.gmail.herman.uladzimir.model.util.NumberUtil;

public class PerfectNumber {

    public static boolean isPerfectNumber(int number) throws NumberNotNaturalException {
        return number == getSumSimpleDividers(number);
    }

    private static int getSumSimpleDividers(int number) throws NumberNotNaturalException {
        int sum = 0;

        if (NumberUtil.isNaturalNumber(number)) {

            for (int i = 1; i < number; i++) {
                if (number % i == 0) {
                    sum += i;
                }
            }

        } else {
            throw new NumberNotNaturalException("PerfectNumber.getSumSimpleDividers");
        }

        return sum;
    }

}