import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WebsocketServer extends WebSocketServer {

    /**
     * TCP port on which this server is listening
     */
    private static int TCP_PORT = 4444;
    /**
     * number of players in our game
     */
    private int NUMBER_OF_PLAYERS;

    /**
     * saves the WebSocket connections we accepted in a set
     */
    private Set<WebSocket> conns;
    /**
     * saves the ip addresses of our current players
     */
    private String[] currentPlayerIPs;
    /**
     * saves the actions the players have taken to give them to the game to process
     */
    private ArrayList<String> actions;
    /**
     * saves the hands of our current players
     */
    private String[] hands;

    /**
     * constructor of the WebsocketServer class. Instantiates with the current hands of our players as well as the
     * number of current players. Also instantiates every variable that is needed to accept connections
     * @param hands String array of current hands of our players
     * @param NUMBER_OF_PLAYERS number of players in our game
     */
    public WebsocketServer(String[] hands, int NUMBER_OF_PLAYERS) {
        super(new InetSocketAddress(TCP_PORT));
        this.NUMBER_OF_PLAYERS = NUMBER_OF_PLAYERS;
        currentPlayerIPs = new String[NUMBER_OF_PLAYERS];
        conns = new HashSet<>();
        actions = new ArrayList<>();
        this.hands = hands;
        for(int i = 0; i < NUMBER_OF_PLAYERS; i++){
            currentPlayerIPs[i] = "0";
        }
    }

    /**
     * When a Websocket is opened, this method saves the connection to the conns Set, saves the current players ip
     * address.
     * @param conn Websocket connection to a client
     * @param handshake handshake that is needed to establish the connection
     */
    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        conns.add(conn);
        String currentIP = conn.getRemoteSocketAddress().getAddress().getHostAddress();
        boolean filled = false;
        for(int i = 0; i < NUMBER_OF_PLAYERS; i++){
            if(currentPlayerIPs[i].equals("0") && !filled){
                currentPlayerIPs[i] = currentIP;
                filled = true;
            }
        }
        System.out.println("New connection from " + currentIP);
    }

    /**
     * this method is called if the Websocket connection has been closed, and handles the closing on the server side.
     * This includes deleting the connection from the conns Set.
     * @param conn Websocket connection to the client
     * @param code error code
     * @param reason gives the reason why the connection was closed
     * @param remote ???
     */
    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        conns.remove(conn);
        String currentIP = conn.getRemoteSocketAddress().getAddress().getHostAddress();
        System.out.println("Closed connection to " + conn.getRemoteSocketAddress().getAddress().getHostAddress());
        for (int i = 0; i < NUMBER_OF_PLAYERS; i++){
            if(currentPlayerIPs[i].equals(currentIP))currentPlayerIPs[i] = null;
        }

    }

    /**
     * This method is called when a client sends a message. It receives "No action taken" if the client has not made
     * any move to trigger an update of the current state of the game, and receives a code if a specific action has
     * been taken. TO-DO it also sends a String to the client that includes the current hand of the specific player,
     * the current top card on the discard pile, and if uno is callable.
     * @param conn Websocket connection to the player
     * @param message is the message that has been received from the client
     *
     *                THIS ALSO UPDATES EVERY CLIENT IF _ONE_ CLIENT SENDS A MESSAGE.
     *                NOT SURE IF WE SHOULD KEEP THIS OR NOT.
     */
    @Override
    public void onMessage(WebSocket conn, String message) {
        System.out.println("Message from client " + conn.getRemoteSocketAddress().getAddress().getHostAddress() +": " + message);
        for (WebSocket sock: conns
             ) {
            String currentIP = sock.getRemoteSocketAddress().getAddress().getHostAddress();
            System.out.println("Test " + currentIP);
            int currentPlayer = 0;
            while (currentPlayer < NUMBER_OF_PLAYERS){
                if(currentPlayerIPs[currentPlayer].equals(currentIP))sock.send(hands[currentPlayer]);
                currentPlayer++;
            }
        }
    }

    /**
     * handles the connection in case an error has occured. Includes deleting the connection from the conns Set-
     * @param conn Websocket connection to the player
     * @param ex exception that has occurred
     */
    @Override
    public void onError(WebSocket conn, Exception ex) {
        //ex.printStackTrace();
        if (conn != null) {
            conns.remove(conn);
            int currentPlayer = checkIfPlayer(conn.getRemoteSocketAddress().getAddress().getHostAddress());
            if(currentPlayer > -1 && currentPlayer < 4)currentPlayerIPs[currentPlayer] = null;
            // do some thing if required
        }
        System.out.println("ERROR from " + conn.getRemoteSocketAddress().getAddress().getHostAddress());
        conn.close();
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
}