package Logic.RoundStates;

import Logic.RoundState;

public class ShowTitle implements RoundState {
    @Override
    public void startRoundState() {
        System.out.println("Showing title...");
    }
}
