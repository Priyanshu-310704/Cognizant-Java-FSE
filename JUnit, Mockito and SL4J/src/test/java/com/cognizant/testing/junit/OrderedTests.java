package com.cognizant.testing.junit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class OrderedTests {
    private static final StringBuilder EXECUTION_ORDER = new StringBuilder();

    @Test
    @Order(1)
    void firstTest() {
        EXECUTION_ORDER.append("A");
        assertTrue(EXECUTION_ORDER.toString().startsWith("A"));
    }

    @Test
    @Order(2)
    void secondTest() {
        EXECUTION_ORDER.append("B");
        assertTrue(EXECUTION_ORDER.toString().contains("AB"));
    }
}
