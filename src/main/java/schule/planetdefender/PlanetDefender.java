package schule.planetdefender;

import schule.planetdefender.handler.LogHandler;
import schule.planetdefender.handler.TextHandler;

import javax.swing.*;

public class PlanetDefender {

    private static final TextHandler textHandler = TextHandler.getInstance();
    private static final LogHandler logHandler = LogHandler.getInstance();

    public static void main(String[] args) {
        logHandler.log(textHandler.LOG_SEPARATOR, "main", LogHandler.LogLevel.INFO, false);
        logHandler.log(textHandler.GAME_INIT_STARTED, "main", LogHandler.LogLevel.INFO, false);
        SwingUtilities.invokeLater(() -> new GameController().start());
    }
}
