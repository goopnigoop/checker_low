package com.checker.app.algs.arrays;

import javafx.util.Pair;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class SplitArrayServiceImplTest {

    SplitArrayService splitArrayService = new SplitArrayServiceImpl();

    @Test
    void splitTheArray() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        int[] array = createArray(current.nextInt(10000));
        Pair<List<int[]>, Integer> ints = splitArrayService.splitTheArray(array);
        List<int[]> arrays = ints.getKey();
        Integer dividedNumber = ints.getValue();
        int sum = arrays.stream()
                        .mapToInt(arr -> arr.length)
                        .sum();
        assertThat(arrays.size(), is(dividedNumber));
        assertThat(arrays, everyItem(Matchers.isA(int[].class)));
        assertThat(sum, is(array.length));
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