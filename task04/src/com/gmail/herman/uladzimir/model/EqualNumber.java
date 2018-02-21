package com.gmail.herman.uladzimir.model;

import com.gmail.herman.uladzimir.model.exception.NumberNotPositiveException;
import com.gmail.herman.uladzimir.model.util.NumberUtil;

public class EqualNumber {

    public static boolean checkEqualityRecursively(int numberOne, int numberTwo)
            throws NumberNotPositiveException {

        if (NumberUtil.isPositiveNumber(numberOne) && NumberUtil.isPositiveNumber(numberTwo)) {
            int newNumberOne = numberOne / 10, newNumberTwo = numberTwo - numberOne % 10;

            if (newNumberOne > 0 && newNumberTwo > 0) {
                return checkEqualityRecursively(newNumberOne, newNumberTwo);
            }

            return numberOne == numberTwo;
        } else {
            throw new NumberNotPositiveException("EqualNumber.checkEqualityRecursively");
        }

    }

    public static boolean checkEqualityIteratively(int numberOne, int numberTwo)
            throws NumberNotPositiveException {

        if (NumberUtil.isPositiveNumber(numberOne) && NumberUtil.isPositiveNumber(numberTwo)) {
            int numberDigits = (int) Math.ceil(Math.log10(numberOne) + 0.5);

            for (int i = 0; i < numberDigits; i++) {
                numberTwo -= numberOne % 10;
                numberOne /= 10;
            }

            return numberOne == numberTwo;
        } else {
            throw new NumberNotPositiveException("EqualNumber.checkEqualityIteratively");
        }

    }

}