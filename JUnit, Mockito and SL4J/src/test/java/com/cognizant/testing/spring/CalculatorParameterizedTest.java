package com.cognizant.testing.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorParameterizedTest {
    private final CalculatorService service = new CalculatorService();

    @ParameterizedTest
    @CsvSource({"1,2,3", "5,7,12", "10,-2,8"})
    void shouldAddMultipleInputs(int a, int b, int expected) {
        assertEquals(expected, service.add(a, b));
    }
}
