package com.checker.app.algs.fibonacci;

import java.util.stream.Stream;

public interface FibonacciSupplier {
    Stream<Integer> getNFibonacciNumber(int quantity);
}
