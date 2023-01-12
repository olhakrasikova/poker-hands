package model;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Player {

    private List<Card> cards;
    private int score = 0;
    private int sameValueCount = 0;

    private boolean isRoyalFlush;
    private boolean isFourOfKind;
    private boolean isFullHouse;
    private boolean isStraightFlush;
    private boolean isThreeOfKind;

    private boolean isFlush;
    private boolean isStraight;
    private Map<Integer, Integer> pairsCount;
    private Card highestCard;




    public Player(List<Card> cards){
        this.cards = cards;
        isRoyalFlush = isRoyalFlush();
        isStraightFlush = isStraightFlush();
        isFourOfKind = isFourOfKind();
        isFullHouse = isFullHouse();
        isFlush = areSameSuit();
        isStraight = areConsecutive();
        isThreeOfKind = isThreeOfKind();
        pairsCount = findPairs();
        highestCard = findHighestValueCard();

    }

    private boolean isRoyalFlush(){
        List<Integer> royalFlush = Arrays.asList(10,11,12,13,14);
        for (Card card : cards) {
            if (!royalFlush.contains(card.getValue())) {
                return false;
            }
        }
        return true;
    }

    private boolean isStraightFlush(){
        return areConsecutive() && areSameSuit();
    }

    private boolean isFourOfKind(){
        if (sameValueCount == 0){
            return countSameValue() == 4;
        }
        return sameValueCount == 4;
    }

    private boolean isThreeOfKind(){
        if (sameValueCount == 0){
            return countSameValue() == 3;
        }
        return sameValueCount == 3;
    }

    private boolean isFullHouse(){
        return isThreeOfKind() && findPairs().size() == 1;
    }

    private boolean areConsecutive(){
        for (int i = 1; i < cards.size(); i++){
            if (cards.get(i).getValue() - cards.get(i-1).getValue() != 1){
                return false;
            }
        }
        return true;
    }

    private boolean areSameSuit(){
        for(int i = 1; i < cards.size(); i++){
            if(cards.get(i).getSuit() != cards.get(i-1).getSuit()){
                return false;
            }
        }
        return true;
    }

    private int countSameValue(){
        Set<Card> sameValueCards = new HashSet<>();
        for(int i = 0; i != cards.size() - 1; i++){
            if(cards.get(i).getValue() == cards.get(i+1).getValue()){
//                System.out.println("i = " + i + " card 1 " + cards.get(i) + " \ncard2: " + cards.get(i+1));
                sameValueCards.add(cards.get(i));
                sameValueCards.add(cards.get(i+1));
            }
        }
        return sameValueCards.size();
    }

    private Map<Integer, Integer> findPairs(){
        Map<Integer, Integer> pairs = new HashMap<>();
        for(int i = 1; i < cards.size(); i++){
            if (cards.get(i).getValue() == cards.get(i-1).getValue())
                if (pairs.get(cards.get(i).getValue()) == null) {
                    pairs.put(cards.get(i).getValue(), 1);
                    i++; // skipping card with index i, not to compare it with next card and create a new pair
                }else {
                    pairs.put(cards.get(i).getValue(), 2);
                    i++;
                }
        }

        return pairs;
    }

    private Card findHighestValueCard(){
        return cards.stream().max(Comparator.comparing(Card::getValue)).get();
    }

    @Override
    public String toString() {
        return "Player{" +
                "cards=" + cards +
                "\nisRoyalFlush=" + isRoyalFlush +
                "\nisStraightFlush=" + isStraightFlush +
                "\nisFourOfKind=" + isFourOfKind +
                "\nisFullHouse=" + isFullHouse +
                "\nisFlush=" + isFlush +
                "\nisStraight=" + isStraight +
                "\nisThreeOfKind=" + isThreeOfKind +
                "\npairsCount=" + pairsCount +
                "\nhighestCard=" + highestCard +
                '}';
    }
}
