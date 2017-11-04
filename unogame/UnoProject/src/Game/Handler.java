package Game;
import java.util.Stack;
//        There are four different colours for the cards
//        There are 2 cards of the numbers 1 to 9 for each colour   **done
//        There is 1 card for the number 0 for each colour          **done
//        There are 2 cards of “draw 2” for every colour **
//        There are 2 cards of “skip” for every colour **
//        There are 2 cards of “reverse” for every colour **
//        There are 4 “wild” cards
//        There are 4 “wild +4” cards

public class Handler {
    //fields
    Stack deck = new Stack();
    int i;

    public void returnTop(){
         System.out.println(deck.peek());
     }

     public void printCards(){
         System.out.println(deck);
     }

     public void addCards() {

         for (i =0; i <= 9; i++) {
             Card c = new Card("Yellow", i);
            deck.push(c);
         }
         for (i =1; i <= 9; i++) {
             Card c = new Card("Yellow", i);
             deck.push(c);
         }
         for (i =0; i <= 9; i++) {
             Card c = new Card("Green", i);
             deck.push(c);
         }
         for (i =1; i <= 9; i++) {
             Card c = new Card("Green", i);
             deck.push(c);
         }
         for (i =0; i <= 9; i++) {
             Card c = new Card("Blue", i);
             deck.push(c);
         }
         for (i =1; i <= 9; i++) {
             Card c = new Card("Blue", i);
             deck.push(c);
         }
         for (i =0; i <= 9; i++) {
             Card c = new Card("Red", i);
             deck.push(c);
         }
         for (i =1; i <= 9; i++) {
             Card c = new Card("Red", i);
             deck.push(c);
         }


         deck.push(new Card("Yellow" , 10));    //skip
         deck.push(new Card("Yellow" , 10));    //skip
         deck.push(new Card("Green" , 10));     //skip
         deck.push(new Card("Green" , 10));     //skip
         deck.push(new Card("Blue" , 10));      //skip
         deck.push(new Card("Blue" , 10));      //skip
         deck.push(new Card("Red" , 10));       //ski[
         deck.push(new Card("Red" , 10));       //skip
         deck.push(new Card("Yellow" , 11));    //draw2
         deck.push(new Card("Yellow" , 11));    //draw2
         deck.push(new Card("Green" , 11));     //draw2
         deck.push(new Card("Green" , 11));     //draw2
         deck.push(new Card("Blue" , 11));      //draw2
         deck.push(new Card("Blue" , 11));      //draw2
         deck.push(new Card("Red" , 11));       //draw2[
         deck.push(new Card("Red" , 11));       //draw2
         deck.push(new Card("Yellow" , 12));    //reverse
         deck.push(new Card("Yellow" , 12));    //reverse
         deck.push(new Card("Green" , 12));     //reverse
         deck.push(new Card("Green" , 12));     //reverse
         deck.push(new Card("Blue" , 12));      //reverse
         deck.push(new Card("Blue" , 12));      //reverse
         deck.push(new Card("Red" , 12));       //reverse[
         deck.push(new Card("Red" , 12));       //reverse
         deck.push(new Card("Wild", 13));       //wild
         deck.push(new Card("Wild", 13));       //wild
         deck.push(new Card("Wild", 13));       //wild
         deck.push(new Card("Wild", 13));       //wild
         deck.push(new Card("Wild + 4", 14));       //wild+4
         deck.push(new Card("Wild + 4", 14));       //wild+4
         deck.push(new Card("Wild + 4", 14));       //wild+4
         deck.push(new Card("Wild + 4", 14));       //wild+4



     }

     }




