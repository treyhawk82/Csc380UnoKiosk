package Game.graphical_user_interface;

import Game.GameObject;
import Game.ID;

import java.awt.*;

/*
player 0 = blue, player 1 = yellow, player 2 = green, player 3 = red
 */
public class UnoBoard extends GameObject {

    int SCREEN_HEIGHT;
    int SCREEN_WIDTH;
    ID id;
    String[] hands;
    int[] numberOfCardsinHands = new int[4];
    int turnOfPlayer;
    String topOfDiscardPile;
    Background background;
    CardDrawer cardDrawer;



    public UnoBoard(int SCREEN_WIDTH, int SCREEN_HEIGHT, ID id, String[] hands, int turnOfPlayer, String topOfDiscardPile){
        super(0,0, id);
        this.SCREEN_HEIGHT = SCREEN_HEIGHT;
        this.SCREEN_WIDTH = SCREEN_WIDTH;
        this.id = id;
        this.hands = hands;
        this.turnOfPlayer = turnOfPlayer;
        this.topOfDiscardPile = topOfDiscardPile;
        background = new Background(SCREEN_WIDTH, SCREEN_HEIGHT, numberOfCardsinHands);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g){
        for (int i = 0; i < hands.length; i++){
            String[] cardsInHand = hands[i].split("x");
            numberOfCardsinHands[i] = cardsInHand.length;
        }



        background.drawBackground(g, turnOfPlayer);
        cardDrawer = new CardDrawer();
        cardDrawer.drawPlayerCards(g, numberOfCardsinHands, topOfDiscardPile);
    }


}