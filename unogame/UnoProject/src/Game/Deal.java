package Game;

import Game.Card;
import Game.Handler;

import java.util.ArrayList;

public class Deal extends Handler {
    private ArrayList<Card> hand;
    public Deal(){
        hand = new ArrayList<>();
    }


    public void addCard(Handler deck){
       // hand.add(0,deck.getLast());
      //  deck.removeLast();
    }


    public void addCard(Card addCard){
        hand.add(addCard);
    }
    public void removeCard(int element){
        hand.remove(element);
    }
    public Card getCard(int element){
        return hand.get(element);
    }
    
    public int getSize(){
        return hand.size();
    }
    public void printArray(){
        System.out.println(hand.toString());
    }
  //  public Card getLast(){
    //    return hand.get(hand.size()-1);
  //  }
}
