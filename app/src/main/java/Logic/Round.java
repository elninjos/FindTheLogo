package Logic;

import android.transition.TransitionManager;

import java.util.Random;

import Logic.RoundStates.PrepareCanvas;
import Models.GameData;

public class Round {
    private final ConcreteRoundState concreteRoundState;
    private final GameData gameData;

    public Round(GameData gameData) {
        this.gameData = gameData;

        // Animation becomes better
        TransitionManager.beginDelayedTransition(this.gameData.layoutGame);
        concreteRoundState = new ConcreteRoundState();
    }

    public void prepare() {
        FillRandomSequence();
    }

    public void start() {
        // Animation becomes better
        TransitionManager.beginDelayedTransition(gameData.layoutGame);

        for (int numbLogo : gameData.logosSeq){
            concreteRoundState.setRoundState(new PrepareCanvas(gameData));
            concreteRoundState.startRoundState();
        }
    }

    public void end(boolean correctAnswer) {

    }

    private void FillRandomSequence(){
        gameData.logosSeq.clear();

        Random rand = new Random();
        while (gameData.logosSeq.size() < 10) {
            gameData.logosSeq.add(rand.nextInt(10));
        }
    }
}