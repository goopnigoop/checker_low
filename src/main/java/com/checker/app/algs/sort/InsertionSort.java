package com.checker.app.algs.sort;

public class InsertionSort implements Sortable {
    @Override
    public int[] sort(int[] toSort) {
        int length = toSort.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (toSort[j] < toSort[j - 1]) {
                    swap(toSort, j, j-1);
                }
            }
        }
        return toSort;
    }
}
