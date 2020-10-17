package com.checker.app.algs.sort;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

public class MainSortChecker {
    private static final HashMap<String, Long> hashMap = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(() -> newSort(new BubbleSort()));
        service.execute(() -> newSort(new CloseToBubbleSort()));
        service.execute(() -> newSort(new InsertionSort()));
        service.execute(() -> newSort(new QuickSort()));
        service.shutdown();
        service.awaitTermination(10, TimeUnit.MINUTES);

        hashMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(entry -> {
            out.println(entry.getKey() + " result: " + entry.getValue());
        });

        service = Executors.newFixedThreadPool(10);

        CompletableFuture<String> voidCompletableFuture = CompletableFuture.supplyAsync((() -> newSort(new BubbleSort())), service);
        CompletableFuture<String> voidCompletableFutureN = CompletableFuture.supplyAsync(() -> newSort(new CloseToBubbleSort()), service);
        CompletableFuture<String> voidCompletableFutureNN = CompletableFuture.supplyAsync(() -> newSort(new InsertionSort()), service);
        CompletableFuture<String> voidCompletableFutureNNN = CompletableFuture.supplyAsync(() -> newSort(new QuickSort()), service);
        CompletableFuture<Object> objectCompletableFuture = CompletableFuture.anyOf(voidCompletableFuture, voidCompletableFutureN, voidCompletableFutureNN, voidCompletableFutureNNN);
        objectCompletableFuture.thenAccept(o -> out.println("That's it, Winner is: "+o)).join();
        service.shutdown();
        service.awaitTermination(1,TimeUnit.SECONDS);
    }

    private static String newSort(Sortable sortable) {
        String aClass = sortable.getClass().getSimpleName();
        Instant start = Instant.now();
        out.println(aClass + " started");
        int[] sort = sortable.sort(getTheArray(10000));
        Instant finish = Instant.now();
        out.println("Sorted: " + aClass + Arrays.toString(sort));
        long timeElapsed = Duration.between(start, finish).toNanos();
        out.println(aClass + " time " + timeElapsed);
        out.println(aClass + " finished");
        hashMap.put(aClass,timeElapsed);
        return aClass;
    }

    private static int[] getTheArray(int i) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        int[] res = new int[i];
        for (int j = 0; j < res.length; j++) {
            res[j] = threadLocalRandom.nextInt(10000);
        }
        return res;
    }
}
