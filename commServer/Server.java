import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Is the class which runs the coordination of communication
 */
public class Server extends Thread{

    //current hands, for access in combination with currentPlayer
    private String currentHand[];
    //keeps track of alternating communication turns
    private boolean inputOutput[] = new boolean[4];
    //current player IP addresses, to keep track who is requesting a connection
    private String currentPlayerIPs[] = new String[4];
    //last connection of each player, to be able to kick a player after he has not connected for a certain amount of time.
    private Date lastConnection[] = new Date[4];
    //lock
    private ReentrantLock lock = new ReentrantLock();
    //serverport
    private int serverPort = 12345;

    /**
     * Constructor of Server, instantiates with the array of current player hands, and instantiates all necessary
     * variables.
     * @param currentHands is the array of current player hands
     */
    public Server(String[] currentHands){
        this.currentHand = currentHands;
        for(int i = 0; i < 4; i++){
            inputOutput[i] = false;
            currentPlayerIPs[i] = "";
        }
        currentHand[0] = "r1,y5,g5,g7,r5";
    }

    /**
     * creates the ServerSocket, accepts connection and gives them to a ConnectionHandler
     */
    public void run() {

        //create Server Socket
        ServerSocket server = null;
        try {
            server = new ServerSocket(serverPort);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //loop
        while (true) {

            //wait for connection
            try {
                Socket connection = server.accept();
                ConnectionHandler connectionHandler = new ConnectionHandler(connection, this, lock);
                connectionHandler.run();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    /**
     * Gets and returns the hand of a current player
     * @param currentPlayerRC is the assigned ID of the player
     * @return returns a String that contains the full hand of the current player
     */
    public String getCurrentHand(int currentPlayerRC){
        return currentHand[currentPlayerRC];
    }

    /**
     * alternates communicationmodes of the communication server, taking turns sending and receiving
     * @param currentPlayer is the assigned ID of the player
     * @return returns a boolean state, TRUE if next mode is receiving, FALSE if next mode is sending
     */
    public boolean alternateInputOutput(int currentPlayer){
        if (inputOutput[currentPlayer]) {
            inputOutput[currentPlayer] = false;
            return true;
        }else {
            inputOutput[currentPlayer] = true;
            return false;
        }
    }

    /**
     * checks if the connection is a new player or an existing player
     * @param ipaddress is the ip address of the device that connected
     * @return returns 20 if game is full and device is not known, returns the ID of the player if device is known,
     * returns and assignes new ID if game is not full and device is not known
     */
    public int checkIfPlayer(String ipaddress){
        boolean created = false;
        for(int i = 0; i < 4; i++){
            if(currentPlayerIPs[i].equals(ipaddress)){
                return i;
            }
        }
        for (int i = 0; i < 4; i++){
            if(currentPlayerIPs[i].equals("") && !created){
                currentPlayerIPs[i] = ipaddress;
                return i;
            }
        }
        return 20;
    }

    /**
     * updates the last time of connection for this player, to make a timeout feature possible
     * @param currentPlayer is the ID of the current player
     * @param lastConnection is the time of the last connection
     */
    public void setLastConnection(int currentPlayer, Date lastConnection){
        this.lastConnection[currentPlayer] = lastConnection;
    }

    /**
     * gets the last time of connection for a player, to make a timeout feature possible
     * @param currentPlayer is the ID of the current player
     * @return returns the last time this player connected to the communication server
     */
    public Date getLastConnection(int currentPlayer){
        return lastConnection[currentPlayer];
    }
}