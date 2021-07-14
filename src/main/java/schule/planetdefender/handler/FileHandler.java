package schule.planetdefender.handler;

import schule.planetdefender.util.FileUtil;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class FileHandler {

    private final TextHandler textHandler = TextHandler.getInstance();
    private final LogHandler logHandler = LogHandler.getInstance();
    private final FileUtil fileUtil = FileUtil.getInstance();

    /* Singleton FileHandler instance. */
    private static final FileHandler instance;

    /*
     * Private constructor so that FileHandler
     * can't be instantiated outside.
     */
    private FileHandler() {
        initFileHandler();
    }

    /*
     * Static block to instantiate the
     * Singleton FileHandler instance.
     */
    static {
        try {
            instance = new FileHandler();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*
     * Getter for the Singleton instance.
     */
    public static synchronized FileHandler getInstance() {
        return instance;
    }

    /*
     * Setup the standad gameController directories and
     * copy the necessary configuration files over
     * to the client machine
     */
    private void initFileHandler() {
        createStandardDirs();
        copyConfigFiles();
    }

    /*
     * Create the standard gameController directories.
     */
    private void createStandardDirs() {
        fileUtil.createDir(textHandler.LOG_DIR_PATH);
        fileUtil.createDir(textHandler.OPTIONS_DIR_CLIENT_PATH);
        fileUtil.createDir(textHandler.FONT_DIR_PATH);
        fileUtil.createDir(textHandler.LEVEL_DIR_PATH);
        fileUtil.createDir(textHandler.PLAYER_DIR_PATH);
        fileUtil.createDir(textHandler.SCORE_DIR_PATH);
    }

    /*
     * Copy the necessary configuration files
     * over to the client machine.
     */
    private void copyConfigFiles() {
        /* Settings configuration file copied to client machine. */
        fileUtil.copyFile(textHandler.OPTIONS_CONFIG_FILE_LOCAL_PATH, textHandler.OPTIONS_CONFIG_FILE_CLIENT_PATH);

        /* Font */
        fileUtil.copyFile(textHandler.GAME_FONT_FILE_LOCAL_PATH, textHandler.GAME_FONT_FILE_CLIENT_PATH);
    }

    /*
     * Read properties from the file given by the filePath.
     * The properties are returned as a map data structure,
     * where the property name is the key, and the property
     * value is equal to the, well, value.
     */
    public Map<String, String> readPropertiesFromFile(String filePath) {
        Properties p = new Properties();

        Map<String, String> map = new HashMap<>();
        logHandler.log(textHandler.actionReadingPropertiesMsg(filePath), "readPropertiesFromFile", LogHandler.LogLevel.INFO, false);

        try (InputStream is = new FileInputStream(filePath)) {
            p.load(is);

            for (String key : p.stringPropertyNames()) {
                String value = p.getProperty(key);
                value = fileUtil.removeCommentFromLine(value);
                if (value != null) {
                    map.put(key, value);
                    logHandler.log(textHandler.successReadPropertyMsg(key, value, filePath), "readPropertiesFromFile", LogHandler.LogLevel.INFO, false);
                }
            }

            logHandler.log(textHandler.finishReadPropertiesMsg(filePath), "readPropertiesFromFile", LogHandler.LogLevel.INFO, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

    public void writePropertyToFile(String filePath, String pKey, String pValue) {
        File file = new File(filePath);

        if (file.isDirectory()) {
            return;
        }

        if (!file.exists()) {
            return;
        }

        List<String> lines = null;

        try {
            lines = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int index = 0;

        if (lines == null) {
            logHandler.log("Failed to write property to file: " + filePath, "writePropertyToFile", LogHandler.LogLevel.FAIL, false);
            return;
        }

        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains(pKey)) {
                index = i;
                break;
            }
        }

        String newLine = pKey + "=" + pValue;

        lines.set(index, newLine);

        try {
            Files.write(file.toPath(), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
     * Read lines from the file given by filePath
     * and return them as a List<String> object.
     */
    public List<String> readLinesFromFile(String filePath) {
        List<String> lineList = new ArrayList<>();
        logHandler.log(textHandler.actionReadingLinesMsg(filePath), "readLinesFromFile", LogHandler.LogLevel.INFO, false);

        try (FileInputStream fis = new FileInputStream(new File(filePath))) {
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = br.readLine()) != null) {
                line = fileUtil.removeCommentFromLine(line);
                if (line != null) {
                    lineList.add(line);
                    logHandler.log(textHandler.successReadLineMsg(line, filePath), "readLinesFromFile", LogHandler.LogLevel.INFO, false);
                }
            }
            logHandler.log(textHandler.finishReadLinesMsg(filePath), "readLinesFromFile", LogHandler.LogLevel.INFO, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lineList;
    }

    public String readPropertyFromFile(String pKey, String filePath) {
        Properties p = new Properties();
        String value = "";

        try (InputStream is = new FileInputStream(filePath)) {
            p.load(is);

            for (String key : p.stringPropertyNames()) {
                if (!key.equals(pKey)) {
                    continue;
                }

                value = p.getProperty(key);
                value = fileUtil.removeCommentFromLine(value);

                if (value != null) {
                    logHandler.log(textHandler.successReadPropertyMsg(pKey, value, filePath), "readPropertyFromFile", LogHandler.LogLevel.INFO, false);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return value;
    }
}
