package com.example.findthelogo;
import android.view.View;

public class GameOver {
    public void gameOver(){
        Game.firstCup.setVisibility(View.INVISIBLE);
        Game.secondCup.setVisibility(View.INVISIBLE);
        Game.thirdCup.setVisibility(View.INVISIBLE);
        Game.logo1.setVisibility(View.INVISIBLE);
        Game.logo2.setVisibility(View.INVISIBLE);
        Game.logo3.setVisibility(View.INVISIBLE);
        Game.popUp.setVisibility(View.VISIBLE);
    }
}
