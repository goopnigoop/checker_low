package com.checker.app.io;

import com.google.common.base.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.io.FileMatchers.aFileWithSize;

class FileReaderReplacerServiceImplTest {

    FileReaderReplacerService fileReaderReplacerService = new FileReaderReplacerServiceImpl();

    String filename = "currentFile.txt";

    @BeforeEach
    void setUp() throws IOException {
        FileUtils.writeStringToFile(new File(filename), "This is example Of file teXT\nAnd we begin to change It", StandardCharsets.UTF_8);
    }

    @Test
    void replaceSmallWithCapital() throws IOException {
        fileReaderReplacerService.replaceSmallWithCapital(filename);
        List<String> lines = new ArrayList<>();
        try (LineIterator it = FileUtils.lineIterator(new File(filename), "UTF-8")) {
            while (it.hasNext()) {
                String line = it.nextLine();
                lines.add(line);
            }
            assertThat(lines.get(0), is("tHIS IS EXAMPLE oF FILE TExt"));
            assertThat(lines.get(1), is("aND WE BEGIN TO CHANGE iT"));
            assertThat(lines, hasSize(2));
        }
    }
}