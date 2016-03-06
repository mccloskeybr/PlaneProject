package entity.impl;

import state.impl.GameManager;
import util.ImageUtil;

/**
 * Created by mccloskeybr on 3/5/16.
 */
public class Debris extends Enemy {

    public Debris(double x, double y) {
        super(ImageUtil.getInstance().loadImage("/assets/debris.png"), 10, x, y);

        setMovingDown(true);

    }

    @Override
    public void onContact() {
        GameManager.getGameState().getPlayer().decrementHealth();
    }
}
