package UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import Logic.StaticData;
import nino.UI.R;

public class Title extends AppCompatActivity {

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
    }

    private void init(){
        StaticData.infoBtn = findViewById(R.id.infoButton);
        StaticData.playBtn = findViewById(R.id.playButton);
        StaticData.layoutTitle = findViewById(R.id.layoutTitle);
    }

    private void draw(){
        StaticData.infoBtn.setBackgroundResource(R.drawable.info);
        StaticData.layoutTitle.setBackgroundResource(R.drawable.background);
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
