package UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.TimeUnit;

import Logic.BackgroundFunctions;
import Logic.StaticData;
import nino.UI.R;

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // FULLSCREEN
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_game);

        init();
    }

    private void init(){
        StaticData.layoutGame = findViewById(R.id.layoutGame);
        StaticData.firstCupBtn = findViewById(R.id.firstCupBtn);
        StaticData.secondCupBtn = findViewById(R.id.secondCupBtn);
        StaticData.thirdCupBtn = findViewById(R.id.thirdCupBtn);
        StaticData.startBtn = findViewById(R.id.startBtn);
        StaticData.logoName = findViewById(R.id.logoName);
        StaticData.logo1 = findViewById(R.id.logo1);
        StaticData.logo2 = findViewById(R.id.logo2);
        StaticData.logo3 = findViewById(R.id.logo3);
        StaticData.logosSeq = new LinkedHashSet<Integer>();
        StaticData.startGameCS = StaticData.layoutGame.getConstraintSet(R.id.startGame);
        StaticData.hideStartBtnCS = StaticData.layoutGame.getConstraintSet(R.id.hideStartButton);
        StaticData.showCupsCS = StaticData.layoutGame.getConstraintSet(R.id.showCups);
        StaticData.cupsUpCS = StaticData.layoutGame.getConstraintSet(R.id.cupsUp);
        StaticData.cupsDownCS = StaticData.layoutGame.getConstraintSet(R.id.cupsDown);
        StaticData.raiseCupCS = new ConstraintSet();
    }

    public static void newRound() throws InterruptedException {
        // Animation becomes better
        TransitionManager.beginDelayedTransition(StaticData.layoutGame);

        // Round by round
        for (int numbLogo : StaticData.logosSeq){
            clearOnNewRound();
            BackgroundFunctions.setLogos(numbLogo);

            hideStartBtn();
            showCups();

//        Thread.sleep(1000);
            raiseCups();

//        Thread.sleep(3000);
            releaseCups();

//            Thread.sleep(1000);
            showLogoName();
        }
    }

    private static void hideStartBtn(){
        StaticData.layoutGame.transitionToState(R.id.hideStartButton);
        StaticData.hideStartBtnCS.applyTo(StaticData.layoutGame);
    }

    private static void showCups() {
        StaticData.firstCupBtn.setClickable(false);
        StaticData.secondCupBtn.setClickable(false);
        StaticData.thirdCupBtn.setClickable(false);

        StaticData.layoutGame.transitionToState(R.id.showCups);
        StaticData.showCupsCS.applyTo(StaticData.layoutGame);
    }

    private static void raiseCups(){
        // TODO: Zmanjsaj velikost kozarckov za x 0.72
        StaticData.firstCupBtn.setBackgroundResource(R.drawable.cupdown);
        StaticData.secondCupBtn.setBackgroundResource(R.drawable.cupdown);
        StaticData.thirdCupBtn.setBackgroundResource(R.drawable.cupdown);

        StaticData.layoutGame.transitionToState(R.id.cupsUp);
        StaticData.cupsUpCS.applyTo(StaticData.layoutGame);
    }

    private static void releaseCups(){
        StaticData.firstCupBtn.setClickable(true);
        StaticData.secondCupBtn.setClickable(true);
        StaticData.thirdCupBtn.setClickable(true);

        StaticData.firstCupBtn.setBackgroundResource(R.drawable.cupup);
        StaticData.secondCupBtn.setBackgroundResource(R.drawable.cupup);
        StaticData.thirdCupBtn.setBackgroundResource(R.drawable.cupup);

        StaticData.layoutGame.transitionToState(R.id.cupsDown);
        StaticData.cupsDownCS.applyTo(StaticData.layoutGame);
    }

    private static void showLogoName(){
//        StaticData.logoName.setVisibility(View.VISIBLE);
    }

    public static void clearOnNewRound(){
        // Set logoName to invisible
        StaticData.logoName.setVisibility(View.INVISIBLE);
        StaticData.logoName.setText("");

        // Make logos invisible
        StaticData.logo1.setVisibility(View.INVISIBLE);
        StaticData.logo2.setVisibility(View.INVISIBLE);
        StaticData.logo3.setVisibility(View.INVISIBLE);

        StaticData.firstCupClicked = false;
        StaticData.secondCupClicked = false;
        StaticData.thirdCupClicked = false;
        StaticData.correctLogo = false;

        // Reset results
        StaticData.gameFinished = false;
    }

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

    public void onClickStart (View view) throws InterruptedException {
        // Clears logos sequence and make new for new game - AFTER GAME OVER
        BackgroundFunctions.fillRandomSequence();
        newRound();
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
