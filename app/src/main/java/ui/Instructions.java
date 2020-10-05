package UI;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Logic.StaticData;
import nino.UI.R;

public class Instructions extends AppCompatActivity {

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

    private void background(){
        StaticData.layoutInstructions = findViewById(R.id.layoutInstructions);

        Glide.with(this).asBitmap().load(R.drawable.background).into(new SimpleTarget<Bitmap>(500, 500) {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                Drawable layout_draw = new BitmapDrawable(resource);
                StaticData.layoutInstructions.setBackground(layout_draw);
            }
        });
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
    }
}
