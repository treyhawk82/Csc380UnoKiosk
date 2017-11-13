package Game;


import Game.gui.GUI;
import Game.commServer.*;

public class Main{

    public static void main(String[] args) {

        /**
         * this is a test Main
         */
//        //fields
//        new GUI();
//        new Server().run();

        Handler h = new Handler();

        Player p1 = new Player(0);
        Player p2 = new Player(1);
        Player p3 = new Player(2);
        Player p4 = new Player(3);
        Deal deal = new Deal();

     //   h.returnTop();
        System.out.println();

        h.returnTop();

        Handler deck = new Handler();


        System.out.println("Welcome to Uno");
        System.out.println();
        System.out.println("You are player " + p1.getID());
        h.addCards();
        deal.DealCard(p1);






    }



}
