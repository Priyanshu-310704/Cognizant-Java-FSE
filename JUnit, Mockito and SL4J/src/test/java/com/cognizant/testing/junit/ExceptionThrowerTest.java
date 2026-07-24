package com.cognizant.testing.junit;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ExceptionThrowerTest {
    @Test
    void shouldThrowExpectedException() {
        ExceptionThrower thrower = new ExceptionThrower();
        assertThrows(IllegalStateException.class, thrower::throwException);
    }
}
