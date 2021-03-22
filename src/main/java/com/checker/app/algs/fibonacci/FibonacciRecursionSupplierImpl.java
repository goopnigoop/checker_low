package com.checker.app.algs.fibonacci;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FibonacciRecursionSupplierImpl implements FibonacciSupplier {
    @Override
    public Stream<Integer> getNFibonacciNumber(int quantity) {
        return IntStream.rangeClosed(1, quantity)
                        .mapToObj(this::getFibonacci);
    }

    private int getFibonacci(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return getFibonacci(n - 2) + getFibonacci(n - 1);
    }
}
