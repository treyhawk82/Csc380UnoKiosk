package Game;

import Game.commServer.Server;

public class GameLogic implements Runnable {

    //fields
    static Handler deck = new Handler();
    static Deal discardPile = new Deal();
    /*
    players
     */
    static Deal player_blue = new Deal();
    static Deal player_yellow = new Deal();
    static Deal player_green = new Deal();
    static Deal player_red = new Deal();

    static boolean done = false;
    static int turnOfPlayer;
    static String lastWildCardColourSelected = "blue";
    static long turnStartTime;
    static boolean calledUno[] = new boolean[4];
    static boolean connectedUser[] = new boolean[4];
    /*
    action cards
     */
    static boolean skip = false;
    static boolean reverse = false;
    static boolean draw2 = false;
    static boolean draw4 = false;
    static int win = 4;
    int lastWinner = 4;
    long lastTime = System.currentTimeMillis();
    long[] unoMercy = new long[4];

    /*
    AI and User
     */
    AI ai1 = new AI(player_blue, this, 0);
    AI ai2 = new AI(player_yellow, this, 1);
    AI ai3 = new AI(player_green, this, 2);
    AI ai4 = new AI(player_red, this, 3);

    User u1 = new User(player_blue, this, this.server, 0);
    User u2 = new User(player_yellow, this, this.server, 1);
    User u3 = new User(player_green, this, this.server, 2);
    User u4 = new User(player_red, this, this.server, 3);


    AI[] ai = new AI[4];
    User[] users = new User[4];

    Server server;
    long[] lastActionTime;
    long[] lastConnectionTimes;


    public void run() {
        /**
         * create the deck and shuffle it
         * game starts with player blue being the first player
         * add 7 cards to each players hand
         * create a discard pile
         * the card will be face up
         */
        resetBoard();
        System.out.println();
        System.out.println("run initiated");
        System.out.println();
        System.out.println();

        System.out.println("player blue");
        player_blue.printHand();
        System.out.println();
        System.out.println("player green");
        player_green.printHand();
        System.out.println();
        System.out.println("player red");
        player_red.printHand();
        System.out.println();
        System.out.println("player yellow");
        player_yellow.printHand();
        System.out.println();


        for (int i = 0; i < connectedUser.length; i++) {
            connectedUser[i] = false;
        }

        for (long unoMercies : unoMercy
                ) {
            unoMercies = System.currentTimeMillis();
        }

        ai[0] = ai1;
        ai[1] = ai2;
        ai[2] = ai3;
        ai[3] = ai4;

        users[0] = u1;
        users[1] = u2;
        users[2] = u3;
        users[3] = u4;
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
        do {
            if (deck.size() == 0) {
                Card Top = discardPile.getCard(discardPile.getSize() - 1);
                for (int i = 0; i < discardPile.getSize(); i++) {
                    deck.push(discardPile.getCard(i));
                }
                discardPile.removeAll();
                discardPile.addCard(Top);


            }
            if (win == 4) {
                if (System.currentTimeMillis() > lastTime + 3000) {
                    lastTime = System.currentTimeMillis();
                    checkIfPlayerHasToDraw(ai[turnOfPlayer].hand, turnOfPlayer);
                    play();

                    System.out.println("Deck Size::::::: " + deck.size());
                    System.out.println("discarD: " + discardPile.getSize());
//                    System.out.println("Discard hand:::::::::::");
//                    discardPile.printHand();
//                    System.out.println("::::::::::::::::::::::");

//                    System.out.println("top============");
//                    System.out.println(discardPile.getCard(discardPile.getSize()-1));
//                    System.out.println("================");

                }
            }
            //System.out.println("test" + loop);
            loop++;
        } while (currentPlayer == 0);
    }

    /*******************************************
     *           these are methods              *
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


    /*
    /**
     * method to handle wild card logic
     * @param cardNum
     * @return Card

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
    }*/

