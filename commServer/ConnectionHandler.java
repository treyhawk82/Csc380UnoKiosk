import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Is the class that handles accepted connections, checking if its sending mode or receiving mode, and starts the
 * corresponding thread.
 */
public class ConnectionHandler extends Thread{

    //the current connection socket
    private Socket currentConnection;
    // the current communication server object, to be able to use its getter and setter methods
    private Server serverObject;
    // a lock for synchronisation
    private ReentrantLock lock;

    /**
     * Constructor of ConnectionHandler
     * @param connection the current connection socket
     * @param serverObject the current communication server object
     * @param lock the current lock
     */
    public ConnectionHandler(Socket connection, Server serverObject, ReentrantLock lock){
        this.currentConnection = connection;
        this.serverObject = serverObject;
        this.lock = lock;
    }

    /**
     * runs the thread, deciding what actions have to be taken (sending or receiving etc.)
     */
    public void run(){
        //current ip address of the connected device
        String currentIPAddress = currentConnection.getInetAddress().toString();
        //player ID of the current player
        int currentPlayer = serverObject.checkIfPlayer(currentIPAddress);
        //current mode, and switches mode of for the following connection via method call of serverObject

        //current time to be able to track connection activity
        Date currentTime = new Date(System.currentTimeMillis());
        //updates the last connection time to the current one for this player
        serverObject.setLastConnection(currentPlayer, currentTime);

        //checks whether it has to send or receive

        Receiver receiverThread = new Receiver(currentPlayer, currentConnection, lock, serverObject);
        receiverThread.run();

        Sender senderThread = new Sender(currentPlayer, currentConnection, lock, serverObject);
        senderThread.run();
    }
}
