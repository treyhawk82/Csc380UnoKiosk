package Game;
import java.util.Arrays;
import java.util.HashMap;

public class Card {
    //fields
    private String cardColor;
    private int cardNum;

    //constructor
    public Card(String cardColor, int cardNum) {
        this.cardColor = cardColor;
        this.cardNum = cardNum;
    }
    //getters
    public String getCardColor() {
        return cardColor;
    }
    public int getCardNum() {
        return cardNum;
    }


}


