package schule.planetdefender.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import schule.planetdefender.handler.LogHandler;
import schule.planetdefender.handler.TextHandler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FileUtil {

    private final TextHandler textHandler = TextHandler.getInstance();
    private final LogHandler logHandler = LogHandler.getInstance();

    private static final FileUtil instance;

    private FileUtil() {

    }

    static {
        try {
            instance = new FileUtil();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized FileUtil getInstance() {
        return instance;
    }

    public void createDir(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists()) {
            try {
                boolean result = dir.mkdirs();
                if (result) {
                    logHandler.log(textHandler.successCreatedDirMsg(dirPath), "createDir", LogHandler.LogLevel.INFO, false);
                } else {
                    logHandler.log(textHandler.errorCreatingDirMsg(dirPath), "createDir", LogHandler.LogLevel.FAIL, false);
                }
            } catch (SecurityException e) {
                logHandler.log(textHandler.errorCreatingDirMsg(dirPath, ExceptionUtils.getStackTrace(e)), "createDir", LogHandler.LogLevel.ERROR, false);
            }
        }
    }

    public void copyFile(String srcFilePath, String destFilePath) {
        InputStream srcIs = getClass().getResourceAsStream(srcFilePath);
        File destFile = new File(destFilePath);

        try {
            /*
             * Check to see whether the file already exists at the destination.
             * If it does, we do not want to overwrite it, since the
             * user could have modified the file to their liking.
             */
            if (!destFile.exists()) {
                FileUtils.copyInputStreamToFile(srcIs, destFile);
                logHandler.log(textHandler.successCopiedFileMsg(srcFilePath, destFile.getPath()), "copyFile", LogHandler.LogLevel.INFO, false);
            }
        } catch (IOException e) {
            logHandler.log(textHandler.errorCopyingFileMsg(srcFilePath, destFilePath, ExceptionUtils.getStackTrace(e)), "copyFile", LogHandler.LogLevel.ERROR, false);
        }
    }

    public String removeCommentFromLine(String line) {
        if (line.trim().length() == 0 || line.trim().charAt(0) == '#') {
            return null;
        }

        String reversed = new StringBuilder(line).reverse().toString();

        int commentIndex = reversed.indexOf('#');

        if (commentIndex == 0) {
            return null;
        }

        if (commentIndex == -1) {
            return line;
        }

        reversed = reversed.substring(commentIndex + 1);

        int firstAlphabeticIndex = -1;

        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);
            if (!Character.isWhitespace(c)) {
                firstAlphabeticIndex = i;
                break;
            }
        }

        if (firstAlphabeticIndex == -1) {
            return new StringBuilder(reversed).reverse().toString();
        }

        reversed = reversed.substring(firstAlphabeticIndex);

        line = new StringBuilder(reversed).reverse().toString();

        return line;
    }
}
