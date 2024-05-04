package org.example;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pathToFirstFile = scanner.next();
        String pathToSecondFile = scanner.next();

        String pathToOutputOnlyInFirst = scanner.next();
        String pathToOutputOnlyInSecond = scanner.next();
        String pathToOutputInBoth = scanner.next();

        JsonParser readParserFirst = new JsonParser(pathToFirstFile);
        JsonParser readParserSecond = new JsonParser(pathToSecondFile);
        try {
            Data problemsInFirst = readParserFirst.readData();
            Data problemsInSecond = readParserSecond.readData();

            Data OnlyInFirst = Data.getProblemsOnlyInFirstData(problemsInFirst, problemsInSecond);
            Data OnlyInSecond = Data.getProblemsOnlyInFirstData(problemsInSecond, problemsInFirst);
            Data InBoth = Data.getProblemsInBoth(problemsInFirst, problemsInSecond);

            JsonParser writeParserOnlyInFirst = new JsonParser(pathToOutputOnlyInFirst);
            JsonParser writeParserOnlyInSecond = new JsonParser(pathToOutputOnlyInSecond);
            JsonParser writeParserInBoth = new JsonParser(pathToOutputInBoth);

            writeParserOnlyInFirst.writeData(OnlyInFirst);
            writeParserOnlyInSecond.writeData(OnlyInSecond);
            writeParserInBoth.writeData(InBoth);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}