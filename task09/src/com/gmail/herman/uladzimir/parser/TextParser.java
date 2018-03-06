package com.gmail.herman.uladzimir.parser;

import java.util.List;

public class TextParser extends SentenceParser {

    public String doParseText() {
        List<String> sentences = super.doParse();
        StringBuffer stringBuffer = new StringBuffer();

        for (String sentence : sentences) {
            stringBuffer.append(sentence);
            if (!sentence.endsWith("\n")) {
                stringBuffer.append(" ");
            }
        }

        return stringBuffer.toString();
    }

}