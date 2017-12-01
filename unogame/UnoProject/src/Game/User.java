package Game;

import Game.commServer.Server;

public class User extends Player {

    Deal hand;
    GameLogic gameLogic;
    Server server;
    int id;
    int lastPlayableCard;

    public User(Deal hand, GameLogic gameLogic, Server server, int id) {
        this.hand = hand;
        this.gameLogic = gameLogic;
        this.server = server;
        this.id = id;
    }

    public Card playTurn() {
        long lastActionTime = gameLogic.getActionTimeOfPlayer(id);
        while (lastActionTime < gameLogic.getTurnStartTime() && gameLogic.checkIfStillConnected(id)) {
            int i = 0;
        }
        if (!gameLogic.checkIfStillConnected(id)) {
            return new Card("disconnected", 123, false);
        } else {
            Card playableCard = hand.getCard(lastPlayableCard);
            hand.discardCard(playableCard);
            return  playableCard;
        }
    }

    public void cardPlayed(String message) {
        for(int i = 0; i < hand.getSize(); i++){
            if(hand.getCard(i).getCommCardString().equalsIgnoreCase(message)){
                lastPlayableCard = i;
            }
        }
    }
}
