package Logic;

import java.util.LinkedHashSet;
import java.util.Random;

import nino.UI.R;

public class BackgroundFunctions {

    public void fillRandomSequence(){
        StaticData.logosSeq.clear();

        Random rand = new Random();
        while (StaticData.logosSeq.size() < 10) {
            StaticData.logosSeq.add(rand.nextInt(10));
        }
    }

    public void setLogos(int rand){
        StaticData.randLogo = (int) (Math.random() * 3 + 1);

        // TODO: se da optimizirat tko da nimaš 10 casov ampak če pride randNumb 3 daš x + "3" + 1
        switch (rand){
            case 0:
                StaticData.logo1.setBackgroundResource(R.drawable.x01);
                StaticData.logo2.setBackgroundResource(R.drawable.x02);
                StaticData.logo3.setBackgroundResource(R.drawable.x03);

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("NIKE"); break;
                    case 2: StaticData.logoName.setText("ADIDAS"); break;
                    case 3: StaticData.logoName.setText("PUMA"); break;
                }
                break;

            case 1:
                StaticData.logo1.setBackgroundResource(R.drawable.x11);
                StaticData.logo2.setBackgroundResource(R.drawable.x12);
                StaticData.logo3.setBackgroundResource(R.drawable.x13);

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("BARCELONA"); break;
                    case 2: StaticData.logoName.setText("LIVERPOOL"); break;
                    case 3: StaticData.logoName.setText("MILAN"); break;
                }
                break;

            case 2:
                StaticData.logo1.setBackgroundResource(R.drawable.x21);
                StaticData.logo2.setBackgroundResource(R.drawable.x22);
                StaticData.logo3.setBackgroundResource(R.drawable.x23);

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("CSKA"); break;
                    case 2: StaticData.logoName.setText("REAL MADRID"); break;
                    case 3: StaticData.logoName.setText("PANATHINAIKOS"); break;
                }
                break;

            case 3:
                StaticData.logo1.setBackgroundResource(R.drawable.x31);
                StaticData.logo2.setBackgroundResource(R.drawable.x32);
                StaticData.logo3.setBackgroundResource(R.drawable.x33);

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("AUDI"); break;
                    case 2: StaticData.logoName.setText("VOLKSWAGEN"); break;
                    case 3: StaticData.logoName.setText("CHEVROLET"); break;
                }
                break;

            case 4:
                StaticData.logo1.setBackgroundResource(R.drawable.x41);
                StaticData.logo2.setBackgroundResource(R.drawable.x42);
                StaticData.logo3.setBackgroundResource(R.drawable.x43);

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("SAAB"); break;
                    case 2: StaticData.logoName.setText("MERCEDES"); break;
                    case 3: StaticData.logoName.setText("VOLVO"); break;
                }
                break;

            case 5:
                StaticData.logo1.setBackgroundResource(R.drawable.x51);
                StaticData.logo2.setBackgroundResource(R.drawable.x52);
                StaticData.logo3.setBackgroundResource(R.drawable.x53);

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("TWITTER"); break;
                    case 2: StaticData.logoName.setText("GMAIL"); break;
                    case 3: StaticData.logoName.setText("TUMBLR"); break;
                }
                break;

            case 6:
                StaticData.logo1.setBackgroundResource(R.drawable.x61);
                StaticData.logo2.setBackgroundResource(R.drawable.x62);
                StaticData.logo3.setBackgroundResource(R.drawable.x63);

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("YOUTUBE"); break;
                    case 2: StaticData.logoName.setText("INSTAGRAM"); break;
                    case 3: StaticData.logoName.setText("SNAPCHAT"); break;
                }
                break;

            case 7:
                StaticData.logo1.setBackgroundResource(R.drawable.x71);
                StaticData.logo2.setBackgroundResource(R.drawable.x72);
                StaticData.logo3.setBackgroundResource(R.drawable.x73);

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("DUCATI"); break;
                    case 2: StaticData.logoName.setText("YAMAHA"); break;
                    case 3: StaticData.logoName.setText("SUZUKI"); break;
                }
                break;

            case 8:
                StaticData.logo1.setBackgroundResource(R.drawable.x81);
                StaticData.logo2.setBackgroundResource(R.drawable.x82);
                StaticData.logo3.setBackgroundResource(R.drawable.x83);

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("ANDROID STUDIO"); break;
                    case 2: StaticData.logoName.setText("ECLIPSE"); break;
                    case 3: StaticData.logoName.setText("NET BEANS"); break;
                }
                break;

            case 9:
                StaticData.logo1.setBackgroundResource(R.drawable.x91);
                StaticData.logo2.setBackgroundResource(R.drawable.x92);
                StaticData.logo3.setBackgroundResource(R.drawable.x93);

                switch (StaticData.randLogo){
                    case 1: StaticData.logoName.setText("TREK"); break;
                    case 2: StaticData.logoName.setText("SCOTT"); break;
                    case 3: StaticData.logoName.setText("KONA"); break;
                }
                break;
        }
    }
}
