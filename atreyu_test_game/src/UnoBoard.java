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

    public UnoBoard(int SCREEN_HEIGHT, int SCREEN_WIDTH, ID id, String[] hands, int turnOfPlayer, String topOfDiscardPile){
        super(0,0, id);
        this.SCREEN_HEIGHT = SCREEN_HEIGHT;
        this.SCREEN_WIDTH = SCREEN_WIDTH;
        this.id = id;
        this.hands = hands;
        this.turnOfPlayer = turnOfPlayer;
        this.topOfDiscardPile = topOfDiscardPile;
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

        hasBeenChanged();

        drawBackground(g);
        drawCards(g);
}

    public void drawCard_right(int x, int y, Graphics g){
        BufferedImage uno_cardback_right = null;
        try {
            uno_cardback_right = ImageIO.read(new File("src/small/card_back_right.png"));
            ((Graphics2D) g).drawImage(uno_cardback_right, x, y, 182, 130, null);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void drawCard_left(int x, int y, Graphics g){
        try {
            BufferedImage uno_cardback_left = ImageIO.read(new File("src/small/card_back_left.png"));
            ((Graphics2D) g).drawImage(uno_cardback_left, x, y, 182, 130, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawCard(int x, int y, Graphics g){
        try {
            BufferedImage uno_cardback = ImageIO.read(new File("src/small/card_back.png"));
            ((Graphics2D) g).drawImage(uno_cardback, x, y, 130, 182, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void drawCardsBlue(Graphics g){
        if (numberOfCardsinHands[0] > 0)drawCard(895, 10, g);
        if (numberOfCardsinHands[0] > 1)drawCard(755, 10, g);
        if (numberOfCardsinHands[0] > 2)drawCard(1035, 10, g);
        if (numberOfCardsinHands[0] > 3)drawCard(615, 10, g);
        if (numberOfCardsinHands[0] > 4)drawCard(1175, 10, g);
        if (numberOfCardsinHands[0] > 5)drawCard(475, 10, g);
        if (numberOfCardsinHands[0] > 6)drawCard(1315, 10, g);
        if (numberOfCardsinHands[0] > 7)drawCard(475, 20, g);
        if (numberOfCardsinHands[0] > 8)drawCard(475, 30, g);
    }

    public void drawCardsYellow (Graphics g){
        if (numberOfCardsinHands[1] > 0)drawCard_right(1728, 475, g);
        if (numberOfCardsinHands[1] > 1)drawCard_right(1728, 335, g);
        if (numberOfCardsinHands[1] > 2)drawCard_right(1728, 615, g);
        if (numberOfCardsinHands[1] > 3)drawCard_right(1728, 195, g);
        if (numberOfCardsinHands[1] > 4)drawCard_right(1728, 755, g);
        if (numberOfCardsinHands[1] > 5)drawCard_right(1728, 55, g);
        if (numberOfCardsinHands[1] > 6)drawCard_right(1728, 895, g);
        if (numberOfCardsinHands[1] > 7)drawCard_right(1718, 55, g);
        if (numberOfCardsinHands[1] > 8)drawCard_right(1708, 55, g);
    }

    public void drawCardsGreen(Graphics g){
        if (numberOfCardsinHands[2] > 0)drawCard(895, 888, g);
        if (numberOfCardsinHands[2] > 1)drawCard(755, 888, g);
        if (numberOfCardsinHands[2] > 2)drawCard(1035, 888, g);
        if (numberOfCardsinHands[2] > 3)drawCard(615, 888, g);
        if (numberOfCardsinHands[2] > 4)drawCard(1175, 888, g);
        if (numberOfCardsinHands[2] > 5)drawCard(475, 888, g);
        if (numberOfCardsinHands[2] > 6)drawCard(1315, 888, g);
        if (numberOfCardsinHands[2] > 7)drawCard(1315, 878, g);
        if (numberOfCardsinHands[2] > 8)drawCard(1315, 868, g);
    }

    public void drawCardsRed(Graphics g){
        if (numberOfCardsinHands[3] > 0)drawCard_left(10, 475, g);
        if (numberOfCardsinHands[3] > 1)drawCard_left(10, 335, g);
        if (numberOfCardsinHands[3] > 2)drawCard_left(10, 615, g);
        if (numberOfCardsinHands[3] > 3)drawCard_left(10, 195, g);
        if (numberOfCardsinHands[3] > 4)drawCard_left(10, 755, g);
        if (numberOfCardsinHands[3] > 5)drawCard_left(10, 55, g);
        if (numberOfCardsinHands[3] > 6)drawCard_left(10, 895, g);
        if (numberOfCardsinHands[3] > 7)drawCard_left(20, 895, g);
        if (numberOfCardsinHands[3] > 8)drawCard_left(30, 895, g);
    }



    public void drawDeck (Graphics g){
        drawCard(985, 449, g);
        drawCard(985, 454, g);
        drawCard(985, 459, g);
        drawCard(985, 464, g);
        drawCard(985, 469, g);
    }

    public void hasBeenChanged(){
        long currentTime = System.currentTimeMillis();
        if(currentTime > time + 1000){
            if (colorchanged){
                colorchanged = false;
                time = currentTime;
            }
            else{
                colorchanged = true;
                time = currentTime;
            }

        }
    }

    public void drawBackground(Graphics g){
        int n = 3;
        if (colorchanged && turnOfPlayer == 0) {
            Color darkerGameBlue = new Color(0, 185, 217);
            g.setColor(darkerGameBlue);
        }else {
            Color gameBlue = new Color(0, 195, 229);
            g.setColor(gameBlue);
        }
        int[] trianglebluex = {0, SCREEN_WIDTH/2, SCREEN_WIDTH};
        int[] trianglebluey = {0, SCREEN_HEIGHT/2, 0};
        Polygon bluep = new Polygon(trianglebluex, trianglebluey, n);

        g.fillPolygon(bluep);
        g.setColor(Color.black);
        Font font = new Font("TimesRoman", Font.PLAIN, 45);
        g.setFont(font);
        String currentHandSize = numberOfCardsinHands[0] + " cards left";
        g.drawString(currentHandSize, 860, 375);

        if(colorchanged && turnOfPlayer == 1) {
            Color darkerGameYellow = new Color(230, 211, 83);
            g.setColor(darkerGameYellow);
        }else {
            Color gameYellow = new Color(247, 227, 89);
            g.setColor(gameYellow);
        }
        int[] triangleyellowx = {SCREEN_WIDTH, SCREEN_WIDTH/2, SCREEN_WIDTH};
        int[] triangleyellowy = {0, SCREEN_HEIGHT/2, SCREEN_HEIGHT};
        Polygon yellowp = new Polygon(triangleyellowx, triangleyellowy, n);

        g.fillPolygon(yellowp);
        g.setColor(Color.black);
        font = new Font("TimesRoman", Font.PLAIN, 45);
        g.setFont(font);
        currentHandSize = numberOfCardsinHands[3] + " cards left";
        g.drawString(currentHandSize, 1225, 550);


        if(colorchanged && turnOfPlayer == 2) {
            Color darkerGameGreen = new Color(17,196,125);
            g.setColor(darkerGameGreen);
        }else {
            Color gameGreen = new Color(47,226,155);
            g.setColor(gameGreen);
        }

        int[] trianglegreenx = {0, SCREEN_WIDTH/2, SCREEN_WIDTH};
        int[] trianglegreeny = {SCREEN_HEIGHT, SCREEN_HEIGHT/2, SCREEN_HEIGHT};
        Polygon greenp = new Polygon(trianglegreenx, trianglegreeny, n);

        g.fillPolygon(greenp);
        g.setColor(Color.black);
        font = new Font("TimesRoman", Font.PLAIN, 45);
        g.setFont(font);
        currentHandSize = numberOfCardsinHands[2] + " cards left";
        g.drawString(currentHandSize, 860, 755);

        if(colorchanged && turnOfPlayer == 3){
            Color darkerGameRed = new Color(222, 91, 89);
            g.setColor(darkerGameRed);
        }else {
            Color gameRed = new Color(255, 104, 102);
            g.setColor(gameRed);
        }
        int[] triangleredx = {0, SCREEN_WIDTH/2, 0};
        int[] triangleredy = {0, SCREEN_HEIGHT/2, SCREEN_HEIGHT};
        Polygon redp = new Polygon(triangleredx, triangleredy, n);

        g.fillPolygon(redp);
        g.setColor(Color.black);
        font = new Font("TimesRoman", Font.PLAIN, 45);
        g.setFont(font);
        currentHandSize = numberOfCardsinHands[3] + " cards left";
        g.drawString(currentHandSize, 475, 550);
    }

    public void drawCards(Graphics g){
        drawCardsBlue(g);
        drawCardsGreen(g);
        drawCardsRed(g);
        drawCardsYellow(g);
        drawDeck(g);
        drawTopOfDiscardPile(810 ,449, g);
    }

    public void drawTopOfDiscardPile(int x, int y, Graphics g){
        if(topOfDiscardPile.equals("b0")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_0.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b1")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_1.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b2")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_2.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b3")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_3.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b4")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_4.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b5")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_5.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b6")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_6.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b7")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_7.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b8")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_8.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b9")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_9.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b10")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_skip.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b11")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_picker.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b12")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_reverse.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y0")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_0.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y1")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_1.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y2")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_2.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y3")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_3.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y4")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_4.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y5")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_5.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y6")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_6.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y7")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_7.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y8")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_8.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y9")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_9.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y10")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_skip.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y11")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_picker.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y12")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_reverse.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g0")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_0.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g1")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_1.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g2")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_2.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g3")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_3.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g4")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_4.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g5")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_5.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g6")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_6.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g7")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_7.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g8")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_8.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g9")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_9.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g10")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_skip.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g11")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_picker.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g12")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_reverse.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r0")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_0.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r1")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_1.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r2")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_2.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r3")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_3.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r4")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_4.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r5")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_5.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r6")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_6.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r7")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_7.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r8")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_8.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r9")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_9.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r10")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_skip.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r11")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_picker.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r12")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_reverse.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("w13")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/wild_color_changer.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("w14")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/wild_pick_4.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
