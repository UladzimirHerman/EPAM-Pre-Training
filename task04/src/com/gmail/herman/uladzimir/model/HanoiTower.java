package com.gmail.herman.uladzimir.model;

import com.gmail.herman.uladzimir.model.exception.NumberNotNaturalException;
import com.gmail.herman.uladzimir.model.util.NumberUtil;

public class HanoiTower {

    public static String solveTowerRecursively(int number, String start, String buffer, String end)
            throws NumberNotNaturalException {

        if (NumberUtil.isNaturalNumber(number)) {
            String result = "";

            if (number != 1) {
                result += solveTowerRecursively(number - 1, start, end, buffer);
                result += start + "-->" + end + " ";
                result += solveTowerRecursively(number - 1, buffer, start, end);
            } else {
                result += start + "-->" + end + " ";
            }

            return result;
        } else {
            throw new NumberNotNaturalException("HanoiTower.solveTowerRecursively");
        }

    }

    public static String solveTowerIteratively(int number, String start, String buffer, String end)
            throws NumberNotNaturalException {

        if (NumberUtil.isNaturalNumber(number)) {
            String result = "";

            //number of iterations for solving the problem
            int iteration = (int) Math.pow(2, number) - 1;

            for (int i = 0; i < iteration; i++) {

                //determine the disk to move
                int disk, a = i + 1;
                for (disk = 0; a % 2 == 0; disk++) {
                    a /= 2;
                }

                //how many times disk is moved before stage i
                int movements = ((i >> disk) + 1) >> 1;

                //disk always moves in the same direction, clockwise=1, counterclockwise=2
                int way = 2 - (3 + disk) % 2;

                //tower, where disk is now
                int source = movements * way % 3;

                //tower, where disk will move
                int destination = (source + way) % 3;

                result += renameRod(source, start, buffer, end) + "-->" +
                        renameRod(destination, start, buffer, end) + " ";

            }

            return result;
        } else {
            throw new NumberNotNaturalException("HanoiTower.solveTowerIteratively");
        }

    }

    private static String renameRod(int number, String start, String buffer, String end) {
        String name = "";

        switch (number) {
            case 0:
                name = start;
                break;
            case 1:
                name = end;
                break;
            case 2:
                name = buffer;
                break;
        }

        return name;
    }

}