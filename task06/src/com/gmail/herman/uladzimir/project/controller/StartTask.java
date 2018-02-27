package com.gmail.herman.uladzimir.project.controller;

import com.gmail.herman.uladzimir.project.model.Palindrome;
import com.gmail.herman.uladzimir.container.exception.StackIsEmptyException;
import com.gmail.herman.uladzimir.container.exception.StackIsFullException;
import com.gmail.herman.uladzimir.project.view.View;

public class StartTask {
    public static void main(String[] args) {

        try {
            String string = "727";
            View.print(string + " is palindrome: " + Palindrome.checkString(string));
        } catch (StackIsFullException | StackIsEmptyException e) {
            View.print(e.getMessage());
        }

    }
}