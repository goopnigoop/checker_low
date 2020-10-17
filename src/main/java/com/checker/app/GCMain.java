package com.checker.app;

import java.util.ArrayList;
import java.util.List;

public class GCMain {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>(10000);

        while (true) {
            for (int i = 0; i < 10000; i++) {
                list.add(new Object());
            }
            list.clear();
        }

    }
}
