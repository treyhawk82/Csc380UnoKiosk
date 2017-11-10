package Game;

import java.util.Random;

public class GameLogic {

    //fields
   static Handler deck = new Handler();
   static Deal player1 = new Deal();
   static Deal computer1 = new Deal();
   static Deal computer2 = new Deal();
   static Deal computer3 = new Deal();


    public static void main(String[] args) {

        deck.addCards();
        deck.shuffleDeck();

        /**
         * add 7 cards to each players hand
         */

        for (int i = 0; i <= 6; i++) {
            player1.DealCard(deck);
            computer1.DealCard(deck);
            computer2.DealCard(deck);
            computer3.DealCard(deck);
        }


    }

}
