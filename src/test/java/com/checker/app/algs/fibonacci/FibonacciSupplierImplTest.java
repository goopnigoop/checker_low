package com.checker.app.algs.fibonacci;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

class FibonacciSupplierImplTest {
    FibonacciSupplierImpl fibonacciSupplier = new FibonacciSupplierImpl();

    @Test
    void shouldReturnTenProperFibonacciNumbers() {
        final Stream<Integer> nFibonacciNumbers = fibonacciSupplier.getNFibonacciNumber(10);
        final List<Integer> integerList = nFibonacciNumbers.collect(Collectors.toList());
        assertThat(integerList, hasSize(10));
        assertThat(integerList, hasItems(0, 1, 1, 2, 3, 5, 8, 13, 21, 34));
    }
}
