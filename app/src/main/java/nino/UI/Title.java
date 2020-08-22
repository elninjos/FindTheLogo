package nino.UI;

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

public class Title extends AppCompatActivity {

    private ImageButton info;
    private Button playButton;
    private TextView title;
    private RelativeLayout layout;

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

    private void init(){
        info = findViewById(R.id.info);
        playButton = findViewById(R.id.playButton);
        title = findViewById(R.id.title);
        layout = findViewById(R.id.layout);
    }

    private void draw(){
        Glide.with(this).asBitmap().load(R.drawable.info).into(new SimpleTarget<Bitmap>(500, 500) {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                Drawable info_draw = new BitmapDrawable(resource);
                info.setBackground(info_draw);
            }
        });

        Glide.with(this).asBitmap().load(R.drawable.background).into(new SimpleTarget<Bitmap>(1648, 1165) {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                Drawable layout_draw = new BitmapDrawable(resource);
                layout.setBackground(layout_draw);
            }
        });
    }

    private void font(){
        StaticData.fontComicSans = Typeface.createFromAsset(getAssets(), "fonts/ComicSans.ttf");
        playButton.setTypeface(StaticData.fontComicSans);

        StaticData.fontOrangeJuice = Typeface.createFromAsset(getAssets(), "fonts/orange_juice.ttf");
        title.setTypeface(StaticData.fontOrangeJuice);
    }

    public void onClickPlay(View view){
        StaticData.gameWindow = new Intent(this, Game.class);
        startActivity(StaticData.gameWindow);
    }

    public void onClickInstructions(View view){
        StaticData.instructionsWindow = new Intent(this, Instructions.class);
        startActivity(StaticData.instructionsWindow);
    }
}
