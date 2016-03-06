package state.impl;

/**
 * Created by mccloskeybr on 3/5/16.
 */
public class GameManager {

    private static GameState gameState;

    public static GameState getGameState(){

        if (gameState == null)
            gameState = new GameState();

        return gameState;

    }

}
