package com.gmail.herman.uladzimir.parser;

import java.util.ArrayList;
import java.util.List;

public class WordParser extends SymbolParser implements Parser {

    @Override
    public List<String> doParse() {
        List<String> symbols = super.doParse();
        List<String> words = new ArrayList<>();
        char symbolsArray[] = new char[symbols.size()];

        for (int i = 0; i < symbolsArray.length; i++) {
            symbolsArray[i] = symbols.get(i).toLowerCase().charAt(0);
        }

        String string = "";

        for (int i = 0; i < symbolsArray.length; i++) {

            while (symbolsArray[i] >= 'a' && symbolsArray[i] <= 'z') {
                string += symbols.get(i);
                if (i == symbolsArray.length - 1) {
                    break;
                }
                i++;
            }

            if (!string.equals("")) {
                words.add(string);
            }

            string = "";

            while (symbolsArray[i] == '.' || symbolsArray[i] == ',' ||
                    symbolsArray[i] == '!' || symbolsArray[i] == '?' ||
                    symbolsArray[i] == '\n') {
                string += symbols.get(i);
                if (i == symbolsArray.length - 1) {
                    break;
                }
                i++;
            }

            if (!string.equals("")) {
                words.add(string);
            }

            string = "";

            if (symbolsArray[i] >= 'a' && symbolsArray[i] <= 'z') {
                i--;
            }
        }

        return words;
    }

}