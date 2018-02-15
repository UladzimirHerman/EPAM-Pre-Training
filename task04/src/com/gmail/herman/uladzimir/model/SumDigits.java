package com.gmail.herman.uladzimir.model;

import com.gmail.herman.uladzimir.model.exception.NumberNotNaturalException;
import com.gmail.herman.uladzimir.model.util.NumberUtil;


public class SumDigits {

    public static int findSumDigitsRecursively(int number) throws NumberNotNaturalException {

        if (NumberUtil.isNaturalNumber(number)) {
            return NumberUtil.countSumDigitsRecursively(number);
        } else {
            throw new NumberNotNaturalException("SumDigits.findSumDigitsRecursively");
        }

    }

    public static int findSumDigitsIteratively(int number) throws NumberNotNaturalException {

        if (NumberUtil.isNaturalNumber(number)) {
            return NumberUtil.countSumDigitsIteratively(number);
        } else {
            throw new NumberNotNaturalException("SumDigits.findSumDigitsIteratively");
        }

    }

}