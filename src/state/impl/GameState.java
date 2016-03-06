package state.impl;

import component.Window;
import entity.impl.Enemy;
import entity.impl.Player;
import location.Map;
import state.State;
import util.ImageUtil;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by mccloskeybr on 3/5/16.
 */
public class GameState implements State {

    private Player player;
    private Map map;

    public GameState(){
        player = new Player(Window.WINDOW_WIDTH / 2, Window.WINDOW_HEIGHT - 120);
        map = new Map(ImageUtil.getInstance().loadImage("/assets/bg.png"));
    }

    public Player getPlayer(){
        return player;
    }

    @Override
    public void update(double delta) {

        map.update(delta);
        player.update(delta);

        if (player.isDead())
            System.exit(0);

        ArrayList<Enemy> enemies = map.getEnemies();
        for (Enemy enemy: enemies){

            if (((enemy.getY() >= player.getY() && enemy.getY() <= player.getY() + player.getHeight()) ||
                (enemy.getY() + enemy.getHeight() >= player.getY() && enemy.getY() + enemy.getHeight() <= player.getY() + player.getHeight()))
                &&
                ((enemy.getX() >= player.getX() && enemy.getX() <= player.getX() + player.getWidth()) ||
                (enemy.getX() + enemy.getWidth() >= player.getX() && enemy.getX() + enemy.getWidth() <= player.getX() + player.getWidth()))) {

                enemy.onContact();
            }
        }
    }

    @Override
    public void render(Graphics g) {
        map.render(g);
        player.render(g);
    }

    @Override
    public void keyPressed(int k) {
        player.keyPressed(k);
    }

    @Override
    public void keyReleased(int k) {
        player.keyReleased(k);
    }

}
