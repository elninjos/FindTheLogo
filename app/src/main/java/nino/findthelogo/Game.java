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
        //Animacija postane boljša
        TransitionManager.beginDelayedTransition(StaticData.layoutGame);

        //Skrije gumb
        StaticData.start.setVisibility(View.GONE);

        //Prikaže loncke
        StaticData.firstCup.setVisibility(View.VISIBLE);
        StaticData.secondCup.setVisibility(View.VISIBLE);
        StaticData.thirdCup.setVisibility(View.VISIBLE);

        //Random za logotipe
        checkRandom();

        //Po 1 sekundi loncke dvigne
        new Timer().schedule(
            new TimerTask() {
            @Override
                public void run() {
                    StaticData.cupsUp = true;
                    changePositionOfCup(StaticData.firstCup);
                    changePositionOfCup(StaticData.secondCup);
                    changePositionOfCup(StaticData.thirdCup);
                    changeSizeOfCup(StaticData.firstCup);
                    changeSizeOfCup(StaticData.secondCup);
                    changeSizeOfCup(StaticData.thirdCup);
                    StaticData.logo1.setBackgroundResource(getFirstLogo());
                    StaticData.logo2.setBackgroundResource(getSecondLogo());
                    StaticData.logo3.setBackgroundResource(getThirdLogo());
                    StaticData.logo1.setVisibility(View.VISIBLE);
                    StaticData.logo2.setVisibility(View.VISIBLE);
                    StaticData.logo3.setVisibility(View.VISIBLE);
                }
            },
        1000
        );

        //Po 3 sekundah loncke nazaj spusti
        new Timer().schedule(
                new TimerTask() {
                    @Override
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
                },
                3000
        );

        //Po 4 sekundah prikaže ime logotipa
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        StaticData.logoName.setVisibility(View.VISIBLE);
                    }
                },
                4000
        );
    }

    public void onClickCup(View view){
        if(!StaticData.cupIsUp) {
            StaticData.logoName.setVisibility(View.INVISIBLE);
            TransitionManager.beginDelayedTransition(StaticData.layoutGame);
            changePositionOfCup(StaticData.firstCup);
            StaticData.cupIsUp = true;
            changeSizeOfCup(StaticData.firstCup);
            StaticData.logo1.setVisibility(View.VISIBLE);
            StaticData.firstCupClicked = true;
        }

        if(!StaticData.cupIsUp) {
            StaticData.logoName.setVisibility(View.INVISIBLE);
            TransitionManager.beginDelayedTransition(StaticData.layoutGame);
            changePositionOfCup(StaticData.secondCup);
            StaticData.cupIsUp = true;
            changeSizeOfCup(StaticData.secondCup);
            StaticData.logo2.setVisibility(View.VISIBLE);
            StaticData.secondCupClicked = true;
        }

        if(!StaticData.cupIsUp) {
            StaticData.logoName.setVisibility(View.INVISIBLE);
            TransitionManager.beginDelayedTransition(StaticData.layoutGame);
            changePositionOfCup(StaticData.thirdCup);
            StaticData.cupIsUp = true;
            changeSizeOfCup(StaticData.thirdCup);
            StaticData.logo3.setVisibility(View.VISIBLE);
            StaticData.thirdCupClicked = true;
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

        char[] tab = new char[10];
        int first, second, third;
        int rand;

        public void checkRandom(){
            rand = (int)(Math.random()*10+0);
            if(tab[rand]!='x'){
                tab[rand]='x';
                setLogos();
            }
            else if(tab[rand]=='x'){
                checkRandom();
            }
            else if(tab[0]=='x'&&tab[1]=='x'&&tab[2]=='x'&&tab[3]=='x'&&tab[4]=='x'&&tab[5]=='x'&&tab[6]=='x'&&tab[7]=='x'&&tab[8]=='x'&&tab[9]=='x') {
                gameOver();
            }
        }

    public void setLogos(){
        StaticData.randLogo = (int) (Math.random()*3+1);
        if(rand == 0) {
            first = R.drawable.x01;
            second = R.drawable.x02;
            third = R.drawable.x03;

            if(StaticData.randLogo == 1) StaticData.logoName.setText("NIKE");
            else if(StaticData.randLogo == 2) StaticData.logoName.setText("ADIDAS");
            else if(StaticData.randLogo == 3) StaticData.logoName.setText("PUMA");
        }

        else if(rand == 1) {
            first = R.drawable.x11;
            second = R.drawable.x12;
            third = R.drawable.x13;

            if(StaticData.randLogo == 1) StaticData.logoName.setText("BARCELONA");
            else if(StaticData.randLogo == 2) StaticData.logoName.setText("LIVERPOOL");
            else if(StaticData.randLogo == 3) StaticData.logoName.setText("MILAN");
        }

        else if(rand == 2) {
            first = R.drawable.x21;
            second = R.drawable.x22;
            third = R.drawable.x23;

            if(StaticData.randLogo == 1) StaticData.logoName.setText("CSKA");
            else if(StaticData.randLogo == 2) StaticData.logoName.setText("REAL MADRID");
            else if(StaticData.randLogo == 3) StaticData.logoName.setText("PANATHINAIKOS");
        }

        else if(rand == 3) {
            first = R.drawable.x31;
            second = R.drawable.x32;
            third = R.drawable.x33;

            if(StaticData.randLogo == 1) StaticData.logoName.setText("AUDI");
            else if(StaticData.randLogo == 2) StaticData.logoName.setText("VOLKSWAGEN");
            else if(StaticData.randLogo == 3) StaticData.logoName.setText("CHEVROLET");
        }

        else if(rand == 4) {
            first = R.drawable.x41;
            second = R.drawable.x42;
            third = R.drawable.x43;

            if(StaticData.randLogo == 1) StaticData.logoName.setText("SAAB");
            else if(StaticData.randLogo == 2) StaticData.logoName.setText("MERCEDES");
            else if(StaticData.randLogo == 3) StaticData.logoName.setText("VOLVO");
        }

        else if(rand == 5) {
            first = R.drawable.x51;
            second = R.drawable.x52;
            third = R.drawable.x53;

            if(StaticData.randLogo == 1) StaticData.logoName.setText("TWITTER");
            else if(StaticData.randLogo == 2) StaticData.logoName.setText("GMAIL");
            else if(StaticData.randLogo == 3) StaticData.logoName.setText("TUMBLR");
        }

        else if(rand == 6) {
            first = R.drawable.x61;
            second = R.drawable.x62;
            third = R.drawable.x63;

            if(StaticData.randLogo == 1) StaticData.logoName.setText("YOUTUBE");
            else if(StaticData.randLogo == 2) StaticData.logoName.setText("INSTAGRAM");
            else if(StaticData.randLogo == 3) StaticData.logoName.setText("SNAPCHAT");
        }

        else if(rand == 7) {
            first = R.drawable.x71;
            second = R.drawable.x72;
            third = R.drawable.x73;

            if(StaticData.randLogo == 1) StaticData.logoName.setText("DUCATI");
            else if(StaticData.randLogo == 2) StaticData.logoName.setText("YAMAHA");
            else if(StaticData.randLogo == 3) StaticData.logoName.setText("SUZUKI");
        }

        else if(rand == 8) {
            first = R.drawable.x81;
            second = R.drawable.x82;
            third = R.drawable.x83;

            if(StaticData.randLogo == 1) StaticData.logoName.setText("ANDROID STUDIO");
            else if(StaticData.randLogo == 2) StaticData.logoName.setText("ECLIPSE");
            else if(StaticData.randLogo == 3) StaticData.logoName.setText("NET BEANS");
        }

        else if(rand == 9) {
            first = R.drawable.x91;
            second = R.drawable.x92;
            third = R.drawable.x93;

            if(StaticData.randLogo == 1) StaticData.logoName.setText("TREK");
            else if(StaticData.randLogo == 2) StaticData.logoName.setText("SCOTT");
            else if(StaticData.randLogo == 3) StaticData.logoName.setText("KONA");
        }
    }

    public int getFirstLogo() {
        return first;
    }

    public int getSecondLogo() {
        return second;
    }

    public int getThirdLogo() {
        return third;
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
            if (StaticData.randLogo == 1) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if (StaticData.firstCupClicked) {
                            changePositionOfCupToFirstPosition(StaticData.firstCup);
                            changeSizeOfCup(StaticData.firstCup);
                            StaticData.logo1.setVisibility(View.INVISIBLE);
                            newRound();
                        }
                        else if(!StaticData.firstCupClicked) {
                            gameOver();
                        }
                    }
                }, 3000);
            }

            if (StaticData.randLogo == 2) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if (StaticData.secondCupClicked) {
                            changePositionOfCupToFirstPosition(StaticData.secondCup);
                            changeSizeOfCup(StaticData.secondCup);
                            StaticData.logo2.setVisibility(View.INVISIBLE);
                            newRound();
                        }
                        else if (!StaticData.secondCupClicked) {
                            gameOver();
                        }
                    }
                }, 3000);
            }

            if (StaticData.randLogo == 3) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if (StaticData.thirdCupClicked) {
                            changePositionOfCupToFirstPosition(StaticData.thirdCup);
                            changeSizeOfCup(StaticData.thirdCup);
                            StaticData.logo3.setVisibility(View.INVISIBLE);
                            newRound();
                        }
                        else if(!StaticData.thirdCupClicked) {
                            gameOver();
                        }
                    }
                }, 3000);
            }
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
