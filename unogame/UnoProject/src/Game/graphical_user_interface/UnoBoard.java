package Game.graphical_user_interface;

import Game.GameObject;
import Game.commServer.Server;

import java.awt.*;
import java.util.Arrays;

/*
player 0 = blue, player 1 = yellow, player 2 = green, player 3 = red
 */
public class UnoBoard extends GameObject {

    int SCREEN_HEIGHT;
    int SCREEN_WIDTH;
    double SCREEN_SCALE_WIDTH;
    double SCREEN_SCALE_HEIGHT;
    ID id;
    String[] hands;
    String[] oldHands;
    int[] numberOfCardsinHands = new int[4];
    int turnOfPlayer;
    String topOfDiscardPile;
    Background background;
    GUI gui;
    Graphics g;
    boolean firstTime = true;
    Server server;
    String lastColourSelected = "blue";

    public UnoBoard(int SCREEN_WIDTH, double SCREEN_SCALE_WIDTH, int SCREEN_HEIGHT, double SCREEN_SCALE_HEIGHT, ID id, GUI gui) {
        super(0,0, id);
        this.SCREEN_HEIGHT = SCREEN_HEIGHT;
        this.SCREEN_WIDTH = SCREEN_WIDTH;
        this.SCREEN_SCALE_WIDTH = SCREEN_SCALE_WIDTH;
        this.SCREEN_SCALE_HEIGHT = SCREEN_SCALE_HEIGHT;
        this.id = id;
        this.hands = gui.getHands();
        this.turnOfPlayer = gui.getTurnOfPlayer();
        this.topOfDiscardPile = gui.getTopOfDiscardPile();
        background = new Background((int) Math.round(SCREEN_WIDTH / SCREEN_SCALE_WIDTH), SCREEN_SCALE_WIDTH, (int) Math.round(SCREEN_HEIGHT / SCREEN_SCALE_HEIGHT), SCREEN_SCALE_HEIGHT, numberOfCardsinHands, this);
        this.gui = gui;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g){
        this.g = g;
        hands = gui.getHands();

        turnOfPlayer = gui.getTurnOfPlayer();
            topOfDiscardPile = gui.topOfDiscardPile;
            for (int i = 0; i < hands.length; i++) {
                String[] cardsInHand = hands[i].split("x");
                numberOfCardsinHands[i] = cardsInHand.length;
            }
        server = gui.getServer();
        lastColourSelected = server.getLastColourSelected();
        background.drawBackground(g, lastColourSelected);
    }


    public int getTurnOfPlayer(){
        return turnOfPlayer;
    }

    public Graphics getGraphics(){
        return g;
    }

    public String getTopOfDiscardPile(){ return topOfDiscardPile;}

    public int[] getNumberOfCardsInHands() {
        return numberOfCardsinHands;
    }

    public GUI getGui() {
        return gui;
    }

    public CardDrawer getCardDrawer() {
        return background.getCardDrawer();
    }
}