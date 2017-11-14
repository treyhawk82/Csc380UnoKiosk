package game.commServer;

import game.GameLogic;

import java.util.Date;

public class Server implements Runnable{

    /**
    * A String array that contains the hands of every player. Will most likely be instantiated by a toString() in the
    * CardHandler class TO-DO
    */
    private GameLogic gameLogic;

    private String commstring[] = new String[4];
    private String hands[] = new String[4];

    private int player_blue_handsize;
    private int player_yellow_handsize;
    private int player_green_handsize;
    private int player_red_handsize;



    private String topOfDiscardPile = "w13";

    /**
     * the number of players in our game
     */
    private static final int NUMBER_OF_PLAYERS = 4;


    public Server(GameLogic gameLogic){
        this.gameLogic = gameLogic;
    }
    public void run(){
        new ConnectionHandler(commstring, NUMBER_OF_PLAYERS).start();
        //just some random data to send to the clients atm TO-DO
        //for(int i = 0; i < NUMBER_OF_PLAYERS; i++){
            //top of discard pile - player number - player 0 # of cards - p1 # of cards - p2 # of cards - p3 # of cards - player hand
        //    commstring[i] = "y4-" + i + "-3-5-4-6-y1xg3xr0";
        //}
        long lastTime = System.currentTimeMillis();

        while (true) {
            if (System.currentTimeMillis() > lastTime + 1000) {
                lastTime = System.currentTimeMillis();
                gameLogic.getHandSizesAndHands();
                String currentHandSizesAndHands = gameLogic.getHandSizesAndHands();
                String parseHandString[] = currentHandSizesAndHands.split("-");
                if (parseHandString.length == 9) {
                    player_blue_handsize = Integer.parseInt(parseHandString[0]);
                    player_yellow_handsize = Integer.parseInt(parseHandString[1]);
                    player_green_handsize = Integer.parseInt(parseHandString[2]);
                    player_red_handsize = Integer.parseInt(parseHandString[3]);

                    hands[0] = parseHandString[4];
                    hands[1] = parseHandString[5];
                    hands[2] = parseHandString[6];
                    hands[3] = parseHandString[7];
                    topOfDiscardPile = parseHandString[8];

                    for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
                        commstring[i] = topOfDiscardPile + "-" + i + "-" + player_blue_handsize + "-"
                                + player_yellow_handsize + "-" + player_green_handsize + "-"
                                + player_red_handsize + "-" + hands[i];
                    }
                }

            }
        }
    }




    public String[] getHands(){
        return hands;
    }

    public String getTopOfDiscardPile() {
        return topOfDiscardPile;
    }
}
