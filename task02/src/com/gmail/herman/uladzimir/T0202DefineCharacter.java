package com.gmail.herman.uladzimir;

import java.util.Scanner;

public class T0202DefineCharacter {
    public static void main(String[] args) {
        char ch = getCharacter();
        workWithCharacter(ch);
    }

    static char getCharacter() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the character [a-Z]: ");
        char ch = '0';

        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.length() == 1) {
                char temp = Character.toLowerCase(input.toCharArray()[0]);
                if (temp > 96 && temp < 123)
                    ch = temp;
            }
        }

        return ch;
    }

    static void workWithCharacter(char ch){

        if (ch != '0') {
            printResult(isVowelOne(ch));
            printResult(isVowelTwo(ch));
            printResult(isVowelThree(ch));
            printResult(isVowelFour(ch));
            printResult(isVowelFive(ch));
            printResult(isVowelSix(ch));
        } else {
            System.out.println("Sorry, I don't work with incorrect data...");
        }

    }

    static boolean isVowelOne(char ch) {
        boolean vowel = false;

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

        return vowel;
    }

    static boolean isVowelTwo(char ch) {
        boolean vowel = false;

        if (ch == 'a') {
            vowel = true;
        } else if (ch == 'e') {
            vowel = true;
        } else if (ch == 'i') {
            vowel = true;
        } else if (ch == 'o') {
            vowel = true;
        } else if (ch == 'u') {
            vowel = true;
        } else if (ch == 'y') {
            vowel = true;
        }

        return vowel;
    }

    static boolean isVowelThree(char ch) {
        String vowels = "aeiouy";
        return vowels.contains(ch + "");
    }

    static boolean isVowelFour(char ch) {
        String vowels = "aeiouy";
        return vowels.indexOf(ch + "") >= 0 && vowels.indexOf(ch + "") < 6;
    }

    static boolean isVowelFive(char ch) {
        String vowels = "97, 101, 105, 111, 117, 121";
        return vowels.contains((int) ch + "");
    }

    static boolean isVowelSix(char ch) {
        return ch == 97 || ch == 101 || ch == 105 || ch == 111 ||
                ch == 117 || ch == 121 ? true : false;
    }

    static void printResult(boolean vowel){
        if(vowel) {
            System.out.println("This is a vowel");
        } else {
            System.out.println("This is a consonant");
        }
    }
}


