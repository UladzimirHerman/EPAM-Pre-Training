package com.gmail.herman.uladzimir.project.model;

import com.gmail.herman.uladzimir.parser.*;

import java.io.IOException;
import java.util.*;

public class TextWorker {
    private static TextWorker unique;
    public String text;

    private TextWorker() {
        try {
            text = TextReader.readFile();
        } catch (IOException e) {
            text = "";
        }
    }

    public static TextWorker getInstance() {
        if (null == unique) {
            unique = new TextWorker();
        }
        return unique;
    }

    public List<String> takeParseSymbol() {
        SymbolParser symbolParser = new SymbolParser();
        return symbolParser.doParse();
    }

    public List<String> takeParseWord() {
        WordParser wordParser = new WordParser();
        return wordParser.doParse();
    }

    public List<String> takeParsePartSentence() {
        SentencePartParser sentencePartParser = new SentencePartParser();
        return sentencePartParser.doParse();
    }

    public List<String> takeParseSentence() {
        SentenceParser sentenceParser = new SentenceParser();
        return sentenceParser.doParse();
    }

    public String takeParseText() {
        TextParser textParser = new TextParser();
        return textParser.doParseText();
    }

    public String sortSentencesByQuantityWords() {
        List<String> sentences = takeParseSentence();
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        int quantityWord;

        for (String sentence : sentences) {
            quantityWord = sentence.length() -
                    sentence.replaceAll(" ", "").length() + 1;
            treeMap.put(quantityWord, sentence);
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            stringBuffer.append(entry.getKey() + " - " + entry.getValue());
        }

        return stringBuffer.toString();
    }

    public String findWordsByLengthInQuestions(int length) {
        List<String> sentences = findQuestions();
        TreeSet<String> treeSet = new TreeSet<>();

        for (String sentence : sentences) {
            String[] words = sentence.trim().split("\\s+");

            for (int i = 0; i < words.length; i++) {
                if (words[i].length() == length) {
                    treeSet.add(words[i]);
                }
            }

        }

        StringBuffer stringBuffer = new StringBuffer();

        for (String value : treeSet) {
            stringBuffer.append(value + " ");
        }

        return stringBuffer.toString();
    }

    private List<String> findQuestions() {
        List<String> sentences = takeParseSentence();
        List<String> question = new ArrayList<>();

        for (String sentence : sentences) {
            if (sentence.endsWith("?") || sentence.endsWith("?\n")) {
                question.add(sentence);
            }
        }

        return question;
    }

}