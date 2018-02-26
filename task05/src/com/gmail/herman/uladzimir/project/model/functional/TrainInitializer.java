package com.gmail.herman.uladzimir.project.model.functional;

import com.gmail.herman.uladzimir.project.model.enumeration.City;
import com.gmail.herman.uladzimir.project.model.enumeration.FreightWagonType;
import com.gmail.herman.uladzimir.project.model.enumeration.PassengerWagonType;

import java.util.Random;

public class TrainInitializer {

    private static final int MIN_TRAIN_NUMBER = 1000;
    private static final int MAX_TRAIN_NUMBER = 9999;
    private static final int MIN_QUANTITY_WAGONS = 10;
    private static final int MAX_QUANTITY_WAGONS = 30;
    private static final double MIN_WEIGHT_PASSENGER_WAGON = 54.4;
    private static final double MAX_WEIGHT_PASSENGER_WAGON = 57;
    private static final double MIN_WEIGHT_FREIGHT_WAGON = 64.8;
    private static final double MAX_WEIGHT_FREIGHT_WAGON = 67.5;
    private static final double LENGTH_PASSENGER_WAGON_OLD_TYPE = 19.4;
    private static final double LENGTH_PASSENGER_WAGON_NEW_TYPE = 21.2;
    private static final double LENGTH_FREIGHT_WAGON_OLD_TYPE = 13.7;
    private static final double LENGTH_FREIGHT_WAGON_NEW_TYPE = 14.5;
    private static final int CAPACITY_CLASS_A = 40;
    private static final int CAPACITY_CLASS_B = 56;
    private static final int MIN_TICKET_PRICE = 5;
    private static final int MAX_TICKET_PRICE = 10;
    private static final int MIN_PERCENT_FILLING_WAGONS = 60;

    public static String initializeNumTrain() {
        Random random = new Random();
        String strChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return (MIN_TRAIN_NUMBER + random.nextInt(MAX_TRAIN_NUMBER - MIN_TRAIN_NUMBER)) +
                "" + strChar.charAt(random.nextInt(strChar.length()));
    }

    public static String initializeRoute() {
        Random random = new Random();
        int numCity = City.values().length;
        int startCityCode = random.nextInt(numCity),
                finishCityCode = random.nextInt(numCity);

        while (startCityCode == finishCityCode) {
            finishCityCode = random.nextInt(numCity);
        }

        String start = "", finish = "";
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

    public static PassengerWagonType initializePassengerWagonType() {
        return new Random().nextBoolean() ?
                PassengerWagonType.BUSINESS : PassengerWagonType.ECONOMY;
    }

    public static FreightWagonType initializeFreightWagonType() {
        return new Random().nextBoolean() ?
                FreightWagonType.COVERED_AND_GONDOLA : FreightWagonType.HOPPERS_AND_CISTERNS;
    }

    public static int initializeQuantityWagons() {
        return MIN_QUANTITY_WAGONS +
                new Random().nextInt(MAX_QUANTITY_WAGONS - MIN_QUANTITY_WAGONS + 1);
    }

    public static double initializePassengerWagonWeight() {
        return MIN_WEIGHT_PASSENGER_WAGON +
                (new Random().nextInt((int) ((MAX_WEIGHT_PASSENGER_WAGON -
                        MIN_WEIGHT_PASSENGER_WAGON) * 10) + 1) / 10);
    }

    public static double initializeFreightWagonWeight() {
        return MIN_WEIGHT_FREIGHT_WAGON +
                (new Random().nextInt((int) ((MAX_WEIGHT_FREIGHT_WAGON -
                        MIN_WEIGHT_FREIGHT_WAGON) * 10) + 1) / 10);
    }

    public static double initializePassengerWagonLength() {
        return new Random().nextBoolean() ?
                LENGTH_PASSENGER_WAGON_OLD_TYPE : LENGTH_PASSENGER_WAGON_NEW_TYPE;
    }

    public static double initializeFreightWagonLength() {
        return new Random().nextBoolean() ?
                LENGTH_FREIGHT_WAGON_OLD_TYPE : LENGTH_FREIGHT_WAGON_NEW_TYPE;
    }

    public static int initializePassengerWagonCapacity() {
        return new Random().nextBoolean() ?
                CAPACITY_CLASS_A : CAPACITY_CLASS_B;
    }

    public static double initializeTicketPrice() {
        return (MIN_TICKET_PRICE * 100 +
                new Random().nextInt((MAX_TICKET_PRICE - MIN_TICKET_PRICE) * 100 + 1)) / 100.;
    }

    public static double initializeFiling() {
        return (MIN_PERCENT_FILLING_WAGONS * 10 +
                new Random().nextInt((100 - MIN_PERCENT_FILLING_WAGONS) * 10) + 1) / 1000.;
    }

    public static boolean initializeDangerousGoods() {
        return new Random().nextBoolean();
    }

}