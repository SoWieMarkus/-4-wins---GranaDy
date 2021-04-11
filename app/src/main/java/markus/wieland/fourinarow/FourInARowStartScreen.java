package markus.wieland.fourinarow;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import markus.wieland.games.screen.view.StartScreenView;

public class FourInARowStartScreen extends StartScreenView {

    private boolean isSinglePlayer;

    public FourInARowStartScreen(@NonNull Context context) {
        super(context);
    }

    public FourInARowStartScreen(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FourInARowStartScreen(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected FourInARowConfiguration getConfiguration() {
        return new FourInARowConfiguration(isSinglePlayer);
    }

    @Override
    protected void onBuild() {

    }
}
