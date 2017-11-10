package Game;


import Game.gui.GUI;
import Game.commServer.*;

public class Main{

    public static void main(String[] args) {

        new GUI();
        new Server().run();

        Handler h = new Handler();

        h.addCards();
     //   h.returnTop();
        System.out.println();

        h.returnTop();

        Handler deck = new Handler();






    }



}
