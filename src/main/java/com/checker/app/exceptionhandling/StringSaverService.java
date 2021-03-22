package com.checker.app.exceptionhandling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringSaverService {

    public static final Logger LOGGER = LoggerFactory.getLogger(StringSaverService.class);

    private final Repository<String> stringRepository;

    public StringSaverService(Repository<String> stringRepository) {
        this.stringRepository = stringRepository;
    }

    public void save(String string) {
        int counter = 0;
        while (counter < 3) {
            try {
                stringRepository.save(string);
                return;
            } catch (Exception exception) {
                counter++;
            }
        }
        throw new NetworkException();
    }

}
