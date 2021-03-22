package com.checker.app.collections.stack.impl;

import com.checker.app.collections.stack.Stack;

import java.util.Arrays;

public class StackFixedSize<E> implements Stack<E> {

    private final Object[] innerArray;
    private int size = 0;
    private int current = -1;

    public StackFixedSize() {
        this.innerArray = new Object[10];
    }

    public StackFixedSize(int size) {
        this.innerArray = new Object[size];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E pop() {
        if (current == -1) {
            throw new IllegalStateException("The stack is empty");
        }
        size--;
        return (E)innerArray[current--];
    }

    @Override
    public void push(E element) {
        if (innerArray.length-1 == current) {
            throw new IllegalArgumentException("The stack is full");
        }
        innerArray[++current] = element;
        size++;
    }

    @Override
    public void clear() {
        current = -1;
        this.size = 0;
        Arrays.fill(innerArray, null);
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peek() {
        return (E)innerArray[current];
    }
}
