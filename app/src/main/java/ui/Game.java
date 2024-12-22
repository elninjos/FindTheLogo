package UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintSet;
import android.support.constraint.motion.MotionLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.LinkedHashSet;

import Logic.Round;
import Logic.StaticData;
import Models.GameData;
import Models.ImageData;
import nino.UI.R;

public class Game extends AppCompatActivity  {
    MotionLayout layoutGame;
    private Round round;
    private GameData gameData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // FULLSCREEN
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_game);

        init();
        start();
    }

    private void init(){
        layoutGame = findViewById(R.id.layoutGame);
        gameData = new GameData(
                layoutGame,
                findViewById(R.id.firstCupBtn),
                findViewById(R.id.secondCupBtn),
                findViewById(R.id.thirdCupBtn),
                findViewById(R.id.startBtn),
                findViewById(R.id.logoName),
                findViewById(R.id.logo1),
                findViewById(R.id.logo2),
                findViewById(R.id.logo3),
                new LinkedHashSet<Integer>(),
                new ImageData[10],
                layoutGame.getConstraintSet(R.id.startGame),
                layoutGame.getConstraintSet(R.id.hideStartButton),
                layoutGame.getConstraintSet(R.id.showCups),
                layoutGame.getConstraintSet(R.id.cupsUp),
                layoutGame.getConstraintSet(R.id.cupsDown),
                new ConstraintSet(),
                false,
                false,
                false,
                false,
                false
        );
        round = new Round(gameData);
    }

    public void start() {
        round.prepare();
    }

    public void end() {
        round = null;
    }

//    public AssetManager GetAssets() {
//        return context.getAssets();
//    }

    /*    public void checkLogo() {
        // TODO: Problem je v tem ker je asinhrono, šele po 3 sekundah gre v run metodo
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (StaticData.cupIsUp) {
                    switch (StaticData.randLogo) {
                        case 1:
                            if (StaticData.firstCupClicked) {
                                changeCupPositionFirst("firstCup");
                                changeSizeOfCup(StaticData.firstCupBtn);
                                StaticData.logo1.setVisibility(View.INVISIBLE);
                                StaticData.correctLogo = true;
                            }
                            break;

                        case 2:
                            if (StaticData.secondCupClicked) {
                                changeCupPositionFirst("secondCup");
                                changeSizeOfCup(StaticData.secondCupBtn);
                                StaticData.logo2.setVisibility(View.INVISIBLE);
                                StaticData.correctLogo = true;
                            }
                            break;

                        case 3:
                            if (StaticData.thirdCupClicked) {
                                changeCupPositionFirst("thirdCup");
                                changeSizeOfCup(StaticData.thirdCupBtn);
                                StaticData.logo3.setVisibility(View.INVISIBLE);
                                StaticData.correctLogo = true;
                            }
                            break;
                    }
                }
            }
        }, 3000);
    }*/

    public void gameOver(){
        StaticData.gameOverWindow = new Intent(this, GameOver.class);
        startActivity(StaticData.gameOverWindow);
    }

    // region BUTTONS

    public void onClickStart (View view) {
        round.start();
    }

    public void onClickCup(View view) {
/*        StaticData.logoName.setVisibility(View.INVISIBLE);
        TransitionManager.beginDelayedTransition(StaticData.layoutGame);
        String cupName = view.getTag().toString();

        if(!StaticData.cupIsUp){
            switch (cupName){
                case "firstCup":
                    changePositionOfCup("firstCup");
                    changeSizeOfCup(StaticData.firstCupBtn);
                    StaticData.logo1.setVisibility(View.VISIBLE);
                    StaticData.firstCupClicked = true;
                    break;

                case "secondCup":
                    changePositionOfCup("secondCup");
                    changeSizeOfCup(StaticData.secondCupBtn);
                    StaticData.logo2.setVisibility(View.VISIBLE);
                    StaticData.secondCupClicked = true;
                    break;

                case "thirdCup":
                    changePositionOfCup("thirdCup");
                    changeSizeOfCup(StaticData.thirdCupBtn);
                    StaticData.logo3.setVisibility(View.VISIBLE);
                    StaticData.thirdCupClicked = true;
                    break;
            }
            StaticData.cupIsUp = true;
        }

        checkLogo();

        if(StaticData.correctLogo){
            resetVars();
            // TODO: Ali se da kako drugače začet novo rundo, da se to mogoče ne cikla?!
            newRound();
        }
        else {
            StaticData.gameFinished = true;
            resetVars();
            gameOver();
        }*/
    }

/*    public void changePositionOfCup(String cupBtn){
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        switch (cupBtn){
            case "firstCup":
                positionRules.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
                positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
                positionRules.setMargins(BackgroundFunctions.convert(61), BackgroundFunctions.convert(40),0,0);
                StaticData.firstCup.setLayoutParams(positionRules);
                break;

            case "secondCup":
                positionRules.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
                positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
                positionRules.setMargins(0, BackgroundFunctions.convert(40),0,0);
                StaticData.secondCup.setLayoutParams(positionRules);
                break;

            case "thirdCup":
                positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
                positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
                positionRules.setMargins(0, BackgroundFunctions.convert(40), BackgroundFunctions.convert(61),0);
                StaticData.thirdCup.setLayoutParams(positionRules);
                break;
        }
    }*/

    // endregion
}
