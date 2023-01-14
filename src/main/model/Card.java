package main.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Card {

    private int value;
    private char suit;

    @Override
    public String toString() {
        return value +
                " " + suit
                ;
    }
}
