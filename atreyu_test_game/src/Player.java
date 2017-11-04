/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Owner
 */
public class Player extends GameObject{

    Random r = new Random();

    private boolean colorchanged = false;
    long timeint = System.currentTimeMillis();
    int PLAYER_WIDTH = 32;
    int PLAYER_HEIGHT = 32;

    public Player(int x, int y, ID id) {
        super(x, y, id);


        //velX = 1;

    }


    public void tick() {
        x += velX;
        y += velY;
        x = Game.clamp(x, 0, Game.WIDTH - 37);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);
        long currentTime = System.currentTimeMillis();
        if(currentTime > timeint + 1000){
            if (colorchanged){
                colorchanged = false;
                timeint = currentTime;
            }
            else{
                colorchanged = true;
                timeint = currentTime;
            }

        }
    }


    public void render(Graphics g) {
        Color gameRed = new Color(245, 100,98);
        Color darkerGameRed = new Color(215,70,68);
        if(id == ID.Player)
            if(colorchanged) {

                g.setColor(gameRed);
            }else {

                g.setColor(gameRed);
            }



        //g.setColor(Color.yellow);
        g.fillRect(x, y, PLAYER_WIDTH, PLAYER_HEIGHT);
    }



}