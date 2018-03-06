package com.gmail.herman.uladzimir.parser;

import com.gmail.herman.uladzimir.project.model.TextWorker;

import java.util.ArrayList;
import java.util.List;

public class SymbolParser implements Parser {
    private String text;

    public SymbolParser() {
        text = TextWorker.getInstance().text;
    }

    @Override
    public List<String> doParse() {
        char symbolsArray[] = text.toCharArray();
        List<String> symbolsList = new ArrayList<>();

        for (int i = 0; i < symbolsArray.length; i++) {
            symbolsList.add(symbolsArray[i] + "");
        }

        return symbolsList;
    }

}