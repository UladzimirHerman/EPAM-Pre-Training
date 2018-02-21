package com.gmail.herman.uladzimir.model;

import com.gmail.herman.uladzimir.model.exception.NumberNotNaturalException;
import com.gmail.herman.uladzimir.model.util.NumberUtil;


public class SumDigits {

    public static int countSumDigitsRecursively(int number) throws NumberNotNaturalException {

        if (NumberUtil.isNaturalNumber(number)) {
            return number >= 10 ?
                    number % 10 + countSumDigitsRecursively(number / 10) : number;
        } else {
            throw new NumberNotNaturalException("SumDigits.countSumDigitsRecursively");
        }

    }

    public static int countSumDigitsIteratively(int number) throws NumberNotNaturalException {

        if (NumberUtil.isNaturalNumber(number)) {
            int sum = 0, numberDigits = (int) Math.ceil(Math.log10(number) + 0.5);

            for (int i = 0; i < numberDigits; i++) {
                sum += number % 10;
                number /= 10;
            }

            return sum;
        } else {
            throw new NumberNotNaturalException("SumDigits.countSumDigitsIteratively");
        }

    }

}