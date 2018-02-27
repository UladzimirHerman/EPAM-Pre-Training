package com.gmail.herman.uladzimir.project.model;

import com.gmail.herman.uladzimir.container.stack.MyArrayStack;
import com.gmail.herman.uladzimir.container.exception.StackIsEmptyException;
import com.gmail.herman.uladzimir.container.exception.StackIsFullException;

public class Palindrome {

    public static boolean checkString(String string) throws StackIsFullException, StackIsEmptyException {
        MyArrayStack<Character> stack = new MyArrayStack<>();

        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));
        }

        for (int i = 0; i < stack.size(); i++) {
            if (string.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }

}