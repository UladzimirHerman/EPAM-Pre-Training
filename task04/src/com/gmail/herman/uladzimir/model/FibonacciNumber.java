package com.gmail.herman.uladzimir.model;

import com.gmail.herman.uladzimir.model.exception.NumberNotNaturalException;
import com.gmail.herman.uladzimir.model.util.NumberUtil;

public class FibonacciNumber {

    public static int findFibonacciNumberRecursively(int number) throws NumberNotNaturalException {

        if (NumberUtil.isNaturalNumber(number)) {
            return number > 2 ? findFibonacciNumberRecursively(number - 1) +
                    findFibonacciNumberRecursively(number - 2) : 1;
        } else {
            throw new NumberNotNaturalException("FibonacciNumber.findFibonacciNumberRecursively");
        }

    }

    public static int findFibonacciNumberIteratively(int number) throws NumberNotNaturalException {

        if (NumberUtil.isNaturalNumber(number)) {
            int sum = 1, nOne = 1, nTwo = 1;

            for (int i = 2; i < number; i++) {
                sum = nOne + nTwo;
                nOne = nTwo;
                nTwo = sum;
            }

            return sum;
        } else {
            throw new NumberNotNaturalException("FibonacciNumber.findFibonacciNumberIteratively");
        }

    }
}