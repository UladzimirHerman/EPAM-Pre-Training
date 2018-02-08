package com.gmail.herman.uladzimir.model;

import com.gmail.herman.uladzimir.model.exception.NumberNotNaturalException;
import com.gmail.herman.uladzimir.model.util.NumberUtil;

import java.util.Random;

public class Coin {

    public static int countHeads(int number) throws NumberNotNaturalException {
        int heads = 0;

        if (NumberUtil.isNaturalNumber(number)) {
            Random random = new Random();

            for (int i = 0; i < number; i++) {
                if (random.nextBoolean()) {
                    heads++;
                }
            }

        } else {
            throw new NumberNotNaturalException("Coin.countHeads");
        }

        return heads;
    }

}