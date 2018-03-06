package com.gmail.herman.uladzimir.parser;

import java.util.List;

public class SentenceParser extends SentencePartParser implements Parser {

    @Override
    public List<String> doParse() {
        List<String> sentences = super.doParse();

        for (int i = sentences.size() - 1; i > 0; i--) {
            if (sentences.get(i).charAt(0) >= 'a' &&
                    sentences.get(i).charAt(0) <= 'z') {
                sentences.set(i - 1, sentences.get(i - 1) + " " + sentences.get(i));
                sentences.remove(i);
            }
        }

        return sentences;
    }

}