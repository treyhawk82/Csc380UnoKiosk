package game;

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

    public String getCommCardString(){
        String commCardString = "";
        if (cardColor.equalsIgnoreCase("red")){
            commCardString = "r";
        }
        if (cardColor.equalsIgnoreCase("blue")){
            commCardString = "b";
        }
        if (cardColor.equalsIgnoreCase("yellow")){
            commCardString = "y";
        }
        if (cardColor.equalsIgnoreCase("green")){
            commCardString = "g";
        }
        commCardString = commCardString + cardNum;
        return commCardString;
    }
}


