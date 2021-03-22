package com.checker.app.collections.stack;

import com.checker.app.collections.stack.impl.StackFixedSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StackFixedSizeTest {

    StackFixedSize<Integer> stack = new StackFixedSize<>();

    @BeforeEach
    void setUp() {
        stack = new StackFixedSize<>();
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
