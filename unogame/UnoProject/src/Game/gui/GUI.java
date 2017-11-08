package Game.gui;

import Game.ID;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GUI extends Canvas implements Runnable {

    public static final int SCREEN_WIDTH = 1920;
    public static final int SCREEN_HEIGHT = 1080;

    private Thread thread;
    private boolean running = false;
    private GUIHandler guiHandler;


    public String[] hands = {"y3xg4xr7", "g5xg7xg8xr5", "y0xy1xy2xy3", "r5xg4xb7xb9xw13xw14xr9xb9xy7"};
    int turnOfPlayer = 1;
    String topOfDiscardPile = "g4";

    public GUI(){
        guiHandler = new GUIHandler();
        new Window(SCREEN_WIDTH, SCREEN_HEIGHT, "Test Game!", this);

        guiHandler.addObject(new UnoBoard(SCREEN_WIDTH, SCREEN_HEIGHT, ID.UnoBoard, hands, turnOfPlayer, topOfDiscardPile));
    }


    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
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
                System.out.println("FPS: " + frames);
                frames = 0;
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
}
