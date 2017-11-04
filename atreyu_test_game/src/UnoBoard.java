import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;


/*
player 0 = blue, player 1 = yellow, player 2 = green, player 3 = red
 */
public class UnoBoard extends GameObject {

    int SCREEN_HEIGHT;
    int SCREEN_WIDTH;
    ID id;
    boolean colorchanged;
    String[] hands;
    int[] numberOfCardsinHands = new int[4];
    int turnOfPlayer;
    long time = System.currentTimeMillis();
    String topOfDiscardPile;
    Background background;
    CardDrawer cardDrawer;



    public UnoBoard(int SCREEN_HEIGHT, int SCREEN_WIDTH, ID id, String[] hands, int turnOfPlayer, String topOfDiscardPile){
        super(0,0, id);
        this.SCREEN_HEIGHT = SCREEN_HEIGHT;
        this.SCREEN_WIDTH = SCREEN_WIDTH;
        this.id = id;
        this.hands = hands;
        this.turnOfPlayer = turnOfPlayer;
        this.topOfDiscardPile = topOfDiscardPile;
        background = new Background(SCREEN_HEIGHT, SCREEN_WIDTH, numberOfCardsinHands);
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
        CardDrawer cardDrawer = new CardDrawer();
        cardDrawer.drawPlayerCards(g, numberOfCardsinHands, topOfDiscardPile);
}


}
