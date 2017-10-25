import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WebsocketServer extends WebSocketServer {

    private static int TCP_PORT = 4444;
    private int NUMBER_OF_PLAYERS;

    private Set<WebSocket> conns;
    private String[] currentPlayerIPs;
    private ArrayList<String> actions;
    private String[] hands;

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

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        conns.remove(conn);
        String currentIP = conn.getRemoteSocketAddress().getAddress().getHostAddress();
        System.out.println("Closed connection to " + conn.getRemoteSocketAddress().getAddress().getHostAddress());
        for (int i = 0; i < NUMBER_OF_PLAYERS; i++){
            if(currentPlayerIPs[i].equals(currentIP))currentPlayerIPs[i] = null;
        }

    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        System.out.println("Message from client: " + message);
        /**for (WebSocket sock : conns) {
            String currentIP = sock.getRemoteSocketAddress().getAddress().getHostAddress();
            int currentPlayer = -1;
            for(int i = 0; i < NUMBER_OF_PLAYERS; i++){
                if(currentPlayerIPs[i].equals(currentIP))currentPlayer = i;
            }
            sock.send(hands[currentPlayer]);
        }*/
        for (WebSocket sock: conns
             ) {
            sock.send("HellO!");
            String currentIP = sock.getRemoteSocketAddress().getAddress().getHostAddress();
            System.out.println("Test " + currentIP);
            int currentPlayer = 0;
            while (currentPlayer < NUMBER_OF_PLAYERS){
                if(currentPlayerIPs[currentPlayer].equals(currentIP))sock.send(hands[currentPlayer]);
                currentPlayer++;
            }



        }
    }

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

    public void updateHands(){

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