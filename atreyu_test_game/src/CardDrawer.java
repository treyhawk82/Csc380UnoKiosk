import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CardDrawer {

    public CardDrawer(){
    }

    public void drawPlayerCards(Graphics g, int[] numberOfCardsinHands, String topOfDiscardPile){
        drawCardsPlayerBlue(g, numberOfCardsinHands);
        drawCardsPlayerGreen(g, numberOfCardsinHands);
        drawCardsPlayerRed(g, numberOfCardsinHands);
        drawCardsPlayerYellow(g, numberOfCardsinHands);
        drawDeck(g);
        drawTopOfDiscardPile(810 ,449, g, topOfDiscardPile);
    }

    public void drawCard_right(int x, int y, Graphics g){
        try {
            BufferedImage uno_cardback_right = ImageIO.read(new File("src/small/card_back_right.png"));
            ((Graphics2D) g).drawImage(uno_cardback_right, x, y, 182, 130, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawCard_left(int x, int y, Graphics g){
        try {
            BufferedImage uno_cardback_left = ImageIO.read(new File("src/small/card_back_left.png"));
            ((Graphics2D) g).drawImage(uno_cardback_left, x, y, 182, 130, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawCard(int x, int y, Graphics g){
        try {
            BufferedImage uno_cardback = ImageIO.read(new File("src/small/card_back.png"));
            ((Graphics2D) g).drawImage(uno_cardback, x, y, 130, 182, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void drawCardsPlayerBlue(Graphics g, int[] numberOfCardsinHands){
        if (numberOfCardsinHands[0] > 0)drawCard(895, 10, g);
        if (numberOfCardsinHands[0] > 1)drawCard(755, 10, g);
        if (numberOfCardsinHands[0] > 2)drawCard(1035, 10, g);
        if (numberOfCardsinHands[0] > 3)drawCard(615, 10, g);
        if (numberOfCardsinHands[0] > 4)drawCard(1175, 10, g);
        if (numberOfCardsinHands[0] > 5)drawCard(475, 10, g);
        if (numberOfCardsinHands[0] > 6)drawCard(1315, 10, g);
        if (numberOfCardsinHands[0] > 7)drawCard(475, 20, g);
        if (numberOfCardsinHands[0] > 8)drawCard(475, 30, g);
    }

    public void drawCardsPlayerYellow (Graphics g, int[] numberOfCardsinHands){
        if (numberOfCardsinHands[1] > 0)drawCard_right(1718, 475, g);
        if (numberOfCardsinHands[1] > 1)drawCard_right(1718, 335, g);
        if (numberOfCardsinHands[1] > 2)drawCard_right(1718, 615, g);
        if (numberOfCardsinHands[1] > 3)drawCard_right(1718, 195, g);
        if (numberOfCardsinHands[1] > 4)drawCard_right(1718, 755, g);
        if (numberOfCardsinHands[1] > 5)drawCard_right(1718, 55, g);
        if (numberOfCardsinHands[1] > 6)drawCard_right(1718, 895, g);
        if (numberOfCardsinHands[1] > 7)drawCard_right(1708, 55, g);
        if (numberOfCardsinHands[1] > 8)drawCard_right(1698, 55, g);
    }

    public void drawCardsPlayerGreen(Graphics g, int[] numberOfCardsinHands){
        if (numberOfCardsinHands[2] > 0)drawCard(895, 888, g);
        if (numberOfCardsinHands[2] > 1)drawCard(755, 888, g);
        if (numberOfCardsinHands[2] > 2)drawCard(1035, 888, g);
        if (numberOfCardsinHands[2] > 3)drawCard(615, 888, g);
        if (numberOfCardsinHands[2] > 4)drawCard(1175, 888, g);
        if (numberOfCardsinHands[2] > 5)drawCard(475, 888, g);
        if (numberOfCardsinHands[2] > 6)drawCard(1315, 888, g);
        if (numberOfCardsinHands[2] > 7)drawCard(1315, 878, g);
        if (numberOfCardsinHands[2] > 8)drawCard(1315, 868, g);
    }

    public void drawCardsPlayerRed(Graphics g, int[] numberOfCardsinHands){
        if (numberOfCardsinHands[3] > 0)drawCard_left(10, 475, g);
        if (numberOfCardsinHands[3] > 1)drawCard_left(10, 335, g);
        if (numberOfCardsinHands[3] > 2)drawCard_left(10, 615, g);
        if (numberOfCardsinHands[3] > 3)drawCard_left(10, 195, g);
        if (numberOfCardsinHands[3] > 4)drawCard_left(10, 755, g);
        if (numberOfCardsinHands[3] > 5)drawCard_left(10, 55, g);
        if (numberOfCardsinHands[3] > 6)drawCard_left(10, 895, g);
        if (numberOfCardsinHands[3] > 7)drawCard_left(20, 895, g);
        if (numberOfCardsinHands[3] > 8)drawCard_left(30, 895, g);
    }



    public void drawDeck (Graphics g){
        drawCard(985, 449, g);
        drawCard(985, 454, g);
        drawCard(985, 459, g);
        drawCard(985, 464, g);
        drawCard(985, 469, g);
    }





    public void drawTopOfDiscardPile(int x, int y, Graphics g, String topOfDiscardPile){
        if(topOfDiscardPile.equals("b0")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_0.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b1")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_1.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b2")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_2.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b3")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_3.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b4")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_4.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b5")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_5.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b6")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_6.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b7")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_7.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b8")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_8.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b9")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_9.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b10")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_skip.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b11")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_picker.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("b12")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/blue_reverse.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y0")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_0.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y1")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_1.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y2")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_2.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y3")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_3.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y4")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_4.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y5")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_5.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y6")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_6.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y7")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_7.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y8")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_8.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y9")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_9.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y10")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_skip.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y11")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_picker.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("y12")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/yellow_reverse.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g0")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_0.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g1")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_1.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g2")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_2.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g3")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_3.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g4")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_4.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g5")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_5.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g6")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_6.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g7")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_7.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g8")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_8.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g9")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_9.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g10")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_skip.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g11")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_picker.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("g12")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/green_reverse.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r0")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_0.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r1")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_1.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r2")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_2.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r3")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_3.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r4")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_4.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r5")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_5.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r6")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_6.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r7")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_7.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r8")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_8.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r9")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_9.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r10")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_skip.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r11")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_picker.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("r12")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/red_reverse.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("w13")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/wild_color_changer.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(topOfDiscardPile.equals("w14")){
            try {
                BufferedImage card = ImageIO.read(new File("src/small/wild_pick_4.png"));
                ((Graphics2D) g).drawImage(card, x, y, 130, 182, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
