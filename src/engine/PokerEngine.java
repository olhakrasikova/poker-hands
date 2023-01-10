package engine;

import model.Card;
import model.Player;
import model.Suit;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PokerEngine {

    public void calculate(String fileName){
        try
        {
            FileInputStream fis=new FileInputStream(fileName);
            Scanner sc=new Scanner(fis);
            while(sc.hasNextLine())
            {
                getPlayersCards(sc.nextLine());
            }
            sc.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private void getPlayersCards(String line){

        List<Card> cardListP1 = Stream.of(line.substring(0, line.length()/2).trim().split(" "))
                .map(card -> new Card(card.charAt(0), card.charAt(1))).toList();


        List<Card> cardListP2 = Stream.of(line.substring(line.length()/2).trim().split(" "))
                .map(card -> new Card(card.charAt(0), card.charAt(1))).toList();


        Player player1 = new Player(cardListP1);
        Player player2 = new Player(cardListP2);

        System.out.println("Player 1: "+ player1);
        System.out.println("Player 2: "+ player2);

    }

//    private void count(){
//
//    }

}



