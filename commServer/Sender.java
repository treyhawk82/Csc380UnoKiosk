import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class that sends hand information to the client
 */
public class Sender extends Thread {
    //current player ID
    private int currentPlayer;
    //current connection socket
    private Socket connectionDetail;
    //lock synchronisation
    private ReentrantLock lock;
    //current communication server object, in order to be able to call its methods for getting and setting
    private Server serverObject;

    /**
     * Constructor of Sender
     * @param currentPlayerRE current player ID
     * @param connectionDetail current connection Socket
     * @param lock lock for synchronisation
     * @param serverObject current communication server object, in order to be able to call its methods for getting and
     *                  and setting
     */
    public Sender(int currentPlayerRE, Socket connectionDetail, ReentrantLock lock, Server serverObject){
        this.currentPlayer = currentPlayerRE;
        this.connectionDetail = connectionDetail;
        this.lock = lock;
        this.serverObject = serverObject;
    }

    /**
     * runs the sending method
     */
    public void run(){
        try {
            lock.lock();
            send(currentPlayer, connectionDetail);
            try {
                connectionDetail.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }finally {
            lock.unlock();
        }
    }

    /**
     * creates a BufferedWriter, and sends information about the current hand of the player to the client
     * @param currentPlayer
     * @param connectionDetail
     */
    public void send(int currentPlayer, Socket connectionDetail){
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connectionDetail.getOutputStream()));

            System.out.println("Player " + (currentPlayer + 1) + " with address: " + connectionDetail.getInetAddress() + " has connected. Last connection: " + serverObject.getLastConnection(currentPlayer));

            String currentHand = serverObject.getCurrentHand(currentPlayer);
            writer.write(currentHand);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}