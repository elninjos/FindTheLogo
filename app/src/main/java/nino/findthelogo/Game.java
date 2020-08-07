package nino.findthelogo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import nino.findthelogo.AllData.StaticData;

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
        StaticData.ocs = new OnClickStart();
        StaticData.occ = new OnClickCup();

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
        StaticData.ocs.onClickStart(view);
    }

    public void onClickCup(View view){
        StaticData.occ.onClickCup(view);
    }

    public void onClickYes (View view){
        finish();
    }

    public void onClickNo (View view){
        finish();
    }
}
