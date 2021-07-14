package schule.planetdefender.handler;

import java.awt.*;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TextHandler {

    /* Log date format. */
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    /* Singleton TextHandler instance */
    private static TextHandler instance;

    /*
     * Private constructor so that TextHandler can't
     * be instantiated from the outside.
     */
    private TextHandler() {

    }

    /*
     * Instantiating the instance object
     * in a static block
     */
    static {
        try {
            instance = new TextHandler();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Getter method for the Singleton instance.
     */
    public synchronized static TextHandler getInstance() {
        return instance;
    }

    /*
     * File separators.
     */
    private final String fs = File.separator;
    private final String fsJar = "/";

    /*
     * Important game strings.
     */
    public final String GAME_TITLE = "Defend! The! Planet!";
    public final String GAME_VERSION = "dev_01";

    public final String USER_HOME = System.getProperty("user.home");
    public final String USER_OS = System.getProperty("os.name");
    public final String USER_JRE_ARCH = System.getProperty("os.arch");

    public final String GAME_ICON_NAME = "icon.png";
    public final String GAME_ICON_DIR_NAME = "images";
    public final String GAME_ICON_RES_PATH = GAME_ICON_DIR_NAME + fsJar + GAME_ICON_NAME;

    public final String gameShutdownMsg = GAME_TITLE + " shutting down.";

    /*
     * Menu button names.
     */
    public final String BTN_START_TEXT = "START";
    public final String BTN_PLAY_TEXT = "PLAY";
    public final String BTN_HIGH_SCORES_TEXT = "HIGH SCORES";
    public final String BTN_OPTIONS_TEXT = "OPTIONS";
    public final String BTN_CONTROLS_TEXT = "CONTROLS";
    public final String BTN_ABOUT_TEXT = "ABOUT";
    public final String BTN_EXIT_TEXT = "EXIT";
    public final String BTN_GAME_OPTIONS_TEXT = "GAME OPTIONS";
    public final String BTN_GRAPHICS_OPTIONS_TEXT = "GRAPHICS OPTIONS";
    public final String BTN_PLAYER_OPTIONS_TEXT = "PLAYER OPTIONS";
    public final String BTN_CONFIGURATION_OPTIONS_TEXT = "CONFIGURATION OPTIONS";
    public final String BTN_SELECT_PLAYER_TEXT = "SELECT PLAYER";
    public final String BTN_CREATE_PLAYER_TEXT = "CREATE PLAYER";
    public final String BTN_DELETE_DELETE_TEXT = "DELETE PLAYER";

    public final String BTN_SOUND_TEXT = "Sound";
    public final String BTN_GOD_MODE_TEXT = "God Mode";
    public final String BTN_FPS_LOCK_TEXT = "FPS Lock";
    public final String BTN_ANTI_ALIASING_TEXT = "Anti-aliasing";

    public final String BTN_CONTROL_MOV_NAV = "WASD/Arrow keys";
    public final String BTN_CONTROL_OK = "z";
    public final String BTN_CONTROL_CANCEL = "x";
    public final String BTN_CONTROL_AUX = "Space";
    public final String BTN_CONTROL_PAUSE = "p";

    /*
     * Menu title names.
     */
    public final String TITLE_WELCOME_SCREEN = "WELCOME";
    public final String TITLE_HIGH_SCORES_SCREEN = "HIGH SCORES";
    public final String TITLE_CONTROLS_SCREEN = "CONTROLS";
    public final String TITLE_OPTIONS_SCREEN = "OPTIONS";
    public final String TITLE_ABOUT_SCREEN = "ABOUT";
    public final String TITLE_EXIT_SCREEN = "EXIT";

    public final String TITLE_SELECT_LEVEL_SCREEN = "SELECT LEVEL";

    public final String TITLE_PLAYER_OPTIONS_SCREEN = "PLAYER OPTIONS";
    public final String TITLE_CONFIGURATION_OPTIONS_SCREEN = "CONFIGURATION OPTIONS";

    public final String TITLE_SELECT_PLAYER_SCREEN = "SELECT PLAYER";
    public final String TITLE_CREATE_PLAYER_SCREEN = "CREATE PLAYER";
    public final String TITLE_DELETE_PLAYER_SCREEN = "DELETE PLAYER";

    public final String TITLE_GAME_OPTIONS_SCREEN = "GAME OPTIONS";
    public final String TITLE_GRAPHICS_OPTIONS_SCREEN = "GRAPHICS OPTIONS";

    public final String TITLE_PAUSE_SCREEN = "PAUSE";

    /*
     * Log announcement messages.
     */
    public final String GAME_INIT_STARTED = "Started " + GAME_TITLE + " " + GAME_VERSION +
            " initialization at " + getDateTime() + " on " + USER_OS + " with " + USER_JRE_ARCH + " JRE";

    public final String GAME_INIT_FINISHED = "Finished " + GAME_TITLE + " " + GAME_VERSION +
            " initialization at " + getDateTime() + " on " + USER_OS + " with " + USER_JRE_ARCH + " JRE";

    /*
     * Client local gameController directory.
     */
    public final String GAME_TOP_DIR_NAME = ".config";
    public final String GAME_DIR_NAME = GAME_TITLE.toLowerCase().replaceAll("\\s+", "");
    public final String GAME_DIR_PATH = USER_HOME + fs + GAME_DIR_NAME + fs + GAME_TOP_DIR_NAME;

    /*
     * Local configuration directories.
     */
    public final String LOCAL_JAR_CONFIG_DIR = fsJar + "config";

    /*
     * Log file information.
     */
    public final String LOG_DIR_NAME = "log";
    public final String LOG_DIR_PATH = GAME_DIR_PATH + fs + LOG_DIR_NAME;

    public final String LOG_FILE_NAME = GAME_TITLE.toLowerCase().replaceAll("\\s+", "")
            + "-" + new SimpleDateFormat("dd-MM-yyyy").format(new Date()) + "_log.txt";
    public final String LOG_FILE_PATH = LOG_DIR_PATH + fs + LOG_FILE_NAME;

    public final String LOG_SEPARATOR = "########################################################################" +
            "#########################################################################";

    public final String logMsgPrefix(LogHandler.LogLevel logLevel) {
        return "[" + dateFormat.format(new Date()) + "]: ";
    }

    /*
     * Options file information.
     */
    public final String OPTIONS_DIR_NAME = "options";
    public final String OPTIONS_DIR_CLIENT_PATH = GAME_DIR_PATH + fs + OPTIONS_DIR_NAME;
    public final String OPTIONS_DIR_LOCAL_PATH = LOCAL_JAR_CONFIG_DIR + fsJar + OPTIONS_DIR_NAME;

    public final String OPTIONS_CONFIG_FILE_NAME = "options.conf";
    public final String OPTIONS_CONFIG_FILE_LOCAL_PATH = OPTIONS_DIR_LOCAL_PATH + fsJar + OPTIONS_CONFIG_FILE_NAME;
    public final String OPTIONS_CONFIG_FILE_CLIENT_PATH = OPTIONS_DIR_CLIENT_PATH + fs + OPTIONS_CONFIG_FILE_NAME;

    /*
     * Player binary file information.
     */
    public final String PLAYER_DIR_NAME = "players";
    public final String PLAYER_DIR_PATH = GAME_DIR_PATH + fs + PLAYER_DIR_NAME;

    public final String PLAYER_BIN_FILE_NAME = "players.bin";
    public final String PLAYER_BIN_FILE_CLIENT_PATH = PLAYER_DIR_PATH + fs + PLAYER_BIN_FILE_NAME;

    /*
     * Score binary file information.
     */
    public final String SCORE_DIR_NAME = "scores";
    public final String SCORE_DIR_PATH = GAME_DIR_PATH + fs + SCORE_DIR_NAME;

    public final String SCORE_BIN_FILE_NAME = "scores.bin";
    public final String SCORE_BIN_FILE_CLIENT_PATH = SCORE_DIR_PATH + fs + SCORE_BIN_FILE_NAME;

    /*
     * Local font file information.
     */
    public final String FONT_DIR_NAME = "fonts";
    public final String FONT_DIR_PATH = GAME_DIR_PATH + fs + FONT_DIR_NAME;
    public final String LOCAL_JAR_FONT_DIR = LOCAL_JAR_CONFIG_DIR + fsJar + FONT_DIR_NAME;

    /* gameFont */
    public final String GAME_FONT_FILE_NAME = "neuropol.ttf";
    public final String GAME_FONT_FILE_LOCAL_PATH = LOCAL_JAR_FONT_DIR + fsJar + GAME_FONT_FILE_NAME;
    public final String GAME_FONT_FILE_CLIENT_PATH = FONT_DIR_PATH + fs + GAME_FONT_FILE_NAME;

    /*
     * Level file information.
     */
    public final int MAX_LEVELS = 12;
    public final int MAX_PLAYERS = 25;
    public final int PLAYER_NAME_MAX_LENGTH = 8;
    public final int PLAYER_NAME_MIN_LENGTH = 3;

    public final String LEVEL_DIR_NAME = "levels";
    public final String LEVEL_DIR_PATH = GAME_DIR_PATH + fs + LEVEL_DIR_NAME;
    public final String LOCAL_JAR_LEVEL_DIR = LOCAL_JAR_CONFIG_DIR + fsJar + LEVEL_DIR_NAME;

    public final String LEVEL_CONFIG_FILE_NAME = "levels.conf";
    public final String LEVEL_CONFIG_FILE_LOCAL_PATH = LOCAL_JAR_LEVEL_DIR + fsJar + LEVEL_CONFIG_FILE_NAME;
    public final String LEVEL_CONFIG_FILE_CLIENT_PATH = LEVEL_DIR_PATH + fs + LEVEL_CONFIG_FILE_NAME;

    /*
     * Property names.
     */

    /*
     * Util properties.
     */
    public final String PROP_KEY_VERBOSE_LOG_ENABLED = "VERBOSE_LOG_ENABLED";
    public final String PROP_KEY_SOUND_ENABLED = "SOUND_ENABLED";
    public final String PROP_KEY_GOD_MODE_ENABLED = "GOD_MODE_ENABLED";
    public final String PROP_KEY_FPS_LOCK_ENABLED = "FPS_LOCK_ENABLED";
    public final String PROP_KEY_ANTI_ALIASING_ENABLED = "ANTI_ALIASING_ENABLED";

    /*
     * Menu color properties.
     */
    public final String PROP_KEY_MENU_FONT_COLOR_HEX = "MENU_FONT_COLOR_HEX";
    public final String PROP_KEY_MENU_BTN_COLOR_HEX = "MENU_BTN_COLOR_HEX";
    public final String PROP_KEY_MENU_BTN_SELECTED_COLOR_HEX = "MENU_BTN_SELECTED_COLOR_HEX";
    public final String PROP_KEY_MENU_BTN_PLAYER_DELETED_COLOR_HEX = "MENU_BTN_PLAYER_DELETED_COLOR_HEX";
    public final String PROP_KEY_MENU_BTN_PLAYER_SELECTED_COLOR_HEX = "MENU_BTN_PLAYER_SELECTED_COLOR_HEX";

    public String getMenuColorLogString(String pKey, Color color) {
        return pKey + ": (" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ")";
    }

    public String getGamePropertyLogString(boolean prop, String prefix) {
        if (prop) {
            return prefix + " enabled.";
        }
        return prefix + " disabled.";
    }

    /*
     * TODO if we want powerups
     */

    /*
     * Menu messages.
     */

    /* SCORES_MENU messages. */

    /* CONTROLS_MENU messages. */
    public final String menuControlsMsg01 = "Movement/Navigation:";
    public final String menuControlsMsg02 = BTN_CONTROL_MOV_NAV;
    public final String menuControlsMsg03 = "Ok/Forward:";
    public final String menuControlsMsg04 = BTN_CONTROL_OK;
    public final String menuControlsMsg05 = "Cancel/Back:";
    public final String menuControlsMsg06 = BTN_CONTROL_CANCEL;
    public final String menuControlsMsg07 = "Auxiliary/Free ball:";
    public final String menuControlsMsg08 = BTN_CONTROL_AUX;
    public final String menuControlsMsg09 = "Pause:";
    public final String menuControlsMsg10 = BTN_CONTROL_PAUSE;

    /* OPTIONS messages. */
    public final String menuConfigMsg01 = "All of the customization related files can be found in the following";
    public final String menuConfigMsg02 = "directory: " + GAME_TOP_DIR_NAME + fs + GAME_DIR_NAME;
    public final String menuConfigMsg03 = "General options can be found in the " + OPTIONS_CONFIG_FILE_NAME + " file";
    public final String menuConfigMsg04 = "inside the " + OPTIONS_DIR_NAME + " directory.";
    public final String menuConfigMsg05 = "Level specific options can be found in the various level files";
    public final String menuConfigMsg06 = "in the " + LEVEL_DIR_NAME + " directory, If creating custom";
    public final String menuConfigMsg08 = "levels, make sure to add them to the " + LEVEL_CONFIG_FILE_NAME + " file.";

    /* ABOUT_MENU messages. TODO Write own about section */
    public final String aboutMenuMsg01 = GAME_TITLE + " is an open-source, space-themed,";
    public final String aboutMenuMsg02 = "Breakout-like sandbox 2D game with focus on a customizable";
    public final String aboutMenuMsg03 = "and replayable experience.";
    public final String aboutMenuMsg04 = "The game plays like your typical Breakout game, with a few";
    public final String aboutMenuMsg05 = "additions such as power ups and a fully customizable";
    public final String aboutMenuMsg06 = "environment. Players are advised to create new levels ";
    public final String aboutMenuMsg07 = "and share them with others.";
    public final String aboutMenuMsg10 = "If any help is needed, take a look at the " + TITLE_CONTROLS_SCREEN + " and";
    public final String aboutMenuMsg11 = TITLE_CONFIGURATION_OPTIONS_SCREEN + " menus for more information.";

    /* EXIT_MENU messages. */


    /* PAUSE messages. */
    public final String MENU_MSG_PAUSED = "Paused";

    /*
     * Success messages.
     */
    public final String successCopiedFileMsg(String srcFilePath, String destFilePath) {
        return "Successfully copied '" + srcFilePath + "' to '" + destFilePath + "'";
    }

    public final String successReadPropertyMsg(String key, String value, String fileName) {
        return "Successfully read property '" + key + ":" + value + "' from '" + fileName + "'";
    }

    public final String successReadLineMsg(String line, String fileName) {
        return "Successfully read line '" + line + "' from '" + fileName + "'";
    }

    public final String successCreatedFileMsg(String filePath) {
        return "Successfully created file '" + filePath + "'";
    }

    public final String successCreatedDirMsg(String dirPath) {
        return "Successfully created directory '" + dirPath + "'";
    }

    public final String successReadScoreBinary() {
        return "Successfully read score binary file '" + SCORE_BIN_FILE_NAME + "'";
    }

    public final String successReadPlayerBinary() {
        return "Successfully read player binary file '" + PLAYER_BIN_FILE_NAME + "'";
    }

    public final String successSaveScoreBinary() {
        return "Successfully saved score binary file '" + SCORE_BIN_FILE_NAME + "' at '" + SCORE_BIN_FILE_CLIENT_PATH + "'";
    }

    public final String successSavePlayerBinary() {
        return "Successfully saved player binary file '" + PLAYER_BIN_FILE_NAME + "' at '" + PLAYER_BIN_FILE_CLIENT_PATH + "'";
    }

    /*
     * Finished messages.
     */
    public final String finishReadPropertiesMsg(String filePath) {
        return "Finished reading properties from '" + filePath + "'";
    }

    public final String finishReadLinesMsg(String filePath) {
        return "Finished reading lines from '" + filePath + "'";
    }

    /*
     * Error messages.
     */

    public final String errorOccurred(String msg, Exception e) {
        return "EXCEPTION: " + msg + ". Error message: " + e.getMessage();
    }

    public final String errorCreatingDirMsg(String dirPath) {
        return "Failed to create directory '" + dirPath + "'";
    }

    public final String errorCreatingDirMsg(String dirPath, String errMsg) {
        return "Failed to create directory '" + dirPath + "' cause '" + errMsg + "'";
    }

    public final String errorWritingToFileMsg(String filePath, String errMsg) {
        return "Failed writing to '" + filePath + "' cause '" + errMsg + "'";
    }

    public final String errorCopyingFileMsg(String srcFilePath, String destFilePath, String errMsg) {
        return "Failed to copy '" + srcFilePath + "' to '" + destFilePath + "' cause '" + errMsg + "'";
    }

    public final String errorParsingPropertiesMsg(String filePath, String errMsg) {
        return "Failed parsing properties from file '" + filePath + "' cause '" + errMsg + "'";
    }

    public final String errorCreatingAudioClipMsg(String filePath, String errMsg) {
        return "Failed to create AudioClip from '" + filePath + "' cause '" + errMsg + "'";
    }

    public final String errorReadScoreBinary() {
        return "Failed to read score binary file '" + SCORE_BIN_FILE_NAME + "'";
    }

    public final String errorReadPlayerBinary() {
        return "Failed to read player binary file '" + PLAYER_BIN_FILE_NAME + "'";
    }

    /*
     * Action messages.
     */
    public final String actionReadingLinesMsg(String filePath) {
        return "Reading lines from '" + filePath + "'...";
    }

    public final String actionReadingPropertiesMsg(String filePath) {
        return "Reading properties from '" + filePath + "'...";
    }

    /* Score messages */

    public final String creatingEmptyBinaryMsg() {
        return "Creating empty binary score file '" + SCORE_BIN_FILE_NAME + "'";
    }

    /*
     * Verbose mode messages.
     */

    /* Ball. */
    public final String vBallTouchedYAxisBottomMsg = "Ball touched bottom y-axis.";
    public final String vBallTouchedYAxisTopMsg = "Ball touched top y-axis.";
    public final String vBallTouchedXAxisLeftMsg = "Ball touched left x-axis.";
    public final String vBallTouchedXAxisRightMsg = "Ball touched right x-axis.";

    public final String vBallBlockFieldCollisionMsg(int blockIndex, int blockHealth) {
        return "Ball collision with BlockField[" + blockIndex + "], Health=" + blockHealth;
    }

    private final DecimalFormat df = new DecimalFormat("000");

    /* Application. */
    public final String vPerformanceMsg(int frames, int updates) {
        return "UPS: " + updates + " - FPS: " + frames;
    }

    /*
     * Private helper methods.
     */
    private String getDateTime() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
    }

    public final String getTimeString(long sec) {
        return String.format("%02d:%02d", sec / 60, sec % 60);
    }

    public String getFixedString(String text, int length) {
        return String.format("%-" + length + "." + length + "s", text);
    }

    /* Welcome AbstractScreen text */
    public final String WELCOME_SCREEN_TEXT = "What lies beyond the cosmos is inevitable";

    public final String WELCOME_SCREEN_TOOLTIP_TEXT = "Press " + BTN_CONTROL_OK + " to go to the selected screen or " +
            BTN_CONTROL_CANCEL + " to go back. Navigate with " + BTN_CONTROL_MOV_NAV + ".";

}
