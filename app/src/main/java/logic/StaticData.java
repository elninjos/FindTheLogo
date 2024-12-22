package Logic;

import android.content.Intent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class StaticData {

    // region TITLE

    public static Intent gameWindow = null;
    public static Intent instructionsWindow = null;
    public static Intent gameOverWindow = null;

    // endregion

    // region INSTRUCTIONS

    public static TextView instructions = null;

    // endregion

    // region GAME

    public static ImageButton firstCupBtn;
    public static ImageButton secondCupBtn;
    public static ImageButton thirdCupBtn;
    public static ImageView logo1;
    public static ImageView logo2;
    public static ImageView logo3;

    // endregion

    // region GAME OVER

    public static Button yes;
    public static Button no;
    public static TextView gameOver;

    // endregion
}
