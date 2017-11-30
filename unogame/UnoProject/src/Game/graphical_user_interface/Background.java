package Game.graphical_user_interface;

import Game.GameLogic;
import Game.commServer.Server;

import java.awt.*;

public class Background {

    /**
     * a boolean keeping track if the colour of the active player has been changed in the last second or not
     */
    private boolean colorchanged;

    /**
     * the windows height
     */
    private int SCREEN_HEIGHT;

    /**
     * the windows width
     */
    private int SCREEN_WIDTH;

    /**
     * an integer array containing the handsize of each individual player
     */
    private final int[] numberOfCardsinHands;

    /**
     * a long that gets instantiated with the current time, in order to help switch colour of the active player
     * every second
     */
    private long time = System.currentTimeMillis();

    private final Color blue = new Color(0, 185, 217);
    private final Color highlightBlue = new Color(20, 205, 239);
    private final Color yellow = new Color(230, 211, 83);
    private final Color highlightYellow = new Color(247, 227, 89);
    private final Color green = new Color(17,196,125);
    private final Color highlightGreen = new Color(43,220,150);
    private final Color red = new Color(222, 91, 89);
    private final Color highlightRed = new Color(255, 104, 102);

    private int[] trianglebluex;
    private int[] trianglebluey;
    private int[] triangleyellowx;
    private int[] triangleyellowy;
    private int[] trianglegreenx;
    private int[] trianglegreeny;
    private int[] triangleredx;
    private int[] triangleredy;

    private final int[] cardsLeftPositionsx = {860, 1225, 860, 475};
    private final int[] cardsLeftPositionsy = {375, 550, 755, 550};

    Font font;

    Graphics g;
    int turnOfPlayer;
    UnoBoard unoBoard;

    CardDrawer cardDrawer;
    GUI gui;
    String lastColourSelected;
    Server server;
    double SCREEN_SCALE_WIDTH;
    double SCREEN_SCALE_HEIGHT;

    private GameLogic gameLogic;
    private long lastTimeWithoutWinner = System.currentTimeMillis();

    /**
     * Constructor of Background.
     * @param SCREEN_WIDTH the windows width
     * @param SCREEN_HEIGHT the windows height
     * @param numberOfCardsinHands the number of cards in the hand of each individual player
     */
    public Background(int SCREEN_WIDTH, double SCREEN_SCALE_WIDTH, int SCREEN_HEIGHT, double SCREEN_SCALE_HEIGHT, int[] numberOfCardsinHands, UnoBoard unoBoard) {
        this.SCREEN_HEIGHT = SCREEN_HEIGHT;
        this.SCREEN_WIDTH = SCREEN_WIDTH;
        this.SCREEN_SCALE_WIDTH = SCREEN_SCALE_WIDTH;
        this.SCREEN_SCALE_HEIGHT = SCREEN_SCALE_HEIGHT;
        this.numberOfCardsinHands = numberOfCardsinHands;
        this.colorchanged = false;
        trianglebluex = new int[]{0, SCREEN_WIDTH / 2, SCREEN_WIDTH};
        trianglebluey = new int[]{0, SCREEN_HEIGHT / 2, 0};
        triangleyellowx = new int[]{SCREEN_WIDTH, SCREEN_WIDTH / 2, SCREEN_WIDTH};
        triangleyellowy = new int[]{0, SCREEN_HEIGHT / 2, SCREEN_HEIGHT};
        trianglegreenx = new int[]{0, SCREEN_WIDTH / 2, SCREEN_WIDTH};
        trianglegreeny = new int[]{SCREEN_HEIGHT, SCREEN_HEIGHT / 2, SCREEN_HEIGHT};
        triangleredx = new int[]{0, SCREEN_WIDTH / 2, 0};
        triangleredy = new int[]{0, SCREEN_HEIGHT / 2, SCREEN_HEIGHT};
        this.turnOfPlayer = unoBoard.getTurnOfPlayer();
        this.g = unoBoard.getGraphics();
        this.unoBoard = unoBoard;
        server = unoBoard.server;
        cardDrawer = new CardDrawer(server, SCREEN_SCALE_WIDTH, SCREEN_SCALE_HEIGHT);
        font = new Font("Arial", Font.PLAIN, (int) Math.round(45 / SCREEN_SCALE_WIDTH));
    }

