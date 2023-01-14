package test;

import main.engine.PokerEngine;
import org.junit.Assert;
import org.junit.Test;

public class PokerEngineTests {

    PokerEngine pokerEngine = new PokerEngine();

    @Test
    public void pokerEngineTestPlayer1Wins(){
        Assert.assertEquals(1, pokerEngine.calculate("src/resources/testCase1.txt"));
    }

    @Test
    public void pokerEngineTestPlayer1Loses(){
        Assert.assertEquals(0, pokerEngine.calculate("src/resources/testCase2.txt"));
    }
}
