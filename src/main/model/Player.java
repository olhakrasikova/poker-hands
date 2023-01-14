package main.model;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Player {

    private List<Card> cards;
    private int sameValueCount = 0;
    private int score;

    private Boolean isRoyalFlush;
    private Boolean isFourOfKind;
    private Boolean isFullHouse;
    private Boolean isStraightFlush;
    private Boolean isThreeOfKind;
    private Boolean isFlush;
    private Boolean isStraight;
    private Map<Integer, Integer> pairsCount;
    private Card highestCard;




    public Player(List<Card> cards){
        this.cards = sortCards(cards);
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

    public int getPlayersScore(){
        if (isRoyalFlush) return 200;
        if (isStraightFlush) return 150;
        if (isFourOfKind) return 140;
        if (isFullHouse) return 130;
        if(isFlush) return 120;
        if(isStraight) return 110;
        if(isThreeOfKind) return 100;
        if (pairsCount.size() == 2) return Collections.max(pairsCount.keySet())*2 + 40;
        if (pairsCount.size() == 1) return Collections.max(pairsCount.keySet()) + 20;
        return highestCard.getValue();
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
            return countSameValue().containsValue(4);
        }
        return sameValueCount == 4;
    }

    private boolean isThreeOfKind(){
        if (sameValueCount == 0){
            return countSameValue().containsValue(3);
        }
        return sameValueCount == 3;
    }

    private boolean isFullHouse(){
        if(findPairs().keySet().containsAll(countSameValue().keySet())){ // so we avoid the option when 3D 3S 3D 5H 10C is considered a full house
            return false;
        }
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

    private Map<Integer, Integer> countSameValue(){
        Map<Integer, Integer> sameValueCards = new HashMap<>();
        for(int i = 0; i != cards.size() - 1; i++){
            if (cards.get(i).getValue() == cards.get(i+1).getValue())
                if (sameValueCards.get(cards.get(i).getValue()) == null) {
                    sameValueCards.put(cards.get(i).getValue(), 2);
                }else {
                    sameValueCards.put(cards.get(i).getValue(), sameValueCards.get(cards.get(i).getValue()) + 1);
                }
        }
        return sameValueCards;
    }

    private Map<Integer, Integer> findPairs(){
        Map<Integer, Integer> pairs = new HashMap<>();
        for(int i = 1; i < cards.size(); i++){
            if (cards.get(i).getValue() == cards.get(i-1).getValue())
                if (pairs.get(cards.get(i).getValue()) == null) {
                    pairs.put(cards.get(i).getValue(), 1 );
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

    private List<Card> sortCards(List<Card> cards){
//        cards.sort(Comparator.comparingInt(Card::getValue));
        List<Card>sortedList=cards.stream().sorted(Comparator.comparingInt(Card :: getValue)).toList();
        return sortedList;
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
