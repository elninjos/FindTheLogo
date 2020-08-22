package nino.UI;

import android.graphics.Bitmap;
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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

public class GameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // FULLSCREEN
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_gameover);

        init();
        draw();
        changeFont();
        gameOver();
    }

    private void init(){
        StaticData.layoutGameOver = (RelativeLayout) findViewById(R.id.layoutGameOver);
        StaticData.gameOver = (TextView) findViewById(R.id.gameOver);
        StaticData.yes = (Button) findViewById(R.id.yes);
        StaticData.no = (Button) findViewById(R.id.no);
    }

    private void draw(){
        Glide.with(this).asBitmap().load(R.drawable.background).into(new SimpleTarget<Bitmap>(247, 350) {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                Drawable background = new BitmapDrawable(resource);
                StaticData.layoutGameOver.setBackground(background);
            }
        });
    }

    private void changeFont(){
        StaticData.yes.setTypeface(StaticData.fontComicSans);
        StaticData.no.setTypeface(StaticData.fontComicSans);
        StaticData.gameOver.setTypeface(StaticData.fontOrangeJuice);
    }

    public void gameOver(){
        StaticData.firstCup.setVisibility(View.INVISIBLE);
        StaticData.secondCup.setVisibility(View.INVISIBLE);
        StaticData.thirdCup.setVisibility(View.INVISIBLE);
        StaticData.logo1.setVisibility(View.INVISIBLE);
        StaticData.logo2.setVisibility(View.INVISIBLE);
        StaticData.logo3.setVisibility(View.INVISIBLE);
    }

    public void onClickYes (View view){
        finish();
    }

    public void onClickNo (View view){
        finish();
    }
}