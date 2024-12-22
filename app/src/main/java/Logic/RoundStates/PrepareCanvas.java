package Logic.RoundStates;

import static android.os.SystemClock.sleep;

import android.annotation.SuppressLint;
import android.view.View;

import Logic.RoundState;
import Logic.StaticData;
import Models.GameData;
import nino.UI.R;

public class PrepareCanvas implements RoundState {
    private final GameData gameData;

    public PrepareCanvas(GameData gameData) {
        this.gameData = gameData;
    }

    @Override
    public void startRoundState() {
        System.out.println("Preparing canvas...");
        clearOnNewRound();
        SetLogos(0); // TODO: Hardcoded, change outside to Round class
        hideStartBtn();
        showCups();

//        sleep(2000);
        raiseCups();

//        sleep(2000);
        releaseCups();
        gameData.logoName.setVisibility(View.VISIBLE);
    }

    private void clearOnNewRound(){
        // Set logoName to invisible
        gameData.logoName.setVisibility(View.INVISIBLE);
        gameData.logoName.setText("");

        // Make logos invisible
        gameData.logo1.setVisibility(View.INVISIBLE);
        gameData.logo2.setVisibility(View.INVISIBLE);
        gameData.logo3.setVisibility(View.INVISIBLE);

        gameData.firstCupClicked = false;
        gameData.secondCupClicked = false;
        gameData.thirdCupClicked = false;
        gameData.correctLogo = false;

        // Reset results
        gameData.gameFinished = false;
    }

    private void hideStartBtn() {
        gameData.layoutGame.transitionToState(R.id.hideStartButton);
        gameData.hideStartBtnCS.applyTo(gameData.layoutGame);
    }

    private void showCups() {
        gameData.firstCupBtn.setClickable(false);
        gameData.secondCupBtn.setClickable(false);
        gameData.thirdCupBtn.setClickable(false);

        gameData.layoutGame.transitionToState(R.id.showCups);
        gameData.showCupsCS.applyTo(gameData.layoutGame);
    }
    
