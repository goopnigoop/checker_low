package com.checker.app.collections.stack;

public interface Stack<E> {
    int size();
    E pop();
    void push(E element);
    void clear();
    E peek();
}
