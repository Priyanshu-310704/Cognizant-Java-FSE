package com.cognizant.testing.junit;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LifecycleTest {
    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void testMultiplyUsingArrangeActAssert() {
        int a = 4;
        int b = 5;
        int result = calculator.multiply(a, b);
        assertEquals(20, result);
    }
}
