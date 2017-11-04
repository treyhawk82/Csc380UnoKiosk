package Game;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Main{

    public static void main(String[] args) {

        new GUI();

        Handler h = new Handler();

        h.addCards();
        h.returnTop();


    }



}
