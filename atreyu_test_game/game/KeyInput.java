/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package let.s.build.a.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Owner
 */
public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getID() == ID.Player) {
                //key events for player
                if (key == KeyEvent.VK_W) {
                    tempObject.setVelY(-5);
                }
                if (key == KeyEvent.VK_S) {
                    tempObject.setVelY(5);
                }
                if (key == KeyEvent.VK_D) {
                    tempObject.setVelX(5);
                }
                if (key == KeyEvent.VK_A) {
                    tempObject.setVelX(-5);
                }
            }
           
            

        }
         if(key == KeyEvent.VK_ESCAPE) System.exit(1);

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getID() == ID.Player) {
                //key events for player
                if (key == KeyEvent.VK_W) {
                    tempObject.setVelY(0);
                }
                if (key == KeyEvent.VK_S) {
                    tempObject.setVelY(0);
                }
                if (key == KeyEvent.VK_D) {
                    tempObject.setVelX(0);
                }
                if (key == KeyEvent.VK_A) {
                    tempObject.setVelX(0);
                }
            }

        }

    }

}
