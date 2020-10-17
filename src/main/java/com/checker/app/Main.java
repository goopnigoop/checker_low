package com.checker.app;

public class Main {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new char[1_000_000]);
        do {
            stringBuilder.append(12345);
            stringBuilder.delete(0,5);
        }while (Thread.currentThread().isAlive());
        System.out.println("that's all"+ stringBuilder.toString());
    }




}