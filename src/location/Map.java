package location;

import component.Window;
import entity.Entity;
import entity.impl.Debris;
import entity.impl.Enemy;
import entity.impl.Heart;
import entity.impl.Player;
import state.impl.GameManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by mccloskeybr on 3/5/16.
 */
public class Map {

    private ArrayList<Enemy> enemies;
    private BufferedImage bgImage, bgTile;
    private double bg_y;

    public Map(BufferedImage bgTile){

        this.bgTile = bgTile;

        enemies = new ArrayList<>();

        bgImage = new BufferedImage(bgTile.getWidth(), bgTile.getHeight() * 3, BufferedImage.TYPE_INT_ARGB);
        Graphics g = bgImage.getGraphics();
        for (int i = 0; i < 3; i++)
            g.drawImage(bgTile, 0, bgTile.getHeight() * i, null);

    }

    public ArrayList<Enemy> getEnemies(){
        return enemies;
    }

    public void update(double delta){

        Player player = GameManager.getGameState().getPlayer();

        for (int i = 0; i < enemies.size(); i++) {

            enemies.get(i).update(delta);

            if (enemies.get(i).getY() > Window.WINDOW_HEIGHT) {
                enemies.remove(i);
                i--;
            }

        }

        if (Math.random() < 0.000005) {

            Random random = new Random();

            if (random.nextInt(4) == 0)
                enemies.add(new Heart(random.nextInt(Window.WINDOW_WIDTH), 0));
            else
                enemies.add(new Debris(random.nextInt(Window.WINDOW_WIDTH), 0));

        }

        bg_y += delta * 10;

        if (bg_y > player.getY() - Window.WINDOW_HEIGHT - 50)
            bg_y -= bgTile.getHeight();

    }

    public void render(Graphics g){

        g.drawImage(bgImage, 0, (int) bg_y, null);

        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).render(g);
        }

    }

}
