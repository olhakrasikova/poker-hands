package main.engine;

import main.model.Card;
import main.model.Player;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class PokerEngine {

    public void calculate(String fileName){
        int player1Wins = 0;
        try
        {
            FileInputStream fis=new FileInputStream(fileName);
            Scanner sc=new Scanner(fis);
            while(sc.hasNextLine())
            {
                player1Wins += getPlayersCardsAndScores(sc.nextLine());
            }
            sc.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        System.out.println(player1Wins);
    }

    private int getPlayersCardsAndScores(String line){

        List<Card> cardListP1 = Stream.of(line.substring(0, line.length()/2).trim().split(" "))
                .map(card -> new Card(handleNotNumericCardValues(card.charAt(0)), card.charAt(1))).toList();


        List<Card> cardListP2 = Stream.of(line.substring(line.length()/2).trim().split(" "))
                .map(card -> new Card(handleNotNumericCardValues(card.charAt(0)), card.charAt(1))).toList();


        Player player1 = new Player(cardListP1);
        Player player2 = new Player(cardListP2);

//        System.out.println("Player 1: "+ player1);
//        System.out.println("Player 2: "+ player2);

//        System.out.println();

//        System.out.println("Player 1: "+ player1.getPlayersScore());
//        System.out.println("Player 2: "+ player2.getPlayersScore());

//        System.out.println();
        if (player1.getPlayersScore() == player2.getPlayersScore()){
            System.out.println(player1.getCards().toString() + " score: " + player1.getPlayersScore() + "\n" + player2.getCards().toString() + " score: " + player2.getPlayersScore());
            System.out.println();
        }
        if (player1.getPlayersScore() > player2.getPlayersScore())
            return 1;

        else return 0;
    }



    private int handleNotNumericCardValues(char value){
        return switch (value) {
            case 'T' -> 10;
            case 'J' -> 11;
            case 'Q' -> 12;
            case 'K' -> 13;
            case 'A' -> 14;
            default -> Character.getNumericValue(value);
        };
    }

}



