package state;

import java.awt.*;

/**
 * Created by mccloskeybr on 3/5/16.
 */
public interface State {

    void update(double delta);

    void render(Graphics g);

    void keyPressed(int k);

    void keyReleased(int k);

}
