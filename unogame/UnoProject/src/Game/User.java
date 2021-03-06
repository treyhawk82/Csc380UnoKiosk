package Game;

import Game.commServer.Server;

public class User extends Player {

    Deal hand;
    GameLogic gameLogic;
    Server server;
    int id;
    int lastPlayableCard;
    boolean hasPlayableCard = false;
    long lastActionTime = System.currentTimeMillis();


    public User(Deal hand, GameLogic gameLogic, Server server, int id) {
        this.hand = hand;
        this.gameLogic = gameLogic;
        this.server = server;
        this.id = id;
    }

    public Card playTurn() {
        int handSize = hand.getSize();
        Card topOfDiscardPile = gameLogic.returnTopOfDiscardPile();
        String topOfDiscardPileColour = topOfDiscardPile.getCardColor();
        int topOfDiscardPileNumber = topOfDiscardPile.getCardNum();
        for (int i = 0; i < handSize; i++) {
            Card handCard = hand.getCard(i);
            if (handCard.getCardColor().equalsIgnoreCase(topOfDiscardPileColour)
                    || handCard.getCardNum() == topOfDiscardPileNumber
                    || handCard.getCardNum() == 13
                    || handCard.getCardNum() == 14) {
                hasPlayableCard = true;
            }
        }
        if (hasPlayableCard) {
            int counter = 0;
            long printTimer = System.currentTimeMillis();
            while (lastActionTime < gameLogic.getTurnStartTime() && gameLogic.checkIfStillConnected(id)) {
                if (gameLogic.getTurnStartTime() + 60000 < System.currentTimeMillis()) {
                    gameLogic.resetBoard();
                    for (int i = 0; i < 4; i++) {
                        try {
                            gameLogic.userDisconnected(i);
                            server.disconnectPlayer(i);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (System.currentTimeMillis() > printTimer + 4000) {
                    System.out.println("Waiting for Player " + id + " to play a Card.");
                    printTimer = System.currentTimeMillis();

                    int turnofPlayer;
                    turnofPlayer = gameLogic.getTurnOfPlayer();
                    if (gameLogic.timeOut()) {
                        if (gameLogic.checkIfStillConnected(turnofPlayer)) {
                            gameLogic.userDisconnected(turnofPlayer);
                            server = gameLogic.getServer();
                            server.disconnectPlayer(turnofPlayer);
                        }
                    }


                }
                //System.out.println(lastActionTime + " = lastActionTime, TurnStartTime = " + gameLogic.getTurnStartTime() + ", still connected = " + gameLogic.checkIfStillConnected(id));
            }
            gameLogic.setLastTime(System.currentTimeMillis());
            System.out.println("Broke out of actiontime loop");
            hasPlayableCard = false;
            if (!gameLogic.checkIfStillConnected(id)) {
                return new Card("disconnected", 123, false);
            } else {
                Card playableCard = hand.getCard(lastPlayableCard);
                hand.discardCard(playableCard);
                gameLogic.discardCard(playableCard);
                System.out.println("card played: " + playableCard.getCardColor() + playableCard.getCardNum());
                return playableCard;
            }
        }
        hasPlayableCard = false;
        hand.dealCard(gameLogic.deck);
        Card noPlayableCard = new Card("noPlayableCard", 15, false);
        return noPlayableCard;
    }

    public void cardPlayed(String message) {
        for(int i = 0; i < hand.getSize(); i++){
            if(hand.getCard(i).getCommCardString().equalsIgnoreCase(message)){
                lastPlayableCard = i;
                System.out.println("Card found: " + lastPlayableCard);
                lastActionTime = System.currentTimeMillis();
            }
        }
    }
}
