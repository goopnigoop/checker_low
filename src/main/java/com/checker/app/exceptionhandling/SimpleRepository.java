package com.checker.app.exceptionhandling;

import java.util.List;

public class SimpleRepository implements Repository<String> {

    private List<String> listOfStrings;

    @Override
    public void save(String entity) {
        listOfStrings.add(entity);
    }
}
