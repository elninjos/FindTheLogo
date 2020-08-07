package com.example.findthelogo;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Instructions extends AppCompatActivity {

    RelativeLayout layout;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //FULLSCREEN
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_instructions);

        background();
        instructions();
    }

    public void instructions(){
        final TextView instructions = (TextView) findViewById(R.id.instructions);
        TextView title = (TextView) findViewById(R.id.title);
        String text="";


        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("instructions.txt")));
            while(br.ready()){
                text = text + " " + br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        instructions.setText(text);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/ComicSans.ttf");
        instructions.setTypeface(font);
        Typeface font2 = Typeface.createFromAsset(getAssets(), "fonts/orange_juice.ttf");
        title.setTypeface(font2);
    }

    public void background(){
        this.layout = (RelativeLayout) findViewById(R.id.layout);

        Glide.with(this).load(R.drawable.background).asBitmap().into(new SimpleTarget<Bitmap>(500, 500) {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                Drawable layout_draw = new BitmapDrawable(resource);
                layout.setBackground(layout_draw);
            }
        });
    }
}
