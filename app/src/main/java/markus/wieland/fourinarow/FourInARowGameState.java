package markus.wieland.fourinarow;

import markus.wieland.games.elements.SerializableMatrix;
import markus.wieland.games.game.grid.GridGameState;
import markus.wieland.games.player.PlayerManager;

public class FourInARowGameState extends GridGameState<FourInARowGameStateField> {

    private final PlayerManager players;

    public FourInARowGameState(SerializableMatrix<FourInARowGameStateField> matrix, PlayerManager players) {
        super(matrix);
        this.players = players;
    }

    public PlayerManager getPlayers() {
        return players;
    }

    public int[][] convert(){
        int[][] board = new int[FourInARowGameBoardView.SIZE_Y][FourInARowGameBoardView.SIZE_X];
        for (FourInARowGameStateField field : matrix) {
            board[field.getCoordinate().getY()][field.getCoordinate().getX()] = field.getValue();
        }
        return board;
    }
}
