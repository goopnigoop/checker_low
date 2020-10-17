package com.checker.app.algs.sort;

public class CloseToBubbleSort implements Sortable {
    @Override
    public int[] sort(int[] toSort) {
        int length = toSort.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (toSort[i] > toSort[j]) {
                    swap(toSort, i, j);
                }
            }
        }
        return toSort;
    }
}
