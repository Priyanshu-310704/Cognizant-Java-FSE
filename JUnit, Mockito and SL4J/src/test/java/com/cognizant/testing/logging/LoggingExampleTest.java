package com.cognizant.testing.logging;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.Test;

class LoggingExampleTest {
    @Test
    void shouldLogErrorWarningParameterizedAndAppenderMessages() {
        LoggingExample example = new LoggingExample();
        assertDoesNotThrow(() -> {
            example.logErrorAndWarning();
            example.logOrder("ORD-1001", 2500.0);
            example.logAppenderDemo();
        });
    }
}
