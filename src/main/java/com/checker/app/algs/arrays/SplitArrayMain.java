package com.checker.app.algs.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;

public class SplitArrayMain {

    public static final Logger LOGGER = LoggerFactory.getLogger(SplitArrayMain.class);

    SplitArrayService splitArrayService;

    public SplitArrayMain(SplitArrayService splitArrayService) {
        this.splitArrayService = splitArrayService;
    }

    public static void main(String[] args) {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        int[] array = createArray(current.nextInt(100));
        SplitArrayMain splitArrayMain = new SplitArrayMain(new SplitArrayServiceImpl());
        SplitArrayService splitArrayService = splitArrayMain.getSplitArrayService();
        splitArrayService.splitTheArray(array);
    }

    public SplitArrayService getSplitArrayService() {
        return splitArrayService;
    }

    private static int[] createArray(int nextInt) {
        int[] ints = new int[nextInt];
        ThreadLocalRandom current = ThreadLocalRandom.current();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = current.nextInt(10000);
        }
        return ints;
    }
}
