package markus.wieland.fourinarow;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.Random;

import markus.wieland.games.elements.Coordinate;
import markus.wieland.games.game.GameBoardField;
import markus.wieland.games.game.grid.GridGameBoardFieldView;
import markus.wieland.games.game.view.GameStateField;

public class FourInARowGameBoardFieldView extends FrameLayout implements GridGameBoardFieldView, View.OnClickListener {

    public static final int PLAYER_1 = 0;
    public static final int PLAYER_2 = 1;

    private Coordinate coordinate;
    private int value;

    private ImageView foreground;
    private ImageView background;

    public FourInARowGameBoardFieldView(@NonNull Context context) {
        this(context, null);
    }

    public FourInARowGameBoardFieldView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FourInARowGameBoardFieldView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_game_board_field, this, true);
        foreground = findViewById(R.id.foreground);
        background = findViewById(R.id.background);
        setOnClickListener(this);

        coordinate = new Coordinate(1, 2);
    }


    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    private Drawable getDrawable(int value) {
        switch (value) {
            case PLAYER_1:
                return ContextCompat.getDrawable(getContext(), R.drawable.red_disc);
            case PLAYER_2:
                return ContextCompat.getDrawable(getContext(), R.drawable.yellow_disc);
            default:
                return null;
        }
    }

    public void update() {
        background.setLayoutParams(new LayoutParams(foreground.getWidth(), foreground.getWidth()));
        background.setImageDrawable(getDrawable(value));
        background.setY(getYOffset());
        background.animate().translationY(0)
                .setDuration(1000)
                .setInterpolator(new BounceInterpolator())
                .start();
    }

    private float getYOffset(){
        return -1 * (getCoordinate().getY() + 1) * getHeight() + (float) getHeight();
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void load(GameStateField stateField) {
        FourInARowGameStateField fourInARowGameStateField = (FourInARowGameStateField) stateField;
        this.coordinate = fourInARowGameStateField.getCoordinate();
        this.value = fourInARowGameStateField.getValue();
    }

    @Override
    public GameStateField getGameStateField() {
        return null;
    }

    @Override
    public void onClick(View view) {
        setValue(new Random().nextInt(3) - 1);
        update();
    }
}
