package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    private String cards;

//    public Player(){
//    }

    private boolean isRoyalFlush(String cards){
        return true;
    }

    private boolean isStraightFlush(String cards){
        return true;
    }

    private boolean isFourOfKind(String cards){
        return true;
    }

    private boolean isFullHouse(String cards){
        return true;
    }
}
