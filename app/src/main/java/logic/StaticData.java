package Logic;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.constraint.motion.MotionLayout;
import android.support.constraint.motion.MotionScene;
import android.transition.Transition;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedHashSet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class StaticData {
    // CLASSES

    // region TITLE

    public static Intent gameWindow = null;
    public static Intent instructionsWindow = null;
    public static Intent gameOverWindow = null;

    // endregion

    // region INSTRUCTIONS

    public static TextView instructions = null;

    // endregion

    // region GAME

    public static MotionLayout layoutGame;
    public static ImageButton firstCupBtn;
    public static ImageButton secondCupBtn;
    public static ImageButton thirdCupBtn;
    public static Button startBtn;
    public static TextView logoName;
    public static ImageView logo1;
    public static ImageView logo2;
    public static ImageView logo3;

    public static boolean firstCupClicked = false;
    public static boolean secondCupClicked = false;
    public static boolean thirdCupClicked = false;
    public static boolean correctLogo = false;
    public static boolean gameFinished = false;

    public static LinkedHashSet<Integer> logosSeq;
    public static int randLogo;

    public static ConstraintSet startGameCS;
    public static ConstraintSet hideStartBtnCS;
    public static ConstraintSet showCupsCS;
    public static ConstraintSet cupsUpCS;
    public static ConstraintSet cupsDownCS;
    public static ConstraintSet raiseCupCS;

    // endregion

    // region GAME OVER

    public static Button yes;
    public static Button no;
    public static TextView gameOver;

    // endregion
}
