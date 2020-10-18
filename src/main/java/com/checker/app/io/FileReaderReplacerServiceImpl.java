package com.checker.app.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * The type File reader replacer service.
 * Read context from a file and replace every small letter into capital and every capital letter
 * into the small letter and then print the modified file as the response of program:
 */
public class FileReaderReplacerServiceImpl implements FileReaderReplacerService {

    /**
     * The constant LOGGER.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(FileReaderReplacerServiceImpl.class);

    @Override
    public void replaceSmallWithCapital(String fileName) {
        File original = new File(fileName);
        File temp = new File("temp");
        try (LineIterator lineIterator = FileUtils.lineIterator(original, "UTF-8")) {
            while (lineIterator.hasNext()) {
                String line = lineIterator.nextLine();
                String processedLine = replaceWithUpperCase(line);
                FileUtils.writeStringToFile(temp, processedLine + "\n", StandardCharsets.UTF_8.name(), true);
            }
            boolean isProcessed = temp.renameTo(original);
            if (isProcessed) {
                LOGGER.info("File is processed");
            }
        } catch (IOException e) {
            LOGGER.error("File doesn't not exist");
            throw new IllegalArgumentException("File doesn't not exist", e);
        }
    }

    private String replaceWithUpperCase(String line) {
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            if (Character.isUpperCase(current)) {
                chars[i] = Character.toLowerCase(current);
            } else if (Character.isLowerCase(current)) {
                chars[i] = Character.toUpperCase(current);
            }
        }
        return new String(chars);
    }
}
