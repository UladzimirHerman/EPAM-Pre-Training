package com.gmail.herman.uladzimir.controller;

import com.gmail.herman.uladzimir.model.*;
import com.gmail.herman.uladzimir.view.View;

public class StartTask {
    public static void main(String[] args) {

        //first Task DinosaurWeight
        int gram = 2_572_436;
        View.print("Dinosaur weight in grams: " + gram +
                ", kilos: " + DinosaurWeight.convertToKilo(gram) +
                ", tons: " + DinosaurWeight.convertToTon(gram));

        //second Task RingArea
        int radius1 = 3, radius2 = 2;
        View.print("Area of the ring: " + RingArea.findRingArea(radius1, radius2));

        //third Task InterchangeNumber
        int a = 28, b = 17;
        View.print("After exchange: " + InterchangeNumber.exchangeNumber(a, b));

        //fourth Task Sequence
        int numSequence = 9741;
        View.print("Sequence in " + numSequence + ": " + Sequence.isSequence(numSequence));

        //fifth Task SumAndMultiply
        int numSumMult = 42123;
        View.print("Work with " + numSumMult +
                ": sum=" + SumAndMultiply.getSum(numSumMult) +
                ", multiply=" + SumAndMultiply.getMult(numSumMult));

        //sixth Task AverageNumber
        int numAverage = 123456;
        View.print("Work with " + numAverage +
                ": arithmetic=" + AverageNumber.getArithmetic(numAverage) +
                ", geometric=" + AverageNumber.getGeometric(numAverage));

        //seventh Task ReverseNumber
        int numReverse = 1234567;
        View.print(numReverse + " has reverse " + ReverseNumber.getReverse(numReverse));

    }
}