package com.cognizant.testing.junit;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import java.time.Duration;
import org.junit.jupiter.api.Test;

class PerformanceTesterTest {
    @Test
    void shouldCompleteWithinTimeout() {
        PerformanceTester tester = new PerformanceTester();
        assertTimeout(Duration.ofMillis(100), tester::performTask);
    }
}
