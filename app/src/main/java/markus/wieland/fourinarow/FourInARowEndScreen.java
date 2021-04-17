package markus.wieland.fourinarow;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import markus.wieland.games.screen.view.EndScreenView;

public class FourInARowEndScreen extends EndScreenView {

    public FourInARowEndScreen(@NonNull Context context) {
        super(context);
    }

    public FourInARowEndScreen(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FourInARowEndScreen(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onNewGameResult() {

    }

    @Override
    protected void onBuild() {

    }
}
