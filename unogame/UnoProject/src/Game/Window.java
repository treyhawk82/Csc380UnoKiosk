package Game;

import javax.swing.*;
import java.awt.*;

public class Window {

    public Window(int width, int height, String title, GUI gui){
        JFrame frame = new JFrame(title);

        int offset = 40;
        frame.setPreferredSize(new Dimension(width, height + offset));
        frame.setMaximumSize(new Dimension(width, height + offset));
        frame.setMinimumSize(new Dimension(width, height + offset));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(gui);
        frame.setVisible(true);
        gui.start();
    }
}
