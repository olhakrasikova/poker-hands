package test;

import main.model.Card;
import main.model.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PlayerTests {

    @Test
    public void testIsRoyalFlush(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(14, 'C'));
        cards.add( new Card(13, 'C'));
        cards.add( new Card(10, 'H'));
        cards.add(new Card(12, 'S'));
        cards.add(new Card(11, 'D'));
        Player player = new Player(cards);
        Assert.assertTrue(player.getIsRoyalFlush());
    }

    @Test
    public void testIsStraightFlush(){
        List<Card> cards1 = new ArrayList<>();
        cards1.add(new Card(2, 'C'));
        cards1.add( new Card(3, 'C'));
        cards1.add( new Card(4, 'C'));
        cards1.add(new Card(5, 'C'));
        cards1.add(new Card(6, 'C'));
        Player player1 = new Player(cards1);
        Assert.assertTrue(player1.getIsStraightFlush());


        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card(2, 'C'));
        cards2.add( new Card(3, 'C'));
        cards2.add( new Card(4, 'C'));
        cards2.add(new Card(5, 'C'));
        cards2.add(new Card(6, 'S'));
        Player player2 = new Player(cards2);
        Assert.assertFalse(player2.getIsStraightFlush());
    }


    @Test
    public void testIsFourOfKind(){
        List<Card> cards1 = new ArrayList<>();
        cards1.add(new Card(5, 'H'));
        cards1.add( new Card(5, 'C'));
        cards1.add( new Card(7, 'H'));
        cards1.add(new Card(5, 'S'));
        cards1.add(new Card(5, 'D'));
        Player player1 = new Player(cards1);
        Assert.assertTrue(player1.getIsFourOfKind());


        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card(5, 'H'));
        cards2.add( new Card(5, 'C'));
        cards2.add( new Card(7, 'H'));
        cards2.add(new Card(5, 'S'));
        cards2.add(new Card(6, 'D'));
        Player player2 = new Player(cards2);
        Assert.assertFalse(player2.getIsFourOfKind());
    }

    @Test
    public void testIsFullHouse(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(5, 'H'));
        cards.add( new Card(5, 'C'));
        cards.add( new Card(7, 'H'));
        cards.add(new Card(5, 'S'));
        cards.add(new Card(7, 'D'));
        Player player1 = new Player(cards);
        Assert.assertTrue(player1.getIsFullHouse());
    }

    @Test
    public void testIsFlush(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(6, 'H'));
        cards.add( new Card(5, 'H'));
        cards.add( new Card(10, 'H'));
        cards.add(new Card(14, 'H'));
        cards.add(new Card(7, 'H'));
        Player player1 = new Player(cards);
        Assert.assertTrue(player1.getIsFlush());
    }

    @Test
    public void testIsStraight(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(6, 'H'));
        cards.add( new Card(5, 'D'));
        cards.add( new Card(2, 'S'));
        cards.add(new Card(3, 'H'));
        cards.add(new Card(7, 'C'));
        Player player1 = new Player(cards);
        Assert.assertFalse(player1.getIsFlush());
    }

    @Test
    public void testPairsCount(){
        List<Card> cards1 = new ArrayList<>();
        cards1.add(new Card(2, 'H'));
        cards1.add( new Card(5, 'D'));
        cards1.add( new Card(2, 'S'));
        cards1.add(new Card(3, 'H'));
        cards1.add(new Card(7, 'C'));
        Player player1 = new Player(cards1);
        Assert.assertEquals("{2=1}", player1.getPairsCount().toString());

        List<Card> cards2 = new ArrayList<>();
        cards2.add(new Card(2, 'H'));
        cards2.add( new Card(5, 'D'));
        cards2.add( new Card(2, 'S'));
        cards2.add(new Card(3, 'H'));
        cards2.add(new Card(5, 'C'));
        Player player2 = new Player(cards2);
        Assert.assertEquals(2, player2.getPairsCount().size());

        Assert.assertEquals("{2=1, 5=1}", player2.getPairsCount().toString());

    }

    @Test
    public void testFindHighestValue(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(6, 'H'));
        cards.add( new Card(5, 'H'));
        cards.add( new Card(10, 'H'));
        cards.add(new Card(14, 'H'));
        cards.add(new Card(7, 'H'));
        Player player1 = new Player(cards);
        Assert.assertEquals(14, player1.getHighestCard().getValue());


        List<Card> cards2 = new ArrayList<>(); // repeating values
        cards2.add(new Card(2, 'H'));
        cards2.add( new Card(5, 'D'));
        cards2.add( new Card(2, 'S'));
        cards2.add(new Card(3, 'H'));
        cards2.add(new Card(5, 'C'));
        Player player2 = new Player(cards2);
        Assert.assertEquals(5, player2.getHighestCard().getValue());

    }


}