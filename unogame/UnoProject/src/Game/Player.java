package Game;

import java.util.ArrayList;

public class Player {

    /**
     * 0 = blue
     * 1 = yellow
     * 2 = green
     * 3 = red
     */

    //fields
    int ID;
    ArrayList<Card> Hand;

    //constructor

    public Player(int ID, ArrayList<Card> hand) {
        this.ID = ID;
        Hand = hand;
    }

    public int getID() {
        return ID;
    }

}
