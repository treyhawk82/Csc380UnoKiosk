package Game;

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
    public int getSpecificCardNum(Card card) { return card.cardNum; }
    @Override
    public String toString() {
        return "\ncolor: " + cardColor + " number: " + cardNum ;
    }
}


