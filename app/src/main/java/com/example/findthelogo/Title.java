package com.example.findthelogo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

public class Title extends AppCompatActivity {

    ImageButton info;
    Button playButton;
    TextView title;
    RelativeLayout layout;
    boolean clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //FULLSCREEN
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_title);

        init();
        draw();
        font();
    }

    public void init(){
        info = (ImageButton) findViewById(R.id.info);
        playButton = (Button) findViewById(R.id.playButton);
        title = (TextView) findViewById(R.id.title);
        layout = (RelativeLayout) findViewById(R.id.layout);
    }

    public void draw(){
        Glide.with(this).load(R.drawable.info).asBitmap().into(new SimpleTarget<Bitmap>(500, 500) {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                Drawable info_draw = new BitmapDrawable(resource);
                info.setBackground(info_draw);
            }
        });

        Glide.with(this).load(R.drawable.background).asBitmap().into(new SimpleTarget<Bitmap>(1648, 1165) {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                Drawable layout_draw = new BitmapDrawable(resource);
                layout.setBackground(layout_draw);
            }
        });
    }

    public void font(){
        //PISAVA COMIC SANS
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/ComicSans.ttf");
        playButton.setTypeface(font);

        //PISAVA ORANGE_JUICE
        Typeface font2 = Typeface.createFromAsset(getAssets(), "fonts/orange_juice.ttf");
        title.setTypeface(font2);
    }

    public void onClickPlay(View view){
        clicked=true;

        if(clicked) {
            Game.cupIsUp = false;
            Game.cupsUp = false;
            OnClickCup.firstCupClicked = false;
            OnClickCup.secondCupClicked = false;
            OnClickCup.thirdCupClicked = false;
            clicked = false;
        }

        Intent openGame = new Intent(this, Game.class);
        startActivity(openGame);
    }

    public void onClickInstructions(View view){
        Intent openInstructions = new Intent(this, Instructions.class);
        startActivity(openInstructions);
    }

}
