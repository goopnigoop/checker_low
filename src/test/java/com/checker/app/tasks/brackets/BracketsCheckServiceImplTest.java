package com.checker.app.tasks.brackets;

import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class BracketsCheckServiceImplTest {

    BracketsCheckServiceImpl bracketsCheckService = new BracketsCheckServiceImpl();

    @Test
    void ShouldBeValid() {
        String stringWithBrackets = "asdfgads{dsfassd{asdsd[dasd(dasd)das]dsad}asd}";
        assertThat(bracketsCheckService.isValid(stringWithBrackets), is(TRUE));
    }

    @Test
    void shouldBeFailedWithWrongOrderOfBracketsInString() {
        String stringWithBrackets = "asdfgads{dsfassd{asdsd]dasd(dasd)das]dsad}asd}";
        assertThat(bracketsCheckService.isValid(stringWithBrackets), is(FALSE));
    }

    @Test
    void ShouldBeValidWithStream() {
        String stringWithBrackets = "asdfgads{dsfassd{asdsd[dasd(dasd)das]dsad}asd}";
        assertThat(bracketsCheckService.isValidWithStream(stringWithBrackets), is(TRUE));
    }


    @Test
    void shouldBeFailedWithWrongOrderOfBracketsInStringWithStream() {
        String stringWithBrackets = "asdfgads{dsfassd{asdsd]dasd(dasd)das]dsad}asd}";
        assertThat(bracketsCheckService.isValidWithStream(stringWithBrackets), is(FALSE));
    }
}