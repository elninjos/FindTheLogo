package Models;

import android.support.constraint.ConstraintSet;
import android.support.constraint.motion.MotionLayout;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedHashSet;

public class GameData {
    public MotionLayout layoutGame;
    public ImageButton firstCupBtn;
    public ImageButton secondCupBtn;
    public ImageButton thirdCupBtn;
    public Button startBtn;
    public TextView logoName;
    public ImageView logo1;
    public ImageView logo2;
    public ImageView logo3;
    public LinkedHashSet<Integer> logosSeq;
    public ImageData[] imagesData;
    public ConstraintSet startGameCS;
    public ConstraintSet hideStartBtnCS;
    public ConstraintSet showCupsCS;
    public ConstraintSet cupsUpCS;
    public ConstraintSet cupsDownCS;
    public ConstraintSet raiseCupCS;
    public boolean firstCupClicked;
    public boolean secondCupClicked;
    public boolean thirdCupClicked;
    public boolean correctLogo;
    public boolean gameFinished;

    public GameData(MotionLayout layoutGame, ImageButton firstCupBtn, ImageButton secondCupBtn, ImageButton thirdCupBtn, Button startBtn, TextView logoName, ImageView logo1, ImageView logo2, ImageView logo3, LinkedHashSet<Integer> logosSeq, ImageData[] imagesData, ConstraintSet startGameCS, ConstraintSet hideStartBtnCS, ConstraintSet showCupsCS, ConstraintSet cupsUpCS, ConstraintSet cupsDownCS, ConstraintSet raiseCupCS, boolean firstCupClicked, boolean secondCupClicked, boolean thirdCupClicked, boolean correctLogo, boolean gameFinished) {
        this.layoutGame = layoutGame;
        this.firstCupBtn = firstCupBtn;
        this.secondCupBtn = secondCupBtn;
        this.thirdCupBtn = thirdCupBtn;
        this.startBtn = startBtn;
        this.logoName = logoName;
        this.logo1 = logo1;
        this.logo2 = logo2;
        this.logo3 = logo3;
        this.logosSeq = logosSeq;
        this.imagesData = imagesData;
        this.startGameCS = startGameCS;
        this.hideStartBtnCS = hideStartBtnCS;
        this.showCupsCS = showCupsCS;
        this.cupsUpCS = cupsUpCS;
        this.cupsDownCS = cupsDownCS;
        this.raiseCupCS = raiseCupCS;
        this.firstCupClicked = firstCupClicked;
        this.secondCupClicked = secondCupClicked;
        this.thirdCupClicked = thirdCupClicked;
        this.correctLogo = correctLogo;
        this.gameFinished = gameFinished;
    }
}
