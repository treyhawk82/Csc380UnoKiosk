package Game;

import java.util.Random;
import java.util.Scanner;

public class GameLogic implements Runnable {

    //fields
    static Handler deck = new Handler();
    static Deal discardPile = new Deal();
    static Deal player_blue = new Deal();
    static Deal player_yellow = new Deal();
    static Deal player_green = new Deal();
    static Deal player_red = new Deal();
    static Random rn = new Random();
    static boolean uno;
    static Scanner s = new Scanner(System.in);
    boolean done = false;
    static int turnOfPlayer;
    static boolean skip;
    static boolean reverse = false;
    static String lastWildCardColourSelected = "blue";
    static int draw2Stack = 0;

    AI ai1 = new AI(player_blue, this);
    AI ai2 = new AI(player_yellow, this);
    AI ai3 = new AI(player_green, this);
    AI ai4 = new AI(player_red, this);

    public void run() {
        /**
         * create the deck and shuffle it
         */
        deck.addCards();
        deck.shuffleDeck();

        /**
         * game starts with player blue being the first player
         */
        turnOfPlayer = 0;

        /**
         * add 7 cards to each players hand
         */
        dealCards();
        /**
         * create a discard pile
         * the card will be face up
         */

        /**
         * if the first card is a wild then randomly select a color to begin the game
         */
        //if (discardPile.getCard(0).getCardNum() == 13) {
        //    wildCard(13);
        //} else if ( discardPile.getCard(0).getCardNum() == 14) {
        //    wildCard(14);
        //}

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
        int loop = 7;
        done = true;
        long lasttime = System.currentTimeMillis();
        do {
            if (System.currentTimeMillis() > lasttime + 2000) {
                lasttime = System.currentTimeMillis();
                play();
            }
            //System.out.println("test" + loop);
            loop++;
        } while (currentPlayer == 0);
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

    private void play() {
        Card playCard;
        if (turnOfPlayer == 0) {
            playCard = ai1.playTurn();
            skipDraw2ReverseWinChecker(playCard, ai1.hand);
            turnOver(skip, reverse);
        } else if (turnOfPlayer == 1) {
            playCard = ai2.playTurn();
            skipDraw2ReverseWinChecker(playCard, ai2.hand);
            turnOver(skip, reverse);
        } else if (turnOfPlayer == 2) {
            playCard = ai3.playTurn();
            skipDraw2ReverseWinChecker(playCard, ai3.hand);
            turnOver(skip, reverse);
        } else if (turnOfPlayer == 3) {
            playCard = ai4.playTurn();
            skipDraw2ReverseWinChecker(playCard, ai4.hand);
            turnOver(skip, reverse);
        }
    }

    private void skipDraw2ReverseWinChecker(Card playCard, Deal ai) {
        if (ai.getSize() == 0) {
            dealCards();
            skip = false;
            reverse = false;
            draw2Stack = 0;
        } else {
            int CardNumber = playCard.getCardNum();
            if (CardNumber == 10) {
                skip = true;
            }
            if (CardNumber == 11) {
                draw2Stack = +2;
            }
            if (CardNumber == 12) {
                swapReverse(reverse);
            }
        }
    }

    private void swapReverse(boolean isReversed) {
        if (reverse) reverse = false;
        else reverse = true;
    }

    private void turnOver(boolean skip, boolean reverse) {
        if (skip) {
            if (reverse) {
                if (turnOfPlayer == 0) {
                    turnOfPlayer = 2;
                } else if (turnOfPlayer == 1) {
                    turnOfPlayer = 3;
                } else {
                    turnOfPlayer--;
                    turnOfPlayer--;
                }
                this.skip = false;
            } else {
                if (turnOfPlayer == 2) {
                    turnOfPlayer = 0;
                } else if (turnOfPlayer == 3) {
                    turnOfPlayer = 1;
                } else {
                    turnOfPlayer++;
                    turnOfPlayer++;
                }
                this.skip = false;
            }
        } else {
            if (reverse) {
                if (turnOfPlayer > 0) {
                    turnOfPlayer--;
                } else turnOfPlayer = 3;
            } else {
                if (turnOfPlayer < 3) {
                    turnOfPlayer++;
                } else turnOfPlayer = 0;
            }
        }
    }

    private void dealCards() {
        player_blue.removeAll();
        player_yellow.removeAll();
        player_green.removeAll();
        player_red.removeAll();
        deck = new Handler();
        deck.addCards();
        deck.shuffleDeck();
        for (int i = 0; i <= 6; i++) {
            player_blue.dealCard(deck);
            player_yellow.dealCard(deck);
            player_green.dealCard(deck);
            player_red.dealCard(deck);

            discardPile.dealCard(deck);
            System.out.println(discardPile.getCard(0));
        }
    }

    public String getHandSizesAndHands() {

        String handSizesandHands = "";
        if (done) {
            handSizesandHands = player_blue.getSizeString() + "-"
                    + player_yellow.getSizeString() + "-"
                    + player_green.getSizeString() + "-"
                    + player_red.getSizeString() + "-";

            handSizesandHands = handSizesandHands + player_blue.getCommHandString() + "-"
                    + player_yellow.getCommHandString() + "-"
                    + player_green.getCommHandString() + "-"
                    + player_red.getCommHandString();

            int discardPileSize = discardPile.getSize();
            handSizesandHands = handSizesandHands + "-"
                    + discardPile.getCard(discardPileSize - 1).getCommCardString() + "-" + turnOfPlayer + "-"
                    + getLastWildCardColourSelected();
            System.out.println(lastWildCardColourSelected + " = last color GameLogic");
        }
        return handSizesandHands;
    }

    public Card returnTopOfDiscardPile() {
        return discardPile.getCard(discardPile.getSize() - 1);
    }

    public void discardCard(Card cardToDiscard) {
        discardPile.addCard(cardToDiscard);
    }

    public void selectColour(String colour) {
        lastWildCardColourSelected = colour;
    }

    public String getLastWildCardColourSelected() {
        return lastWildCardColourSelected;
    }
}
