package component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

/**
 * Created by mccloskeybr on 3/5/16.
 */
public class Window {

    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 500;

    private JFrame jFrame;

    public Window(JPanel jPanel){

        jFrame = new JFrame();
        jFrame.setTitle("Plane Project");
        jFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);

        jFrame.add(jPanel);
        jFrame.setVisible(true);

    }

    public void addKeyListener(KeyListener keyListener) {
        jFrame.addKeyListener(keyListener);
    }

    public void drawPanel(JPanel jPanel){
        jFrame.add(jPanel);
    }


}
