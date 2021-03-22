package com.checker.app.algs.arrays;


import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

/**
 * The interface Split array service.
 * How will you break an array in an equal part? Consider all possible cases
 */
public interface SplitArrayService {
    /**
     * Split the array pair.
     *
     * @param array the array
     * @return the pair
     */
    Pair<List<int[]>, Integer> splitTheArray(int[] array);
}
