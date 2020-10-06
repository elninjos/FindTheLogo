package UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Logic.StaticData;
import nino.UI.R;

public class Instructions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // FULLSCREEN
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_instructions);

        init();
        draw();
        writeInstructions();
    }

    private void init(){
        StaticData.layoutInstructions = findViewById(R.id.layoutInstructions);
        StaticData.instructions = findViewById(R.id.instructions);
    }

    private void draw(){
        StaticData.layoutInstructions.setBackgroundResource(R.drawable.background);
    }

    private void writeInstructions(){
        StringBuilder text = new StringBuilder();

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
