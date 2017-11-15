package Game;


import Game.commServer.Server;
import Game.graphical_user_interface.GUI;

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

        GameLogic gameLogic = new GameLogic();
        Server server = new Server(gameLogic);
        Thread serverThread = new Thread(server, "CommunicationServer");
        serverThread.start();
        GUI gui = new GUI(server);
        Thread gameLogicThread = new Thread(gameLogic, "GameLogic");
        gameLogicThread.start();




    }



}