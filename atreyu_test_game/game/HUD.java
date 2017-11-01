/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package let.s.build.a.game;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Owner
 */
public class HUD {
    public int HEALTH = 100;
    
    
    
    public void tick(){
        //HEALTH --;
        
        HEALTH = Game.clamp(HEALTH, 0, 100);
    }
    
    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 16);
        g.setColor(Color.red);
        g.fillRect(15, 15, HEALTH*2, 16);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 16);
        
    }
    
    
}
