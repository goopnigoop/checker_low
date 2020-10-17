package com.checker.app.algs.sort;

public class QuickSort implements Sortable {
    @Override
    public int[] sort(int[] toSort) {
        int start = 0;
        int end = toSort.length-1;
        return qsort(toSort, start, end);
    }

    private int[] qsort(int[] toSort, int start, int end) {
        int l = start;
        int h = end;
        int medium = l + (h - l) / 2;
        int m = toSort[medium];
        while (l <= h) {
            while (toSort[l] < m) {
                l++;
            }
            while (toSort[h] > m) {
                h--;
            }
            if (l <= h) {
                swap(toSort, l, h);
                l++;
                h--;
            }
            if (l < end) {
                qsort(toSort,l,end);
            }
            if (h > start) {
                qsort(toSort,start,h);
            }
        }
        return toSort;
    }
}
