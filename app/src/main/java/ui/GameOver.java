package UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import Logic.StaticData;
import nino.UI.R;

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
        gameOver();
    }

    private void init(){
        StaticData.gameOver = findViewById(R.id.gameOver);
        StaticData.yes = findViewById(R.id.yes);
        StaticData.no = findViewById(R.id.no);
    }

    public void gameOver(){
        StaticData.firstCupBtn.setVisibility(View.INVISIBLE);
        StaticData.secondCupBtn.setVisibility(View.INVISIBLE);
        StaticData.thirdCupBtn.setVisibility(View.INVISIBLE);
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