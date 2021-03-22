package com.checker.app.algs.arrays;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class MinMaxMain {
    public static void main(String[] args) {
        int[] array = createArray(20);
        System.out.println(Arrays.toString(array));
        int[] maxMin = findMaxMin(array);
        System.out.println("Max=" + maxMin[0] + " min=" + maxMin[1]);
        String collect = Stream.of(1, 3, 5, 8)
                               .filter(s -> s % 2 == 0)
                               .map(String::valueOf)
                               .collect(joining("1", "fdf", "sf"));
        System.out.println(collect);
    }

    private static int[] findMaxMin(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        int first = array[0];
        if (array.length == 1) {
            return new int[]{first, first};
        }
        int max = first;
        int min = first;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            } else if (array[i] < min) {
                min = array[i];
            }
        }
        return new int[]{min, max};
    }

    private static int[] createArray(int i) {
        int[] ints = new int[i];
        ThreadLocalRandom current = ThreadLocalRandom.current();
        for (int i1 = 0; i1 < ints.length; i1++) {
            ints[i1] = current.nextInt(1000);
        }
        return ints;
    }
}