    // MOVE
    @SuppressLint("SetTextI18n")
    public void SetLogos(int rand){
        int randLogo = (int) (Math.random() * 3 + 1);

        // TODO: se da optimizirat tko da nimaš 10 casov ampak če pride randNumb 3 daš x + "3" + 1
        switch (rand){
            case 0:
                gameData.logo1.setBackgroundResource(R.drawable.x01);
                gameData.logo2.setBackgroundResource(R.drawable.x02);
                gameData.logo3.setBackgroundResource(R.drawable.x03);

                switch (randLogo){
                    case 1: gameData.logoName.setText("NIKE"); break;
                    case 2: gameData.logoName.setText("ADIDAS"); break;
                    case 3: gameData.logoName.setText("PUMA"); break;
                }
                break;

            case 1:
                gameData.logo1.setBackgroundResource(R.drawable.x11);
                gameData.logo2.setBackgroundResource(R.drawable.x12);
                gameData.logo3.setBackgroundResource(R.drawable.x13);

                switch (randLogo){
                    case 1: gameData.logoName.setText("BARCELONA"); break;
                    case 2: gameData.logoName.setText("LIVERPOOL"); break;
                    case 3: gameData.logoName.setText("MILAN"); break;
                }
                break;

            case 2:
                gameData.logo1.setBackgroundResource(R.drawable.x21);
                gameData.logo2.setBackgroundResource(R.drawable.x22);
                gameData.logo3.setBackgroundResource(R.drawable.x23);

                switch (randLogo){
                    case 1: gameData.logoName.setText("CSKA"); break;
                    case 2: gameData.logoName.setText("REAL MADRID"); break;
                    case 3: gameData.logoName.setText("PANATHINAIKOS"); break;
                }
                break;

            case 3:
                gameData.logo1.setBackgroundResource(R.drawable.x31);
                gameData.logo2.setBackgroundResource(R.drawable.x32);
                gameData.logo3.setBackgroundResource(R.drawable.x33);

                switch (randLogo){
                    case 1: gameData.logoName.setText("AUDI"); break;
                    case 2: gameData.logoName.setText("VOLKSWAGEN"); break;
                    case 3: gameData.logoName.setText("CHEVROLET"); break;
                }
                break;

            case 4:
                gameData.logo1.setBackgroundResource(R.drawable.x41);
                gameData.logo2.setBackgroundResource(R.drawable.x42);
                gameData.logo3.setBackgroundResource(R.drawable.x43);

                switch (randLogo){
                    case 1: gameData.logoName.setText("SAAB"); break;
                    case 2: gameData.logoName.setText("MERCEDES"); break;
                    case 3: gameData.logoName.setText("VOLVO"); break;
                }
                break;

            case 5:
                gameData.logo1.setBackgroundResource(R.drawable.x51);
                gameData.logo2.setBackgroundResource(R.drawable.x52);
                gameData.logo3.setBackgroundResource(R.drawable.x53);

                switch (randLogo){
                    case 1: gameData.logoName.setText("TWITTER"); break;
                    case 2: gameData.logoName.setText("GMAIL"); break;
                    case 3: gameData.logoName.setText("TUMBLR"); break;
                }
                break;

            case 6:
                gameData.logo1.setBackgroundResource(R.drawable.x61);
                gameData.logo2.setBackgroundResource(R.drawable.x62);
                gameData.logo3.setBackgroundResource(R.drawable.x63);

                switch (randLogo){
                    case 1: gameData.logoName.setText("YOUTUBE"); break;
                    case 2: gameData.logoName.setText("INSTAGRAM"); break;
                    case 3: gameData.logoName.setText("SNAPCHAT"); break;
                }
                break;

            case 7:
                gameData.logo1.setBackgroundResource(R.drawable.x71);
                gameData.logo2.setBackgroundResource(R.drawable.x72);
                gameData.logo3.setBackgroundResource(R.drawable.x73);

                switch (randLogo){
                    case 1: gameData.logoName.setText("DUCATI"); break;
                    case 2: gameData.logoName.setText("YAMAHA"); break;
                    case 3: gameData.logoName.setText("SUZUKI"); break;
                }
                break;

            case 8:
                gameData.logo1.setBackgroundResource(R.drawable.x81);
                gameData.logo2.setBackgroundResource(R.drawable.x82);
                gameData.logo3.setBackgroundResource(R.drawable.x83);

                switch (randLogo){
                    case 1: gameData.logoName.setText("ANDROID STUDIO"); break;
                    case 2: gameData.logoName.setText("ECLIPSE"); break;
                    case 3: gameData.logoName.setText("NET BEANS"); break;
                }
                break;

            case 9:
                gameData.logo1.setBackgroundResource(R.drawable.x91);
                gameData.logo2.setBackgroundResource(R.drawable.x92);
                gameData.logo3.setBackgroundResource(R.drawable.x93);

                switch (randLogo){
                    case 1: gameData.logoName.setText("TREK"); break;
                    case 2: gameData.logoName.setText("SCOTT"); break;
                    case 3: gameData.logoName.setText("KONA"); break;
                }
                break;
        }
    }

    private void raiseCups(){
        // TODO: Zmanjsaj velikost kozarckov za x 0.72
        gameData.firstCupBtn.setBackgroundResource(R.drawable.cupdown);
        gameData.secondCupBtn.setBackgroundResource(R.drawable.cupdown);
        gameData.thirdCupBtn.setBackgroundResource(R.drawable.cupdown);

        gameData.layoutGame.transitionToState(R.id.cupsUp);
        gameData.cupsUpCS.applyTo(gameData.layoutGame);
    }

    private void releaseCups(){
        gameData.firstCupBtn.setClickable(true);
        gameData.secondCupBtn.setClickable(true);
        gameData.thirdCupBtn.setClickable(true);

        gameData.firstCupBtn.setBackgroundResource(R.drawable.cupup);
        gameData.secondCupBtn.setBackgroundResource(R.drawable.cupup);
        gameData.thirdCupBtn.setBackgroundResource(R.drawable.cupup);

        gameData.layoutGame.transitionToState(R.id.cupsDown);
        gameData.cupsDownCS.applyTo(gameData.layoutGame);
    }
}
