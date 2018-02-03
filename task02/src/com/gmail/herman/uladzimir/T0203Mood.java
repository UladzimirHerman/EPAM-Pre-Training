package com.gmail.herman.uladzimir;

public class T0203Mood {
    public static void main(String[] args) {
        showMood((int) (Math.random() * 10) + 1);
    }

    static void showMood(int rand) {

        switch (rand) {
            case 1:
                System.out.println("(◕‿◕)♡");
                break;
            case 2:
                System.out.println("(⌒_⌒;)");
                break;
            case 3:
                System.out.println("<(￣︶￣)>");
                break;
            case 4:
                System.out.println("(￣ヘ￣)");
                break;
            case 5:
                System.out.println("٩(ఠ益ఠ)۶");
                break;
            case 6:
                System.out.println("(｡╯︵╰｡)");
                break;
            case 7:
                System.out.println("(×﹏×)");
                break;
            case 8:
                System.out.println("＼(〇_ｏ)／");
                break;
            case 9:
                System.out.println("¯\\_(ツ)_/¯");
                break;
            case 10:
                System.out.println("ლ(ಠ_ಠ ლ)");
                break;
            default:
                System.out.println("Mood isn't defined");
                break;
        }

    }
}