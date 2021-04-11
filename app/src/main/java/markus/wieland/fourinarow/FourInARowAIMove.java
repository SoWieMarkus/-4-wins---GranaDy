package markus.wieland.fourinarow;

import markus.wieland.games.ai.gridbased.GridGameAIMove;
import markus.wieland.games.game.Difficulty;
import markus.wieland.games.game.GameBoardField;

public class FourInARowAIMove extends GridGameAIMove {

    private final int opponent;

    public FourInARowAIMove(Difficulty difficulty, int player, int opponent, int x, int y, int[][] grid) {
        super(difficulty, player, x, y, grid);
        this.opponent = opponent;
    }

    @Override
    public boolean isLegal() {
        return (y > 0 && grid[y][x] == GameBoardField.FREE && grid[y - 1][x] != GameBoardField.FREE)
                || (y == 0 && grid[y][x] == GameBoardField.FREE);
    }

    @Override
    public void executeMove() {
        grid[y][x] = player;
    }

    @Override
    protected long easyMove() {
        return random.nextInt(1000);
    }

    @Override
    protected long mediumMove() {
        return 0;
    }

    @Override
    protected long hardMove() {
        return 0;
    }
}
