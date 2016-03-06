package entity.impl;

import state.impl.GameManager;
import util.ImageUtil;

import java.awt.image.BufferedImage;

/**
 * Created by mccloskeybr on 3/5/16.
 */
public class Heart extends Enemy {

    public Heart(double x, double y) {
        super(ImageUtil.getInstance().loadImage("/assets/heart.png"), 10, x, y);

        setMovingDown(true);

    }

    @Override
    public void onContact() {

        GameManager.getGameState().getPlayer().incrementHealth();

    }
}
