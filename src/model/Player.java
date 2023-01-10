package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Player {

    private List<Card> cards;
    private boolean isRoyalFlush;
    private boolean isStraightFlush;
    private boolean isFourOfKind;
    private boolean isFullHouse;

    public Player(List<Card> cards){
        this.cards = cards;
        isRoyalFlush = isRoyalFlush(cards);
        isStraightFlush = isStraightFlush(cards);
        isFourOfKind = isFourOfKind(cards);
        isFullHouse = isFullHouse(cards);
    }

    private boolean isRoyalFlush(List<Card>  cards){
        if(cards.contains("T") && cards.contains("J") && cards.contains("Q") && cards.contains("K") && cards.contains("A"))
            return true;
        return false;
    }

    private boolean isStraightFlush(List<Card>  cards){ // not done
//        System.out.println(cards.chars().filter(ch -> ch == Suit.CLUBS.shortSign || ch == Suit.DIAMONDS.shortSign).count());
        return true;
    }

    private boolean isFourOfKind(List<Card> cards){
        return true;
    }

    private boolean isFullHouse(List<Card> cards){
        return true;
    }

    @Override
    public String toString() {
        return "Player{" +
                "cards='" + cards + '\'' +
                ", isRoyalFlush=" + isRoyalFlush +
                ", isStraightFlush=" + isStraightFlush +
                ", isFourOfKind=" + isFourOfKind +
                ", isFullHouse=" + isFullHouse +
                '}';
    }
}
