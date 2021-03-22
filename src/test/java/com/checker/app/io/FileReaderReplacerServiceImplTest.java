package com.checker.app.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

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