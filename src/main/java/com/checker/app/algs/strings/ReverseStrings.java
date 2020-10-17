package com.checker.app.algs.strings;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class ReverseStrings {
    public static void main(String[] args) {
        String s = createString(1_000);
        System.out.println(s + "- original");
        System.out.println(reverseF(s));
        System.out.println(reverseS(s));
        System.out.println(reverseT(s));


        CompletableFuture.anyOf(CompletableFuture.supplyAsync(() -> reverseF(s)),
                CompletableFuture.supplyAsync(() -> reverseS(s)),
                CompletableFuture.supplyAsync(() -> reverseT(s))
                        .thenAcceptAsync((g) -> System.out.println("Cool+"+g)));
    }

    private static String createString(int i) {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        char[] b = new char[i];
        for (int i1 = 0; i1 < b.length; i1++) {
            b[i1] = (char) current.nextInt(94, 145);
        }
        return new String(b);
    }

    private static String reverseT(String s) {
        int length = s.length();
        StringBuilder sb = new StringBuilder(length);
        while (length > 0) {
            sb.append(s.charAt(--length));
        }
        return sb.toString();
    }

    private static String reverseS(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return new String(chars);
    }

    private static String reverseF(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
