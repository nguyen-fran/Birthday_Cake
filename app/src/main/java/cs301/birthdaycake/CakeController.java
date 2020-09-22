package cs301.birthdaycake;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener {

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
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        Log.d("switch", "switch clicked");

        if (cakeModel.hasCandles) {
            cakeModel.hasCandles = false;
        } else {
            cakeModel.hasCandles = true;
        }
        cakeView.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Log.d("seekbar", "seekbar changed");

        cakeModel.numCandles = progress;

        cakeView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //won't be using
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //won't be using
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.d("cakeView", "touch event happened");
        cakeModel.touchX = motionEvent.getX();
        cakeModel.touchY = motionEvent.getY();

        cakeView.invalidate();
        return true;
    }
}
