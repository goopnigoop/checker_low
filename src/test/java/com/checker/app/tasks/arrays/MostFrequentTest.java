package com.checker.app.tasks.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class MostFrequentTest {
    public static final String[] WORDS = {"one", "two", "three", "one"};
    MostFrequent mostFrequent = new MostFrequent();

    @Test
    void findFrequentWithMap() {
        final String result = mostFrequent.findFrequentWithMap(WORDS);
        assertThat(result, is("one"));
    }

    @Test
    void findFrequentWithArray() {
        final String result = mostFrequent.findFrequentWithArray(WORDS);
        assertThat(result, is("one"));
    }

}