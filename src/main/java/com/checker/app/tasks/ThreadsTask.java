package com.checker.app.tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Suppose you have two different files at any location then write a program with two
 * threads where every single thread will read and print single file
 * but both will do the operation at the same time.
 * So file 1 will be read by thread 1 and file 2 will be read by thread 2.
 */
public class ThreadsTask {
    public static void main(String[] args) {
        String home = System.getProperty("user.home");
        ReentrantLock reentrantLock = new ReentrantLock();
        File file = new File(home + "/work/all.txt");
        File sec = new File(home + "/work/commands.txt");

        Thread thread = new Thread(getRunnable(file,reentrantLock));
        Thread next = new Thread(getRunnable(sec,reentrantLock));

        thread.start();
        next.start();

    }

    private static Runnable getRunnable(File file, ReentrantLock reentrantLock) {
        return () -> {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                reentrantLock.lock();
                while (bufferedReader.ready()) {
                    String s = bufferedReader.readLine();
                    System.out.println(s + " " + Thread.currentThread()
                                                       .getName());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
        };
    }
}
