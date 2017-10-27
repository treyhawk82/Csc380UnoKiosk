import java.util.HashMap;

public class Cards {

    private int one = 1;
    private int two = 2;
    private int three = 3;
    private int four = 4;
    private int five = 5;
    private int six = 6;
    private int seven = 7;
    private int eight = 8;
    private int nine = 9;
    private int skip = 10;
    private int reverse = 11;
    private int draw2 = 12;
    private int draw4 = 13;
    private int wild = 14;


    private String red,blue,yellow,green,black;


 //   private Cards[] cards = new Cards[108];


    private HashMap<, >

    public void addCards() {
        int j = 0;
        int k = 0;
        for (Cards i : cards) {
           // System.out.println(cards);
            if (j != 4) {
                     k++;
            }
        }

    }

    public int getOne() {
        return one;
    }

    public int getTwo() {
        return two;
    }

    public int getThree() {
        return three;
    }

    public int getFour() {
        return four;
    }

    public int getFive() {
        return five;
    }

    public int getSix() {
        return six;
    }

    public int getSeven() {
        return seven;
    }

    public int getEight() {
        return eight;
    }

    public int getNine() {
        return nine;
    }

    public int getSkip() {
        return skip;
    }

    public int getReverse() {
        return reverse;
    }

    public int getDraw2() {
        return draw2;
    }

    public int getDraw4() {
        return draw4;
    }

    public int getWild() {
        return wild;
    }

    public void printCards() {
    for (Cards i : cards) {
        System.out.println(cards);
    }
}


}