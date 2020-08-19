package nino.findthelogo;

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

import java.util.Timer;
import java.util.TimerTask;

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
        changeFont();
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
        StaticData.popUp = (RelativeLayout) findViewById(R.id.popUp);
        StaticData.gameOver = (TextView) findViewById(R.id.gameOver);
        StaticData.yes = (Button) findViewById(R.id.yes);
        StaticData.no = (Button) findViewById(R.id.no);
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

        Glide.with(this).asBitmap().load(R.drawable.background).into(new SimpleTarget<Bitmap>(247, 350) {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                Drawable background = new BitmapDrawable(resource);
                StaticData.popUp.setBackground(background);
            }
        });
    }

    private void changeFont(){
        StaticData.start.setTypeface(StaticData.fontComicSans);
        StaticData.logoName.setTypeface(StaticData.fontComicSans);
        StaticData.yes.setTypeface(StaticData.fontComicSans);
        StaticData.no.setTypeface(StaticData.fontComicSans);
        StaticData.gameOver.setTypeface(StaticData.fontOrangeJuice);
    }

    public void onClickStart(View view){
        // Animation becomes better
        TransitionManager.beginDelayedTransition(StaticData.layoutGame);

        // Hide start button
        StaticData.start.setVisibility(View.GONE);

        // Show cups
        StaticData.firstCup.setVisibility(View.VISIBLE);
        StaticData.secondCup.setVisibility(View.VISIBLE);
        StaticData.thirdCup.setVisibility(View.VISIBLE);

        //Random for logotypes
        checkRandom();

        //Po 1 sekundi loncke dvigne
        new Handler().postDelayed(new Runnable() {
            public void run() {
                StaticData.cupsUp = true;
                changePositionOfCup(StaticData.firstCup);
                changePositionOfCup(StaticData.secondCup);
                changePositionOfCup(StaticData.thirdCup);
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
                changePositionOfCupToFirstPosition(StaticData.firstCup);
                changePositionOfCupToFirstPosition(StaticData.secondCup);
                changePositionOfCupToFirstPosition(StaticData.thirdCup);
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

    public void onClickCup(View view){
        StaticData.logoName.setVisibility(View.INVISIBLE);
        TransitionManager.beginDelayedTransition(StaticData.layoutGame);
        String cupName = view.getTag().toString();

        if(!StaticData.cupIsUp){
            switch (cupName){
                case "firstCup":
                    changePositionOfCup(StaticData.firstCup);
                    changeSizeOfCup(StaticData.firstCup);
                    StaticData.logo1.setVisibility(View.VISIBLE);
                    StaticData.firstCupClicked = true;
                    break;

                case "secondCup":
                    changePositionOfCup(StaticData.secondCup);
                    changeSizeOfCup(StaticData.secondCup);
                    StaticData.logo2.setVisibility(View.VISIBLE);
                    StaticData.secondCupClicked = true;
                    break;

                case "thirdCup":
                    changePositionOfCup(StaticData.thirdCup);
                    changeSizeOfCup(StaticData.thirdCup);
                    StaticData.logo3.setVisibility(View.VISIBLE);
                    StaticData.thirdCupClicked = true;
                    break;
            }
        }

        checkLogo();
    }

    //SPREMENI POZICIJO GUMBA OB PREMIKU
    public void changePositionOfCup(ImageButton imgBtn){
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        if(imgBtn.equals(StaticData.firstCup)){
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            positionRules.setMargins(convert(61), convert(40),0,0);
            imgBtn.setLayoutParams(positionRules);
        }
        else if(imgBtn.equals(StaticData.secondCup)){
            positionRules.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            positionRules.setMargins(0, convert(40),0,0);
            imgBtn.setLayoutParams(positionRules);
        }
        else if(imgBtn.equals(StaticData.thirdCup)){
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            positionRules.setMargins(0, convert(40), convert(61),0);
            imgBtn.setLayoutParams(positionRules);
        }
    }

    //PRETVORBA IZ PX V DP
    public static int convert(int px) {
        return (int) (px * Resources.getSystem().getDisplayMetrics().density);
    }

    //SPREMENI POZICIJO GUMBA NA ZAČETNO POZICIJO
    public void changePositionOfCupToFirstPosition(ImageButton imgBtn){
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        if(imgBtn.equals(StaticData.firstCup)) {
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
            positionRules.setMargins(convert(40), convert(200), 0, 0);
            imgBtn.setLayoutParams(positionRules);
        }

        else if(imgBtn.equals(StaticData.secondCup)) {
            positionRules.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            positionRules.setMargins(0, convert(200), 0, 0);
            imgBtn.setLayoutParams(positionRules);
        }

        else if(imgBtn.equals(StaticData.thirdCup)) {
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            positionRules.setMargins(0, convert(200), convert(40), 0);
            imgBtn.setLayoutParams(positionRules);
        }
    }

    public void checkRandom(){
        boolean[] tab = new boolean[10];
        int rand = (int)(Math.random() * 10 + 0);

        if(!tab[rand]){
            tab[rand] = true;
            setLogos(rand);
        }
        else if(tab[rand]){
            checkRandom();
        }
        else if(tab[0] && tab[1] && tab[2] && tab[3] && tab[4] && tab[5] && tab[6] && tab[7] && tab[8] && tab[9]) {
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

    //SPREMENI VELIKOST GUMBA OB PREMIKU
    public void changeSizeOfCup(ImageButton imgBtn){
        ViewGroup.LayoutParams sizeRules = imgBtn.getLayoutParams();
        if(StaticData.cupIsUp||StaticData.cupIsUp) {
            sizeRules.width = convert(112);
            sizeRules.height = convert(136);
        }
        else if(!StaticData.cupsUp&&!StaticData.cupIsUp){
            sizeRules.width = convert(152);
            sizeRules.height = convert(190);
        }

        imgBtn.setLayoutParams(sizeRules);
    }

    public void checkLogo() {
        if (StaticData.cupIsUp) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    switch (StaticData.randLogo){
                        case 1:
                            if (StaticData.firstCupClicked) {
                                changePositionOfCupToFirstPosition(StaticData.firstCup);
                                changeSizeOfCup(StaticData.firstCup);
                                StaticData.logo1.setVisibility(View.INVISIBLE);
                                newRound();
                            }
                            else if(!StaticData.firstCupClicked) {
                                gameOver();
                            }

                            break;

                        case 2:
                            if (StaticData.secondCupClicked) {
                                changePositionOfCupToFirstPosition(StaticData.secondCup);
                                changeSizeOfCup(StaticData.secondCup);
                                StaticData.logo2.setVisibility(View.INVISIBLE);
                                newRound();
                            }
                            else if (!StaticData.secondCupClicked) {
                                gameOver();
                            }
                            break;

                        case 3:
                            if (StaticData.thirdCupClicked) {
                                changePositionOfCupToFirstPosition(StaticData.thirdCup);
                                changeSizeOfCup(StaticData.thirdCup);
                                StaticData.logo3.setVisibility(View.INVISIBLE);
                                newRound();
                            }
                            else if(!StaticData.thirdCupClicked) {
                                gameOver();
                            }
                            break;
                    }
                }
            }, 3000);

            StaticData.cupIsUp = false;
        }
    }

    public void newRound(){
        onClickStart(new View(null));
    }

    public void gameOver(){
        StaticData.firstCup.setVisibility(View.INVISIBLE);
        StaticData.secondCup.setVisibility(View.INVISIBLE);
        StaticData.thirdCup.setVisibility(View.INVISIBLE);
        StaticData.logo1.setVisibility(View.INVISIBLE);
        StaticData.logo2.setVisibility(View.INVISIBLE);
        StaticData.logo3.setVisibility(View.INVISIBLE);
        StaticData.popUp.setVisibility(View.VISIBLE);
    }

    public void onClickYes (View view){
        finish();
    }

    public void onClickNo (View view){
        finish();
    }
}
