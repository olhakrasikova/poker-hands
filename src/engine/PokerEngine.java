package engine;

import model.Player;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class PokerEngine {

    private Player player1 = new Player();
    private Player player2 = new Player();

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

    public void getPlayersCards(String line){
        player1.setCards(line.substring(0, line.length()/2).trim());
        player2.setCards(line.substring(line.length()/2).trim());
        System.out.println("Player 1: "+ player1.getCards());
        System.out.println("Player 2: "+ player2.getCards());

    }

}



