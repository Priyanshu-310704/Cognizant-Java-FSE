package com.cognizant.testing.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {
    @Test
    void shouldAddTwoNumbers() {
        CalculatorService service = new CalculatorService();
        assertEquals(9, service.add(4, 5));
    }
}
