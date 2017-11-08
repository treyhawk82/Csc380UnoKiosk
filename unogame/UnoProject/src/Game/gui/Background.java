package Game.gui;

import java.awt.*;

public class Background {

    boolean colorchanged;
    int SCREEN_HEIGHT;
    int SCREEN_WIDTH;
    int[] numberOfCardsinHands;
    long time = System.currentTimeMillis();

    public Background (int SCREEN_WIDTH, int SCREEN_HEIGHT, int[] numberOfCardsinHands){
        this.SCREEN_HEIGHT = SCREEN_HEIGHT;
        this.SCREEN_WIDTH = SCREEN_WIDTH;
        this.numberOfCardsinHands = numberOfCardsinHands;

    }

    public void drawBackground(Graphics g, int turnOfPlayer){
        hasBeenChanged();
        int n = 3;
        if (colorchanged && turnOfPlayer == 0) {
            Color gameBlue = new Color(0, 195, 229);
            g.setColor(gameBlue);
        }else {
            Color darkerGameBlue = new Color(0, 185, 217);
            g.setColor(darkerGameBlue);
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
            Color gameYellow = new Color(247, 227, 89);
            g.setColor(gameYellow);
        }else {
            Color darkerGameYellow = new Color(230, 211, 83);
            g.setColor(darkerGameYellow);
        }
        int[] triangleyellowx = {SCREEN_WIDTH, SCREEN_WIDTH/2, SCREEN_WIDTH};
        int[] triangleyellowy = {0, SCREEN_HEIGHT/2, SCREEN_HEIGHT};
        Polygon yellowp = new Polygon(triangleyellowx, triangleyellowy, n);

        g.fillPolygon(yellowp);
        g.setColor(Color.black);
        font = new Font("TimesRoman", Font.PLAIN, 45);
        g.setFont(font);
        currentHandSize = numberOfCardsinHands[1] + " cards left";
        g.drawString(currentHandSize, 1225, 550);


        if(colorchanged && turnOfPlayer == 2) {
            Color gameGreen = new Color(43,220,150);
            g.setColor(gameGreen);

        }else {
            Color darkerGameGreen = new Color(17,196,125);
            g.setColor(darkerGameGreen);
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
            Color gameRed = new Color(255, 104, 102);
            g.setColor(gameRed);
        }else {
            Color darkerGameRed = new Color(222, 91, 89);
            g.setColor(darkerGameRed);
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
}