package com.checker.app.io;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class BinaryConverterServiceImplTest {

    BinaryConverterService binaryConverterService =  new BinaryConverterServiceImpl();
    @Test
    void getBinaryRepresentationOf5() {
        String binaryRepresentation = binaryConverterService.getBinaryRepresentation(5);
        assertThat(binaryRepresentation, is("101"));
    }

    @Test
    void getBinaryRepresentationOf8() {
        String binaryRepresentation = binaryConverterService.getBinaryRepresentation(8);
        assertThat(binaryRepresentation, is("1000"));
    }

    @Test
    void getBinaryRepresentationOf152459() {
        String binaryRepresentation = binaryConverterService.getBinaryRepresentation(152459);
        assertThat(binaryRepresentation, is("100101001110001011"));
    }
}