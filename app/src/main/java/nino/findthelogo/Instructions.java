package nino.findthelogo;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import nino.findthelogo.AllData.StaticData;

public class Instructions extends AppCompatActivity {

    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //FULLSCREEN
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_instructions);

        background();
        setTitle();
        instructions();
    }

    private void background(){
        layout = findViewById(R.id.layout);

        Glide.with(this).asBitmap().load(R.drawable.background).into(new SimpleTarget<Bitmap>(500, 500) {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                Drawable layout_draw = new BitmapDrawable(resource);
                layout.setBackground(layout_draw);
            }
        });
    }

    private void setTitle(){
        StaticData.title = findViewById(R.id.title);
        StaticData.title.setTypeface(StaticData.fontOrangeJuice);
    }

    private void instructions(){
        StaticData.instructions = findViewById(R.id.instructions);
        StringBuilder text= new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("instructions.txt")));

            while(br.ready()){
                text.append(" ").append(br.readLine());
            }

            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        StaticData.instructions.setText(text);
        StaticData.instructions.setTypeface(StaticData.fontComicSans);
    }
}