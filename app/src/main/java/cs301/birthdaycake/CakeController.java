package cs301.birthdaycake;

import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;

public class CakeController  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private CakeView cakeView;
    private CakeModel cakeModel;

    public CakeController(CakeView cakeView) {
        this.cakeView = cakeView;
        this.cakeModel = this.cakeView.getCakeModel();

    }

    @Override
    public void onClick(View view) {
        Log.d("button", "button clicked");

        cakeModel.candlesLit = false;
        cakeView.invalidate();

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        Log.d("switch", "switch clicked");

        if (cakeModel.hasCandles == true) {
            cakeModel.hasCandles = false;
        } else {
            cakeModel.hasCandles = true;
        }
        cakeView.invalidate();
    }
}
