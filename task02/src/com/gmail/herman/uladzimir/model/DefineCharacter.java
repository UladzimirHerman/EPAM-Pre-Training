package com.gmail.herman.uladzimir.model;

import java.util.Scanner;

public class DefineCharacter {

    public static final String VOWELS = "aeiouy";

    public static char getCharacter() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the character [A-z]: ");
        char ch = '0';

        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.length() == 1) {
                ch = Character.toLowerCase(input.toCharArray()[0]);
            }
        }

        return ch;
    }

    private static boolean isEnglishAlphabet(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    public static boolean isVowelOne(char ch) {
        boolean vowel = false;

        if (isEnglishAlphabet(ch)) {
            switch (ch) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'y':
                    vowel = true;
                    break;
            }
        }

        return vowel;
    }

    public static boolean isVowelTwo(char ch) {
        boolean vowel = false;

        if (isEnglishAlphabet(ch)) {
            vowel = (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y');
        }

        return vowel;
    }

    public static boolean isVowelThree(char ch) {
        boolean vowel = false;

        if (isEnglishAlphabet(ch)) {
            vowel = VOWELS.contains(ch + "");
        }

        return vowel;
    }

    public static boolean isVowelFour(char ch) {
        boolean vowel = false;

        if (isEnglishAlphabet(ch)) {
            vowel = VOWELS.indexOf(ch + "") >= 0 && VOWELS.indexOf(ch + "") < 6;
        }

        return vowel;
    }

}