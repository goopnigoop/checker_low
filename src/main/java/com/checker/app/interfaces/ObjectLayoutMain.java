package com.checker.app.interfaces;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.System.out;

public class ObjectLayoutMain {
    public static void main(String[] args) {
        out.println(ClassLayout.parseInstance(new String[]{"dsd","sd", "fdd", "ddddd"}).toPrintable());

        List<String> l = new ArrayList<>();
//        l.add("123");
        System.gc();
        out.println(ClassLayout.parseInstance(l).toPrintable());
        out.println(GraphLayout.parseInstance(l).toFootprint());
        out.println(GraphLayout.parseInstance(l).totalSize());
        out.println(GraphLayout.parseInstance(l).toPrintable());
    }

    static class SimpleInt {
        private int state;
    }
}
