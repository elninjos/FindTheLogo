package nino.findthelogo;

import android.content.res.Resources;

public class PxToDp {
    //PRETVORBA IZ PX V DP
    public static int convert(int px) {
        return (int) (px * Resources.getSystem().getDisplayMetrics().density);
    }
}
