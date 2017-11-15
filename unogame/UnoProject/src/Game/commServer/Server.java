package Game.commServer;

import Game.GameLogic;

import java.util.Date;

public class Server implements Runnable{

    /**
     *  saves the GameLogic object to be able to retrieve the current status of the game
     */
    private GameLogic gameLogic;

    /**
     * the individual string for each player that gets communicated to them saved in a string array
     */
    private String commstring[] = new String[4];
    /**
     * a String array that saves the current hands of each individual player
     */
    private String hands[] = new String[4];

    /**
     * handsize of player blue
     */
    private int player_blue_handsize;
    /**
     * handsize of player yellow
     */
    private int player_yellow_handsize;
    /**
     * handsize of player green
     */
    private int player_green_handsize;
    /**
     * handsize of player red
     */
    private int player_red_handsize;


    /**
     * current card on top of the discard pile
     */
    private String topOfDiscardPile = "w13";

    /**
     * the number of players in our game
     */
    private static final int NUMBER_OF_PLAYERS = 4;

    /**
     *
     */
    private int turnOfPlayer = 0;

    public Server(GameLogic gameLogic){
        this.gameLogic = gameLogic;
    }

    /**
     * this method instantiates the ConnectionHandler for the WebSocket connection and then updates the hands and
     * handsizes for each individual player every 1000ms and concatenates them again to pass it on to the gui
     */
    public void run(){
        new ConnectionHandler(commstring, NUMBER_OF_PLAYERS).start();
        //just some random data to send to the clients atm TO-DO
        //for(int i = 0; i < NUMBER_OF_PLAYERS; i++){
            //top of discard pile - player number - player 0 # of cards - p1 # of cards - p2 # of cards - p3 # of cards - player hand
        //    commstring[i] = "y4-" + i + "-3-5-4-6-y1xg3xr0";
        //}
        // saves the initialisation time of the method in order to restrain the method to only update every 1000ms
        long lastTime = System.currentTimeMillis();
        while (true) {
            if (System.currentTimeMillis() > lastTime + 1000) {
                lastTime = System.currentTimeMillis();
                gameLogic.getHandSizesAndHands();
                //gets a concatenated string of hands and handsizes for each individual player
                String currentHandSizesAndHands = gameLogic.getHandSizesAndHands();
                String parseHandString[] = currentHandSizesAndHands.split("-");
                if (parseHandString.length == 10) {
                    player_blue_handsize = Integer.parseInt(parseHandString[0]);
                    player_yellow_handsize = Integer.parseInt(parseHandString[1]);
                    player_green_handsize = Integer.parseInt(parseHandString[2]);
                    player_red_handsize = Integer.parseInt(parseHandString[3]);

                    hands[0] = parseHandString[4];
                    hands[1] = parseHandString[5];
                    hands[2] = parseHandString[6];
                    hands[3] = parseHandString[7];
                    topOfDiscardPile = parseHandString[8];
                    turnOfPlayer = Integer.parseInt(parseHandString[9]);

                    for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
                        boolean isPlayersTurn = false;
                        if (turnOfPlayer == i) {
                            isPlayersTurn = true;
                        }
                        commstring[i] = topOfDiscardPile + "-" + i + "-" + player_blue_handsize + "-"
                                + player_yellow_handsize + "-" + player_green_handsize + "-"
                                + player_red_handsize + "-" + hands[i] + "-" + isPlayersTurn;
                    }
                }

            }
        }
    }

    /**
     * @return returns the String array containing the hands of each individual player
     */
    public String[] getHands(){
        return hands;
    }

    /**
     * @return returns the top card on the discard pile
     */
    public String getTopOfDiscardPile() {
        return topOfDiscardPile;
    }

    public int getTurnOfPlayer() {
        return turnOfPlayer;
    }
}
