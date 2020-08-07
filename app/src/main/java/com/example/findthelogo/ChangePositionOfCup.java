package com.example.findthelogo;

import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class ChangePositionOfCup {
    PxToDp pxToDp = new PxToDp();



    //SPREMENI POZICIJO GUMBA OB PREMIKU
    public void changePositionOfCup(ImageButton imgBtn) {

        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        if (imgBtn.equals(Game.firstCup)) {
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            positionRules.setMargins(pxToDp.convert(61), pxToDp.convert(40), 0, 0);
            imgBtn.setLayoutParams(positionRules);
        } else if (imgBtn.equals(Game.secondCup)) {
            positionRules.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            positionRules.setMargins(0, pxToDp.convert(40), 0, 0);
            imgBtn.setLayoutParams(positionRules);
        } else if (imgBtn.equals(Game.thirdCup)) {
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            positionRules.setMargins(0, pxToDp.convert(40), pxToDp.convert(61), 0);
            imgBtn.setLayoutParams(positionRules);
        }
    }
}
