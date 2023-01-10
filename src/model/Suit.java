package model;

public enum Suit {
    HEARTS("H"), CLUBS("C"), SPADES("S"), DIAMONDS("D");

    public final String shortSign;

    private Suit(String shortSign){
        this.shortSign = shortSign;
    }
}
