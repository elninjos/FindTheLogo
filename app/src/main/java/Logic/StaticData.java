package Logic;

import android.content.Intent;
import android.graphics.Typeface;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class StaticData {
    // CLASSES

    // region TITLE

    public static Intent gameWindow = null;
    public static Intent instructionsWindow = null;
    public static Intent gameOverWindow = null;

    // endregion

    // region INSTRUCTIONS

    public static RelativeLayout layoutInstructions = null;
    public static TextView instructions = null;
    public static TextView title = null;

    // endregion

    // region GAME

    public static RelativeLayout layoutGame;
    public static ImageButton firstCup;
    public static ImageButton secondCup;
    public static ImageButton thirdCup;
    public static Button start;
    public static TextView logoName;
    public static boolean cupsUp = false; //Če so kozarci dvigneni so manjši, drugače so v isti dimenziji
    public static boolean cupIsUp = false; //Če je en kozarček dvignen, druga dva nemoreš dvigniti
    public static ImageButton logo1;
    public static ImageButton logo2;
    public static ImageButton logo3;

    public static boolean firstCupClicked = false;
    public static boolean secondCupClicked = false;
    public static boolean thirdCupClicked = false;
    public static boolean correctLogo = false;
    public static boolean gameFinished = false;

    public static boolean[] results = new boolean[10];;

    public static int randLogo;
    public static int first;
    public static int second;
    public static int third;

    public static BackgroundFunctions bf = new BackgroundFunctions();

    // endregion

    // region GAME OVER

    public static RelativeLayout layoutGameOver;
    public static Button yes;
    public static Button no;
    public static TextView gameOver;

    // endregion
}
