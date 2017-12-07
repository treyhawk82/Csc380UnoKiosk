package Game.graphical_user_interface;

import Game.GameLogic;
import Game.commServer.Server;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GUI extends Canvas implements Runnable {

    public static final int SCREEN_WIDTH = 1920;
    public static final int SCREEN_HEIGHT = 1080;

    public static double SCREEN_SCALE_WIDTH = 1.5;
    public static double SCREEN_SCALE_HEIGHT = 1.5;

    private Thread thread;
    private boolean running = false;
    private GUIHandler guiHandler;
    private Server server;
    private long lastTime2;
    private String lastColourSelected = "blue";
    private UnoBoard unoBoard;
    private GameLogic gameLogic;


    public String[] hands = {};
    int turnOfPlayer = 0;
    String topOfDiscardPile = "w13";

    public GUI(Server server){
        guiHandler = new GUIHandler();
        this.server = server;
        new Window((int) Math.round(SCREEN_WIDTH / SCREEN_SCALE_WIDTH), (int) Math.round(SCREEN_HEIGHT / SCREEN_SCALE_HEIGHT), "UNO", this);

        unoBoard = new UnoBoard(SCREEN_WIDTH, SCREEN_SCALE_WIDTH, SCREEN_HEIGHT, SCREEN_SCALE_HEIGHT, ID.UnoBoard, this);
        guiHandler.addObject(unoBoard);
    }


    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
        lastTime2 = System.currentTimeMillis();
    }

    public synchronized void stop(){
        try {
            thread.join();
            running = false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void run(){

        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1){
                tick();
                delta--;
            }
            if(running){
                render();
            }
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                frames = 0;
            }


            if (System.currentTimeMillis() > lastTime2 + 50) {
                hands = server.getHands();
                for (int i = 0; i < hands.length; i++) {
                    lastTime2 = System.currentTimeMillis();
                }
                this.topOfDiscardPile = server.getTopOfDiscardPile();
                this.turnOfPlayer = server.getTurnOfPlayer();
                this.lastColourSelected = server.getLastColourSelected();
            }
        }
        stop();
    }

    private void tick(){
        guiHandler.tick();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        guiHandler.render(g);

        g.dispose();
        bs.show();
    }

    public String[] getHands(){
        return hands;
    }

    public int getTurnOfPlayer() {
        return turnOfPlayer;
    }

    public String getTopOfDiscardPile() {
        return topOfDiscardPile;
    }

    public String getLastColourSelected() {
        return lastColourSelected;
    }

    public Server getServer() {
        return server;
    }

    public CardDrawer getCardDrawer() {
        return unoBoard.getCardDrawer();
    }

    public void setGameLogic(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
        unoBoard.setGameLogic(gameLogic);
    }

    public void setServer(Server server) {
        this.server = server;
    }
}
