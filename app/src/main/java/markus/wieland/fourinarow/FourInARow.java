package markus.wieland.fourinarow;

import markus.wieland.games.ai.AIMove;
import markus.wieland.games.ai.pattern.PatternMatcher;
import markus.wieland.games.game.GameBoardField;
import markus.wieland.games.game.GameEventListener;
import markus.wieland.games.game.MultiPlayerGame;
import markus.wieland.games.player.Player;
import markus.wieland.games.player.PlayerManager;

public class FourInARow extends MultiPlayerGame<FourInARowGameState, FourInARowGameResult> {

    private final PlayerManager players;
    private final FourInARowGameBoardView fourInARowGameBoardView;

    public FourInARow(GameEventListener<FourInARowGameResult> gameEventListener, FourInARowGameState gameState, FourInARowGameBoardView fourInARowGameBoardView) {
        super(gameEventListener);
        this.players = gameState.getPlayers();
        this.players.shuffleOrder();
        this.fourInARowGameBoardView = fourInARowGameBoardView;
        this.fourInARowGameBoardView.loadGameState(gameState);

        PatternMatcher.getInstance().initialize(4, fourInARowGameBoardView.getLines(), GameBoardField.FREE);
        //TODO append by 4 bits with
        // Das aber am besten direkt im patternmatcher
        

        nextPlayer();
    }

    @Override
    public FourInARowGameState getGameState() {
        return null;
    }

    @Override
    public FourInARowGameResult getResult() {
        return null;
    }

    @Override
    protected void performAIMove(AIMove aiMove) {

    }

    @Override
    public void nextPlayer() {
        Player player = players.next();
        if (player.hasAI()) {
            fourInARowGameBoardView.setEnabled(false);
            performAIMove(player.move(getGameState()));
            return;
        }
        fourInARowGameBoardView.setEnabled(true);

    }
}