    /**
     * draws the background of the Unoboard, highlighting the active player by changing that colour every second,
     * displaying the number of cards in each players hand etc
     * @param g Graphics that draws the gui
     */
    public void drawBackground(Graphics g, String lastColourSelected) {
        if (gameLogic.checkWin() == 4) {
            hasBeenChanged();
            this.turnOfPlayer = unoBoard.getTurnOfPlayer();
            drawBackgroundColours(g, blue, highlightBlue, trianglebluex, trianglebluey, 0, turnOfPlayer);
            drawBackgroundColours(g, yellow, highlightYellow, triangleyellowx, triangleyellowy, 1, turnOfPlayer);
            drawBackgroundColours(g, green, highlightGreen, trianglegreenx, trianglegreeny, 2, turnOfPlayer);
            drawBackgroundColours(g, red, highlightRed, triangleredx, triangleredy, 3, turnOfPlayer);
            cardDrawer.drawPlayerCards(g, unoBoard.getNumberOfCardsInHands(), unoBoard.getTopOfDiscardPile(), lastColourSelected);
            lastTimeWithoutWinner = System.currentTimeMillis();
        } else {
            if (lastTimeWithoutWinner + 7500 > System.currentTimeMillis()) {
                drawWinScreen(g);
            } else {
                gameLogic.setWinFalseAfterVictoryScreen();
            }

        }
    }

    private void hasBeenChanged(){
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

    private void drawBackgroundColours(Graphics g, Color colour, Color colourHighlight, int[] trianglex, int[] triangley, int player, int turnOfPlayer){
        if (colorchanged && (player == turnOfPlayer)) {
            g.setColor(colourHighlight);
        }else {
            g.setColor(colour);
        }
        g.fillPolygon(new Polygon(trianglex, triangley, 3));
        g.setColor(Color.black);
        g.setFont(font);
        g.drawString((numberOfCardsinHands[player] + " cards left"), (int) Math.round(cardsLeftPositionsx[player] / SCREEN_SCALE_WIDTH), (int) Math.round(cardsLeftPositionsy[player] / SCREEN_SCALE_HEIGHT));
    }

    private void drawWinScreen(Graphics g) {
        int winner = gameLogic.checkWin();
        if (winner == 0) {
            g.setColor(blue);
            g.fillRect(0, 0, (int) Math.round(SCREEN_WIDTH / SCREEN_SCALE_WIDTH), (int) Math.round(SCREEN_HEIGHT / SCREEN_SCALE_HEIGHT));
            g.setColor(Color.black);
            g.setFont(font);
            g.drawString("Player Blue Wins!", (int) Math.round((SCREEN_WIDTH / SCREEN_SCALE_WIDTH - 50 / SCREEN_SCALE_WIDTH) / 2), (int) Math.round((SCREEN_HEIGHT / SCREEN_SCALE_HEIGHT - 50 / SCREEN_SCALE_HEIGHT) - 2));
        } else if (winner == 1) {
            g.setColor(yellow);
            g.fillRect(0, 0, (int) Math.round(SCREEN_WIDTH / SCREEN_SCALE_WIDTH), (int) Math.round(SCREEN_HEIGHT / SCREEN_SCALE_HEIGHT));
            g.setColor(Color.black);
            g.setFont(font);
            g.drawString("Player Yellow Wins!", (int) Math.round((SCREEN_WIDTH / SCREEN_SCALE_WIDTH - 50 / SCREEN_SCALE_WIDTH) / 2), (int) Math.round((SCREEN_HEIGHT / SCREEN_SCALE_HEIGHT - 50 / SCREEN_SCALE_HEIGHT) - 2));
        } else if (winner == 2) {
            g.setColor(green);
            g.fillRect(0, 0, (int) Math.round(SCREEN_WIDTH / SCREEN_SCALE_WIDTH), (int) Math.round(SCREEN_HEIGHT / SCREEN_SCALE_HEIGHT));
            g.setColor(Color.black);
            g.setFont(font);
            g.drawString("Player Green Wins!", (int) Math.round((SCREEN_WIDTH / SCREEN_SCALE_WIDTH - 50 / SCREEN_SCALE_WIDTH) / 2), (int) Math.round((SCREEN_HEIGHT / SCREEN_SCALE_HEIGHT - 50 / SCREEN_SCALE_HEIGHT) - 2));
        } else if (winner == 3) {
            g.setColor(red);
            g.fillRect(0, 0, (int) Math.round(SCREEN_WIDTH / SCREEN_SCALE_WIDTH), (int) Math.round(SCREEN_HEIGHT / SCREEN_SCALE_HEIGHT));
            g.setColor(Color.black);
            g.setFont(font);
            g.drawString("Player Red Wins!", (int) Math.round((SCREEN_WIDTH / SCREEN_SCALE_WIDTH - 50 / SCREEN_SCALE_WIDTH) / 2), (int) Math.round((SCREEN_HEIGHT / SCREEN_SCALE_HEIGHT - 50 / SCREEN_SCALE_HEIGHT) - 2));
        }
    }

    public CardDrawer getCardDrawer() {
        return cardDrawer;
    }

    public void setGameLogic(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }


}