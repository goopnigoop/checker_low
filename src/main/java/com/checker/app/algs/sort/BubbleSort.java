package com.checker.app.algs.sort;

public class BubbleSort implements Sortable {
    @Override
    public int[] sort(int[] toSort) {
        int length = toSort.length;
        for (int i = 0; i < length; i++) {
            boolean swapped = false;
            for (int j = 0; j < length - 1; j++) {
                if (toSort[j] > toSort[j + 1]) {
                    swap(toSort, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return toSort;
    }
}
