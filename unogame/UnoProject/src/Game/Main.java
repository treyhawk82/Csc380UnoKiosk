package game;


import game.commServer.Server;
import game.graphical_user_interface.GUI;

public class Main{

    public static void main(String[] args) {

        /**
         * this is a test Main
         */
//        //fields
//        new Server().run();

//        Handler h = new Handler();

//        Player p1 = new Player(0);
//        Player p2 = new Player(1);
//        Player p3 = new Player(2);
//        Player p4 = new Player(3);
//        Deal deal = new Deal();

     //   h.returnTop();
//        System.out.println();

//        h.returnTop();

//        Handler deck = new Handler();


  //      System.out.println("Welcome to Uno");
    //    System.out.println();
      //  System.out.println("You are player " + p1.getID());
        //h.addCards();

        System.out.println("test1");
        GameLogic gameLogic = new GameLogic();
        System.out.println("test2");

        System.out.println("test3");
        Server server = new Server(gameLogic);
        System.out.println("test4");
        server.run();
        System.out.println("test5");
        GUI gui = new GUI(server);
        System.out.println("test6");
        gameLogic.run();




    }



}
