package Game.graphical_user_interface;

import Game.GameLogic;
import Game.commServer.Server;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CardDrawer {

    BufferedImage b0;
    BufferedImage b1;
    BufferedImage b2;
    BufferedImage b3;
    BufferedImage b4;
    BufferedImage b5;
    BufferedImage b6;
    BufferedImage b7;
    BufferedImage b8;
    BufferedImage b9;
    BufferedImage b10;
    BufferedImage b11;
    BufferedImage b12;

    BufferedImage y0;
    BufferedImage y1;
    BufferedImage y2;
    BufferedImage y3;
    BufferedImage y4;
    BufferedImage y5;
    BufferedImage y6;
    BufferedImage y7;
    BufferedImage y8;
    BufferedImage y9;
    BufferedImage y10;
    BufferedImage y11;
    BufferedImage y12;

    BufferedImage g0;
    BufferedImage g1;
    BufferedImage g2;
    BufferedImage g3;
    BufferedImage g4;
    BufferedImage g5;
    BufferedImage g6;
    BufferedImage g7;
    BufferedImage g8;
    BufferedImage g9;
    BufferedImage g10;
    BufferedImage g11;
    BufferedImage g12;

    BufferedImage r0;
    BufferedImage r1;
    BufferedImage r2;
    BufferedImage r3;
    BufferedImage r4;
    BufferedImage r5;
    BufferedImage r6;
    BufferedImage r7;
    BufferedImage r8;
    BufferedImage r9;
    BufferedImage r10;
    BufferedImage r11;
    BufferedImage r12;

    BufferedImage w13;
    BufferedImage w13blue;
    BufferedImage w13yellow;
    BufferedImage w13green;
    BufferedImage w13red;
    BufferedImage w14;
    BufferedImage w14blue;
    BufferedImage w14yellow;
    BufferedImage w14green;
    BufferedImage w14red;

    BufferedImage uno_cardback;
    BufferedImage uno_cardback_right;
    BufferedImage uno_cardback_left;
    BufferedImage uno_called;
    GUI gui;
    String lastColourSelected = "blue";
    Server server;
    GameLogic gameLogic;
    double SCREEN_SCALE_WIDTH;
    double SCREEN_SCALE_HEIGHT;

    boolean unoCalled[] = new boolean[4];

    public CardDrawer(Server server, double SCREEN_SCALE_WIDTH, double SCREEN_SCALE_HEIGHT) {
        this.server = server;
        this.SCREEN_SCALE_WIDTH = SCREEN_SCALE_WIDTH;
        this.SCREEN_SCALE_HEIGHT = SCREEN_SCALE_HEIGHT;
        try {
            b0 = ImageIO.read(new File("src\\Game\\small\\blue_0.png"));
            b1 = ImageIO.read(new File("src\\Game\\small\\blue_1.png"));
            b2 = ImageIO.read(new File("src\\Game\\small\\blue_2.png"));
            b3 = ImageIO.read(new File("src\\Game\\small\\blue_3.png"));
            b4 = ImageIO.read(new File("src\\Game\\small\\blue_4.png"));
            b5 = ImageIO.read(new File("src\\Game\\small\\blue_5.png"));
            b6 = ImageIO.read(new File("src\\Game\\small\\blue_6.png"));
            b7 = ImageIO.read(new File("src\\Game\\small\\blue_7.png"));
            b8 = ImageIO.read(new File("src\\Game\\small\\blue_8.png"));
            b9 = ImageIO.read(new File("src\\Game\\small\\blue_9.png"));
            b10 = ImageIO.read(new File("src\\Game\\small\\blue_skip.png"));
            b11 = ImageIO.read(new File("src\\Game\\small\\blue_picker.png"));
            b12 = ImageIO.read(new File("src\\Game\\small\\blue_reverse.png"));

            y0 = ImageIO.read(new File("src\\Game\\small\\yellow_0.png"));
            y1 = ImageIO.read(new File("src\\Game\\small\\yellow_1.png"));
            y2 = ImageIO.read(new File("src\\Game\\small\\yellow_2.png"));
            y3 = ImageIO.read(new File("src\\Game\\small\\yellow_3.png"));
            y4 = ImageIO.read(new File("src\\Game\\small\\yellow_4.png"));
            y5 = ImageIO.read(new File("src\\Game\\small\\yellow_5.png"));
            y6 = ImageIO.read(new File("src\\Game\\small\\yellow_6.png"));
            y7 = ImageIO.read(new File("src\\Game\\small\\yellow_7.png"));
            y8 = ImageIO.read(new File("src\\Game\\small\\yellow_8.png"));
            y9 = ImageIO.read(new File("src\\Game\\small\\yellow_9.png"));
            y10 = ImageIO.read(new File("src\\Game\\small\\yellow_skip.png"));
            y11 = ImageIO.read(new File("src\\Game\\small\\yellow_picker.png"));
            y12 = ImageIO.read(new File("src\\Game\\small\\yellow_reverse.png"));

            g0 = ImageIO.read(new File("src\\Game\\small\\green_0.png"));
            g1 = ImageIO.read(new File("src\\Game\\small\\green_1.png"));
            g2 = ImageIO.read(new File("src\\Game\\small\\green_2.png"));
            g3 = ImageIO.read(new File("src\\Game\\small\\green_3.png"));
            g4 = ImageIO.read(new File("src\\Game\\small\\green_4.png"));
            g5 = ImageIO.read(new File("src\\Game\\small\\green_5.png"));
            g6 = ImageIO.read(new File("src\\Game\\small\\green_6.png"));
            g7 = ImageIO.read(new File("src\\Game\\small\\green_7.png"));
            g8 = ImageIO.read(new File("src\\Game\\small\\green_8.png"));
            g9 = ImageIO.read(new File("src\\Game\\small\\green_9.png"));
            g10 = ImageIO.read(new File("src\\Game\\small\\green_skip.png"));
            g11 = ImageIO.read(new File("src\\Game\\small\\green_picker.png"));
            g12 = ImageIO.read(new File("src\\Game\\small\\green_reverse.png"));

            r0 = ImageIO.read(new File("src\\Game\\small\\red_0.png"));
            r1 = ImageIO.read(new File("src\\Game\\small\\red_1.png"));
            r2 = ImageIO.read(new File("src\\Game\\small\\red_2.png"));
            r3 = ImageIO.read(new File("src\\Game\\small\\red_3.png"));
            r4 = ImageIO.read(new File("src\\Game\\small\\red_4.png"));
            r5 = ImageIO.read(new File("src\\Game\\small\\red_5.png"));
            r6 = ImageIO.read(new File("src\\Game\\small\\red_6.png"));
            r7 = ImageIO.read(new File("src\\Game\\small\\red_7.png"));
            r8 = ImageIO.read(new File("src\\Game\\small\\red_8.png"));
            r9 = ImageIO.read(new File("src\\Game\\small\\red_9.png"));
            r10 = ImageIO.read(new File("src\\Game\\small\\red_skip.png"));
            r11 = ImageIO.read(new File("src\\Game\\small\\red_picker.png"));
            r12 = ImageIO.read(new File("src\\Game\\small\\red_reverse.png"));

            uno_cardback = ImageIO.read(new File("src\\Game\\small\\card_back.png"));
            uno_cardback_left = ImageIO.read(new File("src\\Game\\small\\card_back_left.png"));
            uno_cardback_right = ImageIO.read(new File("src\\Game\\small\\card_back_right.png"));

            w13 = ImageIO.read(new File("src\\Game\\small\\wild_color_changer.png"));
            w13blue = ImageIO.read(new File("src\\Game\\small\\wild_color_changer_blue.png"));
            w13yellow = ImageIO.read(new File("src\\Game\\small\\wild_color_changer_yellow.png"));
            w13green = ImageIO.read(new File("src\\Game\\small\\wild_color_changer_green.png"));
            w13red = ImageIO.read(new File("src\\Game\\small\\wild_color_changer_red.png"));

            w14 = ImageIO.read(new File("src\\Game\\small\\wild_pick_four.png"));
            w14blue = ImageIO.read(new File("src\\Game\\small\\wild_pick_four_blue.png"));
            w14yellow = ImageIO.read(new File("src\\Game\\small\\wild_pick_four_yellow.png"));
            w14green = ImageIO.read(new File("src\\Game\\small\\wild_pick_four_green.png"));
            w14red = ImageIO.read(new File("src\\Game\\small\\wild_pick_four_red.png"));

            uno_called = ImageIO.read(new File("src\\Game\\small\\uno_called.png"));

            for (boolean calledUnos : unoCalled
                    ) {
                calledUnos = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void drawPlayerCards(Graphics g, int[] numberOfCardsinHands, String topOfDiscardPile, String lastColourSelected) {
        drawCardsPlayerBlue(g, numberOfCardsinHands);
        drawCardsPlayerGreen(g, numberOfCardsinHands);
        drawCardsPlayerRed(g, numberOfCardsinHands);
        drawCardsPlayerYellow(g, numberOfCardsinHands);
        drawDeck(g);
        drawTopOfDiscardPile(810, 449, g, topOfDiscardPile, lastColourSelected);
        drawCalledUnos(g);

    }

    public void drawCard_right(int x, int y, Graphics g){
        g.drawImage(uno_cardback_right, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), null);
    }

    public void drawCard_left(int x, int y, Graphics g){
        g.drawImage(uno_cardback_left, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), null);
    }

    public void drawCard(int x, int y, Graphics g){
        g.drawImage(uno_cardback, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
    }


    public void drawCardsPlayerBlue(Graphics g, int[] numberOfCardsinHands){
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

    public void drawCardsPlayerYellow (Graphics g, int[] numberOfCardsinHands){
        if (numberOfCardsinHands[1] > 0)drawCard_right(1718, 475, g);
        if (numberOfCardsinHands[1] > 1)drawCard_right(1718, 335, g);
        if (numberOfCardsinHands[1] > 2)drawCard_right(1718, 615, g);
        if (numberOfCardsinHands[1] > 3)drawCard_right(1718, 195, g);
        if (numberOfCardsinHands[1] > 4)drawCard_right(1718, 755, g);
        if (numberOfCardsinHands[1] > 5)drawCard_right(1718, 55, g);
        if (numberOfCardsinHands[1] > 6)drawCard_right(1718, 895, g);
        if (numberOfCardsinHands[1] > 7)drawCard_right(1708, 55, g);
        if (numberOfCardsinHands[1] > 8)drawCard_right(1698, 55, g);
    }

    public void drawCardsPlayerGreen(Graphics g, int[] numberOfCardsinHands){
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

    public void drawCardsPlayerRed(Graphics g, int[] numberOfCardsinHands){
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


    public void drawTopOfDiscardPile(int x, int y, Graphics g, String topOfDiscardPile, String lastColourSelected) {
        if(topOfDiscardPile.equals("b0")){
            g.drawImage(b0, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("b1") || topOfDiscardPile.equalsIgnoreCase("b1e")) {
            g.drawImage(b1, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("b2") || topOfDiscardPile.equalsIgnoreCase("b2e")) {
            g.drawImage(b2, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("b3") || topOfDiscardPile.equalsIgnoreCase("b3e")) {
            g.drawImage(b3, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("b4") || topOfDiscardPile.equalsIgnoreCase("b4e")) {
            g.drawImage(b4, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("b5") || topOfDiscardPile.equalsIgnoreCase("b5e")) {
            g.drawImage(b5, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("b6") || topOfDiscardPile.equalsIgnoreCase("b6e")) {
            g.drawImage(b6, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("b7") || topOfDiscardPile.equalsIgnoreCase("b7e")) {
            g.drawImage(b7, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("b8") || topOfDiscardPile.equalsIgnoreCase("b8e")) {
            g.drawImage(b8, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("b9") || topOfDiscardPile.equalsIgnoreCase("b9e")) {
            g.drawImage(b9, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("b10") || topOfDiscardPile.equalsIgnoreCase("b10e")) {
            g.drawImage(b10, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("b11") || topOfDiscardPile.equalsIgnoreCase("b11e")) {
            g.drawImage(b11, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("b12") || topOfDiscardPile.equalsIgnoreCase("b12e")) {
            g.drawImage(b12, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("y0") || topOfDiscardPile.equalsIgnoreCase("y0e")) {
            g.drawImage(y0, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("y1") || topOfDiscardPile.equalsIgnoreCase("y1e")) {
            g.drawImage(y1, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("y2") || topOfDiscardPile.equalsIgnoreCase("y2e")) {
            g.drawImage(y2, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("y3") || topOfDiscardPile.equalsIgnoreCase("y3e")) {
            g.drawImage(y3, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("y4") || topOfDiscardPile.equalsIgnoreCase("y4e")) {
            g.drawImage(y4, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("y5") || topOfDiscardPile.equalsIgnoreCase("y5e")) {
            g.drawImage(y5, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("y6") || topOfDiscardPile.equalsIgnoreCase("y6e")) {
            g.drawImage(y6, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("y7") || topOfDiscardPile.equalsIgnoreCase("y7e")) {
            g.drawImage(y7, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("y8") || topOfDiscardPile.equalsIgnoreCase("y8e")) {
            g.drawImage(y8, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("y9") || topOfDiscardPile.equalsIgnoreCase("y9e")) {
            g.drawImage(y9, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("y10") || topOfDiscardPile.equalsIgnoreCase("y10e")) {
            g.drawImage(y10, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("y11") || topOfDiscardPile.equalsIgnoreCase("y11e")) {
            g.drawImage(y11, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("y12") || topOfDiscardPile.equalsIgnoreCase("y12e")) {
            g.drawImage(y12, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("g0")) {
            g.drawImage(g0, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("g1") || topOfDiscardPile.equalsIgnoreCase("g1e")) {
            g.drawImage(g1, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("g2") || topOfDiscardPile.equalsIgnoreCase("g2e")) {
            g.drawImage(g2, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("g3") || topOfDiscardPile.equalsIgnoreCase("g3e")) {
            g.drawImage(g3, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("g4") || topOfDiscardPile.equalsIgnoreCase("g4e")) {
            g.drawImage(g4, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("g5") || topOfDiscardPile.equalsIgnoreCase("g5e")) {
            g.drawImage(g5, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("g6") || topOfDiscardPile.equalsIgnoreCase("g6e")) {
            g.drawImage(g6, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("g7") || topOfDiscardPile.equalsIgnoreCase("g7e")) {
            g.drawImage(g7, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("g8") || topOfDiscardPile.equalsIgnoreCase("g8e")) {
            g.drawImage(g8, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("g9") || topOfDiscardPile.equalsIgnoreCase("g9e")) {
            g.drawImage(g9, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("g10") || topOfDiscardPile.equalsIgnoreCase("g10e")) {
            g.drawImage(g10, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("g11") || topOfDiscardPile.equalsIgnoreCase("g11e")) {
            g.drawImage(g11, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("g12") || topOfDiscardPile.equalsIgnoreCase("g12e")) {
            g.drawImage(g12, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("r0")) {
            g.drawImage(r0, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("r1") || topOfDiscardPile.equalsIgnoreCase("r1e")) {
            g.drawImage(r1, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("r2") || topOfDiscardPile.equalsIgnoreCase("r2e")) {
            g.drawImage(r2, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("r3") || topOfDiscardPile.equalsIgnoreCase("r3e")) {
            g.drawImage(r3, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("r4") || topOfDiscardPile.equalsIgnoreCase("r4e")) {
            g.drawImage(r4, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("r5") || topOfDiscardPile.equalsIgnoreCase("r5e")) {
            g.drawImage(r5, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("r6") || topOfDiscardPile.equalsIgnoreCase("r6e")) {
            g.drawImage(r6, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("r7") || topOfDiscardPile.equalsIgnoreCase("r7e")) {
            g.drawImage(r7, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("r8") || topOfDiscardPile.equalsIgnoreCase("r8e")) {
            g.drawImage(r8, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("r9") || topOfDiscardPile.equalsIgnoreCase("r9e")) {
            g.drawImage(r9, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("r10") || topOfDiscardPile.equalsIgnoreCase("r10e")) {
            g.drawImage(r10, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("r11") || topOfDiscardPile.equalsIgnoreCase("r11e")) {
            g.drawImage(r11, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if (topOfDiscardPile.equals("r12") || topOfDiscardPile.equalsIgnoreCase("r12e")) {
            g.drawImage(r12, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        }
        //else if(topOfDiscardPile.equals("w13")){
        //    g.drawImage(w13, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int)Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        //}
        //else if(topOfDiscardPile.equals("w14")){
        //    g.drawImage(w14, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int)Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        //}
        else if ((topOfDiscardPile.equals("w13") || topOfDiscardPile.equalsIgnoreCase("w13e") || topOfDiscardPile.equalsIgnoreCase("w13f") || topOfDiscardPile.equalsIgnoreCase("w13g")) && lastColourSelected.equalsIgnoreCase("blue")) {
            g.drawImage(w13blue, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if ((topOfDiscardPile.equals("w13") || topOfDiscardPile.equalsIgnoreCase("w13e") || topOfDiscardPile.equalsIgnoreCase("w13f") || topOfDiscardPile.equalsIgnoreCase("w13g")) && lastColourSelected.equalsIgnoreCase("yellow")) {
            g.drawImage(w13yellow, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if ((topOfDiscardPile.equals("w13") || topOfDiscardPile.equalsIgnoreCase("w13e") || topOfDiscardPile.equalsIgnoreCase("w13f") || topOfDiscardPile.equalsIgnoreCase("w13g")) && lastColourSelected.equalsIgnoreCase("green")) {
            g.drawImage(w13green, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if ((topOfDiscardPile.equals("w13") || topOfDiscardPile.equalsIgnoreCase("w13e") || topOfDiscardPile.equalsIgnoreCase("w13f") || topOfDiscardPile.equalsIgnoreCase("w13g")) && lastColourSelected.equalsIgnoreCase("red")) {
            g.drawImage(w13red, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if ((topOfDiscardPile.equals("w14") || topOfDiscardPile.equalsIgnoreCase("w14e") || topOfDiscardPile.equalsIgnoreCase("w14f") || topOfDiscardPile.equalsIgnoreCase("w14g")) && lastColourSelected.equalsIgnoreCase("blue")) {
            g.drawImage(w14blue, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if ((topOfDiscardPile.equals("w14") || topOfDiscardPile.equalsIgnoreCase("w14e") || topOfDiscardPile.equalsIgnoreCase("w14f") || topOfDiscardPile.equalsIgnoreCase("w14g")) && lastColourSelected.equalsIgnoreCase("yellow")) {
            g.drawImage(w14yellow, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if ((topOfDiscardPile.equals("w14") || topOfDiscardPile.equalsIgnoreCase("w14e") || topOfDiscardPile.equalsIgnoreCase("w14f") || topOfDiscardPile.equalsIgnoreCase("w14g")) && lastColourSelected.equalsIgnoreCase("green")) {
            g.drawImage(w14green, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        } else if ((topOfDiscardPile.equals("w14") || topOfDiscardPile.equalsIgnoreCase("w14e") || topOfDiscardPile.equalsIgnoreCase("w14f") || topOfDiscardPile.equalsIgnoreCase("w14g")) && lastColourSelected.equalsIgnoreCase("red")) {
            g.drawImage(w14red, (int) Math.round(x / SCREEN_SCALE_WIDTH), (int) Math.round(y / SCREEN_SCALE_HEIGHT), (int) Math.round(130 / SCREEN_SCALE_WIDTH), (int) Math.round(182 / SCREEN_SCALE_HEIGHT), null);
        }
    }

    public void drawCalledUnos(Graphics g) {
        unoCalled = gameLogic.getCalledUno();
        if (unoCalled[0]) {
            g.drawImage(uno_called, 615 / (int) Math.round(SCREEN_SCALE_WIDTH), 110 / (int) Math.round(SCREEN_SCALE_HEIGHT), 106 / (int) Math.round(SCREEN_SCALE_WIDTH), 108 / (int) Math.round(SCREEN_SCALE_HEIGHT), null);
        }
        if (unoCalled[1]) {
            g.drawImage(uno_called, 1618 / (int) Math.round(SCREEN_SCALE_WIDTH), 195 / (int) Math.round(SCREEN_SCALE_HEIGHT), 106 / (int) Math.round(SCREEN_SCALE_WIDTH), 108 / (int) Math.round(SCREEN_SCALE_HEIGHT), null);
        }
        if (unoCalled[2]) {
            g.drawImage(uno_called, 615 / (int) Math.round(SCREEN_SCALE_WIDTH), 788 / (int) Math.round(SCREEN_SCALE_HEIGHT), 106 / (int) Math.round(SCREEN_SCALE_WIDTH), 108 / (int) Math.round(SCREEN_SCALE_HEIGHT), null);
        }
        if (unoCalled[3]) {
            g.drawImage(uno_called, 110 / (int) Math.round(SCREEN_SCALE_WIDTH), 195 / (int) Math.round(SCREEN_SCALE_HEIGHT), 106 / (int) Math.round(SCREEN_SCALE_WIDTH), 108 / (int) Math.round(SCREEN_SCALE_HEIGHT), null);
        }
    }

    public void setGameLogic(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }
}