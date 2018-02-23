package com.gmail.herman.uladzimir.model;

import com.gmail.herman.uladzimir.model.container.MyArrayStack;
import com.gmail.herman.uladzimir.model.exception.StackIsEmptyException;
import com.gmail.herman.uladzimir.model.exception.StackIsFullException;

public class Palindrome {

    private MyArrayStack<Character> stack;

    public Palindrome() {
        stack = new MyArrayStack<>();
    }

    public boolean checkString(String string) throws StackIsFullException, StackIsEmptyException {

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