import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class that receives data from the client, for example actions that a player could have taken
 */
public class Receiver extends Thread{
    //current player ID
    private int currentPlayer;
    //current connection Socket
    private Socket connectionDetail;
    //lock for synchronisation
    private ReentrantLock lock;
    //current server object, in order to be able to use its methods etc.
    private Server serverObject;
    //queue of actions taken
    private Queue<String> actions;

    /**
     * Constructor for the Receiver class
     * @param currentPlayerSE current player ID
     * @param connectionDetail current connection Socket
     * @param lock lock for synchronisation
     * @param serverObject current server object, in order to be able to use its methods etc.
     */
    public Receiver(int currentPlayerSE, Socket connectionDetail, ReentrantLock lock, Server serverObject){
        this.currentPlayer = currentPlayerSE;
        this.connectionDetail = connectionDetail;
        this.lock = lock;
        this.serverObject = serverObject;
    }

    /**
     * runs the receive method
     */
    public void run(){
        try {
            lock.lock();
            receive(connectionDetail);
        }finally {
            lock.unlock();
        }
    }

    /**
     * uses a BufferedReader to read the input stream from the client, in order to get information about actions from
     * the player
     * @param connectionDetail is the current connection Socket
     */
    private void receive(Socket connectionDetail){
        String soutput = "";
        BufferedReader sreader = null;
        try {
            sreader = new BufferedReader(new InputStreamReader(connectionDetail.getInputStream()));

            while ((soutput = sreader.readLine()) != null) {
                System.out.println(soutput);
                if (soutput.equals("No action taken"));
                else actions.add(soutput);
            }
            connectionDetail.shutdownInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

