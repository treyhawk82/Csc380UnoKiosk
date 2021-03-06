public class Main {

    /**
     * A String array that contains the hands of every player. Will most likely be instantiated by a toString() in the
     * CardHandler class TO-DO
     */
    private static String[] hands;
    /**
     * the number of players in our game
     */
    private static final int NUMBER_OF_PLAYERS = 4;

    public static void main(String[] args){
        hands = new String[NUMBER_OF_PLAYERS];
        new WebsocketServer(hands, NUMBER_OF_PLAYERS).start();

        //just some random data to send to the clients atm TO-DO
        for(int i = 0; i < NUMBER_OF_PLAYERS; i++){
            //top of discard pile - player number - player 0 # of cards - p1 # of cards - p2 # of cards - p3 # of cards - player hand
            hands[i] = "y4-" + i + "-3-5-4-6-y1xg3xr0";
        }
    }
}
