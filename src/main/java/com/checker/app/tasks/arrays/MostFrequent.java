package com.checker.app.tasks.arrays;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostFrequent {

    public String findFrequentWithMap(String[] words) {
        return Arrays.stream(words)
                     .filter(StringUtils::isNotBlank)
                     .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                     .entrySet()
                     .stream()
                     .max(Map.Entry.comparingByValue())
                     .map(Map.Entry::getKey)
                     .orElseThrow(() -> new RuntimeException("No result"));
    }

    public String findFrequentWithArray(String[] words) {
        String result = words[0];
        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            final String word = words[i];
            int cur = 0;
            for (int j = i + 1; j < words.length; j++) {
                if (word.equals(words[j])) {
                    cur++;
                }
            }
            if (cur > counter) {
                result = word;
                counter = cur;
            }
        }
        return result;
    }

}
