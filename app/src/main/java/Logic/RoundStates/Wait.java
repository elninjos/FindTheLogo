package Logic.RoundStates;

import Logic.RoundState;

public class Wait implements RoundState {
    @Override
    public void startRoundState() {
        System.out.println("Waiting...");
    }
}
