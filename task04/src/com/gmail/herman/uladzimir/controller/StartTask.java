package com.gmail.herman.uladzimir.controller;

import com.gmail.herman.uladzimir.model.*;
import com.gmail.herman.uladzimir.model.exception.NumberIsNullException;
import com.gmail.herman.uladzimir.model.exception.NumberNotNaturalException;
import com.gmail.herman.uladzimir.model.exception.NumberNotPositiveException;
import com.gmail.herman.uladzimir.view.View;

public class StartTask {
    public static void main(String[] args) {

        //first Task SumDigits
        try {
            int num = 214;
            View.print("Sum of digits of " + num + " recursively: " +
                    SumDigits.findSumDigitsRecursively(num));
            View.print("Sum of digits of " + num + " iteratively: " +
                    SumDigits.findSumDigitsIteratively(num));
        } catch (NumberNotNaturalException e) {
            View.print(e.getMessage());
        }

        //second Task NumberInPower
        try {
            double num = 1.5;
            int pow = 2;
            View.print("pow(" + num + ", " + pow + ") recursively: " +
                    NumberInPower.countNumberInPowerRecursively(num, pow));
            View.print("pow(" + num + ", " + pow + ") iteratively: " +
                    NumberInPower.countNumberInPowerIteratively(num, pow));
        } catch (NumberIsNullException e) {
            View.print(e.getMessage());
        }

        //third Task EqualNumber
        try {
            int numOne = 28, numTwo = 10;
            View.print("equals(" + numOne + ", " + numTwo + ") recursively: " +
                    EqualNumber.checkEqualityRecursively(numOne, numTwo));
            View.print("equals(" + numOne + ", " + numTwo + ") iteratively: " +
                    EqualNumber.checkEqualityIteratively(numOne, numTwo));
        } catch (NumberNotPositiveException e) {
            View.print(e.getMessage());
        }

        //fourth Task FibonacciNumber
        try {
            int num = 11;
            View.print(num + " Fibonacci number recursively: " +
                    FibonacciNumber.findFibonacciNumberRecursively(num));
            View.print(num + " Fibonacci number iteratively: " +
                    FibonacciNumber.findFibonacciNumberIteratively(num));
        } catch (NumberNotNaturalException e) {
            View.print(e.getMessage());
        }

        //fifth Task HanoiTower
        try {
            int num = 3;
            String start = "A", buffer = "B", end = "C";
            View.print("Tower of Hanoi (" + num + " discs) recursively: " +
                    HanoiTower.solveTowerRecursively(num, start, buffer, end));
            View.print("Tower of Hanoi (" + num + " discs) iteratively: " +
                    HanoiTower.solveTowerIteratively(num, start, buffer, end));
        } catch (NumberNotNaturalException e) {
            View.print(e.getMessage());
        }

    }
}