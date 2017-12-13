package Game.commServer;

import Game.GameLogic;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConnectionHandler extends WebSocketServer  {
    ReadWriteLock serverLock = new ReentrantReadWriteLock();
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
    private ArrayList<WebSocket> conns;
    /**
     * saves the ip addresses of our current players
     */
    private String[] currentPlayerIPs;
    /**
     * saves the actions the players have taken to give them to the game to process
     */
    private String[] playerActions;
    private long[] lastActionTime = {System.currentTimeMillis(), System.currentTimeMillis(), System.currentTimeMillis(), System.currentTimeMillis()};
    /**
     * saves the hands of our current players
     */
    private String[] hands;

    private long[] lastConnectionTime = new long[4];

    private GameLogic gameLogic;


    /**
     * constructor of the WebsocketServer class. Instantiates with the current hands of our players as well as the
     * number of current players. Also instantiates every variable that is needed to accept connections
     * @param hands String array of current hands of our players
     * @param NUMBER_OF_PLAYERS number of players in our game
     */
    public ConnectionHandler(String[] hands, int NUMBER_OF_PLAYERS) {
        super(new InetSocketAddress(TCP_PORT));
        this.NUMBER_OF_PLAYERS = NUMBER_OF_PLAYERS;
        currentPlayerIPs = new String[NUMBER_OF_PLAYERS];
        conns = new ArrayList<>();
        playerActions = new String[4];
        this.hands = hands;
        for(int i = 0; i < NUMBER_OF_PLAYERS; i++){
            currentPlayerIPs[i] = "0";
            lastConnectionTime[i] = System.currentTimeMillis();
            lastActionTime[i] = System.currentTimeMillis();
            System.out.println(playerActions[i]);
        }
    }

    /**
     * When a Websocket is opened, this method saves the connection to the conns Set, saves the current players ip
     * address.
     * @param conn Websocket connection to a client
     * @param handshake handshake that is needed to establish the connection
     */
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        try {
            serverLock.writeLock().lock();
            boolean isAlreadyConnected = false;
            int counter = 0;
            for (WebSocket con : conns
                    ) {
                if (con.getRemoteSocketAddress().getAddress().getHostAddress().equalsIgnoreCase(conn.getRemoteSocketAddress().getAddress().getHostAddress())) {
                    lastConnectionTime[counter] = System.currentTimeMillis();
                }
                if (!isAlreadyConnected && con.getRemoteSocketAddress().getAddress().getHostAddress().equalsIgnoreCase(conn.getRemoteSocketAddress().getAddress().getHostAddress())) {
                    String currentIP = con.getRemoteSocketAddress().getAddress().getHostAddress();
                    System.out.println("Player with IP: " + con.getRemoteSocketAddress().getAddress().getHostAddress() + " was already connected, Connection denied.");
                    conn.send("already connected");
                    conn.close();
                    for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
                        if (currentPlayerIPs[i].equalsIgnoreCase(currentIP)) {
                            currentPlayerIPs[i] = "0";
                        }
                    }
                    isAlreadyConnected = true;
                }
                counter++;
            }


            if (!isAlreadyConnected) {
                conns.add(conn);
                String currentIP = conn.getRemoteSocketAddress().getAddress().getHostAddress();
                boolean filled = false;
                for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
                    if (currentPlayerIPs[i].equals("0") && !filled) {
                        currentPlayerIPs[i] = currentIP;
                        filled = true;
                        gameLogic.userConnected(i);
                        System.out.println("New connection from " + currentIP);
                    }
                }
            }
        } finally {
            serverLock.writeLock().unlock();
        }
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
        try {
            serverLock.writeLock().lock();
            int connectionNumber = 0;
            int counter = 0;
            for (WebSocket con : conns
                    ) {
                if (con == conn) connectionNumber = counter;
                counter++;
            }
            conns.remove(conn);
            String currentIP = conn.getRemoteSocketAddress().getAddress().getHostAddress();
            System.out.println("Closed connection to " + conn.getRemoteSocketAddress().getAddress().getHostAddress() + " (onClose)");
            gameLogic.userDisconnected(connectionNumber);

        } finally {
            serverLock.writeLock().unlock();
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
        try {
            serverLock.writeLock().lock();
            Date currenttime = new Date(System.currentTimeMillis());


            long printLineTimer = System.currentTimeMillis();
            if (System.currentTimeMillis() > printLineTimer + 5000) {
                System.out.println("Currently connected Devices:");
                for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
                    if (lastConnectionTime[i] > System.currentTimeMillis() - 5000) {
                        System.out.println("Player " + i + " at " + currentPlayerIPs + ".\n");
                    }
                }
                printLineTimer = System.currentTimeMillis();
            }
            //checks for inactive devices
            gameLogic.setLastActionTime(lastActionTime);
            gameLogic.setLastConnectionTimes(lastConnectionTime);
            int playerNumber = -1;
            for (int i = 0; i < conns.size(); i++) {
                WebSocket con = conns.get(i);
                if (conn == con) {
                    lastConnectionTime[i] = System.currentTimeMillis();
                    playerNumber = i;
                }
                if (lastConnectionTime[i] < System.currentTimeMillis() - 5000) {
                    conns.remove(i);
                    gameLogic.userDisconnected(i);
                    con.close();
                    System.out.println("removed Connection: " + i);
                }
            }

            //saves action string if message is not update
            if (message.equalsIgnoreCase("Uno")) {
                if (gameLogic.getHandSize(playerNumber) == 1 && !gameLogic.checkCalledUno(playerNumber)) {
                    gameLogic.callsUno(playerNumber);
                } else {
                    for (int i = 0; i < 4; i++) {
                        gameLogic.callsOutUno();
                    }
                }
            }
            if (!message.equalsIgnoreCase("update") && !message.equalsIgnoreCase("Uno")) {
                for (int i = 0; i < conns.size(); i++) {
                    if (conn == conns.get(i)) {
                        String[] splitMessage = message.split("x");
                        communicatePlayedCardToGameLogic(splitMessage[0], playerNumber);
                        if (splitMessage.length > 1) {
                            if (splitMessage[1].equalsIgnoreCase("b")) {
                                if (gameLogic.getTurnOfPlayer() == playerNumber) {
                                    gameLogic.selectColour("blue");
                                }
                            } else if (splitMessage[1].equalsIgnoreCase("y")) {
                                if (gameLogic.getTurnOfPlayer() == playerNumber) {
                                    gameLogic.selectColour("yellow");
                                }
                            } else if (splitMessage[1].equalsIgnoreCase("g")) {
                                if (gameLogic.getTurnOfPlayer() == playerNumber) {
                                    gameLogic.selectColour("green");
                                }
                            } else if (splitMessage[1].equalsIgnoreCase("r")) {
                                if (gameLogic.getTurnOfPlayer() == playerNumber) {
                                    gameLogic.selectColour("red");
                                }
                            }
                        }
                        lastConnectionTime[i] = System.currentTimeMillis();
                    }
                }
            }
            //sends update data

            conn.send(hands[playerNumber]);
        } finally {
            serverLock.writeLock().unlock();
        }
    }

    /**
     * handles the connection in case an error has occured. Includes deleting the connection from the conns Set-
     *
     * @param conn Websocket connection to the player
     * @param ex   exception that has occurred
     */
    @Override
    public void onError(WebSocket conn, Exception ex) {
        try {
            serverLock.writeLock().lock();
            //ex.printStackTrace();
            if (conn != null) {
                conns.remove(conn);
                int currentPlayer = checkIfPlayer(conn.getRemoteSocketAddress().getAddress().getHostAddress());
                if (currentPlayer > -1 && currentPlayer < 4) currentPlayerIPs[currentPlayer] = null;
                // do some thing if required
            }
            System.out.println("ERROR, a connection has been closed");
        } finally {
            serverLock.writeLock().unlock();
        }
    }

    /**
     * checks if the connection is a new player or an existing player
     * @param ipaddress is the ip address of the device that connected
     * @return returns 20 if game is full and device is not known, returns the ID of the player if device is known,
     * returns and assignes new ID if game is not full and device is not known
     */
    public int checkIfPlayer(String ipaddress) {
        try {
            serverLock.writeLock().lock();

            boolean created = false;
            for (int i = 0; i < 4; i++) {
                if (currentPlayerIPs[i].equals(ipaddress)) {
                    return i;
                }
            }
            for (int i = 0; i < 4; i++) {
                if (currentPlayerIPs[i].equals("") && !created) {
                    currentPlayerIPs[i] = ipaddress;
                    return i;
                }
            }
            return 20;
        } finally {
            serverLock.writeLock().unlock();
        }
    }

    public String returnActionOfPlayer(int playerNumber) {
        try {
            serverLock.readLock().lock();
            return playerActions[playerNumber];
        } finally {
            serverLock.readLock().unlock();
        }
    }

    public long getLastActionTime(int playerNumber) {
        try {
            serverLock.readLock().lock();
            return lastActionTime[playerNumber];
        } finally {
            serverLock.readLock().unlock();
        }
    }

    public void setGameLogic(GameLogic gameLogic) {
        try {
            serverLock.writeLock().lock();
            this.gameLogic = gameLogic;
        } finally {
            serverLock.writeLock().unlock();
        }
    }

    public void runConnectionCheck() {
        try {
            serverLock.writeLock().lock();
            for (int i = 0; i < conns.size(); i++) {
                if (lastConnectionTime[i] < System.currentTimeMillis() - 5000) {
                    System.out.println("removed connection: " + i);
                    WebSocket connection = conns.get(i);
                    conns.remove(i);
                    disconnectPlayerFromGameLogic(i);
                    connection.close();
                }
            }
            for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
                String ipToCheck = currentPlayerIPs[i];
                for (int j = 0; j < NUMBER_OF_PLAYERS; j++) {
                    if (i != j) {
                        if (ipToCheck.equalsIgnoreCase(currentPlayerIPs[j])) {
                            currentPlayerIPs[j] = "0";
                            gameLogic.userDisconnected(j);
                        }
                    }
                }
            }

            for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
                if (!currentPlayerIPs[i].equalsIgnoreCase("0")) {
                    gameLogic.userConnected(i);
                }
            }
        } finally {
            serverLock.writeLock().unlock();
        }
    }

    public void disconnectPlayer(int playerNumber) {
        try {
            serverLock.writeLock().lock();
            for (WebSocket con : conns
                    ) {
                if (currentPlayerIPs[playerNumber].equalsIgnoreCase(con.getRemoteSocketAddress().getAddress().getHostAddress())) {
                    con.send("timeout_disconnect");
                    con.close();
                    currentPlayerIPs[playerNumber] = "0";
                }
            }
        } finally {
            serverLock.writeLock().unlock();
        }
    }

    public void disconnectPlayerFromGameLogic(int i) {
        try {
            serverLock.writeLock().lock();
            gameLogic.userDisconnected(i);
        } finally {
            serverLock.writeLock().unlock();
        }
    }

    public void communicatePlayedCardToGameLogic(String message, int userID) {
        try {
            serverLock.writeLock().lock();

            gameLogic.userPlayedCard(message, userID);
        } finally {
            serverLock.writeLock().unlock();
        }
    }
}
