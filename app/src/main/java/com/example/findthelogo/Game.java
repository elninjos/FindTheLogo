package com.example.findthelogo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.graphics.Bitmap;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

import java.util.concurrent.ExecutionException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.GenericLifecycleObserver;

import static com.bumptech.glide.request.RequestOptions.fitCenterTransform;

public class Game extends AppCompatActivity {

    OnClickStart ocs = new OnClickStart();
    OnClickCup occ = new OnClickCup();

    public static RelativeLayout layoutGame;
    public static ImageButton firstCup;
    public static ImageButton secondCup;
    public static ImageButton thirdCup;
    public static Button start;
    public static TextView logoName;
    public static boolean cupsUp = false; //Če so kozarci dvigneni so manjši, drugače so v isti dimenziji
    public static boolean cupIsUp = false; //Če je en kozarček dvignen, druga dva nemoreš dvigniti
    //slike pod kozarci
    public static ImageButton logo1;
    public static ImageButton logo2;
    public static ImageButton logo3;
    public static RelativeLayout popUp;
    public static Button yes;
    public static Button no;
    public static TextView gameOver;


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
        layoutGame = (RelativeLayout) findViewById(R.id.layoutGame);
        firstCup = (ImageButton) findViewById(R.id.firstCup);
        secondCup = (ImageButton) findViewById(R.id.secondCup);
        thirdCup = (ImageButton) findViewById(R.id.thirdCup);
        start = (Button) findViewById(R.id.start);
        logoName = (TextView) findViewById(R.id.logoName);
        logo1 = (ImageButton) findViewById(R.id.logo1);
        logo2 = (ImageButton) findViewById(R.id.logo2);
        logo3 = (ImageButton) findViewById(R.id.logo3);
        popUp = (RelativeLayout) findViewById(R.id.popUp);
        gameOver = (TextView) findViewById(R.id.gameOver);
        yes = (Button) findViewById(R.id.yes);
        no = (Button) findViewById(R.id.no);
    }

    public void draw() {
        Glide.with(this).load(R.drawable.cup).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                Drawable cup = new BitmapDrawable();
                firstCup.setBackground(cup);
                secondCup.setBackground(cup);
                thirdCup.setBackground(cup);
            }
        });

        public int getImage(String imageName) {

            int drawableResourceId = this.getResources().getIdentifier(imageName, "drawable", this.getPackageName());

            return drawableResourceId;
        }

/*        Glide.with(this).load(R.drawable.cup).asBitmap().into(new SimpleTarget<Bitmap>(247, 350) {
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                Drawable cup = new BitmapDrawable(resource);
                firstCup.setBackground(cup);
                secondCup.setBackground(cup);
                thirdCup.setBackground(cup);
            }
        });

        Glide.with(this).load(R.drawable.background).asBitmap().into(new SimpleTarget<Bitmap>(247, 350) {
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                Drawable background = new BitmapDrawable(resource);
                popUp.setBackground(background);
            }
        });
        Glide.with(this).load(R.drawable.gamebackground).asBitmap().into(new SimpleTarget<Bitmap>(800, 500) {
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                Drawable layout_draw = new BitmapDrawable(resource);
                layoutGame.setBackground(layout_draw);
            }
        });*/
    }

    //SPREMENI PISAVO
    public void changeFont(){
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/ComicSans.ttf");
        start.setTypeface(font);
        logoName.setTypeface(font);
        yes.setTypeface(font);
        no.setTypeface(font);

        Typeface font2 = Typeface.createFromAsset(getAssets(), "fonts/orange_juice.ttf");
        gameOver.setTypeface(font2);
    }

    public void onClickStart(View view){
        ocs.onClickStart(view);
    }

    public void onClickCup(View view){
        occ.onClickCup(view);
    }

    public void onClickYes (View view){
        Intent openGameOver = new Intent(this, Game.class);
        startActivity(openGameOver);
    }

    public void onClickNo (View view){
        Intent openGameOver = new Intent(this, Title.class);
        startActivity(openGameOver);
    }
}
