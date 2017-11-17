package Game;

public class Player {

    /**
     * 0 = blue
     * 1 = yellow
     * 2 = green
     * 3 = red
     */

    //fields
    int ID;


    //constructor
    public Player() {
    }

    public Card playTurn() {
        return new Card("noPlayableCard", 15, false);
    }

    public Player(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

}
