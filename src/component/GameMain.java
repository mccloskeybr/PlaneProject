package component;

import state.StateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by mccloskeybr on 3/5/16.
 */
public class GameMain extends JPanel{

    private double oldTime;

    public GameMain(){

        Window window = new Window(this);

        window.addKeyListener( new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                StateManager.getCurrentState().keyPressed(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                StateManager.getCurrentState().keyReleased(e.getKeyCode());
            }

        });

    }

    @SuppressWarnings("InfiniteLoopStatement")
    public void startGame(){

        while (true)
            loop();

    }

    public void loop(){

        double currentTime = System.currentTimeMillis();
        double delta = currentTime - oldTime;
        oldTime = currentTime;

        if (delta > 0.02f)
            delta = 0.02f;

        StateManager.getCurrentState().update(delta);

        repaint();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        StateManager.getCurrentState().render(g);

    }

}
