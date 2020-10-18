package com.checker.app.algs.arrays;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitArrayServiceImpl implements SplitArrayService {

    private List<int[]> splitArray(int[] array, int theDividedNumber) {
        ArrayList<int[]> objects = new ArrayList<>();
        int newLength = array.length / theDividedNumber;
        for (int i = 0; i < array.length; i += newLength) {
            int[] c = new int[newLength];
            System.arraycopy(array, i, c, 0, newLength);
            objects.add(c);
        }
        return objects;
    }

    private int findTheDevidedNumber(int length) {
        for (int j = 2; j < length; j++) {
            if (length % j == 0) {
                return j;
            }
        }
        return length;
    }

    @Override
    public Pair<List<int[]>, Integer> splitTheArray(int[] array) {
        int theDividedNumber = findTheDevidedNumber(array.length);
        SplitArrayMain.LOGGER.info("Divided number: {}", theDividedNumber);
        SplitArrayMain.LOGGER.info("Current Array: {}", array);
        List<int[]> ints = splitArray(array, theDividedNumber);
        SplitArrayMain.LOGGER.info("Split Arrays: ");
        ints
                .forEach(arr -> {
                    System.out.println(Arrays.toString(arr));
                    System.out.println();
                });
        return new Pair<>(ints, theDividedNumber);
    }
}