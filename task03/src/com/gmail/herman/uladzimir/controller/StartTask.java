package com.gmail.herman.uladzimir.controller;

import com.gmail.herman.uladzimir.model.Coin;
import com.gmail.herman.uladzimir.model.NumberWorker;
import com.gmail.herman.uladzimir.model.PerfectNumber;
import com.gmail.herman.uladzimir.model.exception.NumberNotNaturalException;
import com.gmail.herman.uladzimir.view.View;

public class StartTask {
    public static void main(String[] args) {

        //first Task Coin
        try {
            int num = 1000;
            int heads = Coin.countHeads(num);
            View.print(num + " coin throws: heads=" + heads +
                    ", tails=" + (num - heads));
        } catch (NumberNotNaturalException e) {
            View.print(e.getMessage());
        }

        //second Task NumberWorker
        //2.1
        try {
            int num = 217;
            View.print("The largest number in " + num + ": " +
                    NumberWorker.getBigNumber(num));
        } catch (NumberNotNaturalException e) {
            View.print(e.getMessage());
        }

        //2.2
        try {
            int num = 151;
            View.print(num + " is palindrome: " + NumberWorker.isPalindromeNumber(num));
        } catch (NumberNotNaturalException e) {
            View.print(e.getMessage());
        }

        //2.3
        try {
            int num = 59;
            View.print(num + " is simple: " + NumberWorker.isSimpleNumber(num));
        } catch (NumberNotNaturalException e) {
            View.print(e.getMessage());
        }

        //2.4
        try {
            int num = 24;
            View.print("All simple dividers of " + num + ": " +
                    NumberWorker.getAllSimpleDividers(num));
        } catch (NumberNotNaturalException e) {
            View.print(e.getMessage());
        }

        //2.5
        try {
            int numOne = 16, numTwo = 22;
            View.print(numOne + " and " + numTwo +
                    ": GCD=" + NumberWorker.getGreatestCommonDivisor(numOne, numTwo) +
                    ", LCM=" + NumberWorker.getLeastCommonMultiple(numOne, numTwo));
        } catch (NumberNotNaturalException e) {
            View.print(e.getMessage());
        }

        //2.6
        try {
            int num = 1992;
            View.print("Different numbers of " + num + ": " +
                    NumberWorker.countDifferentNumber(num));
        } catch (NumberNotNaturalException e) {
            View.print(e.getMessage());
        }

        //third Task PerfectNumber
        try {
            int num = 8128;
            View.print(num + " is perfect number: " + PerfectNumber.isPerfectNumber(num));
        } catch (NumberNotNaturalException e) {
            View.print(e.getMessage());
        }

    }
}