    /**
     * where the magic happens. Checks which players turn it is, then lets the selected player make a turn.
     * After that turn, it checks if the Card is a special card (e.g. skip, draw2, reverse) and checks win condition.
     * Then it calls the turnOver method which depending on the reverse and skip status changes the turn to the next
     * player.
     */
    private void play() {
        Card playCard;
        if (!connectedUser[turnOfPlayer]) {
            playCard = ai[turnOfPlayer].playTurn();
            System.out.println("-----------------  " + turnOfPlayer);
            skipDraw2ReverseWinChecker(playCard, ai[turnOfPlayer].hand, turnOfPlayer);
        } else {
            playCard = users[turnOfPlayer].playTurn();
            if (!playCard.getCardColor().equalsIgnoreCase("disconnected")) {
                skipDraw2ReverseWinChecker(playCard, users[turnOfPlayer].hand, turnOfPlayer);
            }
        }
    }

    private void checkIfPlayerHasToDraw(Deal handOfPlayer, int player_id) {
        if (draw2) {
            System.out.println("----------player " + player_id + " is drawing 2 cards-------");
            handOfPlayer.addCard(deck.returnTop());
            deck.pop();
            handOfPlayer.addCard(deck.returnTop());
            deck.pop();

            draw2 = false;

        }
        if (draw4) {
            System.out.println("----------player " + player_id + " is drawing 4 cards-------");
            handOfPlayer.addCard(deck.returnTop());
            deck.pop();

            handOfPlayer.addCard(deck.returnTop());
            deck.pop();

            handOfPlayer.addCard(deck.returnTop());
            deck.pop();

            handOfPlayer.addCard(deck.returnTop());
            deck.pop();

            draw4 = false;
        }
    }

    /**
     * first checks if wincondition is met, if not it checks if either a skip, reverse or draw 2 has been played,
     * and takes the necessary actions.
     *
     * @param playCard card that a player has been played in the last turn
     * @param handOfPlayer       the players hand
     */
    private void skipDraw2ReverseWinChecker(Card playCard, Deal handOfPlayer, int id) {
        System.out.println("");
        if (handOfPlayer.getSize() == 0) {
            System.out.println("Someone Won!");
            resetBoard();
            skip = false;
            reverse = false;
            win = turnOfPlayer;

        } else {
            //check if uno has been called but player had to draw
            if (handOfPlayer.getSize() > 1) {
                calledUno[id] = false;
            }



        }

        int CardNumber = playCard.getCardNum();

        if (CardNumber == 10) {
            skip = true;
        }
        if (CardNumber == 11) {
            draw2 = true;
            //  System.out.println(playCard + " ***** draw 2 = true ******");

        }
        if (CardNumber == 12) {
            swapReverse();
        }
        if (CardNumber == 14) {
            draw4 = true;

        }
        turnOver();

    }


    private void timeOut(User user) {
        if (getActionTimeOfPlayer(1) == 30 + getActionTimeOfPlayer(1)) {

            System.out.println("---------player timed out------------");


        }
    }

    /**
     * if reverse true, then change it to false; if reverse false, change it to true.
     */
    private void swapReverse() {
        if (reverse) reverse = false;
        else reverse = true;
    }

    /**
     * depending on the current status of skip and reverse, decides whos turn it is next
     */
    private void turnOver() {
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
        turnStartTime = System.currentTimeMillis();
    }

    /**
     * resets the whole board.
     * Removes any residual cards from hands, creates new deck and shuffles it, resets turn of player to player blue/0.
     * Then deals new cards to each player and lays down the first card onto the discard pile.
     */
    private void resetBoard() {
        player_blue.removeAll();
        player_yellow.removeAll();
        player_green.removeAll();
        player_red.removeAll();
        discardPile.removeAll();
        deck = new Handler();
        deck.addCards();
        System.out.println(deck.size());
        deck.shuffleDeck();
        lastWinner = turnOfPlayer;
        turnOfPlayer = 0;
        for (int i = 0; i < calledUno.length; i++) {
            calledUno[i] = false;
        }
        turnStartTime = System.currentTimeMillis();
        for (int i = 0; i <= 6; i++) {
            player_blue.dealCard(deck);
            player_yellow.dealCard(deck);
            player_green.dealCard(deck);
            player_red.dealCard(deck);

        }

        discardPile.dealCard(deck);
        System.out.println("Top Card: " + discardPile.getCard(0));
    }

