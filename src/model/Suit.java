package model;

public enum Suit {
    HEARTS('H'), CLUBS('C'), SPADES('S'), DIAMONDS('D');

    public final char shortSign;

    Suit(char shortSign){
        this.shortSign = shortSign;
    }
}
