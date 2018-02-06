package com.gmail.herman.uladzimir.controller;

import com.gmail.herman.uladzimir.model.*;
import com.gmail.herman.uladzimir.view.View;

public class StartTask {
    public static void main(String[] args) {

        //first Task DragonHead
        int years = 5;
        View.print("Dragon years: " + years +
                ", heads: " + DragonHead.countHeads(years) +
                ", eyes: " + DragonHead.countEyes(DragonHead.countHeads(years)));

        //second Task DefineCharacter
        char ch = DefineCharacter.getCharacter();
        View.print("Way 1. Vowel: " + DefineCharacter.isVowelOne(ch) +
                "\nWay 2. Vowel: " + DefineCharacter.isVowelTwo(ch) +
                "\nWay 3. Vowel: " + DefineCharacter.isVowelThree(ch) +
                "\nWay 4. Vowel: " + DefineCharacter.isVowelFour(ch));

        //third Task Mood
        View.print("Your mood: " + Mood.getMood());

        //fourth Task NextDate
        int day = 31, month = 1, year = 2018;
        View.print("Next date: " + NextDate.getNextDate(day, month, year));

        //fifth Task NumberInWords
        int n = NumberInWords.getNumber();
        View.print(n + " -" + NumberInWords.getNumberAsWord(n));

    }
}