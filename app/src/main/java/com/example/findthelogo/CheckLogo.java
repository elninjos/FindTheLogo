package com.example.findthelogo;

import android.content.Intent;
import android.os.Handler;
import android.view.View;

public class CheckLogo {
    NewRound nr = new NewRound();
    ChangePositionOfCupToFirstPosition cpoptfp = new ChangePositionOfCupToFirstPosition();
    ChangeSizeOfCup csop = new ChangeSizeOfCup();
    GameOver go = new GameOver();

    public void checkLogo() {
        if (Game.cupIsUp) {
            if (RandomLogos.randLogo == 1) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if (OnClickCup.firstCupClicked) {
                            cpoptfp.changePositionOfCupToFirstPosition(Game.firstCup);
                            csop.changeSizeOfCup(Game.firstCup);
                            Game.logo1.setVisibility(View.INVISIBLE);
                            nr.newRound();
                        }
                        else if(!OnClickCup.firstCupClicked) {
                            go.gameOver();
                        }
                    }
                }, 3000);
            }

            if (RandomLogos.randLogo == 2) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if (OnClickCup.secondCupClicked) {
                            cpoptfp.changePositionOfCupToFirstPosition(Game.secondCup);
                            csop.changeSizeOfCup(Game.secondCup);
                            Game.logo2.setVisibility(View.INVISIBLE);
                            nr.newRound();
                        }
                        else if (!OnClickCup.secondCupClicked) {
                            go.gameOver();
                        }
                    }
                }, 3000);
            }

            if (RandomLogos.randLogo == 3) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if (OnClickCup.thirdCupClicked) {
                            cpoptfp.changePositionOfCupToFirstPosition(Game.thirdCup);
                            csop.changeSizeOfCup(Game.thirdCup);
                            Game.logo3.setVisibility(View.INVISIBLE);
                            nr.newRound();
                        }
                        else if(!OnClickCup.thirdCupClicked) {
                            go.gameOver();
                        }
                    }
                }, 3000);
            }
            Game.cupIsUp = false;
        }
    }
}
