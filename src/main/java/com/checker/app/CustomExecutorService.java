package com.checker.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class CustomExecutorService {

    List<Thread> listOfThreads;
    Queue<Runnable> queue = new ArrayBlockingQueue<>(100);
    Thread longRunningThread;

    private CustomExecutorService(int i) {
        listOfThreads = new ArrayList<>(i);
    }

    public static CustomExecutorService getFixedThreadPool(int i) {
        return new CustomExecutorService(4);
    }

    public void submit(Runnable runnable) {
        queue.add(runnable);
    }


}
