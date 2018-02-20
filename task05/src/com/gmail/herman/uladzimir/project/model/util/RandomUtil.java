package com.gmail.herman.uladzimir.project.model.util;

import com.gmail.herman.uladzimir.project.model.enumeration.City;
import com.gmail.herman.uladzimir.project.model.enumeration.FreightWagonType;
import com.gmail.herman.uladzimir.project.model.enumeration.PassengerWagonType;

import java.util.Random;

public class RandomUtil {

    public static final int MIN_TRAIN_NUMBER = 1000;
    public static final int MAX_TRAIN_NUMBER = 9999;
    public static final int MIN_TICKET_PRICE = 5;
    public static final int MAX_TICKET_PRICE = 10;
    public static final int MIN_QUANTITY_WAGONS = 10;
    public static final int MAX_QUANTITY_WAGONS = 30;
    public static final int MIN_PERCENT_FILLING_WAGONS = 60;

    public static String createNumTrain() {
        Random random = new Random();
        String strChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return (MIN_TRAIN_NUMBER + random.nextInt(MAX_TRAIN_NUMBER - MIN_TRAIN_NUMBER)) +
                "" + strChar.charAt(random.nextInt(strChar.length()));
    }

    public static String createRoute() {
        Random random = new Random();
        int numCity = City.values().length;
        int startCityCode = random.nextInt(numCity),
                finishCityCode = random.nextInt(numCity);
        String start = "", finish = "";

        while (startCityCode == finishCityCode) {
            finishCityCode = random.nextInt(numCity);
        }

        for (City point : City.values()) {
            if (startCityCode == point.ordinal()) {
                start = point.name();
            }
            if (finishCityCode == point.ordinal()) {
                finish = point.name();
            }
        }

        return start + "-" + finish;
    }

    public static PassengerWagonType definePassengerWagonType() {
        return new Random().nextBoolean() ?
                PassengerWagonType.BUSINESS : PassengerWagonType.ECONOMY;
    }

    public static FreightWagonType defineFreightWagonType() {
        return new Random().nextBoolean() ?
                FreightWagonType.COVERED_AND_GONDOLA : FreightWagonType.HOPPERS_AND_CISTERNS;
    }

    public static int createQuantityWagons() {
        return MIN_QUANTITY_WAGONS +
                new Random().nextInt(MAX_QUANTITY_WAGONS - MIN_QUANTITY_WAGONS + 1);
    }

    public static double createTicketPrice() {
        return (MIN_TICKET_PRICE * 100 +
                new Random().nextInt((MAX_TICKET_PRICE - MIN_TICKET_PRICE) * 100 + 1)) / 100.;
    }

    public static double createFiling() {
        return (MIN_PERCENT_FILLING_WAGONS * 10 +
                new Random().nextInt((100 - MIN_PERCENT_FILLING_WAGONS) * 10) + 1) / 1000.;
    }

    public static boolean isDangerousGoods() {
        return new Random().nextBoolean();
    }

}