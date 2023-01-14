package main;

import main.engine.PokerEngine;

public class Main {

    public static final String FILE_NAME = "src/resources/poker.txt";

    public static void main(String[] args) {
        PokerEngine engine = new PokerEngine();
        System.out.println(engine.calculate(FILE_NAME));
    }
}