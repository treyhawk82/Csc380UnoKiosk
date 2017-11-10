package Game;

import Game.Card;
import Game.Handler;

import java.util.ArrayList;

public class Deal extends Handler {

    //fields
    private ArrayList<Card> hand;

    //instantiate hand
    public Deal(){
        hand = new ArrayList<>();
    }

    //computer deals cards to player and removed from top of drawpile
    public void DealCard(Handler drawPile){
        hand.add(0,drawPile.returnTop());
        drawPile.pop();
    }

    //player plays a card?
//    public void playCard(int element){
//        hand.remove(element);
//    }
//
// returns what card a user has?

    public Card getCard(int element){
        return hand.get(element);
    }
    
    public int getSize(){
        return hand.size();
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
}
