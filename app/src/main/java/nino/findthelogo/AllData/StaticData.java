package nino.findthelogo.AllData;

import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import nino.findthelogo.Game;
import nino.findthelogo.OnClickCup;
import nino.findthelogo.OnClickStart;

public class StaticData {
    // CLASSES

    // region TITLE

    public static Intent gameWindow = null;
    public static Intent instructionsWindow = null;

    // endregion

    // region INSTRUCTIONS

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
    public static RelativeLayout popUp;
    public static Button yes;
    public static Button no;
    public static TextView gameOver;


    public static OnClickStart ocs = null;
    public static OnClickCup occ = null;

    // endregion

    // region ON CLICK CUP

    public static boolean firstCupClicked = false;
    public static boolean secondCupClicked = false;
    public static boolean thirdCupClicked = false;
    public static View firstCupView;
    public static View secondCupView;
    public static View thirdCupView;

    // endregion


    //OTHER

    // region FONTS

    public static Typeface fontOrangeJuice;
    public static Typeface fontComicSans;

    // endregion
}
