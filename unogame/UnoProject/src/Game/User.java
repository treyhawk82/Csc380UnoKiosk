package Game;

import Game.commServer.Server;

public class User extends Player {

    Deal hand;
    GameLogic gameLogic;
    Server server;
    int id;

    public User(Deal hand, GameLogic gameLogic, Server server, int id) {
        this.hand = hand;
        this.gameLogic = gameLogic;
        this.server = server;
        this.id = id;
    }

    public Card playTurn() {
        long lastActionTime = server.getlastActionTime(id);
        while (lastActionTime < gameLogic.getTurnStartTime()) {
            lastActionTime = server.getlastActionTime(id);
        }
        String playerAction = server.getPlayerAction(id);
        String actionArray[] = playerAction.split("-");
        return new Card("to-do", 42);
    }
}
