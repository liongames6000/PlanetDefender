package schule.planetdefender.ui.screen.main;

import schule.planetdefender.GameController;
import schule.planetdefender.ui.screen.AbstractScreen;

import java.awt.*;

public class ExitScreen extends AbstractScreen {

    public ExitScreen(GameController gameController) {
        super(gameController);
    }

    @Override
    public void update() {
        decInputTimer();

        if(inputHandler.isOKPressed() && isInputAvailable()) {
            resetInputTimer();
            gameController.stop();
        }

        if(inputHandler.isCancelPressed() && isInputAvailable()) {
            resetInputTimer();
            if(gameController.getPrevState() != GameController.State.NONE &&
                gameController.getPrevState() == GameController.State.WELCOME) {
                gameController.switchState(GameController.State.WELCOME);
            } else {
                gameController.switchState(GameController.State.MAIN);
            }
        }
    }

    @Override
    public void render(Graphics2D g) {
        drawTitle(g);
        drawSubtitle(textHandler.TITLE_EXIT_SCREEN, g);
        drawCenteredText("Do you wish to exit " + textHandler.GAME_TITLE + "?", 0, g);
        drawInfoPanel(g);
    }
}
