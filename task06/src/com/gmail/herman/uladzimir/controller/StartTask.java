package com.gmail.herman.uladzimir.controller;

import com.gmail.herman.uladzimir.model.Palindrome;
import com.gmail.herman.uladzimir.model.exception.StackIsEmptyException;
import com.gmail.herman.uladzimir.model.exception.StackIsFullException;
import com.gmail.herman.uladzimir.view.View;

public class StartTask {
    public static void main(String[] args) {

        try {
            Palindrome palindrome = new Palindrome();
            String string = "727";
            View.print(string + " is palindrome: " + palindrome.checkString(string));
        } catch (StackIsFullException | StackIsEmptyException e) {
            View.print(e.getMessage());
        }

    }
}