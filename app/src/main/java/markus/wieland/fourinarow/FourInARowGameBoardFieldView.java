package markus.wieland.fourinarow;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import markus.wieland.games.elements.Coordinate;
import markus.wieland.games.game.grid.GridGameBoardFieldView;
import markus.wieland.games.game.view.GameStateField;

public class FourInARowGameBoardFieldView extends androidx.appcompat.widget.AppCompatButton implements GridGameBoardFieldView {

    public static final int PLAYER_1

    public FourInARowGameBoardFieldView(@NonNull Context context) {
        super(context);
    }

    public FourInARowGameBoardFieldView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FourInARowGameBoardFieldView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public Coordinate getCoordinate() {
        return null;
    }

    @Override
    public void load(GameStateField stateField) {

    }

    @Override
    public GameStateField getGameStateField() {
        return null;
    }
}
