package Game;

public class Card {
    //fields
    private String cardColor;
    private int cardNum;
    private String secondCard = "";

    //constructor
    public Card(String cardColor, int cardNum, boolean secondCard) {
        this.cardColor = cardColor;
        this.cardNum = cardNum;
        if (secondCard) this.secondCard = this.secondCard + "e";
    }


    //getters
    public String getCardColor() {
        return cardColor;
    }
    public int getCardNum() {
        return cardNum;
    }
    public int getSpecificCardNum(Card card) { return card.cardNum; }

    public String getSecondCard() {
        return secondCard;
    }
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
        if(cardColor.equalsIgnoreCase("wild")){
            commCardString = "w";
        }
        if(cardColor.equalsIgnoreCase("wild + 4")){
            commCardString = "w";
        }
        commCardString = commCardString + cardNum + secondCard;
        return commCardString;
    }

    public void changeSecondCard(String appendix) {
        this.secondCard = appendix;
    }
}


