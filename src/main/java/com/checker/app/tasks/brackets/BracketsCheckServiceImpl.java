package com.checker.app.tasks.brackets;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.Objects.nonNull;

public class BracketsCheckServiceImpl implements BracketsCheckService {
    private static final Map<Character, Character> mapOfBrackets = Map.of(')', '(', '}', '{', ']', '[');

    @Override
    public boolean isValid(String stringWithBrackets) {
        Deque<Character> stringStack = new LinkedList<>();
        final char[] split = stringWithBrackets.toCharArray();
        for (char s : split) {
            if (mapOfBrackets.containsKey(s) && !mapOfBrackets.get(s)
                                                              .equals(stringStack.pop())) {
                return false;
            }
            if (mapOfBrackets.containsValue(s)) {
                stringStack.push(s);
            }
        }
        return true;


    }

    @Override
    public boolean isValidWithStream(String stringWithBrackets) {
        Deque<Character> stringStack = new LinkedList<>();

        final Predicate<Character> keyPredicate = mapOfBrackets::containsKey;
        final Predicate<Character> valuePredicate = mapOfBrackets::containsValue;
        return stringWithBrackets.chars()
                                 .mapToObj(c -> (char) c)
                                 .filter(keyPredicate.or(valuePredicate))
                                 .map(character -> {
                                     final Character currentCharacter = mapOfBrackets.get(character);
                                     if (nonNull(currentCharacter) && !currentCharacter.equals(stringStack.pop())) {
                                         return false;
                                     }
                                     if (mapOfBrackets.containsValue(character)) {
                                         stringStack.push(character);
                                     }
                                     return true;
                                 })
                                 .filter(current -> !current)
                                 .findFirst()
                                 .orElse(true);

    }
}
