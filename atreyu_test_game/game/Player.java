/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package let.s.build.a.game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Owner
 */
public class Player extends GameObject{

    Random r = new Random();
    
    public Player(int x, int y, ID id) {
        super(x, y, id);
        
        
        //velX = 1;
        
    }

    
    public void tick() {
         x += velX;
         y += velY;
         x = Game.clamp(x, 0, Game.WIDTH - 37);
         y = Game.clamp(y, 0, Game.HEIGHT - 60);
    }

    
    public void render(Graphics g) {
        if(id == ID.Player)
            g.setColor(Color.white);
        
        
           
        
        //g.setColor(Color.yellow);
        g.fillRect(x, y, 32, 32);
    }
    
    
    
}
