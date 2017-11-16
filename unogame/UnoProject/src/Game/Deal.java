package Game;

import java.util.ArrayList;

public class Deal extends Handler {

    //fields
    private ArrayList<Card> hand;


    //instantiate hand
    public Deal(){
        hand = new ArrayList<>();
    }

    //computer deals cards to player and removed from top of drawpile
    public void dealCard(Handler drawPile) {
        hand.add(0,drawPile.returnTop());
        drawPile.pop();
    }

    public void addCard(Card cardToBeAdded) {
        hand.add(cardToBeAdded);
    }

    public void discardCard(Card cardToBePlayed) {
        boolean deletedOnce = false;
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getCardColor().equalsIgnoreCase(cardToBePlayed.getCardColor())
                    && hand.get(i).getCardNum() == cardToBePlayed.getCardNum() && !deletedOnce) {
                deletedOnce = true;
                hand.remove(i);
            }
        }
    }


    public Card getCard(int element){
        return hand.get(element);
    }
    
    public int getSize(){
        return hand.size();
    }

    public String getSizeString(){
        return "" + hand.size();
    }

    public void printArray(){
        System.out.println(hand.toString());
    }


//    public Card getLast(){
//
//        return hand.get(hand.size()-1);
//   }

    public void printHand() {

        for (Card element : hand) {
            System.out.println(element.toString());
        }
    }

    public String getCommHandString(){
        boolean firstTime = true;
        String commHandString = "";
        for (Card handCard: hand) {
            if (!firstTime) {
                commHandString = commHandString + "x";
            }
            commHandString = commHandString + handCard.getCommCardString();
            firstTime = false;
        }
        return commHandString;
    }
}
