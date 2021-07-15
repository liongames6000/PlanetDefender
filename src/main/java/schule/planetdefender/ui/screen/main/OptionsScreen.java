package schule.planetdefender.ui.screen.main;

import schule.planetdefender.GameController;
import schule.planetdefender.ui.screen.AbstractNavigationScreen;
import schule.planetdefender.ui.screen.component.Button;

import java.awt.*;

public class OptionsScreen extends AbstractNavigationScreen {

    private final String[] options = {textHandler.BTN_GAME_OPTIONS_TEXT, textHandler.BTN_GRAPHICS_OPTIONS_TEXT,
        textHandler.BTN_PLAYER_OPTIONS_TEXT, textHandler.BTN_CONFIGURATION_OPTIONS_TEXT};

    private final Button[] buttons;

    public OptionsScreen(NavStyle navStyle, int btnAmount, GameController gameController) {
        super(navStyle, btnAmount, gameController);
        buttons = new Button[btnAmount];

        for(int i = 0; i < btnAmount; i++) {
            buttons[i] = new Button(new Point(getHalfWidth(), initialBtnYPos + btnYIncrement * i),
            new Dimension(380, 50), options[i], true, inputBtnFont,
            screenFontColor, menuBtnColor, new Point(190, 0), new Point(0, -8), screenWidth, screenHeight);
        }
    }

    @Override
    protected void updateNavAux(int index) {

    }

    @Override
    protected  void updateNavOK(int index) {
        if(isOKPressed(index)) {
            super.updateNavOK();
            switch(index) {
                case 0:
                    gameController.switchState(GameController.State.GAME_OPTIONS);
                    break;
                case 1:
                    gameController.switchState(GameController.State.GRAPHICS_OPTIONS);
                    break;
                case 2:
                    gameController.switchState(GameController.State.PLAYER_OPTIONS);
                    break;
                case 3:
                    gameController.switchState(GameController.State.CONFIG_OPTIONS);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void update() {
        super.update();
        updateNavCancel(GameController.State.MAIN);
        updateNavUp();
        updateNavDown();
        updateNavOK(selectedIndex);
        updateSelectedButtonColor(buttons);
    }

    @Override
    public void render(Graphics2D g) {
        drawScreenTitles(textHandler.TITLE_OPTIONS_SCREEN, g);
        renderButtons(buttons, g);
        drawInfoPanel(g);
    }
}
