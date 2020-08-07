package nino.findthelogo;

import android.os.Handler;
import android.os.Looper;
import android.transition.TransitionManager;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class OnClickStart {
    ChangeSizeOfCup csop = new ChangeSizeOfCup();
    ChangePositionOfCup cpop = new ChangePositionOfCup();
    ChangePositionOfCupToFirstPosition cpoptfp = new ChangePositionOfCupToFirstPosition();
    RandomLogos rl = new RandomLogos();

    public static View view;

    public static Handler UIHandler = new Handler(Looper.getMainLooper());

    //KLIK NA GUMB START
    public void onClickStart(View view) {
        OnClickStart.view = view;

        //Animacija postane boljša
        TransitionManager.beginDelayedTransition(Game.layoutGame);

        //Prikaže loncke
        Game.firstCup.setVisibility(View.VISIBLE);
        Game.secondCup.setVisibility(View.VISIBLE);
        Game.thirdCup.setVisibility(View.VISIBLE);

        //Skrije gumb
        Game.start.setVisibility(View.GONE);

        //Random za logotipe
        rl.checkRandom();

        //Po 1 sekundi loncke dvigne
        Timer timer1 = new Timer();
        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                UIHandler.post(new Runnable(){
                    @Override
                    public void run(){
                        Game.cupsUp = true;
                        cpop.changePositionOfCup(Game.firstCup);
                        cpop.changePositionOfCup(Game.secondCup);
                        cpop.changePositionOfCup(Game.thirdCup);
                        csop.changeSizeOfCup(Game.firstCup);
                        csop.changeSizeOfCup(Game.secondCup);
                        csop.changeSizeOfCup(Game.thirdCup);
                        Game.logo1.setBackgroundResource(rl.getFirstLogo());
                        Game.logo2.setBackgroundResource(rl.getSecondLogo());
                        Game.logo3.setBackgroundResource(rl.getThirdLogo());
                        Game.logo1.setVisibility(View.VISIBLE);
                        Game.logo2.setVisibility(View.VISIBLE);
                        Game.logo3.setVisibility(View.VISIBLE);
                    }
                });
            }
        }, 1000);

        //Po 3 sekundah loncke nazaj spusti
        Timer timer2 = new Timer();
        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                UIHandler.post(new Runnable(){
                    @Override
                    public void run(){
                        Game.cupsUp = false;
                        cpoptfp.changePositionOfCupToFirstPosition(Game.firstCup);
                        cpoptfp.changePositionOfCupToFirstPosition(Game.secondCup);
                        cpoptfp.changePositionOfCupToFirstPosition(Game.thirdCup);
                        csop.changeSizeOfCup(Game.firstCup);
                        csop.changeSizeOfCup(Game.secondCup);
                        csop.changeSizeOfCup(Game.thirdCup);
                        Game.logo1.setVisibility(View.INVISIBLE);
                        Game.logo2.setVisibility(View.INVISIBLE);
                        Game.logo3.setVisibility(View.INVISIBLE);
                    }
                });

            }
        }, 3000);

        //Po 4 sekundah prikaže ime logotipa
        Timer timer3 = new Timer();
        timer3.schedule(new TimerTask() {
            @Override
            public void run() {
                UIHandler.post(new Runnable(){
                    @Override
                    public void run(){
                        Game.logoName.setVisibility(View.VISIBLE);
                    }
                });

            }
        }, 3800);


    }
}