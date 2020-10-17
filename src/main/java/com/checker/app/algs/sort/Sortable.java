package com.checker.app.algs.sort;

public interface Sortable {
    int[] sort(int[] toSort);

    default void swap(int[] toSort, int i, int j) {
        int temp = toSort[i];
        toSort[i] = toSort[j];
        toSort[j] = temp;
    }
}
