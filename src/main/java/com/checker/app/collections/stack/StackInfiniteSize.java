package com.checker.app.collections.stack;

import java.util.Arrays;

public class StackInfiniteSize<E> implements Stack<E> {

    public static final int INITIAL_SIZE = 10;
    Object[] arr;
    int size = 0;
    int current = -1;

    public StackInfiniteSize() {
        this.arr = new Object[10];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E pop() {
        if (current == -1 && size == 0) {
            throw new IllegalStateException("The stack is empty");
        }
        size--;
        return (E) arr[current--];
    }

    @Override
    public void push(E element) {
        if (size == arr.length) {
            doubleArray();
        }
        arr[++current] = element;
        size++;
    }

    private void doubleArray() {
        arr = Arrays.copyOf(arr, arr.length * 2);
    }

    @Override
    public void clear() {
        current = -1;
        this.size = 0;
        arr = new Object[INITIAL_SIZE];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peek() {
        return (E) arr[current];
    }
}
