package com.example.findthelogo;

import android.transition.TransitionManager;
import android.view.View;

public class OnClickCup {

    ChangePositionOfCup cpoc = new ChangePositionOfCup();
    ChangeSizeOfCup csop = new ChangeSizeOfCup();
    CheckLogo cl = new CheckLogo();

    public static boolean firstCupClicked = false;
    public static boolean secondCupClicked = false;
    public static boolean thirdCupClicked = false;
    public static View firstCupView;
    public static View secondCupView;
    public static View thirdCupView;

    //KLIK NA KOZAREC
    public void onClickCup(View view){
        if(view.getId()==R.id.firstCup){
            firstCupView = view;
            if(!Game.cupIsUp) {
                Game.logoName.setVisibility(View.INVISIBLE);
                TransitionManager.beginDelayedTransition(Game.layoutGame);
                cpoc.changePositionOfCup(Game.firstCup);
    Game.cupIsUp = true;
    csop.changeSizeOfCup(Game.firstCup);
    Game.logo1.setVisibility(View.VISIBLE);
    firstCupClicked = true;
}
}

        if(view.getId()==R.id.secondCup){
        secondCupView = view;
        if(!Game.cupIsUp) {
        Game.logoName.setVisibility(View.INVISIBLE);
        TransitionManager.beginDelayedTransition(Game.layoutGame);
        cpoc.changePositionOfCup(Game.secondCup);
        Game.cupIsUp = true;
        csop.changeSizeOfCup(Game.secondCup);
        Game.logo2.setVisibility(View.VISIBLE);
        secondCupClicked = true;
        }
        }

        if(view.getId()==R.id.thirdCup){
        thirdCupView = view;
        if(!Game.cupIsUp) {
        Game.logoName.setVisibility(View.INVISIBLE);
        TransitionManager.beginDelayedTransition(Game.layoutGame);
        cpoc.changePositionOfCup(Game.thirdCup);
        Game.cupIsUp = true;
        csop.changeSizeOfCup(Game.thirdCup);
        Game.logo3.setVisibility(View.VISIBLE);
        thirdCupClicked = true;
        }
        }

        cl.checkLogo();
        }
}
