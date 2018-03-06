package com.gmail.herman.uladzimir.project.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextReader {

    private static final String FILE = "src\\resource\\example.txt";

    public static String readFile() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE));
        String fileLine;

        while ((fileLine = bufferedReader.readLine()) != null) {
            stringBuilder.append(fileLine + "\n");
        }

        bufferedReader.close();

        return stringBuilder.toString();
    }

}