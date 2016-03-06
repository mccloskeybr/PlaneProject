package state;

/**
 * Created by mccloskeybr on 3/5/16.
 */
public class StateManager {

    private static State currentState;

    public static void setCurrentState(State state){
        currentState = state;
    }

    public static State getCurrentState(){
        return currentState;
    }

}
