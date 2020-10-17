package com.checker.app.interfaces;

import java.util.function.Consumer;

public interface Vehicle {
    default void start(Consumer<Void> consumer) {
        consumer.accept(null);
        System.out.println("allgood");
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Car();

        vehicle.start(unused -> {
            System.out.println("go");
        });
    }

    public static class Car implements Vehicle {
    }

}
