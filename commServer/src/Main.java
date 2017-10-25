public class Main {

    private static String[] hands;
    private static int NUMBER_OF_PLAYERS = 4;

    public static void main(String[] args){
        hands = new String[NUMBER_OF_PLAYERS];
        new WebsocketServer(hands, NUMBER_OF_PLAYERS).start();
        for(int i = 0; i < NUMBER_OF_PLAYERS; i++){
            hands[i] = "Karten: " + i;
        }
    }
}
