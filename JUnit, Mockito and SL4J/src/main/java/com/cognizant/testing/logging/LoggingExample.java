package com.cognizant.testing.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public void logErrorAndWarning() {
        logger.error("This is an error message");
        logger.warn("This is a warning message");
    }

    public void logOrder(String orderId, double amount) {
        logger.info("Order {} created with amount {}", orderId, amount);
    }

    public void logAppenderDemo() {
        logger.info("This message is written using configured appenders");
    }

    public static void main(String[] args) {
        LoggingExample example = new LoggingExample();
        example.logErrorAndWarning();
        example.logOrder("ORD-1001", 2500.0);
        example.logAppenderDemo();
    }
}
