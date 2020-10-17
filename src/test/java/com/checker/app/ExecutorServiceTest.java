package com.checker.app;

import org.junit.jupiter.api.Test;

public class ExecutorServiceTest {

    private ObjectWithState objectWithState;

    @Test
    void shouldReturn100For5Threads() {
        CustomExecutorService customExecutorService = CustomExecutorService.getFixedThreadPool(4);
    }
}
