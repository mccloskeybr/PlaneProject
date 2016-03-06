package entity.impl;

import entity.Entity;

import java.awt.image.BufferedImage;

/**
 * Created by mccloskeybr on 3/5/16.
 */
public abstract class Enemy extends Entity {
    public Enemy(BufferedImage image, double speed, double x, double y) {
        super(image, speed, x, y);
    }

    public abstract void onContact();
}
