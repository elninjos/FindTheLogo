package Logic;

public class ConcreteRoundState implements RoundState {
    private RoundState roundState;

    public void setRoundState(RoundState roundState) {
        this.roundState = roundState;
    }

    @Override
    public void startRoundState() {
        roundState.startRoundState();
    }
}