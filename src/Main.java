import engine.PokerEngine;

public class Main {

    public static final String FILE_NAME = "src/resources/poker.txt";

    public static void main(String[] args) {
        PokerEngine reader = new PokerEngine();
        reader.calculate(FILE_NAME);
    }
}