package markus.wieland.fourinarow;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import markus.wieland.games.elements.Coordinate;
import markus.wieland.games.elements.Line;
import markus.wieland.games.game.GameResult;
import markus.wieland.games.game.grid.GridGameBoardView;
import markus.wieland.games.persistence.GameState;

public class FourInARowGameBoardView extends GridGameBoardView<FourInARowGameBoardFieldView> {

    public static final int SIZE_X = 7;
    public static final int SIZE_Y = 6;

    public FourInARowGameBoardView(@NonNull Context context) {
        super(context);
    }

    public FourInARowGameBoardView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FourInARowGameBoardView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int getSizeX() {
        return SIZE_X;
    }

    @Override
    protected int getSizeY() {
        return SIZE_Y;
    }

    @Override
    protected void initializeLines() {

        for (int y = 0; y < SIZE_Y; y++) {
            for (int x = 0; x < 4; x++) {
                Line line = new Line();
                addCoordinateToLine(x, y, line);
                addCoordinateToLine(x + 1, y, line);
                addCoordinateToLine(x + 2, y, line);
                addCoordinateToLine(x + 3, y, line);
                addCoordinateToLine(x, y - 1, line);
                addCoordinateToLine(x + 1, y - 1, line);
                addCoordinateToLine(x + 2, y - 1, line);
                addCoordinateToLine(x + 3, y - 1, line);
                lines.add(line);
            }
        }

        for (int y = 0; y < 3; y++ ) {
            for (int x = 0; x < SIZE_X; x++) {
                Line line = new Line();
                addCoordinateToLine(x, y, line);
            }
        }

        //horizontal
        //vertical
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 3; x++) {
                Line line = new Line();
                line.add(new Coordinate(x, y));
                line.add(new Coordinate(x + 1, y));
                line.add(new Coordinate(x + 2, y));
                line.add(new Coordinate(x + 3, y));
                lines.add(line);
            }
        }

        //diagonal bottom left to upper right
        /*for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 4; y++) {
                List<Coordinates> coordinates = new ArrayList<>();
                coordinates.add(new Coordinates(x, y));
                coordinates.add(new Coordinates(x + 1, y + 1));
                coordinates.add(new Coordinates(x + 2, y + 2));
                coordinates.add(new Coordinates(x + 3, y + 3));
                ConnectFourLine line = new ConnectFourLine(coordinates);
                LINES.add(line);
            }
        }

        //diagonal bottom right to upper left
        for (int x = 0; x < 3; x++) {
            for (int y = 3; y < 7; y++) {
                List<Coordinates> coordinates = new ArrayList<>();
                coordinates.add(new Coordinates(x, y));
                coordinates.add(new Coordinates(x + 1, y - 1));
                coordinates.add(new Coordinates(x + 2, y - 2));
                coordinates.add(new Coordinates(x + 3, y - 3));
                ConnectFourLine line = new ConnectFourLine(coordinates);
                LINES.add(line);
            }
        }*/
    }

    public void performClick(int column) {

    }

    private void addCoordinateToLine(int x, int y, Line line) {
        if (y < 0) {
            y = getSizeY();
        }
        line.add(new Coordinate(x, y));
    }

    @Override
    protected void initializeFields() {

    }

    @Override
    protected GameResult checkGameForFinish() {
        return null;
    }

    @Override
    protected void loadGameState(GameState gameState) {
        FourInARowGameState fourInARowGameState = (FourInARowGameState) gameState;

    }
}
