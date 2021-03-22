package com.checker.app.algs.fibonacci;

import java.util.stream.Stream;

public class FibonacciSupplierImpl implements FibonacciSupplier {
    @Override
    public Stream<Integer> getNFibonacciNumber(int quantity) {
        final Stream.Builder<Integer> builder = Stream.builder();
        if (quantity == 1) {
            builder.add(0);
            return builder.build();
        }
        if (quantity == 2) {
            builder.add(1);
            return builder.build();
        }
        int first = 0;
        builder.add(0);
        int second = 1;
        builder.add(1);
        int next;
        for (int i = 0; i < quantity - 2; i++) {
            next = first+second;
            first = second;
            second = next;
            builder.add(next);
        }
        return builder.build();
    }
}
