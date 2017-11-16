package Game;

public class AI {
    Deal hand;
    GameLogic gameLogic;

    public AI(Deal hand, GameLogic gameLogic) {
        this.hand = hand;
        this.gameLogic = gameLogic;
    }

    public void playTurn() {
        Card topOfDiscardPile = gameLogic.returnTopOfDiscardPile();
        Card playCard = checkHandForPlayableCard(topOfDiscardPile);
        if ((playCard.getCardColor().equalsIgnoreCase("noPlayableCard"))) {
            hand.dealCard(gameLogic.deck);
            System.out.println("card drawn");
        } else {
            gameLogic.discardCard(playCard);
            hand.discardCard(playCard);
            System.out.println("card played: " + playCard.getCardColor() + playCard.getCardNum());
        }
        System.out.println("Handsize: " + hand.getSize());
    }

    private Card checkHandForPlayableCard(Card topOfDiscardPile) {
        int handSize = hand.getSize();
        String topOfDiscardPileColour = topOfDiscardPile.getCardColor();
        int topOfDiscardPileNumber = topOfDiscardPile.getCardNum();
        for (int i = 0; i < handSize; i++) {
            Card handCard = hand.getCard(i);
            if (handCard.getCardColor().equalsIgnoreCase(topOfDiscardPileColour) || handCard.getCardNum() == topOfDiscardPileNumber) {
                return handCard;
            }
        }
        Card noPlayableCard = new Card("noPlayableCard", 15);
        return noPlayableCard;
    }

}
