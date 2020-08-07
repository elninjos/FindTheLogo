package nino.findthelogo;

import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class ChangePositionOfCupToFirstPosition {
    PxToDp pxToDp = new PxToDp();

    //SPREMENI POZICIJO GUMBA NA ZAČETNO POZICIJO
    public void changePositionOfCupToFirstPosition(ImageButton imgBtn){
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        if(imgBtn.equals(Game.firstCup)) {
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
            positionRules.setMargins(pxToDp.convert(40), pxToDp.convert(200), 0, 0);
            imgBtn.setLayoutParams(positionRules);
        }

        else if(imgBtn.equals(Game.secondCup)) {
            positionRules.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            positionRules.setMargins(0, pxToDp.convert(200), 0, 0);
            imgBtn.setLayoutParams(positionRules);
        }

        else if(imgBtn.equals(Game.thirdCup)) {
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            positionRules.setMargins(0, pxToDp.convert(200), pxToDp.convert(40), 0);
            imgBtn.setLayoutParams(positionRules);
        }
        else{}
    }
}
