package com.gmail.herman.uladzimir.parser;

import java.util.ArrayList;
import java.util.List;

public class SentencePartParser extends WordParser implements Parser {

    @Override
    public List<String> doParse() {
        List<String> words = super.doParse();
        List<String> sentenceParts = new ArrayList<>();
        String string = "";

        for (int i = 0; i < words.size(); i++) {

            while (!words.get(i).startsWith(".") && !words.get(i).startsWith(",") &&
                    !words.get(i).startsWith("!") && !words.get(i).startsWith("?") &&
                    !words.get(i).startsWith("\n")) {
                string += words.get(i) + " ";
                if (i == words.size() - 1) {
                    sentenceParts.add(string);
                    break;
                }
                i++;
            }

            string = string.trim();

            while (words.get(i).startsWith(".") || words.get(i).startsWith(",") ||
                    words.get(i).startsWith("!") || words.get(i).startsWith("?") ||
                    words.get(i).startsWith("\n")) {
                string += words.get(i);
                if (i == words.size() - 1) {
                    break;
                }
                i++;
            }

            sentenceParts.add(string);
            string = "";

            if (!words.get(i).startsWith(".") && !words.get(i).startsWith(",") &&
                    !words.get(i).startsWith("!") && !words.get(i).startsWith("?") &&
                    !words.get(i).startsWith("\n")) {
                i--;
            }

        }

        return sentenceParts;
    }

}