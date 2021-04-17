package markus.wieland.fourinarow;

import android.view.View;
import android.view.animation.BounceInterpolator;

import markus.wieland.games.GameActivity;
import markus.wieland.games.game.GameConfiguration;
import markus.wieland.games.game.Highscore;
import markus.wieland.games.persistence.GameGenerator;
import markus.wieland.games.persistence.GameSaver;
import markus.wieland.games.screen.view.EndScreenView;
import markus.wieland.games.screen.view.StartScreenView;

public class MainActivity extends GameActivity<FourInARowConfiguration, Highscore, FourInARowGameState, FourInARowGameResult, FourInARow> {

    public MainActivity() {
        super(R.layout.activity_main);
    }

    @Override
    protected StartScreenView initializeStartScreen() {

        return null;
    }

    @Override
    protected EndScreenView initializeEndScreen() {
        return null;
    }

    @Override
    protected GameGenerator<FourInARowGameState> initializeGenerator(GameConfiguration configuration) {
        return new FourInARowGenerator(configuration, this);
    }

    @Override
    protected GameSaver<FourInARowGameState, Highscore> initializeGameSaver() {
        return null;
    }

    @Override
    protected void initializeGame(FourInARowGameState fourInARowGameStateFields) {
        //game = new FourInARow(this, fourInARowGameStateFields, null);


    }
}