package com.checker.app.exceptionhandling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StringSaverServiceTest {
    @InjectMocks
    StringSaverService stringSaverService;

    @Mock
    SimpleRepository stringRepository;

    @Test
    void save() {
        doThrow(new RuntimeException("some exception")).when(stringRepository)
                                                       .save(anyString());
        assertThrows(NetworkException.class, () ->
                stringSaverService.save("any"));
        verify(stringRepository, times(3)).save(anyString());
    }
}