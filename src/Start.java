import component.GameMain;
import state.StateManager;
import state.impl.GameManager;

/**
 * Created by mccloskeybr on 3/5/16.
 */
public class Start {

    public static void main(String[] args) {

        StateManager.setCurrentState(GameManager.getGameState());

        GameMain gameMain = new GameMain();
        gameMain.startGame();

    }

}
