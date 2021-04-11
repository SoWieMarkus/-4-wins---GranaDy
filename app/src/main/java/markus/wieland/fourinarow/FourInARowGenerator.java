package markus.wieland.fourinarow;

import android.content.Context;

import markus.wieland.games.elements.Coordinate;
import markus.wieland.games.elements.SerializableMatrix;
import markus.wieland.games.game.Difficulty;
import markus.wieland.games.game.GameConfiguration;
import markus.wieland.games.persistence.GameGenerator;
import markus.wieland.games.player.Player;
import markus.wieland.games.player.PlayerManager;

public class FourInARowGenerator extends GameGenerator<FourInARowGameState> {

    private final Context context;

    public FourInARowGenerator(GameConfiguration configuration, Context context) {
        super(configuration);
        this.context = context;
    }

    @Override
    public FourInARowConfiguration getConfiguration() {
        return (FourInARowConfiguration) super.getConfiguration();
    }

    @Override
    public FourInARowGameState generate() {
        PlayerManager players = new PlayerManager();
        SerializableMatrix<FourInARowGameStateField> fields = new SerializableMatrix<>(FourInARowGameBoardView.SIZE_X, FourInARowGameBoardView.SIZE_Y);
        for (int x = 0;  x < FourInARowGameBoardView.SIZE_X; x++){
            for (int y = 0;  y < FourInARowGameBoardView.SIZE_Y; y++){
                fields.set(new Coordinate(x,y), new FourInARowGameStateField(new Coordinate(x,y)));
            }
        }
        players.register(new Player(null, TicTacToeGameBoardFieldView.PLAYER_1, context.getString(R.string.tictactoe_player1)));
        players.register(new Player(getConfiguration().isSinglePlayer()
                ? new TicTacToeAI(TicTacToeGameBoardFieldView.PLAYER_2, TicTacToeGameBoardFieldView.PLAYER_1, Difficulty.HARD)
                : null, TicTacToeGameBoardFieldView.PLAYER_2, getConfiguration().isSinglePlayer() ? context.getString(R.string.tictactoe_bot) : context.getString(R.string.tictactoe_player2)));

        return new FourInARowGameState(fields, players);
    }
}
