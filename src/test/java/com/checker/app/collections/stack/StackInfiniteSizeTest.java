package com.checker.app.collections.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class StackInfiniteSizeTest {

    StackInfiniteSize<Integer> stack = new StackInfiniteSize<>();

    @BeforeEach
    void setUp() {
        stack = new StackInfiniteSize<>();
    }

    @Test
    void shouldHaveDefaultSize() {
        assertThat(stack.size(), is(0));
    }

    @Test
    void shouldReturnFirstElements() {
        stack.push(7);
        stack.push(5);
        stack.push(1);
        stack.push(13);
        final ArrayList<Integer> results = new ArrayList<>();
        results.add(stack.pop());
        results.add(stack.pop());
        results.add(stack.pop());
        assertThat(results, hasSize(3));
        assertThat(results, contains(13, 1, 5));
    }

    @Test
    void shouldAddFourElements() {
        stack.push(7);
        stack.push(5);
        stack.push(1);
        stack.push(13);
        assertThat(stack.size(), is(4));
        assertThat(stack.peek(), is(13));
    }

    @Test
    void shouldAddTwentyElements() {
        IntStream.range(0,20).forEach(stack::push);
        assertThat(stack.size(), is(20));
        assertThat(stack.peek(), is(19));
    }

    @Test
    void shouldClearTheStack() {
        assertThat(stack.size(), is(0));
    }

    @Test
    void shouldThrowExceptionWhenStackIsFull() {
        IntStream.rangeClosed(1, 10)
                 .forEach(stack::push);
        assertThrows(IllegalArgumentException.class, () ->
                stack.push(13));
        assertThat(stack.size(), is(10));
    }

    @Test
    void shouldThrowExceptionWhenStackIsEmpty() {
        assertThrows(IllegalStateException.class, () ->
                stack.pop());
        assertThat(stack.size(), is(0));
    }


    @Test
    void peek() {
        stack.push(1);
        stack.push(13);
        assertThat(stack.size(), is(2));
        assertThat(stack.peek(), is(13));
        assertThat(stack.size(), is(2));

    }
}
