package com.checker.app.exceptionhandling;

public interface Repository<E> {
    void save(E entity);
}
