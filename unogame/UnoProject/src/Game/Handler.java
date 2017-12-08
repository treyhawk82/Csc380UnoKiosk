package Game;
import java.util.Collections;
import java.util.Stack;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * There are four different colours for the cards
 * There are 2 cards of the numbers 1 to 9 for each colour   **done
 * There is 1 card for the number 0 for each colour          **done
 * There are 2 cards of “draw 2” for every colour **
 * There are 2 cards of “skip” for every colour **
 * There are 2 cards of “reverse” for every colour **
 * There are 4 “wild” cards
 * There are 4 “wild +4” cards
 */
public class Handler {
    //fields
    Stack deck = new Stack();
    int i;
    ReadWriteLock handlerLock = new ReentrantReadWriteLock();


    /**
     * returns the top of the stack/the last element
     **/
    public Card returnTop() {
        try {
            handlerLock.readLock().lock();
            return (Card) deck.peek();
        } finally {
            handlerLock.readLock().unlock();
        }
    }

    /**
     * pops the top of the stack **
     */
    public void pop(){

        try {
            handlerLock.writeLock().lock();
            deck.pop();
        } finally {
            handlerLock.writeLock().unlock();
        }
     }

    /**
     * prints all of the cards in the deck
     */
    public void printCards(){

        try {
            handlerLock.readLock().lock();
            System.out.println(deck);
        } finally {
            handlerLock.readLock().unlock();
        }
     }

    /**
     * adds cards to deck
     **/
    public void addCards() {
        try {
            handlerLock.writeLock().lock();

            for (i = 0; i <= 9; i++) {
                Card c = new Card("Yellow", i, false);
                deck.push(c);
            }
            for (i = 1; i <= 9; i++) {
                Card c = new Card("Yellow", i, true);
                deck.push(c);
            }
            for (i = 0; i <= 9; i++) {
                Card c = new Card("Green", i, false);
                deck.push(c);
            }
            for (i = 1; i <= 9; i++) {
                Card c = new Card("Green", i, true);
                deck.push(c);
            }
            for (i = 0; i <= 9; i++) {
                Card c = new Card("Blue", i, false);
                deck.push(c);
            }
            for (i = 1; i <= 9; i++) {
                Card c = new Card("Blue", i, true);
                deck.push(c);
            }
            for (i = 0; i <= 9; i++) {
                Card c = new Card("Red", i, false);
                deck.push(c);
            }
            for (i = 1; i <= 9; i++) {
                Card c = new Card("Red", i, true);
                deck.push(c);
            }

            deck.push(new Card("Yellow", 10, false));    //skip
            deck.push(new Card("Yellow", 10, true));    //skip
            deck.push(new Card("Green", 10, false));     //skip
            deck.push(new Card("Green", 10, true));     //skip
            deck.push(new Card("Blue", 10, false));      //skip
            deck.push(new Card("Blue", 10, true));      //skip
            deck.push(new Card("Red", 10, false));       //ski[
            deck.push(new Card("Red", 10, true));       //skip
            deck.push(new Card("Yellow", 11, false));    //draw2
            deck.push(new Card("Yellow", 11, true));    //draw2
            deck.push(new Card("Green", 11, false));     //draw2
            deck.push(new Card("Green", 11, true));     //draw2
            deck.push(new Card("Blue", 11, false));      //draw2
            deck.push(new Card("Blue", 11, true));      //draw2
            deck.push(new Card("Red", 11, false));       //draw2[
            deck.push(new Card("Red", 11, true));       //draw2
            deck.push(new Card("Yellow", 12, false));    //reverse
            deck.push(new Card("Yellow", 12, true));    //reverse
            deck.push(new Card("Green", 12, false));     //reverse
            deck.push(new Card("Green", 12, true));     //reverse
            deck.push(new Card("Blue", 12, false));      //reverse
            deck.push(new Card("Blue", 12, true));      //reverse
            deck.push(new Card("Red", 12, false));       //reverse[
            deck.push(new Card("Red", 12, true));       //reverse
            deck.push(new Card("Wild", 13, false));       //wild
            deck.push(new Card("Wild", 13, true));       //wild
            Card w3 = new Card("Wild", 13, false);

            w3.changeSecondCard("f");
            Card w4 = new Card("Wild", 13, false);
            w4.changeSecondCard("g");
            deck.push(new Card("Wild + 4", 14, false));       //wild+4
            deck.push(new Card("Wild + 4", 14, true));       //wild+4
            Card w7 = new Card("Wild + 4", 14, false);
            w7.changeSecondCard("f");
            Card w8 = new Card("Wild + 4", 14, false);
            w8.changeSecondCard("g");
            deck.push(w3);
            deck.push(w4);
            deck.push(w7);
            deck.push(w8);
        } finally {
            handlerLock.writeLock().unlock();
        }
    }

    public void shuffleDeck() {

        try {
            handlerLock.writeLock().lock();
            Collections.shuffle(deck);
            Collections.shuffle(deck);
            Collections.shuffle(deck);
        } finally {
            handlerLock.writeLock().unlock();
        }
    }

    public int size() {
        try {
            handlerLock.readLock().lock();
            return deck.size();
        } finally {
            handlerLock.readLock().unlock();
        }
    }

    public void push(Card card) {
        try {
            handlerLock.writeLock().lock();
            deck.push(card);
        } finally {
            handlerLock.writeLock().unlock();
        }
    }
}




