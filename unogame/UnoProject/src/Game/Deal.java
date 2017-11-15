package Game;

import java.util.ArrayList;
import java.util.Stack;

public class Deal extends Handler {

    //fields
    private ArrayList<Card> hand;


    //instantiate hand
    public Deal(){
        hand = new ArrayList<>();
    }

    //computer deals cards to player and removed from top of drawpile
    public void DealCard(Handler drawPile) {
        hand.add(0,drawPile.returnTop());
        drawPile.pop();
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
