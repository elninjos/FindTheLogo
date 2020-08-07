package nino.findthelogo;

public class RandomLogos {

    GameOver go = new GameOver();

    char[] tab = new char[10];
    int first, second, third;
    int rand;
    public static int randLogo;

    public void checkRandom(){
        rand = (int)(Math.random()*10+0);
        if(tab[rand]!='x'){
            tab[rand]='x';
            setLogos();
        }
        else if(tab[rand]=='x'){
            checkRandom();
        }
        else if(tab[0]=='x'&&tab[1]=='x'&&tab[2]=='x'&&tab[3]=='x'&&tab[4]=='x'&&tab[5]=='x'&&tab[6]=='x'&&tab[7]=='x'&&tab[8]=='x'&&tab[9]=='x') {
            go.gameOver();
        }
    }

    public void setLogos(){
        randLogo = (int) (Math.random()*3+1);
        if(rand == 0) {
            first = R.drawable.x01;
            second = R.drawable.x02;
            third = R.drawable.x03;

            if(randLogo == 1) Game.logoName.setText("NIKE");
            else if(randLogo == 2) Game.logoName.setText("ADIDAS");
            else if(randLogo == 3) Game.logoName.setText("PUMA");
        }

        else if(rand == 1) {
            first = R.drawable.x11;
            second = R.drawable.x12;
            third = R.drawable.x13;

            if(randLogo == 1) Game.logoName.setText("BARCELONA");
            else if(randLogo == 2) Game.logoName.setText("LIVERPOOL");
            else if(randLogo == 3) Game.logoName.setText("MILAN");
        }

        else if(rand == 2) {
            first = R.drawable.x21;
            second = R.drawable.x22;
            third = R.drawable.x23;

            if(randLogo == 1) Game.logoName.setText("CSKA");
            else if(randLogo == 2) Game.logoName.setText("REAL MADRID");
            else if(randLogo == 3) Game.logoName.setText("PANATHINAIKOS");
        }

        else if(rand == 3) {
            first = R.drawable.x31;
            second = R.drawable.x32;
            third = R.drawable.x33;

            if(randLogo == 1) Game.logoName.setText("AUDI");
            else if(randLogo == 2) Game.logoName.setText("VOLKSWAGEN");
            else if(randLogo == 3) Game.logoName.setText("CHEVROLET");
        }

        else if(rand == 4) {
            first = R.drawable.x41;
            second = R.drawable.x42;
            third = R.drawable.x43;

            if(randLogo == 1) Game.logoName.setText("SAAB");
            else if(randLogo == 2) Game.logoName.setText("MERCEDES");
            else if(randLogo == 3) Game.logoName.setText("VOLVO");
        }

        else if(rand == 5) {
            first = R.drawable.x51;
            second = R.drawable.x52;
            third = R.drawable.x53;

            if(randLogo == 1) Game.logoName.setText("TWITTER");
            else if(randLogo == 2) Game.logoName.setText("GMAIL");
            else if(randLogo == 3) Game.logoName.setText("TUMBLR");
        }

        else if(rand == 6) {
            first = R.drawable.x61;
            second = R.drawable.x62;
            third = R.drawable.x63;

            if(randLogo == 1) Game.logoName.setText("YOUTUBE");
            else if(randLogo == 2) Game.logoName.setText("INSTAGRAM");
            else if(randLogo == 3) Game.logoName.setText("SNAPCHAT");
        }

        else if(rand == 7) {
            first = R.drawable.x71;
            second = R.drawable.x72;
            third = R.drawable.x73;

            if(randLogo == 1) Game.logoName.setText("DUCATI");
            else if(randLogo == 2) Game.logoName.setText("YAMAHA");
            else if(randLogo == 3) Game.logoName.setText("SUZUKI");
        }

        else if(rand == 8) {
            first = R.drawable.x81;
            second = R.drawable.x82;
            third = R.drawable.x83;

            if(randLogo == 1) Game.logoName.setText("ANDROID STUDIO");
            else if(randLogo == 2) Game.logoName.setText("ECLIPSE");
            else if(randLogo == 3) Game.logoName.setText("NET BEANS");
        }

        else if(rand == 9) {
            first = R.drawable.x91;
            second = R.drawable.x92;
            third = R.drawable.x93;

            if(randLogo == 1) Game.logoName.setText("TREK");
            else if(randLogo == 2) Game.logoName.setText("SCOTT");
            else if(randLogo == 3) Game.logoName.setText("KONA");
        }
    }

    public int getFirstLogo() {
        return first;
    }

    public int getSecondLogo() {
        return second;
    }

    public int getThirdLogo() {
        return third;
    }
}
