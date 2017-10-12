import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args){
        //current hands, for access in combination with currentPlayer
        String[] currentHand = new String[4];

        //instantiates Hands
        for (int i = 0; i < 4; i++){
            currentHand[i] = "";
        }
        //Communication server that will be used to communicate between game and client
        Server communicationServer = new Server(currentHand);

        //server extends Thread, so it can run()
        communicationServer.run();

    }
}