    /**
     * Concatenates every important information that we have to send to the client in one single parseble string.
     * These information include:
     *                          - handsizes of each player
     *                          - hands of each player
     *                          - top card on the discard pile
     *                          - last wild colour selected
     *                          - which players turn it is
     * @return the concatenated string
     */
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
            long lastColorConsoleTimer = System.currentTimeMillis();
            if (System.currentTimeMillis() > lastColorConsoleTimer + 5000) {
                System.out.println(lastWildCardColourSelected + " = last color GameLogic");
                lastColorConsoleTimer = System.currentTimeMillis();
            }
        }
        return handSizesandHands;
    }

    /**
     * @return top card of the discard pile
     */
    public Card returnTopOfDiscardPile() {
        return discardPile.getCard(discardPile.getSize() - 1);
    }
    /**
     * @param cardToDiscard card that needs to be discarded
     */
    public void discardCard(Card cardToDiscard) {
        if (cardToDiscard.getCardNum() != 15) {
            discardPile.addCard(cardToDiscard);
        }

    }



    /**
     * @param colour colour that has been selected by the player
     */
    public void selectColour(String colour) {
        lastWildCardColourSelected = colour;
    }

    /**
     * @return the selected colour last time a wild card has been played
     */
    public String getLastWildCardColourSelected() {
        return lastWildCardColourSelected;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public long getTurnStartTime() {
        return turnStartTime;
    }

    public void callsUno(int player_id) {
        calledUno[player_id] = true;
        unoMercy[player_id] = System.currentTimeMillis();
    }

    public void callsOutUno() {
        if (player_blue.getSize() == 1 && !calledUno[0] && unoMercy[0] > System.currentTimeMillis() + 4000) {
            player_blue.dealCard(deck);
            player_blue.dealCard(deck);
        }
        if (player_yellow.getSize() == 1 && !calledUno[1] && unoMercy[1] > System.currentTimeMillis() + 4000) {
            player_yellow.dealCard(deck);
            player_yellow.dealCard(deck);
        }
        if (player_green.getSize() == 1 && !calledUno[2] && unoMercy[2] > System.currentTimeMillis() + 4000) {
            player_green.dealCard(deck);
            player_green.dealCard(deck);
        }
        if (player_red.getSize() == 1 && !calledUno[3] && unoMercy[3] > System.currentTimeMillis() + 4000) {
            player_red.dealCard(deck);
            player_red.dealCard(deck);
        }
    }

    public void userConnected(int id) {
        connectedUser[id] = true;
    }

    public void userDisconnected(int id) {
        connectedUser[id] = false;
    }

    public boolean checkIfStillConnected(int player_id) {
        return connectedUser[player_id];
    }

    public boolean[] getCalledUno() {
        return calledUno;
    }

    public boolean checkCalledUno(int player_id) {
        return calledUno[player_id];
    }

    public void setLastActionTime(long[] actionTimes) {
        lastActionTime = actionTimes;
    }

    public long getActionTimeOfPlayer(int player_id) {
        return lastActionTime[player_id];
    }

    public void setLastConnectionTimes(long[] connectionTimes) {
        lastConnectionTimes = connectionTimes;
    }

    public long getLastConnectionTime(int player_id) {
        return lastConnectionTimes[player_id];
    }

    public int checkWin() {
        return win;
    }

    public void setWinFalseAfterVictoryScreen() {
        win = 4;
    }

    public int getLastWinner() {
        return lastWinner;
    }

    public int getHandSize(int player_id) {
        return ai[player_id].hand.getSize();
    }

    public void userPlayedCard(String message, int userID){
        users[userID].cardPlayed(message);
        System.out.println(message + " = Message, User ID = " + userID + " userPlayedCard method");
    }

    public int getTurnOfPlayer() {
        return turnOfPlayer;
    }

    public void setLastTime(long newTime) {
        lastTime = newTime;
    }
}
