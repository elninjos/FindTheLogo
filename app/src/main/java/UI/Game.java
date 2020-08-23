package UI;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.Arrays;

import Logic.StaticData;
import nino.UI.R;

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //FULLSCREEN
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_game);

        init();
        draw();
    }

    public void init(){
        StaticData.layoutGame = (RelativeLayout) findViewById(R.id.layoutGame);
        StaticData.firstCup = (ImageButton) findViewById(R.id.firstCup);
        StaticData.secondCup = (ImageButton) findViewById(R.id.secondCup);
        StaticData.thirdCup = (ImageButton) findViewById(R.id.thirdCup);
        StaticData.start = (Button) findViewById(R.id.start);
        StaticData.logoName = (TextView) findViewById(R.id.logoName);
        StaticData.logo1 = (ImageButton) findViewById(R.id.logo1);
        StaticData.logo2 = (ImageButton) findViewById(R.id.logo2);
        StaticData.logo3 = (ImageButton) findViewById(R.id.logo3);
    }

    public void resetVars(){
        StaticData.cupsUp = false; //Če so kozarci dvigneni so manjši, drugače so v isti dimenziji
        StaticData.cupIsUp = false; //Če je en kozarček dvignen, druga dva nemoreš dvigniti

        // Make cups visible, update position and size
        StaticData.firstCup.setVisibility(View.VISIBLE);
        StaticData.secondCup.setVisibility(View.VISIBLE);
        StaticData.thirdCup.setVisibility(View.VISIBLE);
        changeCupPositionFirst("firstCup");
        changeCupPositionFirst("secondCup");
        changeCupPositionFirst("thirdCup");
        changeSizeOfCup(StaticData.firstCup);
        changeSizeOfCup(StaticData.secondCup);
        changeSizeOfCup(StaticData.thirdCup);

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
        if(StaticData.gameFinished){
            Arrays.fill(StaticData.results, false);
            StaticData.gameFinished = false;
        }
    }

    private void draw(){
        Glide.with(this).asBitmap().load(R.drawable.gamebackground).into(new SimpleTarget<Bitmap>(800, 500) {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                Drawable layout_draw = new BitmapDrawable(resource);
                StaticData.layoutGame.setBackground(layout_draw);
            }
        });

        Glide.with(this).asBitmap().load(R.drawable.cup).into(new SimpleTarget<Bitmap>(247, 350) {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                Drawable cup = new BitmapDrawable(resource);
                StaticData.firstCup.setBackground(cup);
                StaticData.secondCup.setBackground(cup);
                StaticData.thirdCup.setBackground(cup);
            }
        });
    }

    public void newRound(){
        // Animation becomes better
        TransitionManager.beginDelayedTransition(StaticData.layoutGame);

        // Hide start button
        StaticData.start.setVisibility(View.GONE);

        resetVars();

        //Random for logotypes
        StaticData.bf.checkRandom();

        //Po 1 sekundi loncke dvigne
        new Handler().postDelayed(new Runnable() {
            public void run() {
                StaticData.cupsUp = true;
                changePositionOfCup("firstCup");
                changePositionOfCup("secondCup");
                changePositionOfCup("thirdCup");
                changeSizeOfCup(StaticData.firstCup);
                changeSizeOfCup(StaticData.secondCup);
                changeSizeOfCup(StaticData.thirdCup);
                StaticData.logo1.setBackgroundResource(StaticData.first);
                StaticData.logo2.setBackgroundResource(StaticData.second);
                StaticData.logo3.setBackgroundResource(StaticData.third);
                StaticData.logo1.setVisibility(View.VISIBLE);
                StaticData.logo2.setVisibility(View.VISIBLE);
                StaticData.logo3.setVisibility(View.VISIBLE);
            }
        }, 1000);

        //Po 3 sekundah loncke nazaj spusti
        new Handler().postDelayed(new Runnable() {
            public void run() {
                StaticData.cupsUp = false;
                changeCupPositionFirst("firstCup");
                changeCupPositionFirst("secondCup");
                changeCupPositionFirst("thirdCup");
                changeSizeOfCup(StaticData.firstCup);
                changeSizeOfCup(StaticData.secondCup);
                changeSizeOfCup(StaticData.thirdCup);
                StaticData.logo1.setVisibility(View.INVISIBLE);
                StaticData.logo2.setVisibility(View.INVISIBLE);
                StaticData.logo3.setVisibility(View.INVISIBLE);
            }
        }, 3000);

        //Po 4 sekundah prikaže ime logotipa
        new Handler().postDelayed(new Runnable() {
            public void run() {
                StaticData.logoName.setVisibility(View.VISIBLE);
            }
        }, 4000);
    }

    public void onClickCup(View view) throws InterruptedException {
        StaticData.logoName.setVisibility(View.INVISIBLE);
        TransitionManager.beginDelayedTransition(StaticData.layoutGame);
        String cupName = view.getTag().toString();

        if(!StaticData.cupIsUp){
            switch (cupName){
                case "firstCup":
                    changePositionOfCup("firstCup");
                    changeSizeOfCup(StaticData.firstCup);
                    StaticData.logo1.setVisibility(View.VISIBLE);
                    StaticData.firstCupClicked = true;
                    break;

                case "secondCup":
                    changePositionOfCup("secondCup");
                    changeSizeOfCup(StaticData.secondCup);
                    StaticData.logo2.setVisibility(View.VISIBLE);
                    StaticData.secondCupClicked = true;
                    break;

                case "thirdCup":
                    changePositionOfCup("thirdCup");
                    changeSizeOfCup(StaticData.thirdCup);
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
        }
    }

    public void changePositionOfCup(String cupBtn){
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        switch (cupBtn){
            case "firstCup":
                positionRules.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
                positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
                positionRules.setMargins(StaticData.bf.convert(61), StaticData.bf.convert(40),0,0);
                StaticData.firstCup.setLayoutParams(positionRules);
                break;

            case "secondCup":
                positionRules.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
                positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
                positionRules.setMargins(0, StaticData.bf.convert(40),0,0);
                StaticData.secondCup.setLayoutParams(positionRules);
                break;

            case "thirdCup":
                positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
                positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
                positionRules.setMargins(0, StaticData.bf.convert(40), StaticData.bf.convert(61),0);
                StaticData.thirdCup.setLayoutParams(positionRules);
                break;
        }
    }

    // Convert from PX to DP
    public static int convert(int px) {
        return (int) (px * Resources.getSystem().getDisplayMetrics().density);
    }

    // Changes cup position to first (main) position
    public void changeCupPositionFirst(String cupBtn){
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        switch (cupBtn){
            case "firstCup":
                positionRules.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
                positionRules.setMargins(StaticData.bf.convert(40), StaticData.bf.convert(200), 0, 0);
                StaticData.firstCup.setLayoutParams(positionRules);
                break;

            case "secondCup":
                positionRules.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
                positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
                positionRules.setMargins(0, StaticData.bf.convert(200), 0, 0);
                StaticData.secondCup.setLayoutParams(positionRules);
                break;

            case "thirdCup":
                positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
                positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
                positionRules.setMargins(0, StaticData.bf.convert(200), StaticData.bf.convert(40), 0);
                StaticData.thirdCup.setLayoutParams(positionRules);
                break;
        }
    }

    public void checkRandom(){
        int rand = (int)(Math.random() * 10 + 0);

        if(!StaticData.results[rand]){
            StaticData.results[rand] = true;
            StaticData.bf.setLogos(rand);
        }
        else if(StaticData.results[rand]){
            checkRandom();
        }
        else if(StaticData.results[0] && StaticData.results[1] && StaticData.results[2] && StaticData.results[3] && StaticData.results[4] && StaticData.results[5] && StaticData.results[6] && StaticData.results[7] && StaticData.results[8] && StaticData.results[9]) {
            gameOver();
        }
    }

    public void setLogos(int rand){
        StaticData.randLogo = (int) (Math.random() * 3 + 1);

        switch (rand){
            case 0:
                StaticData.first = R.drawable.x01;
                StaticData.second = R.drawable.x02;
                StaticData.third = R.drawable.x03;

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("NIKE"); break;
                    case 2: StaticData.logoName.setText("ADIDAS"); break;
                    case 3: StaticData.logoName.setText("PUMA"); break;
                }
                break;

            case 1:
                StaticData.first = R.drawable.x11;
                StaticData.second = R.drawable.x12;
                StaticData.third = R.drawable.x13;

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("BARCELONA"); break;
                    case 2: StaticData.logoName.setText("LIVERPOOL"); break;
                    case 3: StaticData.logoName.setText("MILAN"); break;
                }
                break;

            case 2:
                StaticData.first = R.drawable.x21;
                StaticData.second = R.drawable.x22;
                StaticData.third = R.drawable.x23;

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("CSKA"); break;
                    case 2: StaticData.logoName.setText("REAL MADRID"); break;
                    case 3: StaticData.logoName.setText("PANATHINAIKOS"); break;
                }
                break;

            case 3:
                StaticData.first = R.drawable.x31;
                StaticData.second = R.drawable.x32;
                StaticData.third = R.drawable.x33;

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("AUDI"); break;
                    case 2: StaticData.logoName.setText("VOLKSWAGEN"); break;
                    case 3: StaticData.logoName.setText("CHEVROLET"); break;
                }
                break;

            case 4:
                StaticData.first = R.drawable.x41;
                StaticData.second = R.drawable.x42;
                StaticData.third = R.drawable.x43;

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("SAAB"); break;
                    case 2: StaticData.logoName.setText("MERCEDES"); break;
                    case 3: StaticData.logoName.setText("VOLVO"); break;
                }
                break;

            case 5:
                StaticData.first = R.drawable.x51;
                StaticData.second = R.drawable.x52;
                StaticData.third = R.drawable.x53;

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("TWITTER"); break;
                    case 2: StaticData.logoName.setText("GMAIL"); break;
                    case 3: StaticData.logoName.setText("TUMBLR"); break;
                }
                break;

            case 6:
                StaticData.first = R.drawable.x61;
                StaticData.second = R.drawable.x62;
                StaticData.third = R.drawable.x63;

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("YOUTUBE"); break;
                    case 2: StaticData.logoName.setText("INSTAGRAM"); break;
                    case 3: StaticData.logoName.setText("SNAPCHAT"); break;
                }
                break;

            case 7:
                StaticData.first = R.drawable.x71;
                StaticData.second = R.drawable.x72;
                StaticData.third = R.drawable.x73;

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("DUCATI"); break;
                    case 2: StaticData.logoName.setText("YAMAHA"); break;
                    case 3: StaticData.logoName.setText("SUZUKI"); break;
                }
                break;

            case 8:
                StaticData.first = R.drawable.x81;
                StaticData.second = R.drawable.x82;
                StaticData.third = R.drawable.x83;

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("ANDROID STUDIO"); break;
                    case 2: StaticData.logoName.setText("ECLIPSE"); break;
                    case 3: StaticData.logoName.setText("NET BEANS"); break;
                }
                break;

            case 9:
                StaticData.first = R.drawable.x91;
                StaticData.second = R.drawable.x92;
                StaticData.third = R.drawable.x93;

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("TREK"); break;
                    case 2: StaticData.logoName.setText("SCOTT"); break;
                    case 3: StaticData.logoName.setText("KONA"); break;
                }
                break;
        }
    }

    // Changes size of cup at the movement
    public void changeSizeOfCup(ImageButton imgBtn){
        ViewGroup.LayoutParams sizeRules = imgBtn.getLayoutParams();

        if(StaticData.cupIsUp || StaticData.cupsUp) {
            sizeRules.width = StaticData.bf.convert(112);
            sizeRules.height = StaticData.bf.convert(136);
        }
        else {
            sizeRules.width = StaticData.bf.convert(152);
            sizeRules.height = StaticData.bf.convert(190);
        }

        imgBtn.setLayoutParams(sizeRules);
    }

    public void checkLogo() {
        // TODO: Problem je v tem ker je asinhrono, šele po 3 sekundah gre v run metodo
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (StaticData.cupIsUp) {
                    switch (StaticData.randLogo) {
                        case 1:
                            if (StaticData.firstCupClicked) {
                                changeCupPositionFirst("firstCup");
                                changeSizeOfCup(StaticData.firstCup);
                                StaticData.logo1.setVisibility(View.INVISIBLE);
                                StaticData.correctLogo = true;
                            }
                            break;

                        case 2:
                            if (StaticData.secondCupClicked) {
                                changeCupPositionFirst("secondCup");
                                changeSizeOfCup(StaticData.secondCup);
                                StaticData.logo2.setVisibility(View.INVISIBLE);
                                StaticData.correctLogo = true;
                            }
                            break;

                        case 3:
                            if (StaticData.thirdCupClicked) {
                                changeCupPositionFirst("thirdCup");
                                changeSizeOfCup(StaticData.thirdCup);
                                StaticData.logo3.setVisibility(View.INVISIBLE);
                                StaticData.correctLogo = true;
                            }
                            break;
                    }
                }
            }
        }, 3000);
    }

    public void gameOver(){
        StaticData.gameOverWindow = new Intent(this, GameOver.class);
        startActivity(StaticData.gameOverWindow);
    }

    // region BUTTONS

    public void onClickStart (View view){
        newRound();
    }

    // endregion
}
