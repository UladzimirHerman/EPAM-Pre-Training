package com.gmail.herman.uladzimir.model;

import com.gmail.herman.uladzimir.model.exception.NumberNotPositiveException;
import com.gmail.herman.uladzimir.model.util.NumberUtil;

public class EqualNumber {

    public static boolean checkEqualityRecursively(int numberOne, int numberTwo) throws NumberNotPositiveException {

        if (NumberUtil.isPositiveNumber(numberOne) && NumberUtil.isPositiveNumber(numberTwo)) {
            return NumberUtil.countSumDigitsRecursively(numberOne) == numberTwo;
        } else {
            throw new NumberNotPositiveException("EqualNumber.checkEqualityRecursively");
        }

    }

    public static boolean checkEqualityIteratively(int numberOne, int numberTwo) throws NumberNotPositiveException {

        if (NumberUtil.isPositiveNumber(numberOne) && NumberUtil.isPositiveNumber(numberTwo)) {
            return NumberUtil.countSumDigitsIteratively(numberOne) == numberTwo;
        } else {
            throw new NumberNotPositiveException("EqualNumber.checkEqualityIteratively");
        }

    }

}