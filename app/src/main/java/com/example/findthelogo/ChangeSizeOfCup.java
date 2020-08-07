package com.example.findthelogo;

import android.view.ViewGroup;
import android.widget.ImageButton;

public class ChangeSizeOfCup {
    PxToDp pxToDp = new PxToDp();

    //SPREMENI VELIKOST GUMBA OB PREMIKU
    public void changeSizeOfCup(ImageButton imgBtn){
        ViewGroup.LayoutParams sizeRules = imgBtn.getLayoutParams();
        if(Game.cupsUp||Game.cupIsUp) {
            sizeRules.width = pxToDp.convert(112);
            sizeRules.height = pxToDp.convert(136);
        }
        else if(!Game.cupsUp&&!Game.cupIsUp){
            sizeRules.width = pxToDp.convert(152);
            sizeRules.height = pxToDp.convert(190);
        }

        imgBtn.setLayoutParams(sizeRules);
    }
}
