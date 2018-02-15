package com.gmail.herman.uladzimir.model;

import com.gmail.herman.uladzimir.model.exception.NumberIsNullException;
import com.gmail.herman.uladzimir.model.util.NumberUtil;

public class NumberInPower {

    public static double countNumberInPowerRecursively(double number, int power) throws NumberIsNullException {

        if (NumberUtil.isNotNullNumber(number)) {

            if (Math.abs(power) > 1) {
                return power > 1 ? number * countNumberInPowerRecursively(number, power - 1) :
                        1 / number * 1 / countNumberInPowerRecursively(number, Math.abs(power) - 1);
            } else {
                return power == 0 ? 1 : power == 1 ? number : 1 / number;
            }

        } else {
            throw new NumberIsNullException("NumberInPower.countNumberInPowerRecursively");
        }

    }

    public static double countNumberInPowerIteratively(double number, int power) throws NumberIsNullException {

        if (NumberUtil.isNotNullNumber(number)) {
            int powerAbs = Math.abs(power);

            if (powerAbs > 1) {

                double result = 1;
                for (int i = 0; i < powerAbs; i++) {
                    result *= number;
                }
                return power > 1 ? result : 1 / result;

            } else {
                return power == 0 ? 1 : power == 1 ? number : 1 / number;
            }

        } else {
            throw new NumberIsNullException("NumberInPower.countNumberInPowerIteratively");
        }

    }

}