/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 *
 * @author Owner
 */
public class Game extends Canvas implements Runnable {

    private static long serialVersionUID = 1550691097823471818L;
    /**
     * @param args the command line arguments
     */

    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;

    private Thread thread;
    private boolean running = false;
    private Random r;
    private Handler handler;
    private HUD hud;



    public String hands[] = {"y3xg4xr7", "g5xg7xg8xr5", "y0xy1xy2xy3", "r5xg4xb7xb9xw13xw14xr9xb9xy7"};
    int turnOfPlayer = 3;
    String topOfDiscardPile = "g9";




    public Game() {
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        new Window(WIDTH, HEIGHT, "Test Game!", this);


        hud = new HUD();



        r = new Random();


        handler.addObject(new Player(WIDTH/2 -32, HEIGHT/2-32, ID.Player));
        handler.addObject(new UnoBoard(1080, 1920, ID.UnoBoard, hands, turnOfPlayer, topOfDiscardPile));



    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
        hud.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);


        handler.render(g);
        hud.render(g);

        g.dispose();
        bs.show();
    }

    public static int clamp(int var, int min, int max){
        if(var >= max)
            return var = max;
        else if(var <= min)
            return var = min;
        else return var;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        new Game();
    }

}