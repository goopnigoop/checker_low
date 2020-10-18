package com.checker.app.io;

/**
 * The type File reader replacer service.
 * Read context from a file and replace every small letter into capital
 * and every capital letter into the small letter and then print the modified file as the response of program
 */
public interface FileReaderReplacerService {
    /**
     * The Replace.
     */
    void replaceSmallWithCapital(String fileName);
}
