package Game;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {

    //fields
   static Handler deck = new Handler();
   static Deal discardPile = new Deal();
   static Deal player1 = new Deal();
   static Deal computer1 = new Deal();
   static Deal computer2 = new Deal();
   static Deal computer3 = new Deal();
   static Random rn = new Random();
   static boolean uno;
   static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        /**
         * create the deck and shuffle it
         */
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
        /**
         * create a discard pile
         * the card will be face up
         */
        discardPile.DealCard(deck);
       // System.out.println(discardPile.getCard(0));

        /**
         * if the first card is a wild then randomly select a color to begin the game
         */
        if (discardPile.getCard(0).getCardNum() == 13) {
            wildCard(13);
        } else if ( discardPile.getCard(0).getCardNum() == 14) {
            wildCard(14);
        }

        /**
         * instantiate all players
         * user will be player 0 aka player 1
         */
        Player p1 = new Player(0);
        Player p2 = new Player(1);      //computer player
        Player p3 = new Player(2);      //computer player
        Player p4 = new Player(3);      //computer player
        int currentPlayer = 0;      //this is the user

        /**
         * this will be the game loop
         */

        do {        // do this until the game ends
            while(currentPlayer == 0) {

            }
        }
    }


    /*******************************************
     * If you couldn't tell, these are methods *
     *******************************************/

    /**
     * print the last card from the discard pile
     */
    public static void printDiscard(){
        System.out.println("Face up card: ");
        System.out.println(discardPile.returnTop());
    }
    /**
     * get the user's choice
     */
    public static void getChoice() {

    }
    /**
     * method to handle wild card logic
     * @param cardNum
     * @return Card
     */
    public static Card wildCard(int cardNum) {
        System.out.println("Enter a color: ");
        String input = s.nextLine();
        boolean check = false;
        Card newCard = new Card("color", cardNum);

        while (check == false) {
            if (input.equalsIgnoreCase("Red")) {
                newCard = new Card("Red", cardNum);
                check = true;
            } else if (input.equalsIgnoreCase("Blue")) {
                newCard = new Card("Blue", cardNum);
                check = true;
            } else if (input.equalsIgnoreCase("Yellow")) {
                newCard = new Card("Yellow", cardNum);
                check = true;
            } else if (input.equalsIgnoreCase("Green")) {
                newCard = new Card("Green", cardNum);
                check = true;
            } else {
                check = false;
                System.out.println("Try again");
                input = s.next();
            }
        }
        System.out.println(newCard.toString());
        return newCard;
    }

}
