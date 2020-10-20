package Logic;

import android.content.res.Resources;

import java.util.EventListener;

import nino.UI.R;

public class BackgroundFunctions {

    public void checkRandom(){
        // TODO: random brez ponavljanja
        int rand = (int)(Math.random() * 10 + 0);

        // TODO: Poglej za najboljšo podatkovno strukturo, katera ima najhitrejši search and delete
        if(!StaticData.results[rand]){
            StaticData.results[rand] = true;
            setLogos(rand);
        }
        else if(StaticData.results[rand]){
            checkRandom();
        }
        else if(StaticData.results[0] && StaticData.results[1] && StaticData.results[2] && StaticData.results[3] && StaticData.results[4] && StaticData.results[5] && StaticData.results[6] && StaticData.results[7] && StaticData.results[8] && StaticData.results[9]) {
            // Event
            EventListener gameOver = new EventListener() {

            };
//            gameOver();
        }
    }

    // Convert from PX to DP
    public static int convert(int px) {
        return (int) (px * Resources.getSystem().getDisplayMetrics().density);
    }

    public void setLogos(int rand){
        StaticData.randLogo = (int) (Math.random() * 3 + 1);

        switch (rand){
            case 0:
                StaticData.first = R.drawable.x01;
                StaticData.second = R.drawable.x02;
                StaticData.third = R.drawable.x03;

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("NIKE"); break;
                    case 2: StaticData.logoName.setText("ADIDAS"); break;
                    case 3: StaticData.logoName.setText("PUMA"); break;
                }
                break;

            case 1:
                StaticData.first = R.drawable.x11;
                StaticData.second = R.drawable.x12;
                StaticData.third = R.drawable.x13;

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("BARCELONA"); break;
                    case 2: StaticData.logoName.setText("LIVERPOOL"); break;
                    case 3: StaticData.logoName.setText("MILAN"); break;
                }
                break;

            case 2:
                StaticData.first = R.drawable.x21;
                StaticData.second = R.drawable.x22;
                StaticData.third = R.drawable.x23;

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("CSKA"); break;
                    case 2: StaticData.logoName.setText("REAL MADRID"); break;
                    case 3: StaticData.logoName.setText("PANATHINAIKOS"); break;
                }
                break;

            case 3:
                StaticData.first = R.drawable.x31;
                StaticData.second = R.drawable.x32;
                StaticData.third = R.drawable.x33;

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("AUDI"); break;
                    case 2: StaticData.logoName.setText("VOLKSWAGEN"); break;
                    case 3: StaticData.logoName.setText("CHEVROLET"); break;
                }
                break;

            case 4:
                StaticData.first = R.drawable.x41;
                StaticData.second = R.drawable.x42;
                StaticData.third = R.drawable.x43;

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("SAAB"); break;
                    case 2: StaticData.logoName.setText("MERCEDES"); break;
                    case 3: StaticData.logoName.setText("VOLVO"); break;
                }
                break;

            case 5:
                StaticData.first = R.drawable.x51;
                StaticData.second = R.drawable.x52;
                StaticData.third = R.drawable.x53;

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("TWITTER"); break;
                    case 2: StaticData.logoName.setText("GMAIL"); break;
                    case 3: StaticData.logoName.setText("TUMBLR"); break;
                }
                break;

            case 6:
                StaticData.first = R.drawable.x61;
                StaticData.second = R.drawable.x62;
                StaticData.third = R.drawable.x63;

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("YOUTUBE"); break;
                    case 2: StaticData.logoName.setText("INSTAGRAM"); break;
                    case 3: StaticData.logoName.setText("SNAPCHAT"); break;
                }
                break;

            case 7:
                StaticData.first = R.drawable.x71;
                StaticData.second = R.drawable.x72;
                StaticData.third = R.drawable.x73;

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("DUCATI"); break;
                    case 2: StaticData.logoName.setText("YAMAHA"); break;
                    case 3: StaticData.logoName.setText("SUZUKI"); break;
                }
                break;

            case 8:
                StaticData.first = R.drawable.x81;
                StaticData.second = R.drawable.x82;
                StaticData.third = R.drawable.x83;

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("ANDROID STUDIO"); break;
                    case 2: StaticData.logoName.setText("ECLIPSE"); break;
                    case 3: StaticData.logoName.setText("NET BEANS"); break;
                }
                break;

            case 9:
                StaticData.first = R.drawable.x91;
                StaticData.second = R.drawable.x92;
                StaticData.third = R.drawable.x93;

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("TREK"); break;
                    case 2: StaticData.logoName.setText("SCOTT"); break;
                    case 3: StaticData.logoName.setText("KONA"); break;
                }
                break;
        }
    }
}
