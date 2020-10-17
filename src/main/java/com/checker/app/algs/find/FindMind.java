package com.checker.app.algs.find;

import org.apache.commons.lang3.ArrayUtils;

import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.sort;
import static org.apache.commons.lang3.ArrayUtils.isSorted;

public class FindMind {
    public static void main(String[] args) {
        int[] arr = initializeArray(1000);
        ThreadLocalRandom current = ThreadLocalRandom.current();

        int element = current.nextInt(1000);
        System.out.println("Let's find the element " + element + " in array: \n" + ArrayUtils.toString(arr));
        boolean isFound = findElement(arr, element);
        System.out.println(isFound ? "yes" : "no");
    }

    private static boolean findElement(int[] arr, int element) {
        boolean sorted = isSorted(arr);
        if (!sorted) {
            sort(arr);
        }
        int l = 0;
        int h = arr.length;

        while (l <= h) {
            int m = l - (l - h) / 2;
            int i = arr[m];
            if (i == element) {
                return true;
            }
            if (element < i) {
                h = m-1;
            } else {
                l = m+1;
            }
        }
        return false;
    }

    private static int[] initializeArray(int i) {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        int[] res = new int[i];
        for (int j = 0; j < i; j++) {
            res[j] = current.nextInt(1000);
        }
        return res;
    }
}
