package schule.planetdefender.util;

import schule.planetdefender.handler.TextHandler;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Util {

    private final TextHandler textHandler = TextHandler.getInstance();
    private final Random random = new Random();

    private static final Util instance;

    private Util() {

    }

    static {
        try {
            instance = new Util();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized Util getInstance() {
        return instance;
    }

    public Color generatePastelColor(final float luminance, final float sat) {
        final float hue = random.nextFloat();
        final float saturation = (random.nextInt(2000) + 1000) / sat;
        return Color.getHSBColor(hue, saturation, luminance);
    }

    public Font getGameFont() {
        Font gameFont = null;
        try {
            gameFont = Font.createFont(Font.TRUETYPE_FONT, new File(textHandler.GAME_FONT_FILE_CLIENT_PATH));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(textHandler.GAME_FONT_FILE_CLIENT_PATH)));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        return gameFont;
    }
}
