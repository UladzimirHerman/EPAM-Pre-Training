package com.gmail.herman.uladzimir.project.controller;

import com.gmail.herman.uladzimir.project.model.TextReader;
import com.gmail.herman.uladzimir.project.model.TextWorker;
import com.gmail.herman.uladzimir.project.view.View;

import java.io.IOException;

public class StartTask {
    public static void main(String[] args) {

        try {
            View.print("File content:\n" + TextReader.readFile());
            View.print("After parsing:\n" + TextWorker.getInstance().takeParseText());
            //task 2
            View.print("Sort sentences by quantity words:\n" +
                    TextWorker.getInstance().sortSentencesByQuantityWords());
            //task 4
            int wordLength = 2;
            View.print("Words with length=" + wordLength + " in question sentences:\n" +
                    TextWorker.getInstance().findWordsByLengthInQuestions(wordLength));
        } catch (IOException e) {
            View.print(e.getMessage());
        }

    }
}