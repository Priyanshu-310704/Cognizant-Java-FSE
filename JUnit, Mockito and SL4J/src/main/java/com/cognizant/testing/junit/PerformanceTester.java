package com.cognizant.testing.junit;

public class PerformanceTester {
    public String performTask() {
        long sum = 0;
        for (int i = 0; i < 10_000; i++) {
            sum += i;
        }
        return "done-" + sum;
    }
}
