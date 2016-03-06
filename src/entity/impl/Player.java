package entity.impl;

import component.Window;
import entity.Entity;
import util.ImageUtil;
import util.RenderUtil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * Created by mccloskeybr on 3/5/16.
 */
public class Player extends Entity {

    private int health;
    private static final int MAX_HEALTH = 5;
    private double inv_currentTime;
    private static final double INV_MAXTIME = 15;
    private boolean isInvincible;

    private BufferedImage heart;

    public Player(double x, double y){
        super(ImageUtil.getInstance().loadImage("/assets/plane.png"), 20, x, y);

        health = MAX_HEALTH;
        heart = ImageUtil.getInstance().loadImage("/assets/heart.png");

    }

    public void incrementHealth(){

        if (!isInvincible) {

            isInvincible = true;

            health++;
            if (health > MAX_HEALTH)
                health = MAX_HEALTH;

        }

    }

    public void decrementHealth(){

        if (!isInvincible) {

            isInvincible = true;

            health--;

        }
    }

    public boolean isDead(){
        return health <= 0;
    }

    @Override
    public void update(double delta){
        super.update(delta);

        if (isInvincible) {

            inv_currentTime += delta;

            if (inv_currentTime >= INV_MAXTIME) {
                inv_currentTime = 0;
                isInvincible = false;
            }

        }

    }

    public void keyPressed(int k){

        if (k == KeyEvent.VK_A)
            setMovingLeft(true);
        else if (k == KeyEvent.VK_D)
            setMovingRight(true);

    }

    public void keyReleased(int k){

        if (k == KeyEvent.VK_A)
            setMovingLeft(false);
        else if (k == KeyEvent.VK_D)
            setMovingRight(false);

    }

    @Override
    public void render(Graphics g){
        super.render(g);

        for (int i = 0; i < health; i++)
            g.drawImage(
                    heart,
                    Window.WINDOW_WIDTH - (heart.getWidth() * RenderUtil.RENDER_SCALE * MAX_HEALTH) - 30 + (heart.getWidth() * i * RenderUtil.RENDER_SCALE) + 5 * i,
                    10,
                    heart.getWidth() * RenderUtil.RENDER_SCALE,
                    heart.getHeight() * RenderUtil.RENDER_SCALE,
                    null);

    }

}
