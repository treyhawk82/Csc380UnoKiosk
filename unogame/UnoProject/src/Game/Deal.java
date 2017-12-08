package Game;

import java.util.ArrayList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Deal extends Handler {

    //fields
    private ArrayList<Card> hand;
    ReadWriteLock handLock = new ReentrantReadWriteLock();


    //instantiate hand
    public Deal() {
        hand = new ArrayList<>();
    }

    //computer deals cards to player and removed from top of drawpile
    public void dealCard(Handler drawPile) {
        try {
            handLock.writeLock().lock();
            hand.add(0, drawPile.returnTop());
            drawPile.pop();
        } finally {
            handLock.writeLock().unlock();
        }
    }

    public void addCard(Card cardToBeAdded) {
        try {
            handLock.writeLock().lock();
            hand.add(cardToBeAdded);
        } finally {
            handLock.writeLock().unlock();
        }
    }

    public void discardCard(Card cardToBePlayed) {
        try {
            handLock.writeLock().lock();
            boolean deletedOnce = false;
            for (int i = 0; i < hand.size(); i++) {
                if (hand.get(i).getCardColor().equalsIgnoreCase(cardToBePlayed.getCardColor())
                        && hand.get(i).getCardNum() == cardToBePlayed.getCardNum() && !deletedOnce) {
                    deletedOnce = true;
                    hand.remove(i);
                }
            }
        } finally {
            handLock.writeLock().unlock();
        }
    }


    public Card getCard(int element) {

        try {
            handLock.readLock().lock();
            return hand.get(element);
        } finally {
            handLock.readLock().unlock();
        }
    }

    public int getSize() {
        try {
            handLock.readLock().lock();
            return hand.size();
        } finally {
            handLock.readLock().unlock();
        }
    }

    public String getSizeString() {
        return "" + hand.size();
    }

    public void printArray() {
        System.out.println(hand.toString());
    }


//    public Card getLast(){
//
//        return hand.get(hand.size()-1);
//   }

    public void printHand() {

        for (Card element : hand) {
            System.out.println(element.toString());
        }
    }

    public String getCommHandString() {
        boolean firstTime = true;
        String commHandString = "";
        for (Card handCard : hand) {
            if (!firstTime) {
                commHandString = commHandString + "x";
            }
            commHandString = commHandString + handCard.getCommCardString();
            firstTime = false;
        }
        return commHandString;
    }

    public void removeAll() {
        hand.clear();
    }


}
