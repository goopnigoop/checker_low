package com.checker.app.io;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.System.*;

/**
 * The type Count letters.
 * Ask the user to give a string as input then show repeated letters with count as a response
 */
public class CountLetters {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        out.println("Input your string");
        try (Scanner scanner = new Scanner(new BufferedInputStream(in))) {
            while (scanner.hasNext()) {
                String inputString = scanner.nextLine();
                if ("q".equals(inputString)) {
                    break;
                }
                if (inputString.isEmpty()) {
                    out.println("String is empty");
                }
                char[] chars = inputString.toCharArray();
                for (char aChar : chars) {
                    characterIntegerMap.merge(aChar, 1, Integer::sum);
                }
                Set<Character> notDuplicatedLetters = characterIntegerMap.entrySet()
                                                                         .stream()
                                                                         .filter(entry -> entry.getValue() == 1)
                                                                         .map(Map.Entry::getKey)
                                                                         .collect(Collectors.toSet());
                out.println("Letters are not duplicated:" + notDuplicatedLetters);
                characterIntegerMap.values()
                                   .removeIf(entry -> entry < 2);
                out.println("Here are letters:" + characterIntegerMap);
            }
        }
    }
}
