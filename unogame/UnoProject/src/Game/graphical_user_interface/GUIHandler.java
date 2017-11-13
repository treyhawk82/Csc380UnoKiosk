package Game.graphical_user_interface;

import Game.GameObject;

import java.awt.*;
import java.util.LinkedList;

public class GUIHandler {
    LinkedList<GameObject> object = new LinkedList<>();
    public void tick(){
        for (int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);

            tempObject.tick();
        }
    }

    public void render(Graphics g){
        for (int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }
    }

    public void addObject(GameObject object){
        this.object.add(object);
    }

    public void removeObject(GameObject object){
        this.object.remove(object);
    }
}
