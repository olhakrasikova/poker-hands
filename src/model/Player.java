package model;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class Player {

    private List<Card> cards;
    private boolean isRoyalFlush;
    private boolean isStraightFlush;
    private boolean isFourOfKind;
    private boolean isFullHouse;

    private boolean isFlush;
    private boolean isStraight;
    private boolean isThreeOfKind;
    private boolean hasTwoPairs;
    private boolean hasOnePair;
    private Card highestCard;



    public Player(List<Card> cards){
        this.cards = cards;
        isRoyalFlush = isRoyalFlush(cards);
        isStraightFlush = isStraightFlush(cards);
        isFourOfKind = isFourOfKind(cards);
        isFullHouse = isFullHouse(cards);
        isFlush = areSameSuit(cards);
        isThreeOfKind = areConsecutive(cards);
    }

    private boolean isRoyalFlush(List<Card> cards){
        List<Integer> royalFlush = Arrays.asList(10,11,12,13,14);
        for (Card card : cards) {
            if (!royalFlush.contains(card.getValue())) {
                return false;
            }
        }
        return true;
    }

    private boolean isStraightFlush(List<Card>  cards){
        if(areConsecutive(cards) && areSameSuit(cards))
            return true;
        return false;
    }

    private boolean isFourOfKind(List<Card> cards){
        if (countSameValue(cards) == 4)
            return true;
        return false;
    }

    private boolean isFullHouse(List<Card> cards){
        return true;
    }

    private boolean areConsecutive(List<Card> cards){
        for (int i = 1; i < cards.size(); i++){
            if (cards.get(i).getValue() - cards.get(i-1).getValue() != 1){
                return false;
            }
        }
        return true;
    }

    private boolean areSameSuit(List<Card> cards){
        for(int i = 1; i < cards.size(); i++){
            if(cards.get(i).getSuit() != cards.get(i-1).getSuit()){
                return false;
            }
        }
        return true;
    }

    private int countSameValue(List<Card> cards){
        int sameValCount = 0;
        for(int i = 1; i < cards.size(); i++){
            if(cards.get(i).getValue() != cards.get(i-1).getValue()){
                sameValCount++;
            }
        }
        return sameValCount;
    }
    @Override
    public String toString() {
        return "Player{" +
//                "cards='" + cards + '\'' +
                "isRoyalFlush=" + isRoyalFlush +
                ", isStraightFlush=" + isStraightFlush +
                ", isFourOfKind=" + isFourOfKind +
                ", isFullHouse=" + isFullHouse +
                '}';
    }
}
